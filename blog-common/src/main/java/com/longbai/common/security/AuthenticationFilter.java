package com.longbai.common.security;

import cn.hutool.json.JSONUtil;
import com.github.xiaoymin.knife4j.core.util.StrUtil;
import com.longbai.common.cache.Cache;
import com.longbai.common.cache.CachePrefix;
import com.longbai.common.security.enums.SecurityEnum;
import com.longbai.common.security.enums.UserEnums;
import com.longbai.common.security.token.SecretKeyUtil;
import com.longbai.common.utils.ResponseUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.util.PatternMatchUtils;

import javax.naming.NoPermissionException;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Cien
 * @Date 2023/2/21 22:06
 * @Version 1.0
 * @Note
 */
@Slf4j
public class AuthenticationFilter extends BasicAuthenticationFilter {


    private final Cache cache;

    public AuthenticationFilter(AuthenticationManager authenticationManager, Cache cache) {
        super(authenticationManager);
        this.cache = cache;
    }

    @SneakyThrows
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) {
        //从header中获取jwt
        String jwt = request.getHeader(SecurityEnum.HEADER_TOKEN.getValue());
        //如果没有token 则return
        if (StrUtil.isBlank(jwt)) {
            chain.doFilter(request, response);
            return;
        }
        //获取用户信息，存入context,存储userDetails
        UsernamePasswordAuthenticationToken authentication = getAuthentication(jwt, response);
        //自定义权限过滤
        if (authentication != null) {
            //customAuthentication(request, response, authentication);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        chain.doFilter(request, response);
    }

    /**
     * 自定义权限过滤
     *
     * @param request        请求
     * @param response       响应
     * @param authentication 用户信息
     */
    private void customAuthentication(HttpServletRequest request, HttpServletResponse response, UsernamePasswordAuthenticationToken authentication) throws NoPermissionException {
        AuthUser authUser = (AuthUser) authentication.getDetails();
        String requestUrl = request.getRequestURI();
        log.error("请求url "+requestUrl);
        List<String> authUrls = Arrays.asList("/test");
        //如果不是超级管理员， 则鉴权
        /*
        if (!authUser.getIsSuper() && authUser.getRole().getRole().equals(UserEnums.ADMIN.getRole()) &&PatternMatchUtils.simpleMatch(authUrls.toArray(new String[0]),requestUrl)) {
            ResponseUtil.output(response, ResponseUtil.resultMap(false, 400, "权限不足"));
            throw new NoPermissionException("权限不足");
        }
        */
    }

    /**
     * 获取token信息
     *
     * @param jwt      token信息
     * @param response 响应
     * @return 获取鉴权对象
     */
    private UsernamePasswordAuthenticationToken getAuthentication(String jwt, HttpServletResponse response) {
        try {
            Claims claims
                    = Jwts.parser()
                    .setSigningKey(SecretKeyUtil.generalKeyByDecoders())
                    .parseClaimsJws(jwt).getBody();
            //获取存储在claims中的用户信息
            String json = claims.get(SecurityEnum.USER_CONTEXT.getValue()).toString();
            AuthUser authUser = JSONUtil.toBean(json, AuthUser.class);
            //校验redis中是否有权限
            if (cache.hasKey(CachePrefix.ACCESS_TOKEN.getPrefix(UserEnums.USER) + jwt)||
                    cache.hasKey(CachePrefix.ACCESS_TOKEN.getPrefix(UserEnums.ADMIN) + jwt)) {
                //用户角色
                List<GrantedAuthority> auths = new ArrayList<>();
                auths.add(new SimpleGrantedAuthority("ROLE_" + authUser.getRole()));
                //构造返回信息
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(authUser.getUsername(), null, auths);
                authentication.setDetails(authUser);
                return authentication;
            }
            ResponseUtil.output(response, 403, ResponseUtil.resultMap(false, 403, "登录已失效，请重新登录"));
            return null;
        } catch (ExpiredJwtException e) {
            log.debug("user analysis exception:", e);
        } catch (Exception e) {
            log.error("other exception:", e);
        }
        return null;
    }
}


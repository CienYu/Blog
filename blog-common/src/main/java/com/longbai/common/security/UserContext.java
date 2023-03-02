package com.longbai.common.security;

import com.google.gson.Gson;
import com.longbai.common.cache.Cache;
import com.longbai.common.exception.ServiceException;
import com.longbai.common.security.enums.ResultCode;
import com.longbai.common.security.enums.SecurityEnum;
import com.longbai.common.security.token.SecretKeyUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author Cien
 * @Date 2023/3/1 22:29
 * @Version 1.0
 * @Note
 */
public class UserContext {

    /**
     * 根据request获取用户信息
     *
     * @return 授权用户
     */
    public static synchronized AuthUser getCurrentUser() {
        //TODO 实时更新权限
        if (RequestContextHolder.getRequestAttributes() != null) {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String accessToken = request.getHeader(SecurityEnum.HEADER_TOKEN.getValue());
            //测试
           /*AuthUser authUser = new AuthUser();
           authUser.setId(3);
           authUser.setRole(UserEnums.EMPLOYEE);
           authUser.setUsername("19518033091");
           JSONArray jsonArray = new JSONArray();
           jsonArray.put(UserEnums.EMPLOYEE);
           jsonArray.put(UserEnums.PROCESSORS);
           jsonArray.put(UserEnums.CONSIGNOR);
           authUser.setRoles(jsonArray);
           return authUser;*/
            //测试代码结束,测试完毕后 请把下面注释解开
            return getAuthUser(accessToken);
        }

        return null;
    }


    /**
     * 根据jwt获取token重的用户信息
     *
     * @param cache       缓存
     * @param accessToken token
     * @return 授权用户
     */
    public static AuthUser getAuthUser(Cache cache, String accessToken) {
        try {
            if (cache.keys("*" + accessToken).size() == 0) {
                throw new ServiceException(ResultCode.USER_AUTHORITY_ERROR);
            }
            return getAuthUser(accessToken);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 根据jwt获取token重的用户信息
     *
     * @param accessToken token
     * @return 授权用户
     */
    public static AuthUser getAuthUser(String accessToken) {
        try {
            //获取token的信息
            Claims claims
                    = Jwts.parser()
                    .setSigningKey(SecretKeyUtil.generalKeyByDecoders())
                    .parseClaimsJws(accessToken).getBody();
            //获取存储在claims中的用户信息
            String json = claims.get(SecurityEnum.USER_CONTEXT.getValue()).toString();
            return new Gson().fromJson(json, AuthUser.class);
        } catch (Exception e) {
            return null;
        }
    }
}
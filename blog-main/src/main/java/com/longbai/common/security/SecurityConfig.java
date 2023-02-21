package com.longbai.common.security;

import com.longbai.common.cache.Cache;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsConfigurationSource;


import javax.annotation.Resource;

/**
 * @Author Cien
 * @Date 2023/2/21 21:45
 * @Version 1.0
 * @Note
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(jsr250Enabled = true, prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    IgnoredUrlsProperties ignoredUrlsProperties;
    @Resource
    private Cache<String> cache;
    @Resource
    private CorsConfigurationSource corsConfigurationSource;
    @Resource
    private CustomAccessDeniedHandler customAccessDeniedHandler;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = http
                .authorizeRequests();
        //配置的url 不需要授权
        for (String url : ignoredUrlsProperties.getUrls()) {
            registry.antMatchers(url).permitAll();
        }
        registry
                .and()
                //禁止网页iframe
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests()
                //任何请求
                .anyRequest()
                //需要身份认证
                .authenticated()
                .and()
                .cors().configurationSource(corsConfigurationSource).and()
                //关闭跨站请求防护
                .csrf().disable()
                //前后端分离采用JWT 不需要session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                //自定义权限拒绝处理类
                .exceptionHandling().accessDeniedHandler(customAccessDeniedHandler)
                .and()
                //添加JWT认证过滤器
                .addFilter(new AuthenticationFilter(authenticationManager(), cache));
    }
}


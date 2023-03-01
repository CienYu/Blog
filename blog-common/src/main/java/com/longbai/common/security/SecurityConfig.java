package com.longbai.common.security;

import com.longbai.common.cache.Cache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
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


/**
 * todo
 * 自Spring Security 5.7.1及更新版本或者Spring Boot 2.7.0及更新版本，
 * 类WebSecurityConfigurerAdapter已被弃用
 * 故废弃下列代码
 */

public class SecurityConfig   extends WebSecurityConfigurerAdapter {


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

/*public class SecurityConfig {

    @Resource
    IgnoredUrlsProperties ignoredUrlsProperties;
    @Resource
    private Cache<String> cache;
    @Resource
    private CorsConfigurationSource corsConfigurationSource;
    @Resource
    private CustomAccessDeniedHandler customAccessDeniedHandler;

    @Bean
    UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager users = new InMemoryUserDetailsManager();
        users.createUser(User.withUsername("javaboy").password("{noop}123").roles("admin").build());
        users.createUser(User.withUsername("江南一点雨").password("{noop}123").roles("admin").build());
        return users;
    }

    *//**
 * Spring Security 给一个地址放行，有两种方式：
 * 1. 被放行的资源，不需要经过 Spring Security 过滤器链（静态资源一般使用这种）。
 * 2. 经过 Spring Security 过滤器链，但是不拦截（如果是一个接口想要匿名访问，一般使用这种）。
 *
 *//*
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/images/**", "/js/**");
    }

    *//**
 * 自己手动配置安全过滤器链
 *
 * @return
 *//*
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = http
                .authorizeRequests();
        //配置的url 不需要授权
        for (String url : ignoredUrlsProperties.getUrls()) {
            registry.antMatchers(url).permitAll();
        }
        return  registry
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
                .addFilter(new AuthenticationFilter(authenticationManager(), cache)).build();

        *//*http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .csrf().disable();
        return http.build();*//*


    }

}
*/
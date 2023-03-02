package com.longbai.common.security;

import com.longbai.common.cache.Cache;
import com.longbai.common.security.AuthenticationFilter;
import com.longbai.common.security.CustomAccessDeniedHandler;
import com.longbai.common.security.IgnoredUrlsProperties;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfigurationSource;


import javax.annotation.Resource;


@Configuration
@EnableWebSecurity
@SpringBootConfiguration
@EnableGlobalMethodSecurity(jsr250Enabled = true, prePostEnabled = true, securedEnabled = true)
public class SecurityConfig {

    @Resource
    IgnoredUrlsProperties ignoredUrlsProperties;
    @Resource
    private Cache<String> cache;
    @Resource
    private CorsConfigurationSource corsConfigurationSource;
    @Resource
    private CustomAccessDeniedHandler customAccessDeniedHandler;

    /**
     * 指定加密方式
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        // 使用官方推荐的BCrypt加密密码，也就是md5加随机盐
        return new BCryptPasswordEncoder();
    }



    /**
     * configure(WebSecurity)用于影响全局安全性(配置资源，设置调试模式，通过实现自定义防火墙定义拒绝请求)的配置设置。
     * 一般用于配置全局的某些通用事物，例如静态资源等
     * 新版本其实不推荐把路径的拦截写在这里，而是推荐写在securityFilterChain里面
     * "You are asking Spring Security to ignore Ant [pattern='/resources/**']. This is not recommended -- please use permitAll via HttpSecurity#authorizeHttpRequests instead"
     */
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/resources/**", "/ignore2");
    }

    /**
     * 配置接口拦截
     * configure(HttpSecurity)允许基于选择匹配在资源级配置基于网络的安全性，也就是对角色所能访问的接口做出限制
     * @param httpSecurity 请求属性
     * @return HttpSecurity
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {


        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = httpSecurity
                .authorizeRequests();
        //配置的url 不需要授权
        for (String url : ignoredUrlsProperties.getUrls()) {
            registry.antMatchers(url).permitAll();
        }
        registry.and()
                .authorizeRequests()
                // 允许get请求/test/any，而无需认证，不配置HttpMethod默认允许所有请求类型
                .antMatchers(HttpMethod.GET, "/index/text", "/js/**", "/css/**", "/images/**", "/icon/**", "/file/**").permitAll()
                // 指定权限为admin才能访问，这里和方法注解配置效果一样，但是会覆盖注解
                .antMatchers("/test/admin").hasRole("admin")
                // 所有请求都需要验证authenticated() 测试阶段为所有请求都不需要验证
                .anyRequest().permitAll()
                .and()
                //.httpBasic() Basic认证，和表单认证只能选一个
                // 不使用表单认证页面
                .formLogin().disable()
                // 配置登录入口，默认为security自带的页面/login
                //.loginProcessingUrl("/login")
                //.and()
                // post请求要关闭csrf验证,不然访问报错；实际开发中开启，需要前端配合传递其他参数
                .csrf().disable()
                .cors().configurationSource(corsConfigurationSource).and()
                //自定义权限拒绝处理类
                .exceptionHandling().accessDeniedHandler(customAccessDeniedHandler)
                //.and()
                //添加JWT认证过滤器
                //.addFilter(new AuthenticationFilter(authenticationManager(), cache))
                ;
        return httpSecurity.build();
    }

}

/**
 * @Author Cien
 * @Date 2023/2/21 21:45
 * @Version 1.0
 * @Note
 *
 * todo
 * 自Spring Security 5.7.1及更新版本或者Spring Boot 2.7.0及更新版本，
 * 类WebSecurityConfigurerAdapter已被弃用
 * 故废弃下列代码
 */
/*@Configuration
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
                //关闭网页登陆验证
                .formLogin().disable()
                //添加JWT认证过滤器
                .addFilter(new AuthenticationFilter(authenticationManager(), cache));
    }

}*/

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
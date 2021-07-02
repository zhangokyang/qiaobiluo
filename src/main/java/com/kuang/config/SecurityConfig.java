package com.kuang.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Author：zhangyang
 * @Version：1.0
 * @Date：2021/6/23-8:37
 * @desp:
 * @since:
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    链式编程，授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
     http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/level1/**").hasRole("vip1").antMatchers("/level2/**").hasRole("vip2").antMatchers("/level3/**").hasRole("vip3");
     //没有权限默认会到登录页面
        //定制登录页
     http.formLogin().loginPage("/toLogin");
     http.csrf().disable();//关闭csrf功能
     http.logout().logoutSuccessUrl("/index");
     //开启记住我功能，cookie，默认保存两周
     http.rememberMe().rememberMeParameter("remember-me");
    }
//认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
         auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                 .withUser("kuangshen").password(new BCryptPasswordEncoder().encode("123456")).roles("vip2","vip3")
                 .and()
                 .withUser("kobe").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip2","vip3")
                 .and()
                 .withUser("guest").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1");
    }
}

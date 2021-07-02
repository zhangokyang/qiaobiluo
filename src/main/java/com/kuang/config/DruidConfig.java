package com.kuang.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.HashMap;

/**
 * @Author：zhangyang
 * @Version：1.0
 * @Date：2021/6/22-21:54
 * @desp:
 * @since:
 */
@Configuration
public class DruidConfig {
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource(){
return new DruidDataSource();
    }
    //后台监控:web.xml
    //因为springboot内置了servlet容器，所以没有web.xml,替代方法：ServletRegistrationBean
    @Bean
    public ServletRegistrationBean a(){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        //后台需要有人登录，账号密码配置
        HashMap<String, String> initialParams = new HashMap<>();
        //增加配置
        initialParams.put("loginUsername","admin");
        initialParams.put("loginPassword","123456");
        //允许谁可以访问
//        initialParams.put("allow","localhost");
        //禁止谁的访问
//        initialParams.put("kuangshen","192.168.11.123");
        bean.setInitParameters(initialParams);//设置初始化参数
        return bean;
    }
    //filter
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new WebStatFilter());
        HashMap<String, String> initParameters = new HashMap<>();
        //这些东西不进行统计
        initParameters.put("exclusions","*.js,*.css,/druid/*");
        bean.setInitParameters(initParameters);
        return bean;
    }
}

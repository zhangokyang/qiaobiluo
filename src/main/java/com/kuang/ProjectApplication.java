package com.kuang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author：whl
 * @Version：1.0
 * @Date：2021/7/2-15:45
 * @Since:jdk1.8
 */
//1.包扫描：@Component @Controller @Service    @Mapper:xml 和接口同包同目录
@SpringBootApplication
@MapperScan(basePackages = {"com.kuang.mapper"})
@EnableTransactionManagement
public class ProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProjectApplication.class,args);
    }
}

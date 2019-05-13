package com.bjtu.homework03;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


//待解决问题:
// 1.Restful程度
// 2.可以不登陆输出URL直接访问用户列表
// 3.Hateoas
// 4.Oauth2
@MapperScan("com.bjtu.homework03.mapper")
@SpringBootApplication
@EnableCaching
public class Homework03Application {
    public static void main(String[] args) {
        SpringApplication.run(Homework03Application.class, args);
    }
}

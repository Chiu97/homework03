package com.bjtu.homework03.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


//输入  http://localhost:8080/swagger-ui.html 查看swagger api 文档
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .tags(new Tag("loginTag","用户登录API"))
                .select()
                //只有controller下的Controller类才会自动生成Swagger API文档
                .apis(RequestHandlerSelectors.basePackage("com.bjtu.homework03.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("用户管理")
                .description("用户管理中心 API 1.0 操作文档")
                .termsOfServiceUrl("bjtu.edu.cn")
                .version("1.0")
                .contact(new Contact("BJTU", "bjtu.edu.cn", "madridchiu@gmail.com"))
                .build();
    }
}

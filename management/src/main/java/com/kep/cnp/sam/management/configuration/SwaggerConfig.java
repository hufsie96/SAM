package com.kep.cnp.sam.management.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                //.groupName("business-api")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.kep.cnp.sam.management.restApiController"))
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .useDefaultResponseMessages(false);
    }

    private ApiInfo apiInfo(){
        return new ApiInfo(
                "SAM Management REST API",
                "libraray management system API for create, update, delete, search books",
                "version v.01",
                "service",
                new Contact("jackie.choi", "management.sam.kep.com", "admin@sam.kep.com"),
                "license of API"
                ,"http://license.sam.kep.com",
                Collections.emptyList()

        );
    }
}

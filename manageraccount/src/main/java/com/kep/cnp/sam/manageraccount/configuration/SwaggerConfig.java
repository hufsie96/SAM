package com.kep.cnp.sam.manageraccount.configuration;

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
    /**
     * Rest API Version
     */
    private String version;
    /**
     * RestAPI Swagger website's title
     */
    private String title = "SAM manager account REST API ";

    @Bean
    public Docket api(){
        version = "V1.0";
        title = title + version;

        return new Docket(DocumentationType.SWAGGER_2)
                //.groupName("business-api")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.kep.cnp.sam.manageraccount.apicontroller"))
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo(title, version));
    }

    private ApiInfo apiInfo(String title, String version){
        return new ApiInfo(
                title,
                "library manager account system API for generating token, validation check id, and creating users",
                version,
                "service",
                new Contact("jackie.choi", "manageraccount.sam.kep.com", "admin@sam.kep.com"),
                "license of API"
                ,"license.sam.kep.com",
                Collections.emptyList()

        );
    }

}

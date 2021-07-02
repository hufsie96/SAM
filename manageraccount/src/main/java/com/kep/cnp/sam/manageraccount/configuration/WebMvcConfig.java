package com.kep.cnp.sam.manageraccount.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Value("${kep.management.url}")
    String MANAGEMENT_URL;

    @Override
    public void addCorsMappings(CorsRegistry registry){

        registry.addMapping("/**")
                .allowedOrigins(MANAGEMENT_URL)
                .allowedOriginPatterns()
                .exposedHeaders("token");
        ;
                //.allowedMethods("GET,POST,PUT,DELETE,OPTION");
    }
}
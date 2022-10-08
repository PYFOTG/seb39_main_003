package com.web.MyPetForApp.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 모든 경로
//                .allowedOrigins("http://localhost:3000") // 해당 origin 허용
                .allowCredentials(true)
                .allowedOrigins("http://localhost:3000", "http://localhost:8080", "https://seb39-main-003-izr1fgrp2-nomga.vercel.app",
                        "https://seb39-main-003-kslsp3cga-nomga.vercel.app")
                .allowedHeaders("*")
                .exposedHeaders("Authorization")
                .exposedHeaders("refresh")
                .allowedmode: 'no-cors', methods("GET", "POST", "PATCH", "DELETE"); // 허용할 Request 메서드
    }
}
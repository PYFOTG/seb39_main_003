package com.web.MyPetForApp.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
//        config.addAllowedOrigin("http://localhost:3000");
        config.addAllowedOrigin("https://seb39-main-003-bsihsudrk-nomga.vercel.app");
//        config.addAllowedOrigin("https://seb39-main-003-rjwfp0sdz-main003.vercel.app:3000");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        config.addExposedHeader("Authorization");
        config.addExposedHeader("refresh");
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}

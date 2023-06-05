/********************************************************************************
 * Copyright 2000 - 2023 Kyriba Corp. All Rights Reserved.                      *
 * The content of this file is copyrighted by Kyriba Corporation and can not be *
 * reproduced, distributed, altered or used in any form, in whole or in part.   *
 ************************ ********************************************************/
package pl.chris.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@EnableWebSecurity
@Configuration
public class NoAuthSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) {
        try {
            http.securityMatcher("/v2/api-docs", "/swagger-resources/configuration/ui", "/swagger-resources", "/swagger-resources/configuration/security",
                            "/swagger-ui**", "/webjars/**")
                    .csrf()
                    .disable()
                    .authorizeHttpRequests()
                    .anyRequest()
                    .permitAll();

            return http.build();
        }
        catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}

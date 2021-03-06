package com.resource.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class ResourceServerConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .mvcMatchers("/api/**")

                // kita ingin yang bisa bisa mengakses ini hanya access_token yang memilki scope api.read
                .access("hasAuthority('SCOPE_api.read')")
                .and()
                .oauth2ResourceServer()
                .jwt()
        ;
        return http.build();
    }
}

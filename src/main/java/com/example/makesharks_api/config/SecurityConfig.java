//package com.example.makesharks_api.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
//import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter.XFrameOptionsMode;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
//
//
//            // Disable CSRF protection
//                http.authorizeHttpRequests(authorizeRequests ->
//                        authorizeRequests
//                                .requestMatchers("/h2-console/**").permitAll() // Allow access to H2 console
//                                .requestMatchers("/api/**").authenticated() // Use requestMatchers instead of antMatchers
//                                .anyRequest().permitAll()
//
//
//                )
//
//                        .csrf(csrf -> csrf.disable())
//                .httpBasic(withDefaults());
//
//
//        return http.build();
//    }
//}

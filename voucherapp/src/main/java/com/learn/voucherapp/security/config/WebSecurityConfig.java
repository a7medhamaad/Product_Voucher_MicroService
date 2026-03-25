package com.learn.voucherapp.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    	http
        .formLogin(Customizer.withDefaults())
        .httpBasic(Customizer.withDefaults())

        .csrf(csrf -> csrf.disable())

        .authorizeHttpRequests(auth -> auth

            .requestMatchers(HttpMethod.GET, "/voucherapi/vouchers/**","/","/showGetVoucher","/getVoucher")
                .hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")

            .requestMatchers(HttpMethod.GET, "/showCreateVoucher","/createVoucher","/createResponse")
                .hasAuthority("ROLE_ADMIN")

            .requestMatchers(HttpMethod.POST, "/voucherapi/vouchers","/saveVoucher")
                .hasAuthority("ROLE_ADMIN")

            .requestMatchers(HttpMethod.POST,"/getVoucher")
                .hasAnyAuthority("ROLE_ADMIN","ROLE_USER")

            .requestMatchers("/voucherapi/**")
                .authenticated()

            .anyRequest().authenticated()
        );

        return http.build();
    }
}
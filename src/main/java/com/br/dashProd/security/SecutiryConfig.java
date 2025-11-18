package com.br.dashProd.security;

import com.nimbusds.jose.jwk.source.ImmutableSecret;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;

@Configuration
public class SecutiryConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/**").permitAll()
                        .requestMatchers("/dashProd/v1/**").authenticated())
                .oauth2ResourceServer(resource -> resource.jwt(jwtConfigurer -> {}))
                .exceptionHandling(e -> e
                                .authenticationEntryPoint((request, response, authException) ->
                                {
                                    response.setStatus(401);
                                    response.setContentType("application/json");
                                    response.getWriter().write(
                                            "{\"status\":401, \"message\": \"" + authException.getMessage() + "\" }");
                                })
                                .accessDeniedHandler((request, response, accessDeniedException) ->
                                {
                                    response.setStatus(403);
                                    response.setContentType("application/json");
                                    response.getWriter().write(
                                            "{\"status\":403, \"message\": \"" + accessDeniedException.getMessage() + "\" }");
                                } )
                        )
                .build();

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    };

    @Bean
    public NimbusJwtDecoder jwtDecoder(@Value("${JWT_SECRET}") String secret){
       SecretKey secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
       return NimbusJwtDecoder.withSecretKey(secretKey).build();
    }

    @Bean
    public NimbusJwtEncoder jwtEncoder(@Value("${JWT_SECRET}") String secret){
        SecretKey secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        return new NimbusJwtEncoder(new ImmutableSecret<>(secretKey));
    }



}

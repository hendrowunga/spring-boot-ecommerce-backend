package com.hendro.ecommerce.config;

import com.okta.spring.boot.oauth.Okta;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.accept.ContentNegotiationStrategy;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                // Use the new authorizeHttpRequests DSL
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api/orders/**").authenticated()
                        .anyRequest().permitAll()
                )
                // Enable JWT resource server support
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(jwt -> {}) // Customizer can be empty if defaults are fine
                )
                // Enable CORS
                .cors(cors -> {}) // You can further customize CORS if needed
                // CSRF protection as needed (optional)
                .csrf(csrf -> csrf.disable());

        // Add content negotiation strategy
        http.setSharedObject(ContentNegotiationStrategy.class,
                new HeaderContentNegotiationStrategy());

        // Okta 401 response body
        Okta.configureResourceServer401ResponseBody(http);

        return http.build();
    }
}

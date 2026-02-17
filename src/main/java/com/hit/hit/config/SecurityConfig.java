package com.hit.hit.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

    @Autowired
    private UserDetailsService userDetailsService;

    private final JwtRequestFilter jwtRequestFilter;

    public SecurityConfig(JwtRequestFilter jwtRequestFilter) {
        this.jwtRequestFilter = jwtRequestFilter;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors() // Enable CORS support
                .and()
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth").permitAll()
                        .requestMatchers("/register").permitAll()
                        .requestMatchers("/checkout").permitAll()
                        .requestMatchers("/payment/result").permitAll()
                        .requestMatchers("/payment").permitAll()
                        .requestMatchers("/payments/checkout").permitAll()
                        .requestMatchers("/payments/result").permitAll()
                        .requestMatchers("/payments/result/**").permitAll()
                        .requestMatchers("/checkout/**").permitAll()
                        .requestMatchers("/payments/**").permitAll()
                        .requestMatchers("/sync/add").permitAll()
                        .requestMatchers("/payments/status/**").permitAll()
                        .requestMatchers("/class/getPast7Days").permitAll()
                        .requestMatchers("/customer/save").permitAll()
                        .requestMatchers("/auth/getUser/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
                        .requestMatchers("/payments/payments").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
                        .requestMatchers("/payments/pending-payments").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
                        .requestMatchers("/payments/get-all").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
                        .requestMatchers("/payments/get-paid-pending-requests").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
                        .requestMatchers("/customer/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
                        .requestMatchers("/users/get-all").hasAnyAuthority("ROLE_ADMIN")

                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .csrf(csrf -> csrf.disable()); // Disable CSRF for stateless API

        http.addFilterBefore(jwtRequestFilter,
                UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);

        authenticationManagerBuilder
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
        System.out.println(userDetailsService);
        return authenticationManagerBuilder.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}

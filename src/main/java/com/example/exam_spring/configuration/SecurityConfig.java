package com.example.exam_spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
        userDetailsManager.setUsersByUsernameQuery("select user_id, password, is_active from members where user_id = ?");
        userDetailsManager.setAuthoritiesByUsernameQuery("select user_id,role from roles where user_id = ?");
        return userDetailsManager;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/vehicles/**").hasAnyRole("ADMIN")
                        .requestMatchers("/sale/**").hasAnyRole("SALE")

                        .anyRequest().permitAll()
                )
                .formLogin(formLogin -> formLogin
                        .loginPage("/loginPage")
                        .loginProcessingUrl("/authenticateUser")
                        .defaultSuccessUrl("/", true)
                        .failureUrl("/loginPage?error=true")
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/loginPage")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                );
        return http.build();
    }
}

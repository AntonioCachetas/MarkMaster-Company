package com.humber.FinalProject1.config;

import com.humber.FinalProject1.models.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/company/home").permitAll()
                        .requestMatchers("/company/students/**").hasAnyRole("ADMIN", "TEACHER") // For viewing students
                        .requestMatchers("/company/student-names").hasAnyRole("ADMIN", "TEACHER", "STUDENT") // For listing student names
                        .requestMatchers("/company/teacher/update/**").hasAnyRole("ADMIN", "TEACHER") // Teacher can update students
                        .requestMatchers("/company/teacher/delete/**").hasRole("ADMIN") // Only Admin can delete students
                        .requestMatchers("/company/admin/**").hasRole("ADMIN") // Admin specific routes
                        .anyRequest().authenticated() // All other requests require authentication
                )
                .formLogin(customLogin -> customLogin
                        .loginPage("/login")
                        .defaultSuccessUrl("/company/home", true)
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .permitAll()
                );

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder().encode("adminpass"))
                .roles("ADMIN")
                .build();

        UserDetails teacher = User.withUsername("teacher")
                .password(passwordEncoder().encode("teacherpass"))
                .roles("TEACHER")
                .build();

        UserDetails student = User.withUsername("student")
                .password(passwordEncoder().encode("studentpass"))
                .roles("STUDENT")
                .build();

        return new InMemoryUserDetailsManager(admin, teacher, student);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public WebSecurityCustomizer ignoreResources() {
        return (webSecurity) -> webSecurity
                .ignoring()
                .requestMatchers("/css/**", "/h2-console/**"); // Make sure these are paths you want to ignore
    }


}

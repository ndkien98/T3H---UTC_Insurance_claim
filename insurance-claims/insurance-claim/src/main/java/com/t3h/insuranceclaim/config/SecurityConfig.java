package com.t3h.insuranceclaim.config;

import com.t3h.insuranceclaim.security.SecurityUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserDetailsService userDetailsService;

    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/cms/**").hasRole(SecurityUtils.Role.ADMIN.name())
                        .requestMatchers("/user/**").hasAnyRole(SecurityUtils.Role.USER.name(),SecurityUtils.Role.ADMIN.name())
                        .requestMatchers("/", "/home", "/login",
                                "/assets/**", "/fonts/**", "/homeguest_files/**",
                                "/js/**", "/libs/**", "/loginmetlife/**",
                                "/page404/**", "/scss/**", "/tasks/**", "/css/**", "/images/**").permitAll()
                        .requestMatchers("/resource/user/**").hasAnyRole(SecurityUtils.Role.USER.name(),SecurityUtils.Role.ADMIN.name())
                        .requestMatchers("/api/**").permitAll() // Permit all cho tất cả các endpoint bắt đầu bằng /api
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/perform_login")
                        .defaultSuccessUrl("/process-after-login", true) // sau khi login thành công sẽ truy cập vào url process-after-login để điều hướng phân quyền
                        .failureUrl("/login?error=true")
                        .permitAll()
                )
                .logout((logout) -> logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .permitAll()
                );

        return http.build();
    }




    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("admin"));
        System.out.println(passwordEncoder.encode("user"));
    }
}


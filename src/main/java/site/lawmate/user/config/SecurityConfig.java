package site.lawmate.user.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import site.lawmate.user.enums.Role;
import site.lawmate.user.service.impl.OAuthServiceImpl;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

    private final OAuthServiceImpl oAuthServiceImpl;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(
                        (csrfConfig) -> csrfConfig.disable()
                )
                .headers(
                        (headerConfig) -> headerConfig.frameOptions(
                                frameOptionsConfig -> frameOptionsConfig.disable()
                        )
                )
                .authorizeHttpRequests((authorizeRequest) -> authorizeRequest
                        .requestMatchers("/question/new", "/issue/save").hasRole(Role.USER.name())
                        .requestMatchers("/login/**").authenticated()
                                .anyRequest().permitAll()
                )
                .logout(
                        (logoutConfig) -> logoutConfig.logoutSuccessUrl("/")
                )

                .oauth2Login(Customizer.withDefaults());

        return http.build();
    }
}
package fr.dawan.formationspring.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.PathPatternRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) {
		return http
				.authorizeHttpRequests(
						auth -> auth.requestMatchers("/articles/**").authenticated()
						.anyRequest().permitAll())
				.formLogin(login -> login.loginPage("/login").failureUrl("/login?error"))
				.logout((logout) -> logout.logoutSuccessUrl("/users").permitAll()).build();
	}

}

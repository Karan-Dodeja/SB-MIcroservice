package com.photoapiservice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.photoapiservice.service.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurity {

	@Autowired
	private UserService userService;
	
	
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	
	
	public WebSecurity(UserService userService, BCryptPasswordEncoder bcryptPasswordEncoder) {
		super();
		this.userService = userService;
		this.bcryptPasswordEncoder = bcryptPasswordEncoder;
	}

	@Bean
	protected SecurityFilterChain configure(HttpSecurity http) throws Exception {

		AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
		AuthenticationManager authnticationManager = authenticationManagerBuilder.build();

		authenticationManagerBuilder.userDetailsService(userService).passwordEncoder(bcryptPasswordEncoder);
		
		http.csrf().disable();
		
		http.authorizeHttpRequests()
		.requestMatchers(HttpMethod.POST, "/users").permitAll()
		.requestMatchers(new AntPathRequestMatcher("/h2-console/**")).permitAll()
		.and()
		.addFilter(new AuthenticationFilter(authnticationManager, null))
		.authenticationManager(authnticationManager)
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		http.headers().frameOptions().disable();
		
		return http.build();
	}
}

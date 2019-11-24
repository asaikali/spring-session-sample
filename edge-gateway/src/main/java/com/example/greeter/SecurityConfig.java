package com.example.greeter;

import org.springframework.boot.autoconfigure.security.reactive.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig  {

	// @formatter:off
	// tag::config[]

	public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
		return http
			.authorizeExchange()
				.matchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
				.and()
				.csrf().disable()
			.formLogin()
				.and().build();
	}
	// end::config[]
	// @formatter:on

}

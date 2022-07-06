package com.agreggio.challenge.slingr.math.common.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http.headers().frameOptions().disable();
		 http.csrf().disable()
				 .exceptionHandling().authenticationEntryPoint(customAuthenticationEntryPoint).and()
			.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
			.authorizeRequests()
				 .antMatchers(HttpMethod.POST,"/login").permitAll()
				 .antMatchers(HttpMethod.GET,
                    "/v2/api-docs",
                    "/swagger-resources/**",
                    "/swagger-ui.html**",
                    "/webjars/**",
                    "favicon.ico").permitAll()
				 .antMatchers("/expressions/**").hasAnyRole("USER","ADMIN")
				 .antMatchers("/**").hasRole("ADMIN");
	}


}
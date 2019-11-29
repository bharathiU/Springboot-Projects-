package com.bankapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;



@EnableWebSecurity
public class SecConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userdetailsService;

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userdetailsService);
		

	}

	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}



	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
				.antMatchers("/user/**").hasAnyRole("ADMIN")
				.antMatchers("/mgr/**").hasAnyRole("ADMIN", "MGR")
				.antMatchers("/clerk/**").hasAnyRole("CLERK", "ADMIN", "MGR").antMatchers("/home/**")
				.authenticated().and().formLogin().loginPage("/mylogin")
				.loginProcessingUrl("/myloginprocessor")
				.usernameParameter("name")
				.passwordParameter("password")
				.defaultSuccessUrl("/home")
				.permitAll().
				
				and().httpBasic();
	}

}

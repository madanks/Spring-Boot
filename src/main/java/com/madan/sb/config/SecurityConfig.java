package com.madan.sb.config;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource datasource;// for jdbc authentication

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		
/*		  auth.inMemoryAuthentication()
		  .withUser("madan").password("krishna").roles("USER").and()
		  .withUser("sabu").password("kali").roles("ADMIN").and()
		  .withUser("mk").password("km").roles("ADMIN","USER");*/
		 
		final String findUserQuery = "select username,password,enabled from User where username = ?";
		final String findRoles = "select username,role from Roles where username = ?";

		auth.jdbcAuthentication().dataSource(datasource).usersByUsernameQuery(findUserQuery)
				.authoritiesByUsernameQuery(findRoles);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.httpBasic().and().authorizeRequests().antMatchers(HttpMethod.POST, "/save").hasRole("ADMIN")
				.antMatchers(HttpMethod.PUT, "/update/**").hasRole("ADMIN").antMatchers(HttpMethod.DELETE, "/delete/**")
				.hasRole("ADMIN").antMatchers(HttpMethod.GET, "/findall/**").hasRole("USER")
				.antMatchers(HttpMethod.GET, "/find/**").hasRole("USER").and().csrf().disable();
	}
}

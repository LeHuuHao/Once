package com.trungtamjava.hellospringboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
//password =12312436==>asdasjfgf
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);
		return bCryptPasswordEncoder;

	}
//phan quyen
	@Override
    protected void configure(HttpSecurity http) throws Exception {
	http.authorizeRequests()
		.antMatchers("/admin/**")
		.hasAnyAuthority("ROLE_ADMIN")
		
		.antMatchers("/member/**")
		.authenticated()
		
		.anyRequest().permitAll()

		.and().formLogin().defaultSuccessUrl("/welcome"); //duong dan thanh cong
    }
}

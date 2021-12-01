package com.trungtamjava.hellospringboot;

import org.aspectj.weaver.ast.And;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;// can phai co 1 bean
   //xac thuc
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		/// 123456 -> asdaaszxcsdas: bao mat hon
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);
		return bCryptPasswordEncoder;
	}
	  @Override
	    protected void configure(HttpSecurity http) throws Exception {
		http.cors().disable().csrf().disable().authorizeRequests()
			.antMatchers("/admin/**").hasAnyAuthority("ROLE_ADMIN")

			.antMatchers("/member/**").authenticated()

			.anyRequest().permitAll()

			.and().formLogin()
			.loginPage("/login")//dan ve trang get mapping login controller
			.defaultSuccessUrl("/welcome")//duong dan thanh cong
			.and().logout().logoutUrl("/logout")
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))//duong dan thanh con
			.and().httpBasic();
		    
		
	    }
}

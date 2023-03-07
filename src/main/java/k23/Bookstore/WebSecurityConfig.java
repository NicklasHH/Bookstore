package k23.Bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import k23.Bookstore.web.UserDetailServiceImpl;

@Configuration
@EnableWebSecurity // SB2.7
@EnableGlobalMethodSecurity(prePostEnabled = true) // SB2.7
public class WebSecurityConfig {
	@Autowired
	private UserDetailServiceImpl userDetailsService;

	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/css/**").permitAll() // Enable css when logged out
		.and()
		.authorizeRequests().anyRequest().authenticated()
		.and() // h2
		.headers().frameOptions().disable() // h2
		.and()
		.formLogin().defaultSuccessUrl("/booklist", true)
		.and()
		.logout().permitAll();

		http.cors().and().csrf().disable();  // h2
		
		
		//ohjelmistoprojekti1 matskuun tää ->
		// .addFilterAfter(new CsrfLoggerFilter(), CsrfFilter.class;
		return http.build();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
}
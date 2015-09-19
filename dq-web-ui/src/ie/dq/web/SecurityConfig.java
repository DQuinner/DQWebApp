package ie.dq.web;

import ie.dq.web.security.UserDetailsServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	  auth.userDetailsService(userDetailsService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

	  http.authorizeRequests()
		.antMatchers("/home/**").access("hasRole('ROLE_USER')")
		.antMatchers("/media/**").access("hasRole('ROLE_USER')")
		.antMatchers("/user-admin/**").access("hasRole('ROLE_ADMIN')")
		.and()
			.formLogin().loginPage("/login").failureUrl("/login?login_error=true")
			.loginProcessingUrl("/j_spring_security_check")
		    .usernameParameter("username").passwordParameter("password")
	  	.and()
	  		.logout().logoutSuccessUrl("/login?logout=true")
	  		.deleteCookies("JSESSIONID")
	  		.invalidateHttpSession(true)
        .and()
        	.csrf().disable();
	  
	}
	
	@Bean
	protected UserDetailsServiceImpl userDetailsServiceImpl(){
		UserDetailsServiceImpl userDetailsService = new UserDetailsServiceImpl();
		return userDetailsService;
	}

}

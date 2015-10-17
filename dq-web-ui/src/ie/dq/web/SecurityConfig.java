package ie.dq.web;

import ie.dq.web.security.UserDetailsServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@ImportResource("classpath:dq-web-facade-context.xml")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	  auth.userDetailsService(userDetailsService);
	}
	
	@Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**");
        web.ignoring().antMatchers("/js/**");
        web.ignoring().antMatchers("/image/**");
        web.ignoring().antMatchers("/fonts/**");
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
        .authorizeRequests()
            .antMatchers("/home/**").hasRole("USER")
            .antMatchers("/media/**").hasRole("USER")
            .antMatchers("/user-admin/**").hasRole("ADMIN")
            .anyRequest().authenticated()
        .and()
        	.formLogin()
            .loginPage("/login")
            .loginProcessingUrl("/j_spring_security_check" )	
            .defaultSuccessUrl("/signIn")
            .failureUrl("/login?login_error=true")
            .permitAll()
        .and()
            .httpBasic()
        .and()
        	.logout()
        	.logoutUrl("/logout")
	  		.logoutSuccessUrl("/login?logout=true")
	  		.deleteCookies("JSESSIONID")
	  		.invalidateHttpSession(true)
	  		.permitAll()
	  	.and()
	  		.exceptionHandling().accessDeniedPage("/login?denied=true")
        .and()
        	.csrf().disable();
	}
	
	@Bean
	protected UserDetailsServiceImpl userDetailsServiceImpl(){
		UserDetailsServiceImpl userDetailsService = new UserDetailsServiceImpl();
		return userDetailsService;
	}

}

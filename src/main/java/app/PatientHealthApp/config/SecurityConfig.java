package app.PatientHealthApp.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import app.PatientHealthApp.services.UserServiceDetailsImpl;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserServiceDetailsImpl uDetails;
	@Override
	protected void configure (HttpSecurity https) throws Exception {
		//for testing purposes - to be configured later
//		https.authorizeRequests().antMatchers("/").permitAll(); 
		

		https
				.requiresChannel()
				.anyRequest()
				.requiresSecure()
			.and()
				.authorizeRequests().antMatchers("/","/home","/validate","/resources/**", "/img/**.jpg").permitAll()
				
				.antMatchers("/doctor/**").hasRole("DOCTOR")
				.antMatchers("/patient/**").hasRole("PATIENT")
				.antMatchers("/admin/**","/ajax/**").hasRole("ADMIN")
				.anyRequest().authenticated() // all request should be authenticated...
				
				.and().formLogin()
				.passwordParameter("password")
				.usernameParameter("username")
				.loginPage("/login") // for custom page - later on
				.defaultSuccessUrl("/", true)
				.loginProcessingUrl("/authenticateUser") //for custom Processing
				.permitAll()	//...except default Spring Login page
				
				.and().rememberMe()
				.rememberMeCookieName("PatientApp")
				.rememberMeParameter("rememberMe")
				.tokenValiditySeconds(172800)
				
				.and().logout()
					.invalidateHttpSession(true)
					.deleteCookies("JSESSIONID")//delete Spring default cookies
					.deleteCookies("PatientApp")
					.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
					.logoutSuccessUrl("/login?logout")
					.permitAll()
					
				.and().exceptionHandling().accessDeniedPage("/login-error") 
				// same as error page so hackers can' tell whether there is a resource page at that request 
		;
	}
	
	@Autowired
	public void configureGlobal (AuthenticationManagerBuilder auth ) throws Exception {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		auth.userDetailsService(uDetails).passwordEncoder(encoder);
	}
}

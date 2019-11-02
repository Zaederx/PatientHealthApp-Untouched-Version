package app.PatientHealthApp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import app.PatientHealthApp.services.PatientServiceDetailsImpl;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private PatientServiceDetailsImpl pDetails;
	@Override
	protected void configure (HttpSecurity https) throws Exception {
		//for testing purposes - to be configured later
//		https.authorizeRequests().antMatchers("/").permitAll(); 
		
		https.authorizeRequests() 
				.anyRequest().authenticated() // all request should be authenticated...
				
				.and().formLogin()
				.loginPage("/login") // for custom page - later on
				.loginProcessingUrl("/authenticateUser") //for custom Processing
				.permitAll()	//...except default Spring Login page
		;
	}
	
	@Autowired
	public void configureGlobal (AuthenticationManagerBuilder auth ) throws Exception {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		auth.userDetailsService(pDetails).passwordEncoder(encoder);
	}
}

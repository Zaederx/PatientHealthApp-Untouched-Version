package app.PatientHealthApp.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import app.PatientHealthApp.Patient;

public interface UserServices {
	
	Patient getPatientById (int id);
	

	UserDetails getPatientByUsername(String username) throws UsernameNotFoundException;
	
}

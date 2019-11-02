package app.PatientHealthApp.services;

import java.util.List;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import app.PatientHealthApp.domain.Doctor;
import app.PatientHealthApp.domain.Patient;
import app.PatientHealthApp.repository.PatientRepository;

/**
 * 
 * @author Zachary Ishmael
 * 
 * An interface that establishes necessary Service to be implemented.
 * All implementations take place in UserServiceDetailsImpl.
 */
public interface PatientServices {
	
	/*** Patient Services***/
	Patient getPatientById (int id);
	

	Patient getPatientByUsername(String username) throws UsernameNotFoundException;
	
	PatientRepository getPatientRepo();
	
	
	/*** Doctor Services***/
	Doctor getDoctorById (int id);
	

	Doctor getDoctorByUsername(String username) throws UsernameNotFoundException;


	


//	DoctorRepository getDoctorRepo();
	
	/*** Admin Services***/
//	Admin getAdminById (int id);
//	
//
//	Admin getAdminByUsername(String username) throws UsernameNotFoundException;
//
//
//	AdminRepository getDoctorRepo();
	
	
}

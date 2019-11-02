package app.PatientHealthApp;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import app.PatientHealthApp.domain.Patient;
import app.PatientHealthApp.services.PatientServiceDetailsImpl;
import app.PatientHealthApp.services.PatientServices;



/**
 * 
 * @author Zachary Ishmael
 * Class used to run the app.
 * Implements CommandLineRunner - indicates that the class should be run when 
 * within a Spring Application.
 *
 */

@SpringBootApplication
public class ChronicPatientHealthApp implements CommandLineRunner{
	
	@Autowired
	PatientServiceDetailsImpl patientServices; 

	public static void main(String[] args) {
		SpringApplication.run(ChronicPatientHealthApp.class, args);
	}

	@Override
	@Transactional
	public void run (String ... strings ) throws Exception {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
//		Patient p = new Patient("Zach");
//		p.setPassword(encoder.encode("password"));
//		p.setEmail("email@email.com");
//		p.setUsername("ZI");
//		p.setRole("PATIENT");
//		patientServices.save(p);
		
	}
}

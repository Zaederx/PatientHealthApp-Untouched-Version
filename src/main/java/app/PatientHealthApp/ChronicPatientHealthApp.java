package app.PatientHealthApp;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import app.PatientHealthApp.domain.Patient;
import app.PatientHealthApp.domain.User;
import app.PatientHealthApp.repository.UserRepository;
import app.PatientHealthApp.services.PatientServices;
import app.PatientHealthApp.services.UserServiceDetailsImpl;



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
	UserRepository uRepo;
	 

	public static void main(String[] args) {
		SpringApplication.run(ChronicPatientHealthApp.class, args);
	}

	@Override
	@Transactional
	public void run (String ... strings ) throws Exception {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
//		Patient p = new Patient();
//		p.setName("Zach");
//		p.setPassword(encoder.encode("password"));
//		p.setEmail("email@email.com");
//		p.setUsername("ZI");
//		p.setRole("PATIENT");
//		uRepo.save(p);
		
	}
}

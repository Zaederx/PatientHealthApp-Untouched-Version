package app.PatientHealthApp;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import app.PatientHealthApp.domain.Admin;
import app.PatientHealthApp.domain.Doctor;
import app.PatientHealthApp.domain.Medication;
import app.PatientHealthApp.domain.Patient;
import app.PatientHealthApp.domain.Prescription;
import app.PatientHealthApp.domain.User;
import app.PatientHealthApp.repository.DoctorRepository;
import app.PatientHealthApp.repository.MedicationRepository;
import app.PatientHealthApp.repository.PatientRepository;
import app.PatientHealthApp.repository.PrescriptionRepository;
import app.PatientHealthApp.repository.UserRepository;
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
	
	@Autowired
	DoctorRepository dRepo;
	 
	@Autowired
	PatientRepository pRepo;
	
	@Autowired
	MedicationRepository mRepo;
	
	@Autowired
	PrescriptionRepository presRepo;

	public static void main(String[] args) {
		SpringApplication.run(ChronicPatientHealthApp.class, args);
	}

	@Override
	@Transactional
	public void run (String ... strings ) throws Exception {
//		testUsers();
		
	}
	
	private void testUsers() {
		
		//Demo Admin
		Admin admin = new Admin();
		admin.setName("Zach");
		admin.setUsername("Z");
		admin.setPassword("password");
		admin.setId(5);
		uRepo.save(admin);
		
		
		//Demo Doctor
		Doctor doctor = new Doctor();
		doctor.setName("JIM");
		doctor.setPassword("password");
		doctor.setUsername("JIM");
		uRepo.save(doctor);
		
		
		//Demo Patient
		Medication meds = new Medication("med1","desscription1","dosage1");
		mRepo.save(meds);
		Prescription pres = new Prescription(meds);
		pres.setDirections("directions1");
		List<Prescription> prescriptions = new ArrayList<Prescription>();
		prescriptions.add(pres);
		presRepo.save(prescriptions);
		
		Patient p = new Patient();
		p.setName("Zach");
		p.setEmail("email@email.com");
		p.setPassword("password");
		p.setUsername("zim");
		p.setPrescriptions(prescriptions);
		uRepo.save(p);
	}
}

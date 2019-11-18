package app.PatientHealthApp.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import app.PatientHealthApp.addressEnums.PAddressBook;
import app.PatientHealthApp.domain.Patient;
import app.PatientHealthApp.repository.PatientRepository;

@Controller
@RequestMapping("patient")
public class PatientController {
	
	@Autowired
	PatientRepository pRepo;
	
	@GetMapping("/home")
	public String patientHome(){
		return PAddressBook.P_HOME.resource();
	}
	
	@GetMapping("patient-prescriptions")
	public String prescriptions (Principal principal) {
		Patient p = pRepo.findByUsername(principal.getName());
	
		return null;
	}

}

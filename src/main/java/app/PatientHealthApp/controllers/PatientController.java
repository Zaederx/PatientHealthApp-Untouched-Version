package app.PatientHealthApp.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import app.PatientHealthApp.addressEnums.PAddressBook;
import app.PatientHealthApp.domain.Patient;
import app.PatientHealthApp.repository.PatientRepository;

@Controller
@RequestMapping("patient/")
public class PatientController {
	
	@Autowired
	PatientRepository pRepo;
	
	@GetMapping("home")
	public String patientHome(){
		return PAddressBook.P_HOME.resource();
	}
	
	@GetMapping("prescriptions")
	public String prescriptions () {
	
		return "patient/patient-prescriptions";
	}
	
	@GetMapping("details")
	public String viewPatientDetails() {
	
		return "patient/patient-details";
	}

}

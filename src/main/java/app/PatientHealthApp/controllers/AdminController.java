package app.PatientHealthApp.controllers;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import app.PatientHealthApp.addressEnums.AdminAddressBook;
import app.PatientHealthApp.domain.Doctor;
import app.PatientHealthApp.domain.Patient;
import app.PatientHealthApp.formObjects.AdminRegForm;
import app.PatientHealthApp.formObjects.DoctorRegForm;
import app.PatientHealthApp.formObjects.PatientRegForm;
import app.PatientHealthApp.repository.AdminRepository;
import app.PatientHealthApp.repository.DoctorRepository;
import app.PatientHealthApp.repository.PatientRepository;

@Controller
@RequestMapping("admin")
public class AdminController {
	
	@Autowired
	DoctorRepository dRepo;
	
	@Autowired
	PatientRepository pRepo;
	
	@Autowired
	AdminRepository aRepo;
	
	@GetMapping("/home")
	public String adminHome() {
		return AdminAddressBook.A_HOME.resource();
	}
	
	@GetMapping("/assistance")
	public String getAssistance() {
		return "/admin/admin-assistance";
	}
//	@GetMapping("/adminUser")
//	public String addUserPage() {
//		return AdminAddressBook.A_ADD_USER.resource();
//	}
//	
//	@PostMapping("/addDoctor")
//	public String addDoctor(@ModelAttribute("doctorForm") DoctorForm doctorForm, Model model) {
//		Doctor doctor = new Doctor(doctorForm);
//		dRepo.save(doctor);
//
//		return "redirect:"+AdminAddressBook.A_ADD_USER.resource();
//	}
	
	@GetMapping("/search-users")
	public String searchUsers() {
		
		return "admin-search-users";
	}
	
	@GetMapping("/register-users")
	public String viewUsers(Model model) {
		model.addAttribute("patientRegForm", new PatientRegForm());
		model.addAttribute("doctorRegForm", new DoctorRegForm());
		model.addAttribute("adminRegForm", new AdminRegForm());
		return "admin/admin-register-users";
	}
	
	@PostMapping("register-patient")
	public String registerPatient(@Valid @ModelAttribute PatientRegForm form, BindingResult result, Model model) {
		Patient p = new Patient(form);
		pRepo.save(p);
		if(result.hasErrors()) {
			return "redirect:/admin/register-users";
		}
		String success = "Patient added successfully.";
		
		return "redirect:/admin/register-users?success="+success;
	}

//	@PostMapping("removeDoctor")
//	public String removeDoctor() {
//		//TODO
//		return null;
//	}
//	

//	
//	@PostMapping("/removePatient")
//	public String removePatient() {
//		//TODO
//		return null;
//	}
//	

//	
//	@PostMapping("/removeAdmin")
//	public String removeAdmin() {
//		//TODO
//		return null;
//	}
	
	
}

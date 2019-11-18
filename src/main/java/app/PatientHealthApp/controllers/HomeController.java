package app.PatientHealthApp.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import app.PatientHealthApp.addressEnums.AdminAddressBook;
import app.PatientHealthApp.addressEnums.DoctorAddressBook;
import app.PatientHealthApp.addressEnums.HomeAddressBook;
import app.PatientHealthApp.addressEnums.PAddressBook;
import app.PatientHealthApp.repository.UserRepository;

@Controller
public class HomeController {
	@Autowired
	UserRepository uRepo;
	
	@GetMapping("/")
	public String root() {
		return "redirect:/home";
	}
	
	@GetMapping("/authenticatedUsed") 
	public String userHome () {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String role = auth.getAuthorities().stream().findFirst().get().getAuthority();
		System.out.println("Role: "+role);
		switch (role) {
		case "ROLE_PATIENT": return "redirect:"+PAddressBook.P_HOME.controller();
		case "DOCTOR":  return "redirect:"+DoctorAddressBook.D_HOME.controller();
		case "ADMIN": return "redirect:"+AdminAddressBook.A_HOME.controller();
		}
		return "redirect:/home";
	}
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/home/registration")
	public String register () {
		return "/register";
	}
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		
		String view = "login";
		return view;
	}
	
//	@GetMapping("/welcome")
//	public String welcome(@RequestParam(required = false, defaultValue = "Tim") String name, Model model) {
//		model.addAttribute("name", name);
//		return "welcome";
//	}
	
	
//	@RequestMapping(value="/static", method = RequestMethod.GET)
//	public String viewStatic() {
//		String view = "static";
//		return view;
//	}

	
}

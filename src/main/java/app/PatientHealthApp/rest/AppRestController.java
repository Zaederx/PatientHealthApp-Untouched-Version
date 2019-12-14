package app.PatientHealthApp.rest;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import app.PatientHealthApp.domain.Patient;
import app.PatientHealthApp.domain.User;
import app.PatientHealthApp.formObjects.Response;
import app.PatientHealthApp.repository.UserRepository;
import app.PatientHealthApp.services.UserServiceDetailsImpl;

@RestController
@RequestMapping("ajax")
public class AppRestController {
	@Autowired
	UserRepository uRepo;
	
	@Autowired
	UserServiceDetailsImpl uService;
	@GetMapping("/search-user/{username}")
	public String getUsername(@PathVariable String username) {
		
		User user = uRepo.findByUsername(username);
		
		return username;
		
	}
	
	@GetMapping("/search-name/{name}")
	public List<User> getUserByName(@PathVariable String name) {
		List users = uRepo.findByName(name);
		return users;
	}
	
	@GetMapping("/is-user/{username}")
	public Response isUsername(@PathVariable(required = false) String username) {
		Response res = new Response();
		boolean exits = true;
		
		if(username.isBlank()) {
			res.setResponse(!exits);
			return res;
			}
		System.out.println("is-user/{username} called");
		User user = uRepo.findByUsername(username);
		try {
		if ( user != null) {
			res.setResponse(exits);
			res.setErrorMessage("Username already exists. Choose another username.");
			return res;
		}}
		catch (Exception e) {
			res.setResponse(exits);
			return res;
		}
		System.out.println("response = true");
		res.setResponse(!exits);
		return res;
	}
	
	@GetMapping("/is-valid/email/{email}")
	public Response isValidEmail(@PathVariable(required = false) String email) {
		Response res = new Response();
		boolean valid = true;
		
		if (email.isBlank()) {
			res.setResponse(!valid);
		}
		
		System.out.println("/is-valid/email/{email} - called");
		
		Patient p = uService.getPatientRepo().findByEmail(email);
		String emailPattern = "[a-z0-9._%+-]+@[a-z0-9.-]+\\\\.[a-z]{2,}$";//TODO - is this the best regex pattern for email???
		boolean matches = Pattern.matches(emailPattern, email);
		
		if(!matches) {
			res.setResponse(!valid);
			res.setErrorMessage("Passwords do not match."
					+ " Please enter your password correctly both times.");
		}
		
		try {
			if (p != null) {
				res.setResponse(valid);
				res.setErrorMessage("This email is already in use."
						+ " Please choose a unique email or contact our "
						+ "administrative team for assistance.");//TODO - help / support / assistance ?? which is better
				return res;
			} 
		} catch (Exception e) {
			res.setResponse(valid);
			res.setErrorMessage("There seems to be a problem."
					+ " Please contact our administrative team for assistance.");//TODO
			return res;
		}
		res.setResponse(!valid);
		
		return res;
	}
	
	@GetMapping("/is-valid/password/{password}/{passwordTwo}")
	public Response isValidPassword(@PathVariable(required = false) String password, @PathVariable(required = false) String passwordTwo) {
		Response res = new Response();
		boolean valid = false;
		
		if (password.isBlank()) {
			res.setResponse(!valid);
		}
		
		//TODO - Check whether passwords match regex pattern
		
		//IF PASSWORD 2 IS NOT NULL - THEN {
		//TODO - Check whether password 1 and 2 match each other
		//}
		if (password != null && passwordTwo != null) {
			if (password.equals(passwordTwo)) {
				res.setResponse(valid);
				return res;
			}
			res.setResponse(!valid);
			res.setErrorMessage("Passwords do not match.");
			return res;
		}
		
		//TODO - 
		return res;
	}
	
	@GetMapping("/matches/{passwordTwo}/{password}")
	public Response passwordsMatch() {
		Response res = new Response();
		
		return res;
	}
}

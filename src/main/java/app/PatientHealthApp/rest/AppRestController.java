package app.PatientHealthApp.rest;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.PatientHealthApp.domain.Patient;
import app.PatientHealthApp.domain.User;
import app.PatientHealthApp.jsonObject.Response;
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
	
	/**
	 * Used to check whether a username is foudn in Database.
	 * Can be user for any user class/entity.
	 * @param username
	 * @return
	 */
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
	
	/**
	 * Check whether an email is found in the Database.
	 * This method is only necessary for the patient class,
	 * as they are the only class that have emails registered.
	 * @param email
	 * @return
	 */
	@GetMapping("/is-valid/email/{email}")
	public Response isValidEmail(@PathVariable(required = false) String email) {
		Response res = new Response();
		boolean valid = false;
		
		if (email.isBlank()) {
			res.setResponse(!valid);
		}
		
		System.out.println("/is-valid/email/{email} - called");
		
		Patient p = uService.getPatientRepo().findByEmail(email);
		String emailPattern = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}$";//TODO - is this the best regex pattern for email???
		boolean matches = Pattern.matches(emailPattern, email);
		
		if(!matches) {
			res.setResponse(!valid);
			res.setErrorMessage("Not valid email. Please enter a valid email address "
					+ "or contact our administrative team for assistance.");
			return res;
		}
		
		try {
			if (p != null) {
				res.setResponse(!valid);
				res.setErrorMessage("This email is already in use."
						+ " Please choose a unique email or contact our "
						+ "administrative team for assistance.");//TODO - help / support / assistance ?? which is better
				return res;
			} 
		} catch (Exception e) {
			res.setResponse(!valid);
			res.setErrorMessage("There seems to be a problem."
					+ " Please contact our administrative team for assistance.");//TODO
			return res;
		}
		res.setResponse(valid);
		
		return res;
	}
	
	@GetMapping(path = {"/is-valid/password/{password}","/is-valid/password/{password}/{passwordTwo}","/matches/{passwordTwo}","/matches/{password}/{passwordTwo}"})
	public Response isValidPassword(@PathVariable(required = false, name="password") String password, @PathVariable(required = false, name = "passwordTwo") String passwordTwo) {
		Response res = new Response();
		boolean valid = false;
		boolean p1Null = password == null;
		boolean p2Null = passwordTwo == null;
		
		if (p1Null || password.isBlank()) {
			res.setResponse(!valid);
			//TODO make error message more user friendly
			res.setErrorMessage("First password field is empty.");
			return res;
		}
		
//		if (p2Null || passwordTwo.isBlank()) {
//			res.setResponse(!valid);
//			//TODO make error message more user friendly
//			res.setErrorMessage("Second password field is empty.");
//			return res;
//		}
		
		//TODO - Check whether passwords match regex pattern
		String passwordPattern = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}";
		boolean matches = Pattern.matches(passwordPattern, password);
		String errorMessage = "Password should: be 8 characters long, contain a captial letter and a lowercased letter and contain a number.";

//		String len = ".{8,}";
////		String spec = "";
//		String cap = "([A-Z]).{1,}";
//		String low = "([a-z]).{1,}";
//		String num = "([0-9]).{1,}";
//		
//		String errorMessage = "Password should:";
//		String lError = "\n - be 8 characters in length";
//		String sError = "\n";
//		String capError = "\n - contain a captial letter";
//		String lowError = "\n - contain a lowercase letter";
//		String numError = "\n - contain a number";
//		
//		
//		String p = "";
//		if (!p1Null) {p = password;}
//		else if (!p2Null) {p = passwordTwo;}
//		
//		boolean matches = Pattern.matches(passwordPattern, p);
//		boolean length = Pattern.matches(len, p);
////		boolean special = Pattern.matches(spec, p);
//		boolean capital = Pattern.matches(cap, p);
//		boolean lowercase = Pattern.matches(low, p);
//		boolean number = Pattern.matches(num, p);
//		
//		if (length) {errorMessage+= lError;}
////		if (!special) {}
//		if (capital) {errorMessage+= capError;}
//		if (lowercase) {errorMessage+=lowError;}
//		if (number) {errorMessage+=numError;}
		
		if (!matches) {
			res.setResponse(!valid);
			res.setErrorMessage(errorMessage);
			
//			return res;
		}
		
		//IF PASSWORD 2 IS NOT NULL - THEN {
		//TODO - Check whether password 1 and 2 match each other
		//}
		if (!p1Null && !p2Null) {
			if (!password.equals(passwordTwo)) {
				res.setResponse(!valid);
				errorMessage += "Passwords do not match.";
				res.setErrorMessage(errorMessage);
				return res;
			}
			res.setResponse(valid);
			return res;
		}
		//if null
		return res;
	}
	
	@GetMapping("/matches/{passwordTwo}/{password}")
	public Response passwordsMatch(@PathVariable(required = false) String password, @PathVariable(required = false) String passwordTwo) {
		Response res = new Response();
		
		boolean valid = false;
		
		if (password.isBlank()) {
			res.setResponse(!valid);
		}
		
		if (password != null && passwordTwo != null) {
			if (password.equals(passwordTwo)) {
				res.setResponse(valid);
				return res;
			}
			res.setResponse(!valid);
			res.setErrorMessage("Passwords do not match.");
			return res;
		}
		
		return res;
	}
	
	
	
	/**
	 * Used to validate a doctor GMC code
	 * Mock GMC check - no real api accesible
	 */
	@GetMapping("is-valid/gmc/{gmc}")
	public Response isValidGMC() {
		
		return null;
	}
}

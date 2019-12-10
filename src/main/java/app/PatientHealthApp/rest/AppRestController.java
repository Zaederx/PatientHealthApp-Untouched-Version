package app.PatientHealthApp.rest;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
	public @ResponseBody String getUsername(@PathVariable String username) {
		
		User user = uRepo.findByUsername(username);
		
		return username;
		
	}
	
	@GetMapping("/search-name/{name}")
	public @ResponseBody List<User> getUserByName(@PathVariable String name) {
		List users = uRepo.findByName(name);
		return users;
	}
	
	@GetMapping("/is-user/{username}")
	public @ResponseBody Response isUsername(@PathVariable(required = false) String username) {
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
		boolean used = true;
		
		if (email.isBlank()) {
			res.setResponse(!used);
		}
		
		System.out.println("is-valid/email/{email} - called");
		
		Patient p = uService.getPatientRepo().findByEmail(email);
		
		try {
			if (p != null) {
				res.setResponse(used);
				res.setErrorMessage("This email is already in use."
						+ " Please choose a unique email or contact our "
						+ "administrative team for assistance.");//TODO - help / support / assistance ?? which is better
				return res;
			} 
		} catch (Exception e) {
			res.setResponse(used);
			res.setErrorMessage("There seems to be a problem."
					+ " Please contact our administrative team for assistance.");//TODO
			return res;
		}
		res.setResponse(!used);
		
		return res;
	}
}

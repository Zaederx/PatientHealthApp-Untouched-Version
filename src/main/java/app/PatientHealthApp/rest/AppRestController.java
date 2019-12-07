package app.PatientHealthApp.rest;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import app.PatientHealthApp.domain.User;
import app.PatientHealthApp.formObjects.Response;
import app.PatientHealthApp.repository.UserRepository;

@RestController
@RequestMapping("ajax")
public class AppRestController {
	@Autowired
	UserRepository uRepo;
	
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
	public @ResponseBody Response isUsername(@PathVariable String username) {
		Response res = new Response();
		System.out.println("is-user/{username} called");
		User user = uRepo.findByUsername(username);
		try {
		if ( user != null) {
			res.setResponse(true);
			return res;
		}}
		catch (Exception e) {
			res.setResponse(true);
			return res;
		}
		System.out.println("response = true");
		res.setResponse(false);
		return res;
	}
}

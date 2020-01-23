package app.PatientHealthApp.rest;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.PatientHealthApp.domain.Patient;
import app.PatientHealthApp.domain.Prescription;
import app.PatientHealthApp.jsonObject.PrescriptionResponse;
import app.PatientHealthApp.jsonObject.Response;
import app.PatientHealthApp.repository.PatientRepository;

@RestController
@RequestMapping("ajax/patient/")
public class PatientRestController {

	@Autowired
	HttpSession session;
	@Autowired
	PatientRepository pRepo;
	
	private String getUsername() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		return username;
	}
	
	@GetMapping("retrieve-u")
	public Object retrieveAccountUsername() {
		String username = getUsername();
		Response res = new Response();
		if (username != null) {
			res.setResponse(true);
			res.setMessage(username);
			res.setMessages(null);
		}
		
		return res;
	}
//	@GetMapping("retrieve-p")
//	public Object retrieveAccountPassword() {
//		Response res = new Response();
//		String username = getUsername();
//		Patient p = null;
//		if (username != null) {
//			p = pRepo.findByUsername(username);
//		}
//		String password = null;
//		password = p.getPassword();
//		
//
//		res.setResponse(true);
//		res.setMessage(password);
//		
//		return res;
//	}
	
	
	
	
	@GetMapping("prescriptions")
	public Object getPrescriptions() {
		String username = getUsername();
		Response res = new Response();
		
		Patient p = null;
		if (username != null) {
			p = pRepo.findByUsername(username);
		} else {
			res.setResponse(false);
			res.setMessage("Invalid user session. Please try logging in again.");
		}
		if (p != null) {
			PrescriptionResponse pRes = new PrescriptionResponse(p.getPrescriptions());
			return pRes;
		}
		
		
		res.setResponse(false);
		res.setMessage("No Active Prescriptions");
		
		return res;
	}
	
	@GetMapping("editAccount")
	public Object editAccount(@RequestParam(name = "username") String newUsername, @RequestParam(name = "current", defaultValue = "empty") String currentP, @RequestParam(name = "new", defaultValue = "empty") String newP, @RequestParam(name = "repeat", defaultValue = "empty") String repeatP) {
		Response res = new Response();
		String currentUsername = getUsername();
		
		boolean emptyParam = false;
		/* Check if fields*/
		if (newUsername.equals("empty")) {
			emptyParam = true;
			res.getMessages().add("Please enter a new username.");
		}
		
		if (currentP.equals("empty")) {
			emptyParam = true;
			res.getMessages().add("Please enter your current password.");
		}
		
		if (newP.equals("empty")) {
			emptyParam = true;
			res.getMessages().add("Please enter a new password.");
		}
		
		if (repeatP .equals("empty")) {
			emptyParam = true;
			res.getMessages().add("Please repeat your new password.");
		}
		
		if (emptyParam) {
			res.setResponse(false);
			return res;
		}
		
		Patient p = null;
		p = pRepo.findByUsername(currentUsername);
		if (p != null) {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			encoder.matches(currentP, p.getPassword());
			/*Set new field values*/
			if (newP.equals(repeatP)) {
				
				
				p.setPassword(newP);
				p.setUsername(newUsername);
				pRepo.save(p);
				
				/*Manually (Re)authenticate user*/
				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(newUsername, newP);
				SecurityContext context = SecurityContextHolder.getContext();
				context.setAuthentication(authToken);
				/*Return Context to HTTP session*/
				session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, context);
				
				res.setResponse(true);
				res.setMessage(null);
				res.getMessages().add("Account Succesfully Added");
				return res;
			}
			res.setResponse(false);
			res.getMessages().add("Passwords do not match");
		}
		
		return res;
	}
}

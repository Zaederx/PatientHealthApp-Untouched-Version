package app.PatientHealthApp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.PatientHealthApp.jsonObject.Response;

/**
 * Mock Api for requesting doctor GMC.
 * Used to check that a doctor is a certified doctor.
 * @author Zachary Ishmael
 *
 */
@RestController
@RequestMapping("national-medical-services/gmc/api")
public class MockGMCApi {

	@GetMapping("/{gmc}")
	public Response isValidGMC(@PathVariable Integer gmc) {
		Response res = new Response();
		
		if (gmc == null) {
			res.setResponse(false);
		}
		
		else {
			res.setResponse(true);
		}
		
		return res;
	}
}

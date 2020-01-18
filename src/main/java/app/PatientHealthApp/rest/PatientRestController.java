package app.PatientHealthApp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	PatientRepository pRepo;
	
	@GetMapping("prescriptions")
	public Object getPrescriptions() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		Response res = new Response();
		
		Patient p = null;
		if (username != null) {
			p = pRepo.findByUsername(username);
		} else {
			res.setResponse(false);
			res.setErrorMessage("Invalid user session. Please try logging in again.");
		}
		if (p != null) {
			PrescriptionResponse pRes = new PrescriptionResponse(p.getPrescriptions());
			return pRes;
		}
		
		
		res.setResponse(false);
		res.setErrorMessage("No Active Prescriptions");
		
		return res;
	}
}

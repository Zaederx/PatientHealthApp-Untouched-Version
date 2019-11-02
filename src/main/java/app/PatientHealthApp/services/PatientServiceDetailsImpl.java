package app.PatientHealthApp.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import app.PatientHealthApp.domain.Doctor;
import app.PatientHealthApp.domain.Patient;
import app.PatientHealthApp.repository.PatientRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
/**
 * 
 * @author Zachary Ishmael
 * Class for Patient Authorisation.
 */
@Service
public class PatientServiceDetailsImpl implements PatientServices, UserDetailsService{
	
	@Autowired
	private PatientRepository patRepo;

	/**
	 * A Patient Implementation of loadUserByUsername.
	 */
	@Override
	@Transactional
	public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException {
		
		System.out.println("\n***************** LoadByUsername Called**************");
		System.out.println(username);
		Patient p =  patRepo.findByUsername(username);
		
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNotLocked  = true;
		
		ArrayList<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		if (p.getRole().equals("PATIENT")) {
			System.out.println("Patient created and granted authority.");
		} authorities.add(new SimpleGrantedAuthority("ROLE_PATIENT"));
		
		return new User(
				username,
				p.getPassword(),
				enabled, 
				accountNonExpired,
				credentialsNonExpired, 
				accountNotLocked,
				authorities
				);
	}
	
	public void save(Patient patient) {
		patRepo.save(patient);
	}

	@Override
	public Patient getPatientById(int id) {
		return patRepo.findById(id);
	}
	
	@Override
	public PatientRepository getPatientRepo() {
		return patRepo;
	}


	@Override
	public Doctor getDoctorById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Doctor getDoctorByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Patient getPatientByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	
}

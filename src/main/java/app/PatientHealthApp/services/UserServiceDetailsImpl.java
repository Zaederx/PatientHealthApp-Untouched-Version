package app.PatientHealthApp.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import app.PatientHealthApp.repository.AdminRepository;
import app.PatientHealthApp.repository.DoctorRepository;
import app.PatientHealthApp.repository.PatientRepository;
import app.PatientHealthApp.repository.UserRepository;

/**
 * Provides access to all User Repositories.
 * Implements {@link UserDetailsService}.
 * Also overrides {@code loadByUsername(String username)} method in 
 * UserDetails service to provide custom user roles assignment.
 * @author Zachary Ishmael
 *
 */
@Service
public class UserServiceDetailsImpl implements UserDetailsService{
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	PatientRepository pRepo;
	
	@Autowired
	DoctorRepository dRepo;
	
	@Autowired
	AdminRepository aRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("\n***************** LoadByUsername Called**************");
		System.out.println(username);
		app.PatientHealthApp.domain.User u =  userRepo.findByUsername(username);
		
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNotLocked  = true;
		
		ArrayList<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		String role = u.getRole();
		
			System.out.println(role+" created and granted authority.");
		authorities.add(new SimpleGrantedAuthority("ROLE_"+role));
		
		return new User(
				username,
				u.getPassword(),
				enabled, 
				accountNonExpired,
				credentialsNonExpired, 
				accountNotLocked,
				authorities
				);
	}

	/**
	 * @return the UserRepository
	 */
	public UserRepository getUserRepo() {
		return userRepo;
	}

	/**
	 * @return the PatientRepository.
	 */
	public PatientRepository getPatientRepo() {
		return pRepo;
	}

	/**
	 * @return the DoctorRepository
	 */
	public DoctorRepository getDoctorRepo() {
		return dRepo;
	}

	/**
	 * @return the AdminRepository
	 */
	public AdminRepository getAdminRepo() {
		return aRepo;
	}

}

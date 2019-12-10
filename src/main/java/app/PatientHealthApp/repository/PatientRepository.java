package app.PatientHealthApp.repository;



import org.springframework.data.repository.CrudRepository;

import app.PatientHealthApp.domain.Patient;

/**
 * A Repository used to interface with User data in the database.
 * 
 * By default certain methods are provided by CrudRepository.
 * 
 * @author Zachary Ishmael
 *
 */


public interface PatientRepository extends CrudRepository<Patient,Integer> {

	
	Patient findByUsername(String name);
	
	Patient findByEmail(String email);
	
	Patient findById(int id);
	
}

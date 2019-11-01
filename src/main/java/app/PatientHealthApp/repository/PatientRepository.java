package app.PatientHealthApp.repository;



import org.springframework.data.repository.CrudRepository;
import app.PatientHealthApp.Patient;

/**
 * A Repository used to interface with User data in the database.
 * 
 * By default certain methods are provided by CrudRepository.
 * 
 * @author Zachary Ishmael
 *
 */


public interface PatientRepository extends CrudRepository<Patient,Integer> {

	
	Patient findByName(String name);
	
	Patient findById(int id);
	
}

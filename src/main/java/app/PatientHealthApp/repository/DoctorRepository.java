package app.PatientHealthApp.repository;

import org.springframework.data.repository.CrudRepository;

import app.PatientHealthApp.domain.Doctor;

/**
 * A Repository used to interface with User data in the database.
 * 
 * By default certain methods are provided by CrudRepository.
 * 
 * @author Zachary Ishmael
 *
 */

public interface DoctorRepository extends CrudRepository<Doctor, Integer>{
	
	Doctor findByName(String name);
	Doctor findById(int id);

}

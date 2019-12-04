package app.PatientHealthApp.repository;

import org.springframework.data.repository.CrudRepository;

import app.PatientHealthApp.domain.Admin;

public interface AdminRepository extends CrudRepository<Admin, Integer>{
	
	Admin findByUsername(String username);
}

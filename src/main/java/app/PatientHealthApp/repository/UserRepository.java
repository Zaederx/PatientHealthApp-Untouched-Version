package app.PatientHealthApp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import app.PatientHealthApp.domain.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	
	User findByUsername(String username);
	
	List<User> findByRole(String role);

}

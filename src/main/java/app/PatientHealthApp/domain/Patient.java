package app.PatientHealthApp.domain;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * 
 * @author Zachary Ishmael<br>
 * 
 * Class used to represent patients with chronic illness.
 */

@Entity(name = "patient")
public class Patient extends User{
	
	@Column(name="email")
	private String email;
	

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "patients")
	public List<Doctor> doctors;
	
	@ManyToMany(fetch = FetchType.LAZY)
	public List<Prescription> prescriptions;
	
	//default constructor - needed by Spring
	public Patient() {
		
	}
	
	public Patient(String name, String username, String password, String role, String email) {
		super(name,username,password,role);
		this.email = email;
	}

	public void setEmail(String email) {
	this.email = email;
	}
	
}

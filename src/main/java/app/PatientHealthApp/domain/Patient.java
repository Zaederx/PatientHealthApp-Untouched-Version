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

import app.PatientHealthApp.formObjects.PatientRegForm;

/**
 * 
 * @author Zachary Ishmael<br>
 * 
 * Class used to represent patients with chronic illness.
 */

@Entity(name = "patient")
public class Patient extends User{
	
	@Column(name="email", unique = true)
	private String email;
	

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "patients")
	public List<Doctor> doctors;
	
	@ManyToMany(fetch = FetchType.LAZY)
	public List<Prescription> prescriptions;
	
	//default constructor - needed by Spring
	public Patient() {
		this.role = "PATIENT";
	}
	
	public Patient(String name, String username, String password, String role, String email) {
		super(name,username,password,"PATIENT");
		this.email = email;
	}

	public Patient(PatientRegForm form) {
		super(form.getName(), form.getUsername(),form.getPassword(),"PATIENT");
		this.email = form.getEmail();
	}
	public void setEmail(String email) {
	this.email = email;
	}
	
}

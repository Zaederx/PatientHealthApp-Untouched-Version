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
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "role")
	private String role = "PATIENT";
	
	@Column(name="email")
	private String email;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name = "name")
	private String name;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "patients")
	public List<Doctor> doctors;
	
	//default constructor - needed by Spring
	public Patient() {
		
	}
	
	public Patient(String name) {
		this.name = name;

	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getRole() {
		return role;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
	this.email = email;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
}

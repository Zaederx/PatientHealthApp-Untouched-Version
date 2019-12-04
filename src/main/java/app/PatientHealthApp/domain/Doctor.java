package app.PatientHealthApp.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import app.PatientHealthApp.formObjects.DoctorRegForm;
/**
 * Doctor {@link Entity} that defines doctor table.
 * 
 * @author Zachary Ishmael
 *
 */
@Entity(name= "doctor")
public class Doctor extends User {

	@Column
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "PatientsToDoctors", joinColumns=
	@JoinColumn ( name = "doctor_id"),
	inverseJoinColumns=@JoinColumn(name ="patient_id" ))
	public List<Patient> patients;
	
	public Doctor() {
		
	}
	
	public Doctor (String name, String username, String password, String role) {
		super(name,username,password,"DOCTOR");
	}
	
	public Doctor(DoctorRegForm form) {
		super(form.getName(),form.getUsername(),form.getPassword(),"DOCTOR");
	}
	
	public List<Patient> getPatients() {
		return patients;
	}
	
	public void setPatients(List<Patient>patients) {
		this.patients = patients;
	}
	
}

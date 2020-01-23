package app.PatientHealthApp.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import app.PatientHealthApp.formObjects.PatientRegForm;

/**
 * An {@link Entity} class used to represent patients with chronic illness.
 * @author Zachary Ishmael<br>
 */

@Entity(name = "patient")
public class Patient extends User{
	
	/* Account Details */
	@Column(name="email", unique = true)
	private String email;
	

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "patients")
	private List<Doctor> doctors;
	
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Prescription> prescriptions;
	
	@Column
	Date birthday;
	
	//default constructor - needed by Spring
	public Patient() {
		this.role = "PATIENT";
		this.birthday = new Date();
	}
	
	public Patient(String name, String username, String password, String role, String email, Date birthday) {
		super(name,username,password,"PATIENT");
		this.email = email;
		this.birthday = birthday;
	}

	public Patient(PatientRegForm form) {
		super(form.getName(), form.getUsername(),form.getPassword(),"PATIENT");
		this.email = form.getEmail();
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the doctors
	 */
	public List<Doctor> getDoctors() {
		return doctors;
	}

	/**
	 * @param doctors the doctors to set
	 */
	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	/**
	 * @return the prescriptions
	 */
	public List<Prescription> getPrescriptions() {
		return prescriptions;
	}

	/**
	 * @param prescriptions the prescriptions to set
	 */
	public void setPrescriptions(List<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}

	/**
	 * @return the birthday
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	
	
}

package app.PatientHealthApp.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
/**
 * @author Zachary Ishmael
 * 
 * Entity to represent doctor's prescription to a patient.
 * 
 * Each prescription has instructions to the patient
 * and references a medication in the Medication entity.
 * 
 *
 */

@Entity(name="prescription")
public class Prescription {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="directions", nullable = false)
	private String directions;
	
	@ManyToOne
	@JoinColumn(name="medication", referencedColumnName = "id")
	//@JoinColumn - allows for naming of this column and 
	//explicit reference data to be referenece  in this column from another tables column
	private Medication medication;
	
	
	
	public Prescription(String directions) {
		this.directions = directions;
	}
	
	
	public void setMedication (Medication medication) {
		this.medication = medication;
	}

}

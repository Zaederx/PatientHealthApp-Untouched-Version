package app.PatientHealthApp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * @author Zachary Ishmael<br>
 * 
 * @apiNote
 * Class used to represent medical drugs.<br>
 * 
 * Contains medication name, description of what it is used to treat
 * and manufacturer's dosage instructions.<br>
 * 
 * This class also keeps a list of all other medication names that
 * have been initailised or added.
 *
 */
@Entity(name = "Medication")
public class Medication {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
//	private static String[] medList;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	@Column(name = "Dosage_Instructions")
	private String dosageInstructions;//manufacturer's dosge instrcutions
	/*
	 *  An array of descriptive tags
	 *  - e.g. pain relief, anti-inflamatory, anti-histamine, etc.
	 */


	public Medication () {
		
	}
	
	public String getName() {
		return name;
	}
}

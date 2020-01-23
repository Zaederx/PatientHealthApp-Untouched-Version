package app.PatientHealthApp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * An {@link Entity} class used to store GMC codes.
 * @apiNote GMC codes are used to certify that someone is qualified doctor.
 * @author Zachary Ishmael
 *
 */
@Entity
public class GMC {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String code;
	
	@Column
	Boolean used;
	
	
	public GMC() {
	}
	
	public GMC(String code) {
		this.code = code;
		this.used = false;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
}

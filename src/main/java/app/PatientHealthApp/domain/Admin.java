package app.PatientHealthApp.domain;

import javax.persistence.Entity;

/**
 * Admin {@link Entity} class that defines admin table.
 * @author Zachary Ishmael
 *
 */
@Entity(name="admin")
public class Admin extends User {

	/*Default constructor - required by jpa/hibernate*/
	public Admin() {
		this.role = "ADMIN";
	}
	
	public Admin(String name, String username, String password) {
		super(name, username, password, "ADMIN");
	}
	

}

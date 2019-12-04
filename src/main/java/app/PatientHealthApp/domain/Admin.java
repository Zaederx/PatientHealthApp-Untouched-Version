package app.PatientHealthApp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * Admin {@link Enity} class that defines admin table.
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

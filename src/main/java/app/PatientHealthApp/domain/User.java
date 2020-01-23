package app.PatientHealthApp.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Class to represent users.
 * All other user types extend from this class.
 * Enables jpa/hibernate to perform repository 
 * operations on interchangable user objects.
 * 
 * Important for use of Spring Security login conventions.
 * @author Zachary Ishmael
 *
 */
@Entity(name = "User")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	@Column(nullable = false)
	protected String name;
	@Column(unique = true, nullable = false)
	protected String username;
	@Column(nullable = false)
	protected String password;
	@Column(nullable = false)
	protected String role;
	@OneToMany
	protected List<Message> messages;
	@Transient
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	
	public User () {
		
	}
	
	public User(String name, String username, String password, String role ) {
		this.name = name;
		this.username = username;
		this.password = encoder.encode(password);
		this.role = role;
		this.messages = new ArrayList<Message>();
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = encoder.encode(password);
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the messages
	 */
	public List<Message> getMessages() {
		return messages;
	}

	/**
	 * @param messages the messages to set
	 */
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	
	
}

package app.PatientHealthApp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * An {@link Entity} class used to store user messages.
 * 
 * @author Zachary Ishmael
 *
 */
@Entity
public class Message {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@ManyToOne
	User sender;
	
	@ManyToOne
	User reciever;
	
	@Column
	String title;
	
	@Column
	String body;
	
	public Message() {
	}

	
	public Message(User sender, User reciever) {
		this.sender = sender;
		this.reciever = reciever;
	}

	public Message(User sender, User reciever, String title, String body) {
		this.sender = sender;
		this.reciever = reciever;
		this.title = title;
		this.body = body;
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
	 * @return the sender
	 */
	public User getSender() {
		return sender;
	}


	/**
	 * @param sender the sender to set
	 */
	public void setSender(User sender) {
		this.sender = sender;
	}


	/**
	 * @return the reciever
	 */
	public User getReciever() {
		return reciever;
	}


	/**
	 * @param reciever the reciever to set
	 */
	public void setReciever(User reciever) {
		this.reciever = reciever;
	}


	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}


	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}


	/**
	 * @return the body
	 */
	public String getBody() {
		return body;
	}


	/**
	 * @param body the body to set
	 */
	public void setBody(String body) {
		this.body = body;
	}
	
	

}

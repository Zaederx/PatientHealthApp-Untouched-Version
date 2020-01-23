package app.PatientHealthApp.jsonObject;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Class used to transport ajax responses.
 * 
 * @author Zachary Ishmael
 *
 */
@JsonInclude(Include.NON_NULL)
public class Response {
	/*If Form has Errors 
	 * - response set to true*/
	private boolean response;
	private String message;

	private List<String> messages;
	private Integer count;

	public Response () {
		response = false;
		message = "";
		messages = new ArrayList<String>();
		count = 0;
	}
	
	/**
	 * @return the response
	 */
	public boolean getResponse() {
		return response;
	}

	/**
	 * @param response the response to set
	 */
	public void setResponse(boolean response) {
		this.response = response;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the errorMessage to set
	 */
	public void setMessage(String errorMessage) {
		this.message = errorMessage;
	}

	/**
	 * @return the messages
	 */
	public List<String> getMessages() {
		return messages;
	}

	/**
	 * @param messages the messages to set
	 */
	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	/**
	 * @return the count
	 */
	public Integer getCount() {
		count();
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(Integer count) {
		this.count = count;
	}

	@JsonIgnore
	public void count() {
		if (messages != null) {
			count = messages.size();
		}
	}
	
	
}

package app.PatientHealthApp.formObjects;

/**
 * Class used to transport ajax responses.
 * 
 * @author Zachary Ishmael
 *
 */
public class Response {
	/*If Form has Errors 
	 * - response set to true*/
	private boolean response;

	private String errorMessage;


	public Response () {
		response = false;
		errorMessage = "";
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
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	
	
}

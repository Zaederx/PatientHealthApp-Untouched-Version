package app.PatientHealthApp.formObjects;

public class DoctorRegForm {
	private String name;
	
	private String username;
	
	private String password;
	
	private String specialisation;
	
	/*General Medical Council Number
	 * i.e. license number*/
	private String gmcNum;
	
//	/*Which medical practice/centre they will be going to.*/
//	private String assignedCentre;//TODO - Might be a good idea??
	
	
	
	public DoctorRegForm() {
		
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
		this.password = password;
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
	 * @return the specialisation
	 */
	public String getSpecialisation() {
		return specialisation;
	}

	/**
	 * @param specialisation the specialisation to set
	 */
	public void setSpecialisation(String specialisation) {
		this.specialisation = specialisation;
	}

	/**
	 * @return the medicalLicenseCode
	 */
	public String getGmcNum() {
		return gmcNum;
	}

	/**
	 * @param gmcNum the medicalLicenseCode to set
	 */
	public void setGmcNum(String gmcNum) {
		this.gmcNum = gmcNum;
	}

	//TODO - Assiged Center for doctors - Might be a good idea???
//	/**
//	 * @return the assignedCentre
//	 */
//	public String getAssignedCentre() {
//		return assignedCentre;
//	}
//
//	/**
//	 * @param assignedCentre the assignedCentre to set
//	 */
//	public void setAssignedCentre(String assignedCentre) {
//		this.assignedCentre = assignedCentre;
//	}

	
	
}

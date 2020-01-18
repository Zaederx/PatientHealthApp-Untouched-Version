package app.PatientHealthApp.jsonObject;

import java.util.List;

import app.PatientHealthApp.domain.Prescription;

/**
 * A Class used to return Prescriptions to user.
 * Spring's Jackson support used to convert to json objects.
 * @author Zachary Ishmael
 *
 */
public class PrescriptionResponse {
	
	Integer count;
	List<Prescription> prescriptions;
	
	public PrescriptionResponse() {
		
	}
	
	public PrescriptionResponse(List<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
		this.count = prescriptions.size();
	}

	/**
	 * @return the count
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(Integer count) {
		this.count = count;
	}

	/**
	 * @return the prescriptions
	 */
	public List<Prescription> getPrescriptions() {
		return prescriptions;
	}

	/**
	 * @param prescriptions the prescriptions to set
	 */
	public void setPrescriptions(List<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}
	
}

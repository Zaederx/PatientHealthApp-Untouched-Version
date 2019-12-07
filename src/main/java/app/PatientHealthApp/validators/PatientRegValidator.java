package app.PatientHealthApp.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import app.PatientHealthApp.domain.Patient;
import app.PatientHealthApp.domain.User;
import app.PatientHealthApp.formObjects.PatientRegForm;
import app.PatientHealthApp.repository.UserRepository;

/**
 * User to validate Admin's Patient Registration Form.
 * @author Zachary Ishmael
 *
 */
public class PatientRegValidator implements Validator {
	UserRepository uRepo;
	
	public PatientRegValidator(UserRepository uRepo) {
		this.uRepo = uRepo;
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return PatientRegValidator.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		PatientRegForm form = (PatientRegForm)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Name must not be empty.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors , "username", "" ,"Username must not be empty.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "", "Email must not be empty.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "", "Password must not be empty.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password2", "", "Passwords must match: Second Password Field cannot be empty.");
		
		//TODO Username must not already exist
		User user = uRepo.findByUsername(form.getUsername());
		
		if (!user.equals(null)) {
			errors.rejectValue("username", "" , "Username is already in use");
		}
		
		//TODO PASSWORDS MUST MEET Password Strength Criteria(regex)
		
		
		//TODO PASSWORDS MUST MATCH
		
		//TODO Email must not be associated with another account
		
		
	}

}

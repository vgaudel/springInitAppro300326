package fr.dawan.formationspring.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import fr.dawan.formationspring.forms.UserForm;

public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz==UserForm.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "prenom", "user.prenom.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nom", "user.nom.empty");
		
		UserForm userForm = (UserForm)target;
		if(!userForm.getPassword().equals(userForm.getConfirmationPassword())) {
			errors.rejectValue("password","user.password.notequals", "Message par défaut");
		}
		
	}

}

package fr.dawan.formationspring.validators;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import fr.dawan.formationspring.forms.UserForm;
import fr.dawan.formationspring.services.UserService;

@Component
public class UserValidator implements Validator{

	@Autowired
	private UserService userService;
	
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
		if(userService.mailExist(userForm.getEmail())) {
			System.out.println("probleme mau=il égaux2");
			errors.rejectValue("email", "user.email.allreadyexist", "Mail déjà enregistré chez nous !");
		}
	}

}

package fr.dawan.formationspring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.dawan.formationspring.entities.User;
import fr.dawan.formationspring.repositories.FakeUserRepository;
import fr.dawan.formationspring.validators.UserValidator;
import jakarta.validation.Valid;
import fr.dawan.formationspring.forms.UserForm;
//import fr.dawan.formationspring.validators.UserValidator;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
    private FakeUserRepository repository;
    
    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("users", repository.findAll());
        return "users";
    }
    
    @GetMapping("/add")
    public String createUser(@ModelAttribute("userForm") UserForm userForm) {
        return "addUser";
    }
    
    @PostMapping("/add")
    //public ModelAndView createUserPost(@Valid @ModelAttribute("userForm") UserForm userForm,BindingResult result) {
    public ModelAndView createUserPost(@ModelAttribute("userForm") UserForm userForm,BindingResult result, RedirectAttributes ra) {
        ModelAndView mdv=new ModelAndView();
        
        new UserValidator().validate(userForm, result);
        
        if(result.hasErrors()) {
            mdv.addObject("userForm",userForm);
            mdv.addObject("errors", result);
            mdv.setViewName("addUser");
        }else {
            User user=new User();
            user.setPrenom(userForm.getPrenom());
            user.setNom(userForm.getNom());
            user.setEmail(userForm.getEmail());
            user.setNaissance(userForm.getNaissance());
            user.setPassword(userForm.getPassword());
            repository.save(user);
            ra.addFlashAttribute("msgCreatedUser", "L'utilisateur " + user.getNom() + "a bien été créé.");
            mdv.setViewName("redirect:/users");
        }
        
        return mdv;
    }
}

package fr.dawan.formationspring.controllers;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.dawan.formationspring.entities.Utilisateur;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("utilisateur2")
public class ExempleController {

	@RequestMapping("/exemple")
	public String exemple() {
		return "exemple";
	}
	
	@RequestMapping("/exemple/testmodel")
	public String testModel(Model model) {
		model.addAttribute("msg", "Test du model");
		return "exemple";
	}
	
	@RequestMapping("/exemple/testmodelandview")
	public ModelAndView testModelAndView() {
		ModelAndView mav= new ModelAndView("exemple");
		mav.addObject("msg", "Test de ModelAndView");
		return mav;
	}
	
	@RequestMapping("/exemple/thymeleaf")
	public String testThymeleaf(Model model) {
		
		int val = 60;
		model.addAttribute("val", val);
		
		Utilisateur u1 = new Utilisateur("John", "Baguette");
		model.addAttribute("u1", u1);
		
		double t[]= {1.4,6.7,8.9,3.5,9.1};
		model.addAttribute("tab", t);
		
		Map<String,Integer> ages = new HashMap<String,Integer>();
		ages.put("John", 45);
		ages.put("Jane", 35);
		ages.put("Yves", 63);
		ages.put("Jo", 38);
		model.addAttribute("ages", ages);
		
		int v1=40;
		model.addAttribute("v1", v1);
		
		model.addAttribute("dateJour", LocalDate.now());
		model.addAttribute("phrase", "il est 16 heure");
		
		return "exemplethymeleaf";
		
	}
	
	@GetMapping(value="/testparam", params="id")
	public String testParams(Model model) {
		model.addAttribute("msg", "La requète contient un paramètre de requète id");
		return "exemple";
	}
	@GetMapping(value="/testparam", params="id=42")
	public String testParamsValue(Model model) {
		model.addAttribute("msg", "La requète contient un paramètre de requète id égal à 42");
		return "exemple";
	}
	
	 
    // @PathVaraible -> paramètre de chemin

    @GetMapping("/testpath/{id}")
    public String testPath(@PathVariable String id, Model model) {
        model.addAttribute("msg", "Le paramètre de chemin id=" + id);
        return "exemple";
    }

    @GetMapping("/testpathmulti/{id}/{action}")
    public String testPathMulti(@PathVariable String id, @PathVariable String action, Model model) {
        model.addAttribute("msg", "les paramètres de chemin id=" + id + ", action=" + action);
        return "exemple";
    }
    
    @GetMapping("/testpathmap/{id}/{nom}/action/{action}")
    public String testPathMap(@PathVariable Map<String,String> pathVar,Model model) {
        String str=String.format("les paramètres de chemin id=%s nom=%s action=%s", pathVar.get("id"),pathVar.get("nom"),pathVar.get("action"));
        model.addAttribute("msg", str);
        return "exemple";
    }
    
    @GetMapping("/testpathamb/{id:[0-9]+}")
    public String testPathAmb1(@PathVariable String  id,Model model) {
        model.addAttribute("msg", "pathVariable id="+id);
        return "exemple";
    }
    
    @GetMapping("/testpathamb/{nom:[a-zA-Z ]+}")
    public String testPathAmb2(@PathVariable String  nom,Model model) {
        model.addAttribute("msg", "pathVariable nom="+nom);
        return "exemple";
    }
    
    // @RequestParam ->  paramètre de requête
    
    @GetMapping("/testparam")
    public String testParam(@RequestParam String id,Model model) {
        model.addAttribute("msg", "requestparam id="+id);
        return "exemple";
    }
    
    @GetMapping("/testparammulti")
    public String testParam(@RequestParam String id,@RequestParam String nom,Model model) {
        model.addAttribute("msg", "requestparam id="+id + " nom="+nom);
        return "exemple";
    }
    
    @GetMapping("/testparammap")
    public String testParam(@RequestParam Map<String,String> paramMap,Model model) {
        model.addAttribute("msg", "requestparam id="+paramMap.get("id") + " nom="+paramMap.get("nom"));
        return "exemple";
    }
    
    @GetMapping(value="/testparamamb", params="id")
    public String testParaAmb1(@RequestParam String id,Model model) {
        model.addAttribute("msg", "request param id="+id);
        return "exemple";
    }
    
    @GetMapping(value="/testparamamb", params="nom")
    public String testParaAmb2(@RequestParam String nom,Model model) {
        model.addAttribute("msg", "request param nom="+nom);
        return "exemple";
    }
    
    @GetMapping({"/testpathopt/{id}","/testpathopt"})
    public String testPathOptionel1(@PathVariable(required=false) String id,Model model) {
        model.addAttribute("msg", "pathvariable optionnel id="+id);
        return "exemple";
    }
    @GetMapping({"/testpathopt2/{id}","/testpathopt2"})
    public String testPathOptionel2(@PathVariable Optional<String> id,Model model) {
        if(id.isEmpty()) {
            model.addAttribute("msg", "vide");
        }
        else {
            model.addAttribute("msg", "pathvariable optionnel id="+id.get());
        }
        return "exemple";
    }
    
    @GetMapping("/testparamdefault")
    public String testParamDefault(@RequestParam(defaultValue = "john doe") String nom,Model model) {
        model.addAttribute("msg", "requestparam default nom="+nom);
        return "exemple";
    }
    
    // Conversion des paramètres
    @GetMapping("/testconv/{id}")
    public String testConv(@PathVariable long id,Model model) {
        model.addAttribute("msg", "test conversion long id =" +id);
        return "exemple";
    }
    
    @GetMapping("/testconvdate/{date}")
    public String testConvDate(@DateTimeFormat(pattern = "dd-MM-yyyy") @PathVariable LocalDate date,Model model) {
        model.addAttribute("msg", date.toString());
        return"exemple";
    }
    
    //lier des objets 
    @GetMapping("/testbindpath/{prenom}/{nom}")
    public String testBindPath(Utilisateur u, Model model) {
    	model.addAttribute("msg", u.toString());
    	return "exemple";
    }
    @GetMapping("/testbindparam")
    public String testBindParam(@ModelAttribute("user") Utilisateur u, Model model) {
    	model.addAttribute("msg", u.toString());
    	return "exemple";
    }
    
    //redirection
    @GetMapping("/testredirect")
    public String testRedirect(){
    	return "redirect:/hello";
    }
    
    @GetMapping("/testforward")
    public String testForward() {
    	return "forward:/hello";
    }
    
    // Cookies
    
    @GetMapping("/writecookie")
    public String writeCookie(HttpServletResponse response) {
    	Cookie cookie = new Cookie("testCookie","Valeur_de_test");
    	cookie.setMaxAge(300);
    	response.addCookie(cookie);
    	return "redirect:/exemple";
    }
    
    @GetMapping("/readcookie")
    public String readCookie(@CookieValue(value="testCookie",defaultValue="Valeur par défaut") String value, Model model) {
    	model.addAttribute("msg", "Cookie = "+value);
    	return "exemple";
    }
    
    //Session 
    // 1 Session Jakarta EE
    @GetMapping("/writesession1")
    public String writeSession1(HttpServletRequest request){
    	HttpSession session = request.getSession();
    	session.setAttribute("utilisateur1", new Utilisateur("John", "Baguette"));
    	return "redirect:/exemple";
    }
    
    @GetMapping("/readsession1")
    public String readsession1(HttpServletRequest request, Model model) {
    	HttpSession session = request.getSession();
    	Utilisateur u1 = (Utilisateur) session.getAttribute("utilisateur1");
    	model.addAttribute("msg", "Session Jakarta EE " + u1);
        return "exemple";
    }
    
    //2 Session @SessionAttributes
    @ModelAttribute("utilisateur2")
    public Utilisateur initSession2() {
        return new Utilisateur();
    }
    
    @GetMapping("/writesession2")
    public String writeSession2(Model model) {
        model.addAttribute("utilisateur2", new Utilisateur("yves","roulo"));
        return "redirect:/exemple";
    }
    
    @GetMapping("/readsession2")
    public String readSesion2(@ModelAttribute("utilisateur2") Utilisateur utilisateur2,Model model) {
        model.addAttribute("msg", "session @SessionAttributes "+utilisateur2.toString());
        return "exemple";
    }
}

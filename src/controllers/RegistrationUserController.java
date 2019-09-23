
package controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import beans.RegistrationUser;
@Controller
@RequestMapping("/registrationUser")
public class RegistrationUserController {
	
	// display registration 
	@RequestMapping(path = "/newuser", method = RequestMethod.GET)
	public ModelAndView displayLoginForm() {
		return new ModelAndView("registrationForm", "registrationUser", new RegistrationUser());
	}
	@RequestMapping(path = "/addUser", method = RequestMethod.POST)
	public ModelAndView addUser(@Valid @ModelAttribute("registrationUser")RegistrationUser registrationUser, BindingResult result) {
		
		if(result.hasErrors()) {
			return new ModelAndView("registrationForm", "registrationUser", registrationUser);
		}
		
		//Assigning and displaying values of new registered user
//		ModelAndView regisModelView =  new ModelAndView("registeredUserView");	
////		regisModelView.addObject("firstName", registrationUser.getFirstName());
//		
//		return regisModelView;
		
		return new ModelAndView("registeredUserView", "user", registrationUser);
	}
}

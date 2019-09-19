package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import beans.User;

@Controller
@RequestMapping("/navigate")
public class FormController {
	
	// TODO: FormController from login to registration

	// display registration form
	@RequestMapping(path = "/newuser", method = RequestMethod.GET)
	public ModelAndView displayRegistrationForm() {
		return new ModelAndView("registrationform", "user", new User());
	}

}

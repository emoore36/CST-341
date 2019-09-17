package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import beans.User;

@Controller
@RequestMapping("/login")
public class LoginController {

	@RequestMapping(path = "/displayform", method = RequestMethod.GET)
	public ModelAndView displayLoginForm() {
		return new ModelAndView("loginform", "user", new User());
	}

	@RequestMapping(path = "/authenticate", method = RequestMethod.POST)
	public ModelAndView authenticate(@ModelAttribute("user") User user) {

		String testUN = "root";
		String testPW = "root";

		System.out.println(user.getUsername() + "\t" + user.getPassword());

		// authenticate the user
		if (!user.getUsername().equals(testUN) || !user.getPassword().equals(testPW))
			return new ModelAndView("loginform", "user", new User()); // return to form page

		// return success screen
		return new ModelAndView("index");
	}

}

/**
 * 
 */
package controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import beans.CredentialSet;
import beans.Notification;
import beans.User;

/**
 * 
 * @author Eric Moore
 *
 */
@Controller
@RequestMapping("/")
public class WelcomeController {

	// display welcome screen
	/**
	 * Displays the welcome screen.
	 * 
	 * @return welcome.jsp
	 */
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView displayWelcome() {

		// return welcome screen
		return new ModelAndView("welcome");
	}

	// display login form
	/**
	 * Displays the login form.
	 * 
	 * @return loginform.jsp
	 */
	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public ModelAndView displayLogin() {

		// return login form page with a blank CredentialSet
		return new ModelAndView("loginform", "cred", new CredentialSet());
	}

	// display registration form
	/**
	 * Displays the registration form.
	 * 
	 * @return registrationForm.jsp
	 */
	@RequestMapping(path = "/newuser", method = RequestMethod.GET)
	public ModelAndView displayRegistration() {

		// return the registration form page with a blank User
		return new ModelAndView("registrationForm", "user", new User());
	}

	// process login
	/**
	 * Process the user's login credentials.
	 * 
	 * @param cred
	 *            The user's credentials -- CredentialSet
	 * @param result
	 *            The data validation results
	 * @return the login form if unsuccessful, or the dashboard if successful.
	 */
	@RequestMapping(path = "/authenticate", method = RequestMethod.POST)
	public ModelAndView authenticate(@Valid @ModelAttribute("cred") CredentialSet cred, BindingResult result) {

		// if validation errors, return to form page with credentials
		if (result.hasErrors())
			return new ModelAndView("loginform", "cred", cred);

		// otherwise, verify the user's credentials
		if (validateCredentials(cred))
			return new ModelAndView("dashboard", "notif", new Notification("Login successful!"));

		// if the verification failed, return to the login form
		return new ModelAndView("loginform", "notif", new Notification(""));
	}

	// process registration
	/**
	 * Process the new user's account information.
	 * 
	 * @param user
	 *            The user's account information.
	 * @param result
	 *            The data validation results.
	 * @return the registration form page if unsuccessful, or the dashboard if
	 *         successful.
	 */
	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public ModelAndView addUser(@Valid @ModelAttribute("user") User user, BindingResult result) {

		// if errors, return to newUser form
		if (result.hasErrors())
			return new ModelAndView("registrationForm", "user", user);

		// otherwise, connect a BS and add the user
		// TODO: Connect a BS

		// redirect to dashboard
		return new ModelAndView("dashboard", "notif", new Notification("Account created successfully!"));
	}

	// verify credentials
	/**
	 * 
	 * @param cred
	 *            The user's login credentials.
	 * @return true if successful, or false if unsuccessful
	 */
	private boolean validateCredentials(CredentialSet cred) {
		String testUN = "username";
		String testPW = "password";

		// if the creds don't match, return false
		if (!cred.getUsername().equals(testUN) || !cred.getPassword().equals(testPW))
			return false;

		// otherwise, return true
		return true;
	}

}

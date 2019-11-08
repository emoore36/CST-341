/**
 * 
 */
package com.camelback.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.camelback.beans.CredentialSet;
import com.camelback.beans.Notification;
import com.camelback.beans.User;
import com.camelback.business.SecurityInterface;
import com.camelback.business.UserBusinessInterface;
import com.camelback.util.DatabaseException;

/**
 * 
 * @author Eric Moore
 *
 */
@Controller
@RequestMapping("/")
public class WelcomeController {

	private UserBusinessInterface userService;
	private SecurityInterface<CredentialSet> securityService;

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

		ModelAndView mav = new ModelAndView();

		// if validation errors, return to form page with credentials
		if (result.hasErrors())
			return new ModelAndView("loginform", "cred", cred);

		try {

			// otherwise, verify the user's credentials
			if (validateCredentials(cred) == 1)
				return new ModelAndView("dashboard", "notif", new Notification("Login successful!"));

			// if the verification failed, return to the login form
			return new ModelAndView("loginform", "notif",
					new Notification("Invalid credentials given. Please try again."));

		} catch (DatabaseException e) {
			mav.setViewName("displayError");
		}

		return mav;

	}

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

		ModelAndView mav = new ModelAndView();

		try {

			// otherwise, connect a BS and add the user
			int success = userService.create(user);

			if (success == 1) {
				// redirect to dashboard
				return new ModelAndView("dashboard", "notif", new Notification("Account created successfully!"));
			} else {
				// redirect to Registration Form
				return new ModelAndView("registrationForm", "notif", new Notification("Failed to create account."));
			}

		} catch (DatabaseException e) {
			mav.setViewName("displayError");
		}

		return mav;

	}

	/**
	 * Displays the dashboard
	 * 
	 * @return dashboard.jsp
	 */
	@RequestMapping(path = "/dashboard", method = RequestMethod.GET)
	public ModelAndView viewDashboard() {
		return new ModelAndView("dashboard");
	}

	/**
	 * Tests the user's credentials.
	 * 
	 * @param cred
	 *            The user's login credentials.
	 * @return 1 if successful, or 0 if unsuccessful
	 */
	private int validateCredentials(CredentialSet cred) {

		return securityService.authenticate(cred);

	}

	/**
	 * Set the Business Interface for this Controller.
	 * 
	 * @param userService
	 *            the userService to set
	 */
	@Autowired
	public void setUserService(UserBusinessInterface service) {
		this.userService = service;
	}

	@Autowired
	public void setSecurityService(SecurityInterface<CredentialSet> service) {
		this.securityService = service;
	}

}

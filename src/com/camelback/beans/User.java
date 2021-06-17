package com.camelback.beans;

import javax.validation.constraints.NotNull;

public class User {

	@NotNull(message = "Please include first name.")
	private String firstName;

	@NotNull(message = "Please include last name.")
	private String lastName;

	private CredentialSet credentials;

	@NotNull(message = "Please include email address.")
	// @Size(min = 6, max = 25, message = "Email Address must be between 6 and 25
	// characters.")
	private String email;

	@NotNull(message = "Role must be included.")
	// @Size(min = 1, max = 20, message = "Role must be between 1 and 20
	// characters.")
	private String role;

	/**
	 * A model of the user in the database.
	 */
	public User() {
		firstName = "";
		lastName = "";
		credentials = null;
		email = "";
		role = "";
	}

	/**
	 * A model of the user in the database.
	 * 
	 * @param firstName
	 *            The user's first name.
	 * @param lastName
	 *            The user's last name.
	 * @param credentials
	 *            The user's login credentials: username and password.
	 * @param email
	 *            The user's email address.
	 * 
	 * @param role
	 *            The user's role on the website.
	 */
	public User(String firstName, String lastName, CredentialSet credentials, String email, String role) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.credentials = credentials;
		this.email = email;
		this.role = role;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the credentials
	 */
	public CredentialSet getCredentials() {
		return credentials;
	}

	/**
	 * @param credentials
	 *            the credentials to set
	 */
	public void setCredentials(CredentialSet credentials) {
		this.credentials = credentials;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	public String printAllValues() {
		return "\nFirst Name = " + firstName + "\nLastName = " + lastName + "\nEmail = " + email + "\nUsername = "
				+ credentials.getUsername() + "\nPassword = " + credentials.getPassword() + "\nRole = " + role;
	}

}

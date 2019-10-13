package com.camelback.beans;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CredentialSet {

	// attributes
	@NotNull(message = "Please include username.")
	@Size(min = 6, max = 16, message = "Username must be between 6 and 16 characters.")
	private String username;

	@NotNull(message = "Please include password.")
	@Size(min = 6, max = 16, message = "Password must be between 6 and 16 characters.")
	private String password;

	// default constructor
	public CredentialSet() {
		username = "";
		password = "";
	}

	// non-default constructor
	/**
	 * @param username
	 *            The user's username - String
	 * @param password
	 *            The user's password - String
	 */
	public CredentialSet(String username, String password) {
		this.username = username;
		this.password = password;
	}

	// getters and setters

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}

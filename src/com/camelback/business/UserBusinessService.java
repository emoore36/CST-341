package com.camelback.business;

import com.camelback.beans.CredentialSet;
import com.camelback.beans.User;

public class UserBusinessService implements BusinessInterface<User> {

	// TODO: Implement DAO

	@Override
	/**
	 * Add a user to the database.
	 * 
	 * @param model
	 *            The user to add.
	 * 
	 */
	public int create(User model) {

		// TODO: User DAO
		return 1;

	}

	@Override
	public int authenticate(CredentialSet cred) {

		String testUN = "username";
		String testPW = "password";

		// if the creds don't match, return false
		if (!cred.getUsername().equals(testUN) || !cred.getPassword().equals(testPW))
			return 0;

		// otherwise, return true
		return 1;

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		// Currently doesn't do anything.
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		// Currently doesn't do anything.
	}

}

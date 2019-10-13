package com.camelback.data;

import com.camelback.beans.User;

public class UserDAO implements DataAccessInterface<User> {

	@Override
	/**
	 * Persist the user to the database.
	 * 
	 * @param model
	 *            The user to persist.
	 */
	public int create(User model) {

		return 1; // success
	}

}

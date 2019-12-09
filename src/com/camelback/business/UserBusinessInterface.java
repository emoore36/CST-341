package com.camelback.business;

import com.camelback.beans.User;

public interface UserBusinessInterface {

	/**
	 * Create an instance of user.
	 * 
	 * @param user
	 *            The user to create.
	 * @return 1 if successful, 0 if not.
	 */
	public int create(User user);

}

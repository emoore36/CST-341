package com.camelback.business;

import org.springframework.beans.factory.annotation.Autowired;

import com.camelback.beans.User;
import com.camelback.data.DataAccessInterface;

public class UserBusinessService implements UserBusinessInterface {

	private DataAccessInterface<User> dao;

	@Override
	/**
	 * Add a user to the database.
	 * 
	 * @param model
	 *            The user to add.
	 * 
	 */
	public int create(User user) {

		System.out.println("Entering UserBusinessService create() with the following values: " + user.printAllValues());

		return dao.create(user);

	}

	/**
	 * @param dao
	 *            the dao to set
	 */
	@Autowired
	public void setDao(DataAccessInterface<User> dao) {
		this.dao = dao;
	}

}

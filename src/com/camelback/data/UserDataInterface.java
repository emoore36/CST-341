/**
 * 
 */
package com.camelback.data;

/**
 * @author Owner
 *
 */
public interface UserDataInterface<T> {

	/**
	 * Persist an instance of the User class to the database.
	 * 
	 * @param user
	 *            The user to persist
	 * @return the number of rows affected.
	 */
	public int create(T user);

}

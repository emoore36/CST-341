/**
 * 
 */
package com.camelback.business;

/**
 * @author Owner
 *
 */
public interface SecurityInterface<T> {

	/**
	 * Authenticate the user's credentials -- username and password.
	 * 
	 * @param cred
	 *            The credentials of the user.
	 * @return 1 if successful, 0 if not.
	 */
	public int authenticate(T cred);

}

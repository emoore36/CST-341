/**
 * 
 */
package com.camelback.data;

/**
 * @author Owner
 *
 */
public interface SecurityDataInterface<T> {

	/**
	 * Find if the database contains the user's credentials.
	 * 
	 * @param cred
	 *            The user credentials.
	 * @return 1 if found, 0 if not.
	 */
	public int find(T cred);

}

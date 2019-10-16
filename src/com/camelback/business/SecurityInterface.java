/**
 * 
 */
package com.camelback.business;

import com.camelback.beans.CredentialSet;

/**
 * @author Owner
 *
 */
public interface SecurityInterface {

	/**
	 * Authenticate the user's credentials -- username and password.
	 * 
	 * @param cred
	 *            The credentials of the user.
	 * @return 1 if successful, 0 if not.
	 */
	public int authenticate(CredentialSet cred);

}

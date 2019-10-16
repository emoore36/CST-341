/**
 * 
 */
package com.camelback.business;

import com.camelback.beans.CredentialSet;

/**
 * @author Owner
 *
 */
public class SecurityService implements SecurityInterface {

	@Override
	public int authenticate(CredentialSet cred) {

		try {
			String testUN = "username";
			String testPW = "password";

			// if the creds don't match, return false
			if (!cred.getUsername().equals(testUN) || !cred.getPassword().equals(testPW))
				return 0;
			else
				return 1;
		} catch (Exception e) {
			System.out.println("SecurityService error:\n");
			e.printStackTrace();
			return -1;
		}
	}

}

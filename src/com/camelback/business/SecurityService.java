/**
 * 
 */
package com.camelback.business;

import org.springframework.beans.factory.annotation.Autowired;

import com.camelback.beans.CredentialSet;
import com.camelback.data.SecurityDataInterface;

/**
 * @author Owner
 *
 */
public class SecurityService implements SecurityInterface<CredentialSet> {

	private SecurityDataInterface<CredentialSet> dao;

	@Override
	/**
	 * Validate the user's credentials
	 * 
	 * @param cred
	 *            the user's credentials
	 * 
	 * @return the number of rows retrieved
	 */
	public int authenticate(CredentialSet cred) {

		return dao.find(cred);

	}

	/**
	 * @param dao
	 *            the dao to set
	 */
	@Autowired
	public void setDao(SecurityDataInterface<CredentialSet> dao) {
		this.dao = dao;
	}

}

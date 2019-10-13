package com.camelback.business;

import com.camelback.beans.CredentialSet;

public interface BusinessInterface<T> {

	// TODO: Inject DAO INTERFACE

	/**
	 * Create an instance of the relevant model.
	 * 
	 * @param model
	 *            The model to create.
	 * @return 1 if successful, 0 if not.
	 */
	public int create(T model);

	/**
	 * Authenticate the user's credentials.
	 * 
	 * @param cred
	 *            The CredentialSet to test
	 * @return 1 if successful, 0 if unsuccessful
	 */
	int authenticate(CredentialSet cred);

	/**
	 * The initialization method for the business service.
	 */
	public void init();

	/**
	 * The initialization method for the business service.
	 */
	public void destroy();

}

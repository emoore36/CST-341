package com.camelback.data;

public interface DataAccessInterface<T> {

	// TODO: Add a database?
	/**
	 * Persist a model to the database.
	 * 
	 * @param model
	 *            The model to persist.
	 * @return 1 if successful, 0 if not
	 */
	public int create(T model);

}

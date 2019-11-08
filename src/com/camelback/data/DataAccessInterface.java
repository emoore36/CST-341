/**
 * 
 */
package com.camelback.data;

import java.util.List;

/**
 * @author Eric
 *
 */
public interface DataAccessInterface<T> {

	/**
	 * Create an instance of the relevant model to the database.
	 * 
	 * @return The number of rows affected.
	 */
	public int create(T t);

	/**
	 * Retrieve all instances of the relevant model from the database.
	 * 
	 * @return a list of all instances of the model
	 */
	public List<T> findAll();

	/**
	 * Find the instance of the relevant model whose ID matches the given integer.
	 * 
	 * @param ID
	 *            The ID of the instance to retrieve
	 * @return an instance of the model at the requested ID
	 */
	public T findBy(int ID);

	/**
	 * Update an instance of the relevant model within the database
	 * 
	 * @param t
	 *            The model instance to update
	 * @return the number of rows affected
	 */
	public int update(T t);

	/**
	 * Delete the instance of the relevant model in the database at the given ID
	 * 
	 * @param ID
	 *            The ID of the instance to delete
	 * @return the number of rows affected
	 */
	public int delete(int ID);

}

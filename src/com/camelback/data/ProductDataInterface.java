/**
 * 
 */
package com.camelback.data;

import java.util.List;

/**
 * @author Owner
 *
 */
public interface ProductDataInterface<T> {

	/**
	 * Persist an instance of the Product class to the database.
	 * 
	 * @param product
	 *            The product to persist.
	 * @return the number of rows affected.
	 */
	public int create(T product);

	/**
	 * Retrieve all instances from the database.
	 * 
	 * @return list of values
	 */
	public List<T> findAll();

}

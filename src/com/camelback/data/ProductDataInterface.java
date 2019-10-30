/**
 * 
 */
package com.camelback.data;

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

}

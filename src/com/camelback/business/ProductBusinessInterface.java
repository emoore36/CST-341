package com.camelback.business;

import java.util.List;

public interface ProductBusinessInterface<T> {

	/**
	 * Create an instance of product.
	 * 
	 * @param product
	 *            The product to create.
	 * @return 1 if successful, 0 if not.
	 */
	public int create(T product);

	/**
	 * Retrieve all products from the database.
	 * 
	 * @return a list of products
	 */
	public List<T> findAll();

}

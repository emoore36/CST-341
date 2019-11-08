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
	public int addProduct(T product);

	/**
	 * Retrieve all products from the database.
	 * 
	 * @return a list of products
	 */
	public List<T> getAllProducts();

	/**
	 * Find a product by the given ID
	 * 
	 * @param ID
	 *            The ID by which to search
	 * @return the product at the given ID
	 */
	public T findByID(int ID);

}

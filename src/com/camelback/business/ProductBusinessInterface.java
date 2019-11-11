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
	public T getProductByID(int ID);

	/**
	 * Update product
	 * 
	 * The ID by which to search
	 * 
	 * @return the product at the given ID
	 */
	public int editProduct(T product);

	/**
	 * Remove a product at the given ID.
	 * 
	 * @param ID
	 *            The ID of the product to delete.
	 * @return the number of rows affected.
	 */
	public int removeProduct(int ID);

}

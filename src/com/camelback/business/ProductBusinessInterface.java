package com.camelback.business;

import com.camelback.beans.Product;

public interface ProductBusinessInterface {

	/**
	 * Create an instance of product.
	 * 
	 * @param product
	 *            The product to create.
	 * @return 1 if successful, 0 if not.
	 */
	public int create(Product product);

}

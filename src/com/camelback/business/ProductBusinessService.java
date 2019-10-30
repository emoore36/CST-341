package com.camelback.business;

import org.springframework.beans.factory.annotation.Autowired;

import com.camelback.beans.Product;
import com.camelback.data.ProductDataInterface;

public class ProductBusinessService implements ProductBusinessInterface {

	private ProductDataInterface<Product> dao;

	@Override
	/**
	 * Create an instance of product.
	 * 
	 * @param product
	 *            the product to create.
	 * 
	 * @return 1 if successful, 0 if not.
	 */
	public int create(Product product) {
		return dao.create(product);
	}

	/**
	 * @param dao
	 *            the dao to set
	 */
	@Autowired
	public void setDao(ProductDataInterface<Product> dao) {
		this.dao = dao;
	}

}

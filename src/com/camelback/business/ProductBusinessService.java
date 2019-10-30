package com.camelback.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.camelback.beans.Product;
import com.camelback.data.ProductDataInterface;

public class ProductBusinessService implements ProductBusinessInterface<Product> {

	private ProductDataInterface<Product> dao;

	@Override
	public int create(Product product) {
		return dao.create(product);
	}

	@Override
	public List<Product> findAll() {
		return dao.findAll();
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

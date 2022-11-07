package com.camelback.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.camelback.beans.Product;
import com.camelback.data.DataAccessInterface;

public class ProductBusinessService implements ProductBusinessInterface<Product> {

	private DataAccessInterface<Product> dao;

	@Override
	public int addProduct(Product product) {
		return dao.create(product);
	}

	@Override
	/**
	 * Returns all products from database
	 * 
	 * @return product list
	 */
	public List<Product> getAllProducts() {
		return dao.findAll();
	}

	/**
	 * @param dao
	 *            the dao to set
	 */
	@Autowired
	public void setDao(DataAccessInterface<Product> dao) {
		this.dao = dao;
	}

	@Override
	/**
	 * Returns relevant product from database
	 * 
	 * @param ID
	 *            the id of the product
	 * 
	 * @return product
	 */
	public Product getProductByID(int ID) {
		return dao.findBy(ID);
	}

	@Override
	/**
	 * Returns relevant product from database
	 * 
	 * @param Product
	 *            the product to edit
	 * 
	 * @return number of rows affected
	 */
	public int editProduct(Product product) {
		return dao.update(product);
	}

	@Override
	/**
	 * Removes the relevant product from the database
	 * 
	 * @param ID
	 *            the id of the product
	 * 
	 * @return the number of rows affected
	 */
	public int removeProduct(int ID) {
		return dao.delete(ID);
	}

}

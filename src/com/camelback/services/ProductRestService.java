/**
 * 
 */
package com.camelback.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.camelback.beans.Product;
import com.camelback.business.ProductBusinessInterface;

/**
 * @author Owner
 *
 */
@RestController
@RequestMapping("/products")
public class ProductRestService {

	@Autowired
	ProductBusinessInterface<Product> service;

	@GetMapping("/getAll")
	public List<Product> getProducts() {
		System.out.println("ProductRestService getProducts() activated.");
		return service.getAllProducts();
	}

	/**
	 * @param service
	 *            the service to set
	 */
	public void setService(ProductBusinessInterface<Product> service) {
		this.service = service;
	}

}

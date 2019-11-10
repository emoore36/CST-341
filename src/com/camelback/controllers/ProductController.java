package com.camelback.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.camelback.beans.Notification;
import com.camelback.beans.Product;
import com.camelback.business.ProductBusinessInterface;
import com.camelback.util.DatabaseException;

@Controller
@RequestMapping("/product")
public class ProductController {

	private ProductBusinessInterface<Product> service;

	/**
	 * Displays the AddProduct form
	 * 
	 * @return addProduct.jsp
	 */
	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public ModelAndView displayAddProductForm() {
		return new ModelAndView("addProduct", "product", new Product());
	}

	/**
	 * Add the product to the database.
	 * 
	 * @param product
	 *            The product to add.
	 * @param result
	 *            The data validation result.
	 * @return allProducts.jsp
	 */
	@RequestMapping(path = "/addProduct", method = RequestMethod.POST)
	public ModelAndView addProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {

		if (result.hasErrors()) {
			return new ModelAndView("addProduct", "product", product);
		}

		// prepare the view
		ModelAndView mav = new ModelAndView();

		try {

			// persist the product
			int flag = service.addProduct(product);

			// get all products
			List<Product> products = service.getAllProducts();

			if (flag == 1) {
				mav.setViewName("allProducts");
				mav.addObject("products", products);
				mav.addObject("notif", new Notification("Product added successfully!"));
			} else {
				mav.setViewName("addProduct");
				mav.addObject("notif", new Notification("Failed to add product."));
			}

		} catch (DatabaseException e) {
			mav.setViewName("displayError");
		}

		return mav;
	}

	/**
	 * Display a page containing all products.
	 * 
	 * @return allProducts.jsp
	 */
	@RequestMapping(path = "/showAll", method = RequestMethod.GET)
	public ModelAndView showAll() {

		List<Product> products = service.getAllProducts();

		return new ModelAndView("allProducts", "products", products);
	}

	// TODO: JavaDoc this.
	@RequestMapping(path = "/showOneProduct", method = RequestMethod.POST)
	public ModelAndView showOneProduct(int ID) {

		ModelAndView mav = new ModelAndView();
		Product product = new Product();

		try {
			product = service.findByID(ID);

			mav.setViewName("showOneProduct");
			mav.addObject("product", product);

		} catch (DatabaseException e) {
			mav.setViewName("displayError");
		}

		return mav;
	}
	
	// TODO: JavaDoc this.
		@RequestMapping(path = "/displayUpdateForm", method = RequestMethod.POST)
	public ModelAndView displayUpdateForm(int ID) {

		ModelAndView mav = new ModelAndView();
		Product product = new Product();

		try {
			product = service.findByID(ID);

			mav.setViewName("displayUpdateForm");
			mav.addObject("product", product);

		} catch (DatabaseException e) {
			mav.setViewName("displayError");
		}

		return mav;
	}
	
	@RequestMapping(path = "/updateProduct", method = RequestMethod.POST)
	public ModelAndView updateProduct(Product product) {
		ModelAndView mav = new ModelAndView();
		try {
			service.updateProduct(product);
			List<Product> products = service.getAllProducts();
			return new ModelAndView("allProducts", "products", products);

		} catch (DatabaseException e) {
			mav.setViewName("displayError");
		}

		return mav;
	}
	@RequestMapping(path = "/deleteProduct", method = RequestMethod.POST)
	public ModelAndView deleteProduct(int ID) {
		ModelAndView mav = new ModelAndView();
		try {
			service.deleteProduct(ID);
			List<Product> products = service.getAllProducts();
			return new ModelAndView("allProducts", "products", products);

		} catch (DatabaseException e) {
			mav.setViewName("displayError");
		}

		return mav;
	}

	/**
	 * Set the BusinessService
	 * 
	 * @param service
	 *            The ProductBusinessService to set.
	 */
	@Autowired
	public void setService(ProductBusinessInterface<Product> service) {
		this.service = service;
	}

}

package com.camelback.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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

		// fire data validation rules
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

			// if successful, add the product list to the allProducts page.
			if (flag == 1) {
				mav.setViewName("allProducts");
				mav.addObject("products", products);
				mav.addObject("notif", new Notification("Product added successfully!"));
			} else if (flag == 0) {
				// otherwise go back to the product creation screen.
				mav.setViewName("addProduct");
				mav.addObject("notif", new Notification("Failed to add product."));
			} else if (flag == -2) {
				// This means the product already exists.
				mav.setViewName("addProduct");
				mav.addObject("notif", new Notification("Product already exists."));
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

		try {
			// get the products from the database
			List<Product> products = service.getAllProducts();

			// return the allProducts page with the list.
			return new ModelAndView("allProducts", "products", products);

		} catch (DatabaseException e) {

			// Database exception. Go back.
			return new ModelAndView("displayError");
		}
	}

	/**
	 * Display one product's properties on its own page.
	 * 
	 * @param ID
	 *            The ID of the product to display.
	 * @return The showOneProduct page.
	 */
	@RequestMapping(path = "/showOneProduct", method = RequestMethod.POST)
	public ModelAndView showOneProduct(int ID) {

		// Prepare the ModelAndView and its data.
		ModelAndView mav = new ModelAndView();
		Product product = new Product();

		try {

			// attempt to find the product using the given ID
			product = service.getProductByID(ID);

			// add product to product page
			mav.setViewName("showOneProduct");
			mav.addObject("product", product);

		} catch (DatabaseException e) {

			// Database exception. Go back.
			mav.setViewName("displayError");
		}

		// return the ModelAndView
		return mav;
	}

	/**
	 * Display the update form for the given ID's product
	 * 
	 * @param ID
	 *            The ID of the product to edit
	 * @return The edit display form page
	 */
	@RequestMapping(path = "/displayUpdateForm", method = RequestMethod.POST)
	public ModelAndView displayUpdateForm(int ID) {

		// set up ModelAndView and Product instance
		ModelAndView mav = new ModelAndView();
		Product product = new Product();

		// attempt to find the product in the database
		try {
			product = service.getProductByID(ID);

			// found the product -- push it to the edit form page
			mav.setViewName("displayUpdateForm");
			mav.addObject("product", product);

		} catch (DatabaseException e) {

			// database error. Pull back.
			mav.setViewName("displayError");
		}

		return mav;
	}

	/**
	 * Process the update for the given product.
	 * 
	 * @param product
	 *            The edited product to alter in the database.
	 * @return The all products page.
	 */
	@RequestMapping(path = "/updateProduct", method = RequestMethod.POST)
	public ModelAndView updateProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {

		// run data validation
		if (result.hasErrors()) {
			return new ModelAndView("displayUpdateForm", "product", product);
		}

		// Prepare MaV
		ModelAndView mav = new ModelAndView();
		try {

			// update the product
			int flag = service.editProduct(product);

			// get the updated list of products
			List<Product> products = service.getAllProducts();

			// prepare the page with all of the products
			mav.setViewName("allProducts");
			mav.addObject("products", products);

			// if successful...
			if (flag == 1) {

				// ... Alert the user of the success.
				mav.addObject("notif", new Notification("Product Successfully updated."));
			}
			// if unsuccessful...
			else if (flag == 0) {

				// ...alert the user that no update occurred.
				mav.addObject("notif", new Notification("No update occurred."));
			}

		} catch (DatabaseException e) {

			// database error. Roll back.
			mav.setViewName("displayError");
		}

		// return the view
		return mav;
	}

	/**
	 * Delete the product at the given ID
	 * 
	 * @param ID
	 *            The ID of the product to be deleted.
	 * @return The all products page.
	 */
	@RequestMapping(path = "/deleteProduct", method = RequestMethod.POST)
	public ModelAndView deleteProduct(int ID) {

		// Prepare the ModelAndView
		ModelAndView mav = new ModelAndView();
		try {
			// attempt to delete the product
			service.removeProduct(ID);

			// retrieve the updated list of products
			List<Product> products = service.getAllProducts();

			// return the allProducts page with updated list
			return new ModelAndView("allProducts", "products", products);

		} catch (DatabaseException e) {

			// Error. Roll back.
			mav.setViewName("displayError");
		}

		return mav;
	}

	/**
	 * Display the products page with admin functionality
	 * 
	 * @return allProductsAdmin page.
	 */
	@RequestMapping(path = "/admin", method = RequestMethod.GET)
	public ModelAndView showAdminPage() {

		try {

			List<Product> products = service.getAllProducts();
			return new ModelAndView("allProductsAdmin", "products", products);
		} catch (DatabaseException e) {
			return new ModelAndView("displayError");
		}

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

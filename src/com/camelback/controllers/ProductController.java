package com.camelback.controllers;

import java.util.ArrayList;
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

@Controller
@RequestMapping("/product")
public class ProductController {

	private List<Product> products = new ArrayList<Product>();

	private ProductBusinessInterface service;

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

		int flag = service.create(product);

		ModelAndView mav = new ModelAndView();

		if (flag == 1) {
			mav.setViewName("allProducts");
			products.add(product);
			mav.addObject("products", products);
			mav.addObject("notif", new Notification("Product added successfully!"));
		} else {
			mav.setViewName("addProduct");
			mav.addObject("notif", new Notification("Failed to add product."));
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
		return new ModelAndView("allProducts", "products", products);
	}

	/**
	 * Set the BusinessService
	 * 
	 * @param service
	 *            The ProductBusinessService to set.
	 */
	@Autowired
	public void setService(ProductBusinessInterface service) {
		this.service = service;
	}

}

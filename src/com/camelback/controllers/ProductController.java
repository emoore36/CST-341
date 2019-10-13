package com.camelback.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.camelback.beans.Product;

@Controller 
@RequestMapping("/product")
public class ProductController {
	
	
	@RequestMapping(path="/add", method=RequestMethod.GET)
	public ModelAndView displayAddProductForm()
	{
		return new ModelAndView("addProduct", "product", new Product());
	}
	
	@RequestMapping(path="/addProduct", method=RequestMethod.POST)
	public ModelAndView addProduct(@Valid@ModelAttribute("product") Product product,  BindingResult result)
	{
		
		if(result.hasErrors()) {
			return new ModelAndView("addProduct", "product", product);
		}
		
		ModelAndView mav = new ModelAndView("allProducts", "product", product);
		return mav;
		
	}
	
}



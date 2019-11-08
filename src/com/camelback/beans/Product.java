package com.camelback.beans;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * An instance of the Product class.
 * 
 * @author Harpreet Sidhu
 *
 */
public class Product {

	private int ID;

	// product properties.
	@NotNull(message = "Please include a name.")
	@Size(min = 2, max = 30, message = "Name must be between 2 and 30 characters.")
	private String name;

	@NotNull(message = "Please include the price.")
	@Digits(integer = 6, fraction = 2, message = "Cost must be between 2 and 6 digits.")
	private String price;

	@NotNull(message = "Please include the brand name.")
	@Size(min = 2, max = 30, message = "Brand name must be between 2 and 30 characters.")
	private String brandName;

	private String image;

	/**
	 * An instance of the Product class.
	 */
	public Product() {
		ID = 0;
		name = "";
		price = "";
		brandName = "";
		image = "";
	}

	/**
	 * An instance of the Product class.
	 * 
	 * @param ID
	 *            The ID of the product
	 * 
	 * @param name
	 *            The name of the product
	 * @param price
	 *            The price of the product
	 * @param brandName
	 *            The name of the product's company brand
	 * @param image
	 *            The product's image.
	 */
	public Product(int ID, String name, String price, String brandName, String image) {
		this.ID = ID;
		this.name = name;
		this.price = price;
		this.brandName = brandName;
		this.image = image;
	}

	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}

	/**
	 * @param iD
	 *            the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image
	 *            the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

}

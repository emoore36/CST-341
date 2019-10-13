package com.camelback.beans;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Product {
	
	public Product() {
		name = "";
		price = "";
		brandName = "";
	}
	// product properties. 
	
	@NotNull @Size(min=2, max=30) 
	private String name;
	
	@NotNull @Size(min=2, max=30) @Digits(integer=6, fraction=2)
	private String price;
	
	@NotNull @Size(min=2, max=30) 
	private String brandName;
	
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
	
	
}

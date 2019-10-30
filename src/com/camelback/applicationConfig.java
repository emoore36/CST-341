package com.camelback;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import com.camelback.beans.CredentialSet;
import com.camelback.beans.Product;
import com.camelback.beans.User;
import com.camelback.business.ProductBusinessInterface;
import com.camelback.business.ProductBusinessService;
import com.camelback.business.SecurityInterface;
import com.camelback.business.SecurityService;
import com.camelback.business.UserBusinessInterface;
import com.camelback.business.UserBusinessService;
import com.camelback.controllers.ProductController;
import com.camelback.controllers.WelcomeController;
import com.camelback.data.ProductDataInterface;
import com.camelback.data.ProductDataService;
import com.camelback.data.SecurityDataInterface;
import com.camelback.data.SecurityDataService;
import com.camelback.data.UserDAO;
import com.camelback.data.UserDataInterface;

@Configuration
public class applicationConfig {

	/**
	 * Get an instance of the welcome controller.
	 * 
	 * @return the Welcome Controller.
	 */
	@Bean(name = "welcomeController")
	public WelcomeController getWelcomeController() {
		return new WelcomeController();
	}

	/**
	 * Get an instance of the Product Controller.
	 * 
	 * @return the Product Controller.
	 */
	@Bean(name = "productController")
	public ProductController getProductController() {
		return new ProductController();
	}

	/**
	 * Get an instance of the ProductBusinessInterface.
	 * 
	 * @return the ProductBusinessService.
	 */
	@Bean(name = "productService")
	@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
	public ProductBusinessInterface getProductService() {
		return new ProductBusinessService(); // interchangeable concrete implementation
	}

	/**
	 * Get an instance of the UserBusinessInterface.
	 * 
	 * @return the UserBusinessService.
	 */
	@Bean(name = "userService")
	@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
	public UserBusinessInterface getUserService() {
		return new UserBusinessService(); // interchangeable concrete implementation
	}

	/**
	 * Get an instance of the SecurityInterface.
	 * 
	 * @return the SecurityService.
	 */
	@Bean(name = "securityService")
	@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
	public SecurityInterface getSecurityService() {
		return new SecurityService(); // interchangeable concrete implementation
	}

	/**
	 * Get an instance of the UserDataInterface
	 * 
	 * @return the UserDataService
	 */
	@Bean(name = "userDao")
	@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
	public UserDataInterface<User> getUserDao() {
		return new UserDAO(); // interchangeable concrete implementation
	}

	/**
	 * Get an instance of the SecurityDataInterface
	 * 
	 * @return the SecurityDataService
	 */
	@Bean(name = "securityDao")
	@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
	public SecurityDataInterface<CredentialSet> getSecurityDao() {
		return new SecurityDataService(); // interchangeable concrete implementation
	}

	/**
	 * Get an instance of the ProductDataInterface
	 * 
	 * @return the ProductDataService
	 */
	@Bean(name = "productDao")
	@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
	public ProductDataInterface<Product> getProductDao() {
		return new ProductDataService(); // interchangeable concrete implementation
	}

}

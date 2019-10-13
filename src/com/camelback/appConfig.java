package com.camelback;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import com.camelback.beans.User;
import com.camelback.business.BusinessInterface;
import com.camelback.business.UserBusinessService;
import com.camelback.controllers.WelcomeController;

@Configuration
public class AppConfig {

	@Bean(name = "welcomeController")
	public WelcomeController getWelcomeController() {
		return new WelcomeController();
	}

	// @Bean(name = "productController")
	// public ProductController getProductController() {
	// return new ProductController();
	// }

	@Bean(name = "userService", initMethod = "init", destroyMethod = "destroy")
	@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
	public BusinessInterface<User> getUserService() {
		return new UserBusinessService(); // interchangeable concrete implementation
	}

	// @Bean(name = "productService", initMethod = "init", destroyMethod =
	// "destroy")
	// @Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
	// public BusinessInterface getProductService() {
	// return new ProductBusinessService(); // interchangeable concrete
	// implementation
	// }

}

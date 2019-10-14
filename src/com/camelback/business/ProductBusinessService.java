package com.camelback.business;

import com.camelback.beans.CredentialSet;
import com.camelback.beans.Product;

public class ProductBusinessService implements BusinessInterface<Product> {

	@Override
	public int create(Product model) {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public void init() {
		System.out.println("init() from ProductBusinessService");

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void test() {
		// TODO Auto-generated method stub

	}

	@Override
	public int authenticate(CredentialSet cred) {
		// TODO Auto-generated method stub
		return 0;
	}

}

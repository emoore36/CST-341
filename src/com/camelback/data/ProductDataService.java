/**
 * 
 */
package com.camelback.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.camelback.beans.Product;

/**
 * @author Owner
 *
 */
public class ProductDataService implements DataAccessInterface<Product> {

	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public int create(Product product) {

		// create SQL String
		String sql = "INSERT INTO `PRODUCT_TABLE`(`NAME`, `PRICE`, `BRAND_NAME`, `IMAGE`) VALUES (?,?,?,?)";

		try {
			// get rows affected from stmtExecute
			int rows = jdbcTemplateObject.update(sql, product.getName(), product.getPrice(), product.getBrandName(),
					product.getImage());

			// return the result
			return rows;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public List<Product> findAll() {

		// create the productList to populate
		List<Product> products = new ArrayList<Product>();

		// create SQL String
		String sql = "SELECT * FROM `PRODUCT_TABLE`";

		try {
			// execute SQL and loop over
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);

			// extract products from database
			while (srs.next()) {
				products.add(new Product(srs.getInt("ID"), srs.getString("NAME"), srs.getString("PRICE"), srs.getString("BRAND_NAME"),
						srs.getString("IMAGE")));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// return the list of products
		return products;
	}

	/**
	 * @param dataSource
	 *            the dataSource to set
	 */
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public Product findBy(int ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Product t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int ID) {
		// TODO Auto-generated method stub
		return 0;
	}

}

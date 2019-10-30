/**
 * 
 */
package com.camelback.data;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.camelback.beans.Product;

/**
 * @author Owner
 *
 */
public class ProductDataService implements ProductDataInterface<Product> {

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

	/**
	 * @param dataSource
	 *            the dataSource to set
	 */
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

}

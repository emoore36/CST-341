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
import com.camelback.util.DatabaseException;

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
			throw new DatabaseException(e);
		}
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
				products.add(new Product(srs.getInt("ID"), srs.getString("NAME"), srs.getString("PRICE"),
						srs.getString("BRAND_NAME"), srs.getString("IMAGE")));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DatabaseException(e);
		}

		// return the list of products
		return products;
	}

	@Override
	public Product findBy(int ID) {

		Product product = new Product();

		// create SQL String
		String sql = "SELECT * FROM `PRODUCT_TABLE` WHERE `ID` = ? LIMIT 1";

		try {
			// execute SQL and loop over
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql, ID);

			// extract products from database
			while (srs.next()) {
				product = new Product(srs.getInt("ID"), srs.getString("NAME"), srs.getString("PRICE"),
						srs.getString("BRAND_NAME"), srs.getString("IMAGE"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DatabaseException(e);
		}

		return product;

	}

	@Override
	public int update(Product t) {
		
		// create SQL String
		int ID = t.getID();
		String sql = "UPDATE `PRODUCT_TABLE` SET `NAME` = ?,  `PRICE` = ?, `BRAND_NAME` = ?, `IMAGE` = ?"
				+ "WHERE ID = ?";

		try {
			// get rows affected from stmtExecute
			int rows = jdbcTemplateObject.update(sql, t.getName(), t.getPrice(), t.getBrandName(),t.getImage(), t.getID());

			// return the result
			return rows;

		} catch (Exception e) {
			e.printStackTrace();
			throw new DatabaseException(e);
		}
	}

	@Override
	public int delete(int ID) {
		// create SQL String
		String sql = "DELETE FROM `PRODUCT_TABLE` WHERE `ID` = ?";

		try {
			// get rows affected from stmtExecute
			int rows = jdbcTemplateObject.update(sql, ID);

			// return the result
			return rows;

		} catch (Exception e) {
			e.printStackTrace();
			throw new DatabaseException(e);
		}
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

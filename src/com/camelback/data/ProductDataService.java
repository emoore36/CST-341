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
	/**
	 * Create an instance of the relevant model to the database.
	 * 
	 * @param product
	 *            The product to create.
	 * 
	 * @return The number of rows affected.
	 * @throws ItemAlreadyExistsException
	 */
	public int create(Product product) {

		// check and ensure that the product does not already exist
		// In this case, we will consider a duplicate name OR image as a duplicate
		// product
		String preSQL = "SELECT * FROM `PRODUCT_TABLE` WHERE `NAME` = ? OR `IMAGE` = ?";

		try {
			// execute SQL and loop over
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(preSQL, product.getName(), product.getImage());

			if (srs.next()) {
				return -2;
			}

		} catch (Exception e) {
			// issue with the database. Log and throw an unchecked exception.
			e.printStackTrace();
			throw new DatabaseException(e);
		}

		// create SQL String
		String sql = "INSERT INTO `PRODUCT_TABLE`(`NAME`, `PRICE`, `BRAND_NAME`, `IMAGE`) VALUES (?,?,?,?)";

		try {
			// get rows affected from stmtExecute
			int rows = jdbcTemplateObject.update(sql, product.getName(), product.getPrice(), product.getBrandName(),
					product.getImage());

			// return the result
			return rows;

		} catch (Exception e) {
			// issue with the database. Log and throw an unchecked exception.
			e.printStackTrace();
			throw new DatabaseException(e);
		}
	}

	@Override
	/**
	 * Retrieve all instances of the relevant model from the database.
	 * 
	 * @return a list of all instances of the model
	 */
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
			// issue with the database. Log and throw an unchecked exception.
			e.printStackTrace();
			throw new DatabaseException(e);
		}

		// return the list of products
		return products;
	}

	@Override
	/**
	 * Find the instance of the relevant model whose ID matches the given integer.
	 * 
	 * @param ID
	 *            The ID of the instance to retrieve
	 * @return an instance of the model at the requested ID
	 */
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
			// issue with the database. Log and throw an unchecked exception.
			e.printStackTrace();
			throw new DatabaseException(e);
		}

		return product;

	}

	@Override
	/**
	 * Update an instance of the relevant model within the database
	 * 
	 * @param t
	 *            The model instance to update
	 * @return the number of rows affected
	 */
	public int update(Product t) {

		// create SQL String
		String sql = "UPDATE `PRODUCT_TABLE` SET `NAME` = ?,  `PRICE` = ?, `BRAND_NAME` = ?, `IMAGE` = ? WHERE ID = ?";

		try {
			// get rows affected from stmtExecute
			int rows = jdbcTemplateObject.update(sql, t.getName(), t.getPrice(), t.getBrandName(), t.getImage(),
					t.getID());

			// return the result
			return rows;

		} catch (Exception e) {
			// issue with the database. Log and throw an unchecked exception.
			e.printStackTrace();
			throw new DatabaseException(e);
		}
	}

	@Override
	/**
	 * Delete the instance of the relevant model in the database at the given ID
	 * 
	 * @param ID
	 *            The ID of the instance to delete
	 * @return the number of rows affected
	 */
	public int delete(int ID) {

		// create SQL String
		String sql = "DELETE FROM `PRODUCT_TABLE` WHERE `ID` = ?";

		try {
			// get rows affected from stmtExecute
			int rows = jdbcTemplateObject.update(sql, ID);

			// return the result
			return rows;

		} catch (Exception e) {
			// issue with the database. Log and throw an unchecked exception.
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

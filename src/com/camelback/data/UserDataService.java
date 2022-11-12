package com.camelback.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.camelback.beans.User;
import com.camelback.util.DatabaseException;

public class UserDataService implements DataAccessInterface<User> {

	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	@Override
	/**
	 * Create an instance of the relevant model to the database.
	 * 
	 * @param t
	 *            - The model to create.
	 * 
	 * @return The number of rows affected.
	 * @throws ItemAlreadyExistsException
	 */
	public int create(User user) {

		System.out.println("Entering UserDataService create() with the following values: " + user.printAllValues());

		// check to see if user already exists
		// In this case, assume duplicate username means duplicate user.
		String preSQL = "SELECT * FROM USER_TABLE WHERE USERNAME = ?";

		// execute SQL and retrieve info
		SqlRowSet srs = jdbcTemplateObject.queryForRowSet(preSQL, user.getCredentials().getUsername());

		if (srs.next()) {
			return -2; // item already exists
		}

		// create SQL String
		String sql = "INSERT INTO USER_TABLE(FIRST_NAME, LAST_NAME, EMAIL, USERNAME, PASSWORD, ROLE) VALUES (?,?,?,?,?,?)";

		try {
			// get rows affected from stmtExecute
			int rows = jdbcTemplateObject.update(sql, user.getFirstName(), user.getLastName(), user.getEmail(),
					user.getCredentials().getUsername(), user.getCredentials().getPassword(), user.getRole());

			System.out.println("Leaving UserDataService create() with rows = " + rows);

			// return the result
			return rows;

		} catch (Exception e) {
			// database error. Log and throw checked exception.
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

	@Override
	/**
	 * Retrieve all instances of the relevant model from the database.
	 * 
	 * @return a list of all instances of the model
	 */
	public List<User> findAll() {
		return null;
	}

	@Override
	/**
	 * Find the instance of the relevant model whose ID matches the given integer.
	 * 
	 * @param ID
	 *            The ID of the instance to retrieve
	 * @return an instance of the model at the requested ID
	 */
	public User findBy(int ID) {
		return null;
	}

	@Override
	/**
	 * Update an instance of the relevant model within the database
	 * 
	 * @param t
	 *            The model instance to update
	 * @return the number of rows affected
	 */
	public int update(User t) {
		return 0;
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
		return 0;
	}
}

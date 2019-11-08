package com.camelback.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.camelback.beans.User;
import com.camelback.util.DatabaseException;

public class UserDataService implements DataAccessInterface<User> {

	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public int create(User user) {

		System.out.println("Entering UserDataService create() with the following values: " + user.printAllValues());

		// create SQL String
		String sql = "INSERT INTO `USER_TABLE`(`FIRST_NAME`, `LAST_NAME`, `EMAIL`, `USERNAME`, `PASSWORD`, `ROLE`) VALUES (?,?,?,?,?,?)";

		try {
			// get rows affected from stmtExecute
			int rows = jdbcTemplateObject.update(sql, user.getFirstName(), user.getLastName(), user.getEmail(),
					user.getCredentials().getUsername(), user.getCredentials().getPassword(), user.getRole());

			System.out.println("Leaving UserDataService create() with rows = " + rows);

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

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findBy(int ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(User t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int ID) {
		// TODO Auto-generated method stub
		return 0;
	}
}

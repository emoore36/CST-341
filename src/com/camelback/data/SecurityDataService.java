/**
 * 
 */
package com.camelback.data;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.camelback.beans.CredentialSet;

/**
 * @author Owner
 *
 */
public class SecurityDataService implements SecurityDataInterface<CredentialSet> {

	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public int find(CredentialSet cred) {

		System.out.println("Entering SecurityDataService find() with the following values:\nUsername = "
				+ cred.getUsername() + "\nPassword = " + cred.getPassword());

		// create SQL String
		String sql = "SELECT * FROM `USER_TABLE` WHERE `USERNAME` = ? AND `PASSWORD` = ? LIMIT 1";

		try {
			// execute SQL and retrieve info
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql, cred.getUsername(), cred.getPassword());

			if (srs.next()) {
				return 1;
			} else {
				return 0;
			}

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

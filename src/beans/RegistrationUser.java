package beans;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Owner
 *
 */
public class RegistrationUser {

	// TODO: Add Data Validation to attributes.
	// attributes
	
	@NotNull(message = "Please include first name.")
	private String firstName;
	
	@NotNull(message = "Please include last name.")
	private String lastName;
	
	@NotNull(message = "Please include username.")
	@Size(min = 6, max = 16, message = "Username must be between 6 and 16 characters.")
	private String userName;
	
	@NotNull(message = "Please include password.")
	@Size(min = 6, max = 16, message = "Password must be between 6 and 16 characters.")
	private String password;
	
	@NotNull(message = "Please include email address.")
	@Size(min = 6, max = 16, message = "Email Address must be between 6 and 16 characters.")
	private String email;

	// default constructor
	public RegistrationUser() {
		firstName = "";
		lastName = "";
		userName = "";
		password = "";
		email = "";
	}

	// non-default constructor
	/**
	 * @param firstName
	 *            String : The user's first name.
	 * @param lastName
	 *            String : The user's last name.
	 * @param userName
	 *            String : The user's username. This will be used when logging in.
	 * @param password
	 *            String : The user's password. This will be used when logging in.
	 * @param email
	 *            String : The user's primary email address.
	 */
	public RegistrationUser(String firstName, String lastName, String userName, String password, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.email = email;
	}

	// getters and setters

	/**
	 * @return String - The user's first name.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            The user's first name.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return String - The user's last name.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            The user's last name.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return String - The user's username.
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            - The user's username.
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return String - The user's password.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            - The user's password.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return String - The user's email address.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            - The user's email address.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}

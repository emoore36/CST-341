package beans;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {

	// just the things I need right now
	@NotNull(message = "Username cannot be null.")
	@Size(min = 6, max = 20, message = "Username must be between 6 and 20 characters.")
	private String username;
	
	@NotNull(message = "Password cannot be null.")
	@Size(min = 6, max = 20, message = "Username must be between 6 and 20 characters.")
	private String password;

	// default constructor
	public User() {
		username = "";
		password = "";
	}

	// non-default constructor
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	

	// getters and setters

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

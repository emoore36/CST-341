package beans;



public class User {

	// just the things I need right now
	private String username;
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

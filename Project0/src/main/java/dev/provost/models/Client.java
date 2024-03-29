package dev.provost.models;

public class Client {
	
	private int clientId;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	
	public Client() {
		super();
	}
	
	public Client(int clientId, String firstName, String lastName, String username, String password) {
		super();
		this.clientId = clientId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return clientId;
	}
	public void setId(int clientId) {
		this.clientId = clientId;
	}
	
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

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

	@Override
	public String toString() {
		return "User [clientId=" + clientId + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username + ", password=" + password + "]";
	}
	
	

}

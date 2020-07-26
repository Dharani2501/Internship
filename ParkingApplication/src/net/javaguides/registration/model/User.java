package net.javaguides.registration.model;

public class User {
	private String firstName;
	private String lastName;
	private String password;
	private String username;
	private String address;
	private String contact;
	
	public User() {
		
	}
	
	public User(String firstName, String lastName, String password, String username, String address, String contact) 
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.username = username;
		this.address = address;
		this.contact = contact;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}

}

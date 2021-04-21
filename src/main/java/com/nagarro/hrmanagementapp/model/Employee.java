package com.nagarro.hrmanagementapp.model;

public class Employee {

	public Employee() {
	}

	public Employee(int id, String name, String location, String email, String dob) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.email = email;
		this.dob = dob;
	}

	private int id;
	private String name;
	private String location;
	private String email;
	private String dob;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", location=" + location + ", email=" + email + ", dob=" + dob
				+ "]";
	}

}

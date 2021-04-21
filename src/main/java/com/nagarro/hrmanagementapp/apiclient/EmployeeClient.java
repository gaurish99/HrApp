package com.nagarro.hrmanagementapp.apiclient;

import java.util.List;

import com.nagarro.hrmanagementapp.model.Employee;

public interface EmployeeClient {

	List<Employee> getAllEmployees();

	void addEmployee(Employee employee);

	void addAllEmployees(List<Employee> employees);

	void updateEmployee(Employee employee);

}

package com.nagarro.hrmanagementapp.apiclient;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.nagarro.hrmanagementapp.constant.Constants;
import com.nagarro.hrmanagementapp.model.Employee;

@Component
public class EmployeeClientImp implements EmployeeClient {

	@Autowired
	RestTemplate restTemplate;

	@Value("${api.base.url}")
	String REST_API_URI;

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		String url = REST_API_URI + Constants.GET_ALL_EMPLOYEES;
		try {
			ResponseEntity<List<Employee>> response = restTemplate.exchange(url, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<Employee>>() {
					});
			employees = response.getBody();

		} catch (Exception e) {

			throw e;

		}

		return employees;
	}

	@Override
	public void addEmployee(Employee employee) {
		String url = REST_API_URI + Constants.POST_EMPLOYEE;
		restTemplate.postForObject(url, employee, Employee.class);

	}

	@Override
	public void addAllEmployees(List<Employee> employees) {
		for (Employee employee : employees) {
			this.addEmployee(employee);
		}

	}

	@Override
	public void updateEmployee(Employee employee) {
		String url = REST_API_URI + Constants.PUT_EMPLOYEE;
		restTemplate.put(url, employee);

	}

}

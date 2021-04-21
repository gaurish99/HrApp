package com.nagarro.hrmanagementapp.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.supercsv.io.ICsvBeanWriter;

import com.nagarro.hrmanagementapp.apiclient.EmployeeClient;
import com.nagarro.hrmanagementapp.constant.Constants;
import com.nagarro.hrmanagementapp.model.Employee;
import com.nagarro.hrmanagementapp.utils.CSVUtil;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeClient employeeClient;

	public List<Employee> getAllEmployees() {
		return employeeClient.getAllEmployees();
	}

	public void updateEmployee(Employee employee) {
		employeeClient.updateEmployee(employee);
	}

	public void addAllEmployees(MultipartFile file) {
		List<Employee> employees = CSVUtil.getParsedData(file);
		if (employees != null) {
			employeeClient.addAllEmployees(employees);
		}
	}

	public void addEmployeeDetailsToFile(ICsvBeanWriter csvBeanWriter) throws IOException {
		List<Employee> employees = this.getAllEmployees();
		csvBeanWriter.writeHeader(Constants.DISPLAY_HEADER);
		for (Employee employee : employees) {
			csvBeanWriter.write(employee, Constants.BEAN_HEADER);
		}
	}

}

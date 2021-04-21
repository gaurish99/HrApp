package com.nagarro.hrmanagementapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.nagarro.hrmanagementapp.constant.Constants;
import com.nagarro.hrmanagementapp.model.Employee;
import com.nagarro.hrmanagementapp.service.EmployeeService;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getEmployeeList(ModelAndView model, HttpServletRequest request) {
		HttpSession httpSession = request.getSession(false);
		String username = httpSession.getAttribute("username").toString();
		if (httpSession != null && username != null) {
			List<Employee> employees = employeeService.getAllEmployees();
			model.addObject("employees", employees);
			model.setViewName("home");
		} else {
			model.setViewName("redirect:/login");
		}
		return model;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String editEmployee(@ModelAttribute("employee") Employee employee, Model model) {
//		System.out.println("In editEmployee");
		model.addAttribute("employee", employee);
		return "employeeEdit";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateEmployee(@ModelAttribute("employee") Employee employee, Model model) {
		employeeService.updateEmployee(employee);
		return "redirect:/employee";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String uploadFile(@RequestParam("file") MultipartFile file, Model model) {
		employeeService.addAllEmployees(file);
		return "redirect:/employee";
	}

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public void downloadFile(HttpServletResponse response) {
		response.setContentType("text/csv");
		response.addHeader("Content-Disposition", "attachment; filename=" + Constants.CSV_FILE_NAME);
		ICsvBeanWriter csvBeanWriter = null;
		try {
			csvBeanWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
			employeeService.addEmployeeDetailsToFile(csvBeanWriter);
			csvBeanWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

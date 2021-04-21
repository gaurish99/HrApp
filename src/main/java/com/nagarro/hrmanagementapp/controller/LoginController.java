package com.nagarro.hrmanagementapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nagarro.hrmanagementapp.dao.HrDao;

@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginget() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginpost(HttpServletRequest req, HttpServletResponse res) {

		String email = req.getParameter("email");
		String password = req.getParameter("pwd");

		HrDao hrDao = new HrDao();

		try {
			boolean check = hrDao.validate(email, password);

			if (check) {
				req.getSession().setAttribute("username", email);
				return "redirect:/employee";
			} else {
				res.getWriter().println("Invalid user name /password");
				return "login";

			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return "login";
	}

	@RequestMapping(value = "logout", method = RequestMethod.POST)
	public String logout(HttpServletRequest request) {
		request.getSession(false).removeAttribute("username");
		return "redirect:/login";
	}

}

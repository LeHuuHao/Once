package com.trungtamjava.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPost(HttpServletRequest request, @RequestParam("username") String uname,
	    @RequestParam("password") String password) {

	// String uname = request.getParameter("username");
	// String password = request.getParameter("password");

	HttpSession session = request.getSession();

	session.setAttribute("name", uname);

	return "redirect:/hello";// ten trang view login.jsp
    }

}

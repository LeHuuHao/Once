package com.trungtamjava.controller;

import java.net.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HelloController {
	@Autowired
	private Environment env;
	@GetMapping("/hi")
	public String hello(HttpServletRequest request) {
		request.setAttribute("msg", "Hello Spring boot");
		System.out.println(env.getProperty("my.key"));
		return "hello";
	}

}

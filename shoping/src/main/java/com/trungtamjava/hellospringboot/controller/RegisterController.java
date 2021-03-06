package com.trungtamjava.hellospringboot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trungtamjava.hellospringboot.entity.Person;
import com.trungtamjava.hellospringboot.repository.PersonRepository;
@Controller
public class RegisterController {
	 @Autowired
	    PersonRepository userDao;
	    
	    @Autowired
	    PasswordEncoder encoder;

	    @GetMapping("/register")
	    public String register() {
		return "register-user";
	    }

	    @PostMapping("/register")
	    public String register(@RequestParam("username") String uname,
		    @RequestParam(value = "password", required = false) String pass, // null
		    @RequestParam("name") String name) {

		/// save to database
		Person user = new Person();
		user.setUsername(uname);
		user.setPassword(encoder.encode(pass));
		user.setName(name);
		user.setRole("ROLE_MEMBER");

		userDao.save(user);

		return "redirect:/login";
	    }
	    
	    @GetMapping("/login")
	    public String login() {
		return "login";
	    }
	    
	    @GetMapping("/welcome")
	    public String welcome(HttpServletRequest httpServletRequest) {
	    	if(httpServletRequest.isUserInRole("ADMIN")) {
	    		return "redirect:/admin/user/search";
	    	}
		return "client/client";
	    }
}

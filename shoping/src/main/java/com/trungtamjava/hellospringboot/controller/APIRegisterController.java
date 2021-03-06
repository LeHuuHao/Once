package com.trungtamjava.hellospringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trungtamjava.hellospringboot.entity.Person;
import com.trungtamjava.hellospringboot.repository.PersonRepository;
@RequestMapping("/api")
@Controller
public class APIRegisterController {
	 @Autowired
	    PersonRepository userDao;
	    
	    @Autowired
	    PasswordEncoder encoder;
	@PostMapping("/register")
	@ResponseBody
    public Person register(@RequestParam("username") String uname,
	    @RequestParam(value = "password", required = false) String pass, // null
	    @RequestParam("name") String name) {

	/// save to database
	Person user = new Person();
	user.setUsername(uname);
	user.setPassword(encoder.encode(pass));
	user.setName(name);
	user.setRole("ROLE_MEMBER");

	userDao.save(user);

	return user;
    }

}

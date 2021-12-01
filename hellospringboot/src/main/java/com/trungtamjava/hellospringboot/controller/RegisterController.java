package com.trungtamjava.hellospringboot.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trungtamjava.hellospringboot.dao.IDCardDao;
import com.trungtamjava.hellospringboot.dao.UserDao;
import com.trungtamjava.hellospringboot.model.IDCard;
import com.trungtamjava.hellospringboot.model.User;

import javassist.Loader.Simple;

@Controller
public class RegisterController {

    @Autowired
    UserDao userDao;
    @Autowired 
    IDCardDao idCardDao;

    @GetMapping("/register")
    public String register() {
	return "register-user";
    }

    @PostMapping("/register")
    public String register(@RequestParam("username") String uname,
	    @RequestParam(value = "password", required = false) String pass, // null
	    @RequestParam("name") String name, @RequestParam("role") String role,
	    @RequestParam("idNumber") String idNumBer,
	    @RequestParam("date") String date) throws ParseException {

	/// save to database

	User user = new User();
	user.setUsername(uname);
	user.setPassword(pass);
	user.setName(name);
	user.setRole(role);
    IDCard idCard= new IDCard();
    idCard.setId_Number(idNumBer);
    SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd/MM/yyyy");
    idCard.setIssue_Date(simpleDateFormat.parse(date));
    idCard.setUser(user);
    userDao.save(user);
    idCardDao.save(idCard);
	

	return "redirect:/login";
    }

    // cach 2
    @PostMapping("/register-model")
    public String registerModel(@ModelAttribute User user) {
	/// save to database

	userDao.save(user);

	return "redirect:/login";
    }
    // getmap -> tra ve form
    // postmap -> doc form
}

package com.trungtamjava.hellospringboot.controller;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trungtamjava.hellospringboot.dao.UserDao;
import com.trungtamjava.hellospringboot.model.User;
import com.trungtamjava.hellospringboot.validator.UserValidator;

@Controller
@RequestMapping("/admin/user")
public class UserController {

    @Autowired // tu dong gan BEAN tuong ung vao - DI
//	@Qualifier("test1") // IoC
    UserDao userDao; // = new UserDaoImpl()

    @Autowired
    UserValidator userValidator;

    @GetMapping("/search")
    public String search(HttpServletRequest req, @RequestParam(value = "name", required = false) String name)
	    throws SQLException {

	if (name == null)
	    name = "";/// neu nguoi dung ko truyen len name

	List<User> users = userDao.search("%" + name + "%");/// MODEL

	req.setAttribute("uList", users);

	return "searchUser";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id) throws SQLException {
	userDao.deleteById(id);

	return "redirect:/admin/user/search";
    }

    	///edit?id=123
    @GetMapping("/edit")
    public String edit(Model model, @Param("id") int id) {
	User user = userDao.getById(id);

	model.addAttribute("user", user);

	return "editUser";
    }
    
    //edit/213/adsba
    @GetMapping("/edit/{id}")
    public String editPath(Model model, @PathVariable("id") int id) {
	User user = userDao.getById((id));

	model.addAttribute("user", user);

	return "editUser";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute User user, BindingResult bindingResult,
    		@RequestParam("date") @DateTimeFormat(pattern="dd/MM/yyyy") Date date) throws SQLException {
	/// nho goi ham validate o day
	userValidator.validate(user, bindingResult);

	if (bindingResult.hasErrors()) {
	    return "editUser";
	}
	//convert date
	user.getCard().setIssue_Date(date);
	//set user cho card
    user.getCard().setUser(user);
	userDao.save(user);

	return "redirect:/admin/user/search";
    }
}

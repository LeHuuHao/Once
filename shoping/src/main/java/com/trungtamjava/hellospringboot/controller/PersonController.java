package com.trungtamjava.hellospringboot.controller;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trungtamjava.hellospringboot.entity.Person;
import com.trungtamjava.hellospringboot.entity.UserOrder;
import com.trungtamjava.hellospringboot.repository.PersonRepository;
import com.trungtamjava.hellospringboot.repository.UserOderResposity;
import com.trungtamjava.hellospringboot.validator.PersonValidator;
@Controller
@RequestMapping("/admin/user")
public class PersonController {

	    @Autowired 
	    PersonRepository personRepository;

	    @Autowired
	    PersonValidator personValidator;
        @Autowired 
        UserOderResposity userOderResposity;
	    @Autowired
	    PasswordEncoder encoder;

	    // tao moi user
	    @GetMapping("/create")
	    public String create() {
		return "user/create-user";
	    }

	    @PostMapping("/create")
	    public String create(@ModelAttribute Person product) {
		product.setPassword(encoder.encode(product.getPassword()));
		personRepository.save(product);
		return "redirect:/admin/user/welcome";
	    }

	    /// SEARCH USER
	    @GetMapping("/search")
	    public String search(HttpServletRequest req, @RequestParam(value = "name", required = false) String name) {

		if (name == null)
		    name = "";/// neu nguoi dung ko truyen len name

		List<Person> users = personRepository.search("%" + name + "%");/// MODEL

		req.setAttribute("uList", users);

		return "user/searchUser";
	    }

	    @GetMapping("/delete")
	    public String delete(@RequestParam("id") int id) throws SQLException {
		personRepository.deleteById(id);
		return "redirect:/admin/user/search";
	    }

	    /// edit?id=123
	    @GetMapping("/edit")
	    public String edit(Model model, @Param("id") int id) {
		Person user = personRepository.getById(id);
		model.addAttribute("user", user);

		return "user/editUser";
	    }

//	    // edit/213/adsba
//	    @GetMapping("/edit/{id}")
//	    public String editPath(Model model, @PathVariable("id") int id) {
//		Person user = personRepository.getById((id));
	//
//		model.addAttribute("user", user);
	//
//		return "editUser";
//	    }

	    @PostMapping("/edit")
	    public String edit(@ModelAttribute("user") Person user, BindingResult bindingResult) {
		/// nho goi ham validate o day
		personValidator.validate(user, bindingResult);

		if (bindingResult.hasErrors()) {
		    return "user/editUser";
		}
		// encode password
		user.setPassword(encoder.encode(user.getPassword()));

		personRepository.save(user);

		return "redirect:/admin/user/search";
	    }
	   
}

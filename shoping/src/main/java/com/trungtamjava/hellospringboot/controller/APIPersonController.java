package com.trungtamjava.hellospringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trungtamjava.hellospringboot.entity.Person;
import com.trungtamjava.hellospringboot.repository.PersonRepository;
import com.trungtamjava.hellospringboot.validator.PersonValidator;

@RestController
@RequestMapping("/admin/api/user")

public class APIPersonController {
	@Autowired // tu dong gan BEAN tuong ung vao - DI
	PersonRepository personRepository;

	@Autowired
	PersonValidator personValidator;

	@Autowired
	PasswordEncoder encoder;

	@PostMapping("/create")
	public Person create(@ModelAttribute Person user) {
		// encode password
		user.setPassword(encoder.encode(user.getPassword()));
		personRepository.save(user);

		return user;
	}

	/// SEARCH USER
	@GetMapping("/search")
	public List<Person> search(@RequestParam(value = "name", required = false) String name) {
		if (name == null)
			name = "";/// neu nguoi dung ko truyen len name
		List<Person> users = personRepository.search("%" + name + "%");/// MODEL
		return users;
	}

	@DeleteMapping("/delete")
	public void delete(@RequestParam("id") int id) {
		personRepository.deleteById(id);
	}

	@PostMapping("/edit")
	public void edit(@ModelAttribute Person user) {
		// encode password
		user.setPassword(encoder.encode(user.getPassword()));
		personRepository.save(user);
	}

	@PutMapping("/edit-body")
	public void editBody(@RequestBody Person user) {
		// encode password
		user.setPassword(encoder.encode(user.getPassword()));
		personRepository.save(user);
	}

}

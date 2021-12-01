package com.trungtamjava.controller;


import java.text.ParseException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trungtamjava.dao.AddressDao;
import com.trungtamjava.dao.ProductDao;
import com.trungtamjava.model.Address;
import com.trungtamjava.model.Product;

@Controller
public class RegisterController {
    @Autowired ProductDao productDao;
    @Autowired AddressDao addressDao;
    
    
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	 @PostMapping("/register")
	    public String register(@RequestParam("username") String uname,
		    @RequestParam(value = "password", required = false) String pass, // null
		    @RequestParam("name") String name, @RequestParam("price") String price,
		    @RequestParam("city") String city,
		    @RequestParam("product_code") String product_code) throws ParseException {

		/// save to database

		Product product = new Product();
		product.setUsername(uname);
		product.setPassword(pass);
		product.setName(name);
		product.setPrice(Integer.parseInt(price));
	    Address address= new Address();
	    address.setCity(city);
	    address.setProduct_code(product_code);
	    address.setProduct(product);
	    productDao.save(product);
	    addressDao.save(address);

		

		return "redirect:/login";
	    }

}

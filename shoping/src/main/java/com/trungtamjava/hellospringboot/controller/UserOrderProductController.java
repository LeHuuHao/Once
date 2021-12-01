package com.trungtamjava.hellospringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trungtamjava.hellospringboot.entity.Product;
import com.trungtamjava.hellospringboot.entity.UserOrderProduct;
import com.trungtamjava.hellospringboot.repository.ProductRepository;
import com.trungtamjava.hellospringboot.repository.UserOrderProductResposity;
@RequestMapping("/admin/user-oder-product")
@Controller
public class UserOrderProductController {
	@Autowired 
	UserOrderProductResposity userOrderProductResposity;
	@Autowired
	ProductRepository productRepository;
	@GetMapping("/userOrderProduct")
	public String userOder(Model model) {
		List<Product> pList=productRepository.findAll();
		model.addAttribute("listUserOderProduct", pList);
		return "order/user-order-product";
	}
	@PostMapping("/userOrderProduct")
	public String userOrder(@RequestParam("product_id") String productId,
			@RequestParam("quanity") String quanity,
			@RequestParam("unitprice") String unitPrice
			) {
		Product product= new Product();
		product.setId(Integer.parseInt(productId));
		UserOrderProduct user= new UserOrderProduct();
		user.setProduct(product);
		user.setQuanity(Integer.parseInt(quanity));
		user.setUnitPrice(Integer.parseInt(unitPrice));	
		userOrderProductResposity.save(user);
		return "redirect:/admin/user/search";
	}


}

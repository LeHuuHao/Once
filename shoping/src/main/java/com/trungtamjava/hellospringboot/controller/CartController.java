package com.trungtamjava.hellospringboot.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trungtamjava.hellospringboot.entity.Product;
import com.trungtamjava.hellospringboot.entity.UserOrderProduct;
import com.trungtamjava.hellospringboot.repository.ProductRepository;

@Controller
public class CartController {
	@Autowired ProductRepository productRepository;
	
	@GetMapping("/cart")
	public String viewCart() {
		return "cart/view-cart";
	}
	@GetMapping("/add-to-cart")
	public String addToCart(@RequestParam(name = "pid") int pid, 
			@RequestParam(name = "quantity") int quantity,
			HttpSession session) {
		// check session
		Product product = productRepository.getById(pid);

		Object obj = session.getAttribute("cart");
		if (obj == null) {
			UserOrderProduct userOrderProduct = new UserOrderProduct();
			userOrderProduct.setProduct(product);
			userOrderProduct.setQuanity(quantity);
			userOrderProduct.setUnitPrice(product.getPrice());

			Map<Integer, UserOrderProduct> map = new HashMap<>();
			map.put(product.getId(), userOrderProduct);

			/// thay vi luu db, luu tam session
			session.setAttribute("cart", map);
		} else {
			//doc map tu session
			Map<Integer, UserOrderProduct> map = (Map<Integer, UserOrderProduct>) obj;
			
			UserOrderProduct userOrderProduct = map.get(product.getId());
			
			if (userOrderProduct == null) {
				userOrderProduct = new UserOrderProduct();
				userOrderProduct.setProduct(product);
				userOrderProduct.setQuanity(quantity);
				userOrderProduct.setUnitPrice(product.getPrice());
				//luu them vao mapp
				map.put(product.getId(), userOrderProduct);
			} else {
				userOrderProduct.setQuanity(userOrderProduct.getQuanity()+ quantity);
			}
			
			/// thay vi luu db, luu tam session
			session.setAttribute("cart", map);
		}
		
		return "cart/view-cart";// view
	}
	@GetMapping("/remove-cart-item")
	public String deleteItem(@RequestParam(name = "pid") int pid,
			HttpSession session) {
		Object obj = session.getAttribute("cart");

		if (obj != null) {
			//doc map tu session
			Map<Integer, UserOrderProduct> map = (Map<Integer, UserOrderProduct>) obj;
			
			map.remove(pid);
			/// update session
			session.setAttribute("cart", map);
		}
		
		return "cart/view-cart";// view
	}
	
	@GetMapping("/update-to-cart")
	public String updateCart(@RequestParam(name = "pid") int pid, 
			@RequestParam(name = "quanity") int quantity,
			HttpSession session) {
		// check session
		Object obj = session.getAttribute("cart");

		if (obj != null) {
			//doc map tu session
			Map<Integer, UserOrderProduct> map = (Map<Integer, UserOrderProduct>) obj;
			
			UserOrderProduct userOrderProduct = map.get(pid);
			
			if (userOrderProduct != null) {
				userOrderProduct.setQuanity(quantity);
			}
			
			/// thay vi luu db, luu tam session
			session.setAttribute("cart", map);
		}
		
		return "cart/view-cart";// view
	}

}

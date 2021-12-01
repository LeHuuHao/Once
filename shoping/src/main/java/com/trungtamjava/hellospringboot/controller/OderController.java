package com.trungtamjava.hellospringboot.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trungtamjava.hellospringboot.entity.Person;
import com.trungtamjava.hellospringboot.entity.UserOrder;
import com.trungtamjava.hellospringboot.entity.UserOrderProduct;
import com.trungtamjava.hellospringboot.repository.PersonRepository;
import com.trungtamjava.hellospringboot.repository.UserOrderReposity;

@Controller
public class OderController {
	@Autowired UserOrderReposity userOrderReposity;
	@Autowired PersonRepository personRepository;
	
	@GetMapping("/admin/place-order")
	public String placeOrder(Model model) {
		model.addAttribute("buyList",personRepository.findAll());
		return "cart/place-order";
		
	}
	@PostMapping("/admin/confirm-order")
	public String addOrder(@RequestParam(name="buyerId")int buyerId,HttpSession session) {
		SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserOrder userOrder= new UserOrder();
		userOrder.setCreatedDate(new Date());
		Person person = new Person();
		person.setId(buyerId);
		userOrder.setBuyer(person);
		// doc tu session gio hang
				Object obj = session.getAttribute("cart");

				if (obj != null) {
					// doc map tu session
					Map<Integer, UserOrderProduct> map = (Map<Integer, UserOrderProduct>) obj;
					// convert map to list
					List<UserOrderProduct> orderProducts = new ArrayList<>();

					for (Entry<Integer, UserOrderProduct> entry : map.entrySet()) {
						UserOrderProduct userOrderProduct = entry.getValue();
						// set user order, thuoc ve don hang id
						userOrderProduct.setUserOrder(userOrder);

						orderProducts.add(userOrderProduct);
					}

					// set list vao usserorder de luu cascade
					userOrder.setUserOrderProducts(orderProducts);
				}

				userOrderReposity.save(userOrder);

				// xoa session sau khi them thanh cong
				session.removeAttribute("cart");

				return "redirect:/admin/user-oder/search";
		
		
	}
	/// TRANG CLIENT MEMBER
		@GetMapping("/member/confirm-order")
		public String addOrder(HttpSession session) {
			// lay thang dn hien tai
			User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			UserOrder userOrder = new UserOrder();
			userOrder.setCreatedDate(new Date());
			// set buyer
			Person buyer = personRepository.getByUsername(user.getUsername());
			userOrder.setBuyer(buyer);

			// doc tu session gio hang
			Object obj = session.getAttribute("cart");

			if (obj != null) {
				// doc map tu session
				Map<Integer, UserOrderProduct> map = (Map<Integer, UserOrderProduct>) obj;

				// convert map to list
				List<UserOrderProduct> orderProducts = new ArrayList<>();

				for (Entry<Integer, UserOrderProduct> entry : map.entrySet()) {
					UserOrderProduct userOrderProduct = entry.getValue();
					// set user order, thuoc ve don hang id
					userOrderProduct.setUserOrder(userOrder);

					orderProducts.add(userOrderProduct);
				}

				// set list vao usserorder de luu cascade
				userOrder.setUserOrderProducts(orderProducts);
			}

			userOrderReposity.save(userOrder);

			// xoa session sau khi them thanh cong
			session.removeAttribute("cart");

			return "redirect:/admin/order/search";
		}

		@GetMapping("/admin/order/search") // url
		public String search(Model req) {
			List<UserOrder> userOrders = userOrderReposity.findAll();
			req.addAttribute("userOrders", userOrders);

			return "order/search-user-order";// ten trang view login.jsp
		}

}

package com.trungtamjava.hellospringboot.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.nio.file.Files;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.trungtamjava.hellospringboot.dao.CategoryDao;
import com.trungtamjava.hellospringboot.dao.ProductDao;
import com.trungtamjava.hellospringboot.entity.Category;
import com.trungtamjava.hellospringboot.entity.Person;
import com.trungtamjava.hellospringboot.entity.Product;
import com.trungtamjava.hellospringboot.entity.UserOrder;
import com.trungtamjava.hellospringboot.entity.UserOrderProduct;
import com.trungtamjava.hellospringboot.repository.CategoryRepository;
import com.trungtamjava.hellospringboot.repository.PersonRepository;
import com.trungtamjava.hellospringboot.repository.ProductRepository;
import com.trungtamjava.hellospringboot.repository.UserOrderReposity;
import com.trungtamjava.hellospringboot.validator.ProductValidator;

@Controller
@RequestMapping("/member/product")
public class ClientController {
	@Autowired PersonRepository personRepository;
	@Autowired ProductRepository productRepository;
	@Autowired UserOrderReposity userOrderReposity;
	@Autowired
	ProductValidator productValidator;
	@Autowired
	ProductDao productDao;
	@Autowired CategoryDao categoryDao;
    @Autowired CategoryRepository categoryRepository;
	// tao moi user
    @GetMapping(value = "/download")
	public void download(HttpServletResponse response, @RequestParam("image") String image) {
		final String uploadFolder = "C:\\Picture\\";
		File file = new File(uploadFolder + File.separator + image);
		if (file.exists()) {
			try {
				Files.copy(file.toPath(), response.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@GetMapping("/search")
	public String search(HttpServletRequest req, @RequestParam(value = "name", required = false) String name) {

		if (name == null)
			name = "";/// neu nguoi dung ko truyen len name

		List<Product> products = productRepository.search("%" + name + "%");/// MODEL

		req.setAttribute("listProduct", products);

		return "client/client";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("id") int id) throws SQLException {
		productRepository.deleteById(id);
		return "redirect:/admin/product/search";
	}
	@GetMapping("/confirm-order")
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
	

}

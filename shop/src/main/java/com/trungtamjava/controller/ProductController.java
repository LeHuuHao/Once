package com.trungtamjava.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trungtamjava.dao.AddressDao;
import com.trungtamjava.dao.ProductDao;

import com.trungtamjava.model.Product;
import com.trungtamjava.validator.ProductValidator;

@Controller
@RequestMapping("/admin/product")
public class ProductController {
	@Autowired
	ProductDao productDao;
	@Autowired
	AddressDao addressDao;

	@Autowired
	ProductValidator productValidator;

	@GetMapping("/search")
	public String search(HttpServletRequest req, @RequestParam(value = "name", required = false) String name) {
		if (name == null) {
			name = "";
		}
		List<Product> products = productDao.search("%" + name + "%");
		for (Product product : products) {
			System.out.println(product.getName());
		}
		req.setAttribute("listProduct", products);
		return "searchProduct";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("id") int id) throws SQLException {
		productDao.deleteById(id);

		return "redirect:/admin/product/search";
	}

	/// edit?id=123
	@GetMapping("/edit")
	public String edit(Model model, @Param("id") int id) {
		Product product = productDao.getById(id);
	    System.out.println(product.getAddress().getCity());
		model.addAttribute("product", product);

		return "editProduct";
	}
	

	// edit/213/adsba
	@GetMapping("/edit/{id}")
	public String editPath(Model model, @PathVariable("id") int id) {
		Product product = productDao.getById((id));
        System.out.println(product.getAddress().getCity());
		model.addAttribute("product", product);

		return "editProduct";
	}

	@PostMapping("/edit")
	public String edit(@ModelAttribute Product product, BindingResult bindingResult) throws SQLException {
		/// nho goi ham validate o day
		productValidator.validate(product, bindingResult);

		if (bindingResult.hasErrors()) {
			return "editProduct";
		}

		productDao.save(product);

		return "redirect:/admin/product/search";
	}

}

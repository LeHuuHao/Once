package com.trungtamjava.hellospringboot.controller;



import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trungtamjava.hellospringboot.entity.Category;
import com.trungtamjava.hellospringboot.repository.CategoryRepository;






@Controller
@RequestMapping(value = "/admin/category")
public class CategoryController {
	
	@Autowired // tu dong gan BEAN
	CategoryRepository categoryDao; //= NEW UserDaoImpl()
	//Cate
		@GetMapping("/registercate") // url
		public String regisproPage() {
			return "category/register-category";// ten trang view login.jsp
		}
		
		
		@PostMapping("/registercate")
		public String registerpro(
				@RequestParam("name") String name	,
				@RequestParam("id") String id
				) throws ParseException {
					Category category = new Category();
					category.setName(name);
					category.setId(Integer.parseInt(id));									
					categoryDao.save(category);										
			return "redirect:/admin/category/searchcate";
		}
		
	@GetMapping("/searchcate") // url
	public String search(Model req, @RequestParam(value = "name", required = false) String name) {
//		String name = req.getParameter("name");

		if (name == null)
			name = "";

		try {
//			ProductDao productDao = new ProductDaoImpl();
			List<Category> categorys = categoryDao.search("%" + name + "%");/// MODEL

			req.addAttribute("cList", categorys);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "category/search-category";// ten trang view login.jsp
	}

	@GetMapping("/deletecate") // url
	public String delete(HttpServletRequest req, @RequestParam("id") int id){	

		categoryDao.deleteById(id);	

		return "redirect:/admin/category/searchcate";//ten trang view login.jsp
	}

	@GetMapping("/editcate") // url
	public String edit(Model req, @RequestParam("id") int id) {


		Category category = categoryDao.getById(id);

		req.addAttribute("category", category);
		return "category/edit-category";// ten trang view login.jsp
	}
	
	@PostMapping("/editcate")
	public String edit(@ModelAttribute Category category) throws SQLException {
//		ProductDao productDao = new ProductDaoImpl();
		//convert 			
		categoryDao.save(category);
		return "redirect:/admin/searchcate";
		
	}
}

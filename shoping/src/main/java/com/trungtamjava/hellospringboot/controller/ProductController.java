package com.trungtamjava.hellospringboot.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.trungtamjava.hellospringboot.dao.CategoryDao;
import com.trungtamjava.hellospringboot.dao.ProductDao;
import com.trungtamjava.hellospringboot.entity.Category;
import com.trungtamjava.hellospringboot.entity.Product;
import com.trungtamjava.hellospringboot.repository.CategoryRepository;
import com.trungtamjava.hellospringboot.repository.ProductRepository;
import com.trungtamjava.hellospringboot.validator.ProductValidator;

@Controller
@RequestMapping("/admin/product")

public class ProductController {
	@Autowired // tu dong gan BEAN tuong ung vao - DI
	ProductRepository productRepository;
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
	@GetMapping("/create")
	public String create(Model model) {
		List<Category> categories=categoryRepository.findAll();
		model.addAttribute("cateList",categories);
		return "product/create-product";
	}

	@PostMapping("/create")
	public String registerpro(
			@RequestParam("name") String name,
			@RequestParam("price") String price,			
			@RequestParam("description") String description,
			@RequestParam("imagefile") MultipartFile imagefile ,
			@RequestParam("categoryId") String cattegoryId
			
			) throws ParseException {
				Product product = new Product();
				product.setName(name);
				product.setPrice(Integer.parseInt(price));
				product.setDescription(description);										
				String originalFilename = imagefile.getOriginalFilename();
				int lastIndex = originalFilename.lastIndexOf(".");
				String ext = originalFilename.substring(lastIndex);
				Category category= new Category();
				category.setId(Integer.parseInt(cattegoryId));
				String avatarFilename = System.currentTimeMillis() + ext;
				File newfile = new File("C:\\Picture\\" + avatarFilename);
				FileOutputStream fileOutputStream;
				try {
					fileOutputStream = new FileOutputStream(newfile);
					fileOutputStream.write(imagefile.getBytes());
					fileOutputStream.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

				product.setPhotoURL(avatarFilename);
				product.setCategory(category);
				productDao.save(product);
				
		return "redirect:/admin/product/search";
	}

	/// SEARCH USER
	@GetMapping("/search")
	public String search(HttpServletRequest req, @RequestParam(value = "name", required = false) String name) {

		if (name == null)
			name = "";/// neu nguoi dung ko truyen len name

		List<Product> products = productRepository.search("%" + name + "%");/// MODEL

		req.setAttribute("listProduct", products);

		return "product/searchProduct";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("id") int id) throws SQLException {
		productRepository.deleteById(id);
		return "redirect:/admin/product/search";
	}

	/// edit?id=123
	@GetMapping("/edit")
	public String edit(Model model, @Param("id") int id) {
		Product product = productRepository.getById(id);
		model.addAttribute("product", product);

		return "product/editProduct";
	}

//    // edit/213/adsba
//    @GetMapping("/edit/{id}")
//    public String editPath(Model model, @PathVariable("id") int id) {
//	Person user = personRepository.getById((id));
//
//	model.addAttribute("user", user);
//
//	return "editUser";
//    }

	@PostMapping("/edit")
	public String edit(@ModelAttribute("product") Product product, BindingResult bindingResult,
			@RequestParam("imagefile")MultipartFile imagefile) {
		/// nho goi ham validate o day
		productValidator.validate(product, bindingResult);

		if (bindingResult.hasErrors()) {
			return "product/editProduct";
		}

		if (imagefile != null && imagefile.getSize() > 0) {
			// luu anh
			String originalFilename = imagefile.getOriginalFilename();
			int lastIndex = originalFilename.lastIndexOf(".");
			String ext = originalFilename.substring(lastIndex);

			String avatarFilename = System.currentTimeMillis() + ext;
			File newfile = new File("C:\\Picture\\" + avatarFilename);
			FileOutputStream fileOutputStream;
			try {
				fileOutputStream = new FileOutputStream(newfile);
				fileOutputStream.write(imagefile.getBytes());
				fileOutputStream.close();
				
				product.setPhotoURL(avatarFilename);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}


		return "redirect:/admin/product/search";
	}

}

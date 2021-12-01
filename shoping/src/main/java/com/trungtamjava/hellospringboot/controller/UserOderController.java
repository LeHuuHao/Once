package com.trungtamjava.hellospringboot.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trungtamjava.hellospringboot.entity.Person;
import com.trungtamjava.hellospringboot.entity.UserOrder;
import com.trungtamjava.hellospringboot.repository.PersonRepository;
import com.trungtamjava.hellospringboot.repository.UserOderResposity;
@RequestMapping("/admin/user-oder")
@Controller
public class UserOderController {
	@Autowired 
	PersonRepository personRepository;
	@Autowired
	UserOderResposity userOderResposity;
	@GetMapping("/userOrder")
	public String userOder(Model model) {
		List<Person> perList=personRepository.findAll();
		model.addAttribute("listUserOder", perList);
		return "Order/user-order";
	}
	@PostMapping("/userOrder")
	public String userOrder(@RequestParam("date") String date,
			@RequestParam("buyerId") String id
			) throws ParseException {
		if(id==null) {
			
		}
	    UserOrder userOrder= new UserOrder();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		userOrder.setCreatedDate(simpleDateFormat.parse(date));
		Person person= new Person();
		person.setId(Integer.parseInt(id));
		userOrder.setBuyer(person);
		userOderResposity.save(userOrder);
		return "redirect:/admin/user/search";
	}
	@GetMapping("/search") 
	public String searchByBuyer(Model req, 
			@RequestParam(value = "uId",required = false) String aId) {
	if(aId==null) {
		List<UserOrder> userorders = userOderResposity.findAll();/// MODEL
		req.addAttribute("oderList", userorders);
	}else {
		List<UserOrder> userorders = userOderResposity.searchByBuyer(Integer.parseInt(aId));/// MODEL
		req.addAttribute("oderList", userorders);
	}
		
		return "Order/search-user-order";// ten trang view login.jsp
	}
//	@GetMapping("/searchByBuyer") // url
//	public String searchByBuyer(Model req, @RequestParam(value = "uId", required = false) String uId) {
//		if (uId != null) {
//
//			List<UserOrder> userorders = userorderDao.searchByBuyer(Integer.parseInt(uId));/// MODEL
//			req.addAttribute("bList", userorders);
//		}else {
//			List<UserOrder> userorders = userorderDao.findAll();
//			req.addAttribute("bList", userorders);
//		}
//		return "userorder/search-userorder";// ten trang view login.jsp
//	}
//	
	@GetMapping("/deleteuserorder") // url
	public String delete(HttpServletRequest req, @RequestParam("id") int id){	

		userOderResposity.deleteById(id);	

		return "redirect:/admin/searchpro";// ten trang view login.jsp
	}
	

}


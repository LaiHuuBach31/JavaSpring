package com.project.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.dao.CartDAO;
import com.project.dao.ProductDAO;
import com.project.dao.UserDAO;
import com.project.dto.user.CreateDTO;
import com.project.entities.CustomUserDetails;
import com.project.entities.Product;
import com.project.entities.Role;
import com.project.entities.User;
import com.project.entities.UserRole;


@Controller
public class HomeController {
	
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private CartDAO cartDAO;
	@Autowired
	private ModelMapper modelMapper;
	
	@InitBinder
	public void initBinder(WebDataBinder data) {
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		s.setLenient(false);
		data.registerCustomEditor(Date.class, new CustomDateEditor(s, true));
	}

	@RequestMapping(value = {"", "home"})
	public String index(Model model, HttpSession session) {
		 try {
		        Object userObject = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		        if (userObject instanceof CustomUserDetails) {
		            CustomUserDetails user = (CustomUserDetails) userObject;
		            int count = cartDAO.getAll().size();
					model.addAttribute("count", count);
					session.setAttribute("user", user);
		        } 
		        
		        
		    } catch (ClassCastException ex) {
		        ex.printStackTrace();
		    }
		 	
		return "home_customer";
	}

	

	@RequestMapping("about")
	public String about(Model model) {
		return "about";

	}
	
	@RequestMapping("delivery")
	public String delivery(Model model) {
		return "delivery";

	}
	
	@RequestMapping("blog")
	public String blog(Model model) {
		return "blog";

	}
	
	@RequestMapping("location")
	public String location(Model model) {
		return "location";

	}
	
	@RequestMapping("menu")
	public String menu(Model model, @RequestParam(name = "keyWord", required = false) String keyWord,
			 @RequestParam(name = "pageNo", required = false) String pageNo) {
		int pagesize = 9	;
		int count = productDAO.count();
		int totalPage = count % pagesize == 0 ? count / pagesize : (count / pagesize) + 1;
		int pageno = pageNo != null ? Integer.parseInt(pageNo) : 1;	
		List<Product> list = productDAO.pading(pageno, pagesize);
		model.addAttribute("list", list);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("count", count);
		return "menu";

	}
	
	@RequestMapping("detail/{id}")
	public String detail(@PathVariable String id,  Model model) {
		Product product = productDAO.find(Integer.parseInt(id));
		model.addAttribute("product", product);
		return "detail";

	}
	
	@GetMapping("registercus")
	public String register(Model model) {
//		User user = new User();
//		model.addAttribute("user", user);
		return "registercus";

	}
	@PostMapping("registercus")
	public String registerCus(@Valid @ModelAttribute("user")CreateDTO user,BindingResult result, Model model, RedirectAttributes redirectAttrs) {
		if (result.hasErrors()) {
			model.addAttribute("user", user);
			return "registercus";
		} else {
			User u = modelMapper.map(user, User.class);
			u.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
			u.setEnabled(user.getEnabled());
			boolean check = userDAO.register(u);
			
			UserRole user_Role = new UserRole();
			user_Role.setUser(u);
			Role r = new Role();
			r.setName("ROLE_USER");
			
			user_Role.setRole(r);
//			boolean r = userDAO.addUserRoleus(null);
			if (check) {
				redirectAttrs.addFlashAttribute("success", "Register successfuly");
				return "redirect:/logincus";
			} else {
				return "registercus";
			}
		}
		
	}
	
	@RequestMapping("/logincus")
	public String login(@RequestParam(value = "error", required = false) String error, Model model) {
		if (error != null) {
			model.addAttribute("mess", "Login failed!");
		}
		return "logincus";

	}
	
	@RequestMapping("/logoutcus")
	public String logout(Model model) {
		model.addAttribute("mess", "Has Logged out!!!");
		return "logincus";
	}
	
}

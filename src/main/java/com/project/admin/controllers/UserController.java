package com.project.admin.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.dao.UserDAO;
import com.project.entities.OrderDetail;
import com.project.entities.Role;
import com.project.entities.User;
import com.project.entities.UserRole;

@Controller
@RequestMapping("admin/user")
public class UserController {

	@Autowired
	private UserDAO userDAO;
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping(value = "")
	public String index(Model model, @RequestParam(name = "keyWord", required = false) String keyWord,
			@RequestParam(name = "pageNo", required = false, defaultValue = "1") String pageNo) {
		int pagesize = 5;
		int count = userDAO.count();
		int totalPage = count % pagesize == 0 ? count / pagesize : (count / pagesize) + 1;
		int pageno = pageNo != null ? Integer.parseInt(pageNo) : 1;	
		List<User> list = userDAO.pading(pageno, pagesize);
		if(keyWord != null) {
			count = userDAO.countUser(keyWord);
			totalPage = count % pagesize == 0 ? count / pagesize : (count / pagesize) + 1;
			list = userDAO.searchUser(keyWord, pageno, pagesize);
		}
		model.addAttribute("list", list);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("count", count);
		return "userlist";
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable String id,RedirectAttributes redirectAttrs) {
		List<UserRole> list = userDAO.listByUser(Integer.parseInt(id));
		for (UserRole userRole : list) {
			userDAO.deleteUserRole(userRole.getId());
		}
		boolean check = userDAO.delete(Integer.parseInt(id));
		if (check) {
			redirectAttrs.addFlashAttribute("success", "Delete successfuly");
			return "redirect:/admin/user";
		} else {
			redirectAttrs.addFlashAttribute("faild", "Delete faild");
			return "redirect:/admin/user";
		}

	}
}

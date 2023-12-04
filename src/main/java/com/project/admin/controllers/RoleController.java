package com.project.admin.controllers;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.dao.RoleDAO;
import com.project.dto.role.CreateDTO;
import com.project.entities.Role;

@Controller
@RequestMapping("admin/role")
public class RoleController {
	
	@Autowired
	private RoleDAO roleDAO;
	@Autowired
	private ModelMapper modelMapper;

	
	@GetMapping(value = "")
	public String index(Model model, @RequestParam(name = "keyWord", required = false) String keyWord,
			@RequestParam(name = "pageNo", required = false, defaultValue = "1") String pageNo) {
		int pagesize = 5;
		int count = roleDAO.count();
		int totalPage = count % pagesize == 0 ? count / pagesize : (count / pagesize) + 1;
		int pageno = pageNo != null ? Integer.parseInt(pageNo) : 1;	
		List<Role> list = roleDAO.pading(pageno, pagesize);
		if(keyWord != null) {
			count = roleDAO.countRole(keyWord);
			totalPage = count % pagesize == 0 ? count / pagesize : (count / pagesize) + 1;
			list = roleDAO.searchRole(keyWord, pageno, pagesize);
		}
		model.addAttribute("list", list);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("count", count);
		return "rolelist";
	}
	
	@GetMapping("create")
	public String add(Model model) {
		Role role = new Role();
		model.addAttribute("role", role);
		return "rolecreate";
	}
	
	@PostMapping(value = "create")
	public String insert(@Valid @ModelAttribute("role") CreateDTO role, BindingResult result, Model model,
			RedirectAttributes redirectAttrs) {
		if (result.hasErrors()) {
			model.addAttribute("role", role);
			return "rolecreate";
		} else {
			Role ro = modelMapper.map(role, Role.class);
			ro.setName("ROLE_" +  role.getName().toUpperCase().replaceAll("\\s", ""));
			boolean check = roleDAO.create(ro);
			if (check) {
				redirectAttrs.addFlashAttribute("success", "Add new successfuly");
				return "redirect:/admin/role";
			} else {
				redirectAttrs.addFlashAttribute("faild", "Add new faild");
				return "rolecreate";
			}
		}
	}
	
	@GetMapping(value = "edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		Role role = roleDAO.find(id);
		role.setName(role.getName().replaceAll("ROLE_", ""));
		model.addAttribute("role", role);
		return "roleedit";
	}
	
	
	@PostMapping(value = "edit/{id}")
	public String update(@Valid @ModelAttribute("role") CreateDTO role, BindingResult result, Model model,
			RedirectAttributes redirectAttrs) {
		if (result.hasErrors()) {
			model.addAttribute("role", role);
			return "rolecreate";
		} else {
			Role ro = modelMapper.map(role, Role.class);
			ro.setName("ROLE_" +  role.getName().toUpperCase().replaceAll("\\s", ""));
			boolean check = roleDAO.update(ro);
			if (check) {
				redirectAttrs.addFlashAttribute("success", "Update successfuly");
				return "redirect:/admin/role";
			} else {
				redirectAttrs.addFlashAttribute("faild", "Update faild");
				return "rolecreate";
			}
		}
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable String id, RedirectAttributes redirectAttrs) {
		boolean check = roleDAO.delete(Integer.parseInt(id));
		if (check) {
			redirectAttrs.addFlashAttribute("success", "Delete successfuly");
			return "redirect:/admin/role";
		} else {
			redirectAttrs.addFlashAttribute("faild", "Delete faild");
			return "redirect:/admin/role";
		}

	}
}

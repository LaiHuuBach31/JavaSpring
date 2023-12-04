package com.project.admin.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.dao.CategoryDAO;
import com.project.dao.ProductDAO;
import com.project.dto.category.CreateDTO;
import com.project.dto.category.UpdateDTO;
import com.project.entities.Category;

@Controller
@RequestMapping("admin/category")
public class CategoryController {

	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("")
	public String index(Model model, @RequestParam(name = "keyword", required = false) String keyWord,
			@RequestParam(name = "pageno", required = false, defaultValue = "1") String pageNo) {
		int pagesize = 5;
		int count = categoryDAO.count();
		int totalPage = count % pagesize == 0 ? count / pagesize : (count / pagesize) + 1;
		int pageno = pageNo != null ? Integer.parseInt(pageNo) : 1;	
		List<Category> list = categoryDAO.pading(pageno, pagesize);
		if(keyWord != null) {
			count = categoryDAO.countCategory(keyWord);
			totalPage = count % pagesize == 0 ? count / pagesize : (count / pagesize) + 1;
			list = categoryDAO.searchCategory(keyWord, pageno, pagesize);
		}
		model.addAttribute("list", list);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("count", count);
		return "categorylist";
	}

	@GetMapping("create")
	public String add(Model model) {
		Category category = new Category();
		model.addAttribute("category", category);
		return "categorycreate";
	}

	@PostMapping(value = "create")
	public String insert(@Valid @ModelAttribute("category") CreateDTO category, BindingResult result, Model model,
			HttpServletRequest request, RedirectAttributes redirectAttrs) {
		if (result.hasErrors()) {
			model.addAttribute("category", category);
			return "categorycreate";
		} else {
			String path = request.getServletContext().getRealPath("resources/images");
			File f = new File(path);
			String fileName = category.getImage().getOriginalFilename();
			File destination = new File(f.getAbsolutePath() + "/" + fileName);
		
			try {
				if (!destination.exists()) {
					Files.write(destination.toPath(), category.getImage().getBytes(), StandardOpenOption.CREATE);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			Category categoryCreate = modelMapper.map(category, Category.class);
			
			categoryCreate.setImage(category.getImage().getOriginalFilename());
			
			boolean check = categoryDAO.create(categoryCreate);
			
			if (check) {
				redirectAttrs.addFlashAttribute("success", "Add new successfuly");
				return "redirect:/admin/category";
			} else {
				redirectAttrs.addFlashAttribute("faild", "Add new faild");
				return "categorycreate";
			}
		}
	}
	
	@GetMapping(value = "edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		Category category = categoryDAO.find(id);
		model.addAttribute("category", category);
		return "categoryedit";
	}
	
	@PostMapping(value = "edit/{id}")
	public String update(@Valid @ModelAttribute("category") UpdateDTO category, BindingResult result, Model model,
			HttpServletRequest request, RedirectAttributes redirectAttrs) {
		if (result.hasErrors()) {
			model.addAttribute("category", category);
			return "categoryedit";
		} else {
			Category categoryUpdate = modelMapper.map(category, Category.class);
			MultipartFile newImage = category.getImage();
			 if(newImage != null && !newImage.isEmpty()) {
				 String path = request.getServletContext().getRealPath("resources/images");
		            File f = new File(path);
		            String fileName = newImage.getOriginalFilename();
		            File destination = new File(f.getAbsolutePath() + "/" + fileName);
		            try {
		                if (!destination.exists()) {
		                    Files.write(destination.toPath(), newImage.getBytes(), StandardOpenOption.CREATE);
		                }
		                categoryUpdate.setImage(newImage.getOriginalFilename());
		            } catch (IOException e) {
		                e.printStackTrace();
		            }
			 } else {
				 Category currentCategory = categoryDAO.find(category.getId());
				 categoryUpdate.setImage(currentCategory.getImage());
			 }
		    
			boolean check = categoryDAO.update(categoryUpdate);
			
			if (check) {
				redirectAttrs.addFlashAttribute("success", "Update successfuly");
				return "redirect:/admin/category";
			} else {
				redirectAttrs.addFlashAttribute("faild", "Update faild");
				return "categoryedit";
			}
		}
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable String id, RedirectAttributes redirectAttrs) {
		int count = productDAO.countCateId(Integer.parseInt(id));
		if(count > 0) {
			redirectAttrs.addFlashAttribute("faild", "There are products in the catalog");
			return "redirect:/admin/category";
		} else {
			boolean check = categoryDAO.delete(Integer.parseInt(id));
			if (check) {
				redirectAttrs.addFlashAttribute("success", "Delete successfuly");
				return "redirect:/admin/category";
			} else {
				redirectAttrs.addFlashAttribute("faild", "Delete faild");
				return "redirect:/admin/category";
			}
		}	
	}
}

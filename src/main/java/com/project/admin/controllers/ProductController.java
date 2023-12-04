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
import com.project.dto.product.CreateDTO;
import com.project.dto.product.UpdateDTO;
import com.project.entities.Category;
import com.project.entities.Product;

@Controller
@RequestMapping("admin/product")
public class ProductController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private ModelMapper modelMapper;

	
	@GetMapping(value = "")
	public String index(Model model, @RequestParam(name = "keyword", required = false) String keyWord,
			 @RequestParam(name = "pageno", required = false) String pageNo) {
		int pagesize = 10;
		int count = productDAO.count();
		int totalPage = count % pagesize == 0 ? count / pagesize : (count / pagesize) + 1;
		int pageno = pageNo != null ? Integer.parseInt(pageNo) : 1;	
		List<Product> list = productDAO.pading(pageno, pagesize);
		if(keyWord != null) {
			count = productDAO.countProduct(keyWord);
			totalPage = count % pagesize == 0 ? count / pagesize : (count / pagesize) + 1;
			list = productDAO.searchProduct(keyWord, pageno, pagesize);
		}
		model.addAttribute("list", list);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("count", count);
		return "productlist";	
	}
	
	@GetMapping(value = "create")
	public String add(Model model) {
		List<Category> listCategory = categoryDAO.getAll();
		Product product = new Product();
		model.addAttribute("listCategory", listCategory);
		model.addAttribute("product", product);
		return "productcreate";
	}
	
	@PostMapping(value = "create")
	public String insert(@Valid @ModelAttribute("product") CreateDTO product, BindingResult result, Model model,
			HttpServletRequest request, RedirectAttributes redirectAttrs) {
		if (result.hasErrors()) {
			List<Category> listCategory = categoryDAO.getAll();
			model.addAttribute("listCategory", listCategory);
			model.addAttribute("product", product);
			return "productcreate";
		} else {
			String path = request.getServletContext().getRealPath("resources/images");
			File f = new File(path);
			String fileName = product.getImage().getOriginalFilename();
			File destination = new File(f.getAbsolutePath() + "/" + fileName);
			System.out.println(destination);
			try {
				if (!destination.exists()) {
					Files.write(destination.toPath(), product.getImage().getBytes(), StandardOpenOption.CREATE);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			Product productCreate = modelMapper.map(product, Product.class);

			productCreate.setImage(product.getImage().getOriginalFilename());

			if (productDAO.create(productCreate)) {
				redirectAttrs.addFlashAttribute("success", "Add new successfuly");
				return "redirect:/admin/product";
			} else {
				redirectAttrs.addFlashAttribute("faild", "Add new faild");
				return "redirect:/admin/create";
			}
		}
	}
	
	@GetMapping(value = "edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		Product product = productDAO.find(id);
		List<Category> listCategory = categoryDAO.getAll();
		model.addAttribute("product", product);
		model.addAttribute("listCategory",listCategory);
		return "productedit";
	}
	
	@PostMapping(value = "edit/{id}")
	public String update(@Valid @ModelAttribute("product") UpdateDTO product, BindingResult result, Model model,
			HttpServletRequest request, RedirectAttributes redirectAttrs) {
		if(result.hasErrors()) {
			List<Category> listCategory = categoryDAO.getAll();
			model.addAttribute("product", product);
			model.addAttribute("listCategory",listCategory);
			return "productedit";
		} else {
			 Product productUpdate = modelMapper.map(product, Product.class);
			 MultipartFile newImage = product.getImage();
			 if(newImage != null && !newImage.isEmpty()) {
				 String path = request.getServletContext().getRealPath("resources/images");
		            File f = new File(path);
		            String fileName = newImage.getOriginalFilename();
		            File destination = new File(f.getAbsolutePath() + "/" + fileName);
		            try {
		                if (!destination.exists()) {
		                    Files.write(destination.toPath(), newImage.getBytes(), StandardOpenOption.CREATE);
		                }
		                productUpdate.setImage(newImage.getOriginalFilename());
		            } catch (IOException e) {
		                e.printStackTrace();
		            }
			 } else {
				 Product currentProduct = productDAO.find(product.getId());
				 productUpdate.setImage(currentProduct.getImage());
			 }
		    

			if (productDAO.update(productUpdate)) {
				redirectAttrs.addFlashAttribute("success", "Update successfuly");
				return "redirect:/admin/product";
			} else {
				redirectAttrs.addFlashAttribute("faild", "Update faild");
				return "redirect:/admin/product";
			}
		}
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable String id,RedirectAttributes redirectAttrs) {
		boolean check = productDAO.delete(Integer.parseInt(id));
		if(check) {
			redirectAttrs.addFlashAttribute("success", "Delete successfuly");
			return "redirect:/admin/product";
		} else {
			redirectAttrs.addFlashAttribute("faild", "Delete faild");
			return "redirect:/admin/product";
		}
	}
}

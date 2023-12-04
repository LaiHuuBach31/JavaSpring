package com.project.admin.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.dao.OrderDAO;
import com.project.entities.Order;
import com.project.entities.OrderDetail;

@Controller
@RequestMapping("admin/order")
public class OrderController {
	
	@Autowired
	private OrderDAO orderDAO;
	
	@GetMapping(value = "")
	public String index(Model model) {
		List<Order> list = orderDAO.getAll();
		model.addAttribute("list", list);
		return "orderlist";
	}
	
	@GetMapping("{id}")
	public String orderDetail(@PathVariable String id, Model model) {
		List<OrderDetail> list = orderDAO.listByOrder(Integer.parseInt(id));
		Order order = orderDAO.find(Integer.parseInt(id));
		int item = list.size();
		model.addAttribute("list", list);
		model.addAttribute("order", order);
		model.addAttribute("item", item);
		return "orderdetail";
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable String id, RedirectAttributes redirectAttrs) {
		List<OrderDetail> list = orderDAO.listByOrder(Integer.parseInt(id));
		for (OrderDetail orderDetail : list) {
			orderDAO.deleteOrderDetail(orderDetail.getId());
		}
		boolean check = orderDAO.deleteOrder(Integer.parseInt(id));
		if (check) {
			redirectAttrs.addFlashAttribute("success", "Delete successfuly");
			return "redirect:/admin/order";
		} else {
			redirectAttrs.addFlashAttribute("faild", "Delete faild");
			return "redirect:/admin/order";
		}

	}
	
}

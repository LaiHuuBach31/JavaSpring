package com.project.controllers;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.apache.commons.lang.RandomStringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.dao.CartDAO;
import com.project.dao.MailDAO;
import com.project.dao.OrderDAO;
import com.project.dao.ProductDAO;
import com.project.dao.UserDAO;
import com.project.dto.order.CreateDTO;
import com.project.entities.Cart;
import com.project.entities.CustomUserDetails;
import com.project.entities.Order;
import com.project.entities.OrderDetail;
import com.project.entities.Product;
import com.project.entities.User;

@Controller
public class CartController {

	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private CartDAO cartDAO;
	@Autowired
	private OrderDAO orderDAO;
	@Autowired
	private MailDAO mailDAO;
	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("cart")
	public String index(Model model) {
		List<Cart> list = cartDAO.getAll();
		model.addAttribute("list", list);
		return "cart";
	}

	@PostMapping("cart")
	public String cart(@RequestParam(name = "id", required = false) String productId, Model model,
			RedirectAttributes redirectAttrs) {

		Product p = productDAO.find(Integer.parseInt(productId));
		CustomUserDetails cus = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		User u = userDAO.findByUserName(cus.getUsername());

		List<Cart> list = cartDAO.getAll();

		if (list.isEmpty()) {
			Cart newCart = new Cart();
			newCart.setProduct(p);
			newCart.setQuantity(1);
			newCart.setTotal(p.getPrice());
			newCart.setUser(u);

			Boolean check = cartDAO.create(newCart);
			System.out.println(check);
			if (check) {
				redirectAttrs.addFlashAttribute("success", "Add to cart successfuly");
			}
			redirectAttrs.addFlashAttribute("faild", "Add to cart falid");
		} else {
			Cart existingCart = null;
			for (Cart cart : list) {
				if (p.getId().equals(cart.getProduct().getId())) {
					existingCart = cart;
					break;
				}
			}

			if (existingCart != null) {
				existingCart.setQuantity(existingCart.getQuantity() + 1);
				existingCart.setTotal(existingCart.getQuantity() * p.getPrice());
				boolean check = cartDAO.update(existingCart);
				if (check) {
					redirectAttrs.addFlashAttribute("success", "Add to cart success");
				}
				redirectAttrs.addFlashAttribute("faild", "Add to cart falid");
			} else {
				Cart newCart = new Cart();
				newCart.setProduct(p);
				newCart.setQuantity(1);
				newCart.setTotal(p.getPrice());
				newCart.setUser(u);

				Boolean check = cartDAO.create(newCart);
				if (check) {
					redirectAttrs.addFlashAttribute("success", "Add to cart success");
				}
				redirectAttrs.addFlashAttribute("faild", "Add to cart falid");

			}

		}

		return "redirect:/cart";
	}
	
	@PostMapping("updateQuantity")
    public String updateQuantity(@RequestParam Integer cartId, @RequestParam int quantity) {
		Cart cart = cartDAO.find(cartId);
		cart.setQuantity(quantity);
		cart.setTotal(quantity * cart.getProduct().getPrice());
		cartDAO.update(cart);
        return "redirect:/cart";
    }

	@GetMapping("delete/{id}")
	public String delete(@PathVariable String id, RedirectAttributes redirectAttrs) {
		if (cartDAO.delete(Integer.parseInt(id))) {
			redirectAttrs.addFlashAttribute("success", "Delete successfuly");
			return "redirect:/cart";
		}
		redirectAttrs.addFlashAttribute("faild", "Delete faild");
		return "redirect:/cart";
	}

	@GetMapping("checkout")
	public String checkout(Model model) {
		CustomUserDetails cus = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		List<Cart> list = cartDAO.getAll();
		Order order = new Order();
		model.addAttribute("list", list);
		model.addAttribute("cus", cus);
		model.addAttribute("order", order);
		return "checkout";
	}

	@PostMapping("checkout")
	public String checkout(@Valid @ModelAttribute("order") CreateDTO order, BindingResult result, Model model,
			RedirectAttributes redirectAttrs) {
		System.out.println(result.hasErrors() + " check validate");
		if (result.hasErrors()) {
			CustomUserDetails cus = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			List<Cart> list = cartDAO.getAll();
			model.addAttribute("list", list);
			model.addAttribute("cus", cus);
			model.addAttribute("order", order);
			return "checkout";
		} else {
			Order o = modelMapper.map(order, Order.class);
			CustomUserDetails cus = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			User user = userDAO.findByUserName(cus.getUsername());
			String token = UUID.randomUUID().toString();
			 String orderCode = RandomStringUtils.randomNumeric(10);
			o.setStatus(false);
			o.setToken(token);
			o.setUser(user);
			o.setOrderCode(orderCode);
			o.setOrderDate(new Date());
			boolean check = orderDAO.createOrder(o);

			List<Cart> list = cartDAO.getAll();

			for (Cart cart : list) {
				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setOrder(o);
				orderDetail.setPrice(cart.getTotal());
				orderDetail.setProduct(cart.getProduct());
				orderDetail.setQuantity(cart.getQuantity());
				orderDAO.createOrderDetail(orderDetail);
			}

//			mailDAO.send();

			if (check) {
				for (Cart cart : list) {
					cartDAO.delete(cart.getId());
				}
				redirectAttrs.addFlashAttribute("success", "Order successfully");
				return "redirect:/";
			} else {
				redirectAttrs.addFlashAttribute("faild", "Order faild");
				return "redirect:/checkout";
			}
		}

	}
	

	@GetMapping("/mail")
	public String haha() {
		try {
			mailDAO.send("minhka192@gmail.com", "Hi", "chao cau");
		} catch (Exception e) {
			// TODO: handle exception
		}

		return "";
	}
}

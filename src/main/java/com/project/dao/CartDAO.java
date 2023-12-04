package com.project.dao;

import java.util.List;

import com.project.entities.Cart;

public interface CartDAO {
	public List<Cart> getAll();
	public Boolean create(Cart cart);
	public Cart find(Integer cartID);
	public Boolean update(Cart cart);
	public Boolean delete(Integer cartID);
}

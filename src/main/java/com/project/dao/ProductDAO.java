package com.project.dao;

import java.util.List;

import com.project.entities.Product;

public interface ProductDAO {
	public List<Product> getAll();
	public Boolean create(Product product);
	public Product find(Integer productID);
	public Boolean update(Product product);
	public Boolean delete(Integer productID);
	
	public Boolean existsByUsername(String name);
	
	public List<Product> search(String keyWord);
	public List<Product> pading(Integer pageNo, Integer pageSize);
	public int count();
	public List<Product> searchProduct(String keyWord, Integer pageNo, Integer pageSize);
	public int countProduct(String keyWord);
	public int countCateId(Integer cateId);
}

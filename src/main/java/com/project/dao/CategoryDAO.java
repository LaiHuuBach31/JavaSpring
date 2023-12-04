package com.project.dao;

import java.util.List;

import com.project.entities.Category;


public interface CategoryDAO {
	public List<Category> getAll();
	public Boolean create(Category category);
	public Category find(Integer categoryID);
	public Boolean update(Category category);
	public Boolean delete(Integer categoryID);
	
	public Boolean existsByUsername(String name);
	
	public List<Category> search(String keyWord);
	public List<Category> pading(Integer pageNo, Integer pageSize);
	public int count();
	public List<Category> searchCategory(String keyWord, Integer pageNo, Integer pageSize);
	public int countCategory(String keyWord);
}

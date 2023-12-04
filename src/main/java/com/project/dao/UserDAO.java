package com.project.dao;

import java.util.List;

import com.project.entities.User;
import com.project.entities.UserRole;

public interface UserDAO {
	
	public List<User> getAll();
	public User find(Integer userId);
	public boolean delete(Integer userId);
	public List<User> pading(Integer pageNo, Integer pageSize);
	public int count();
	public List<User> searchUser(String keyWord, Integer pageNo, Integer pageSize);
	public int countUser(String keyWord);
	
	public User findByUserName(String username);
	public boolean register(User user);
	
	public boolean addUserRole(UserRole userRole);
	public List<UserRole> listByUser(Integer userId);
	public UserRole findUserRole(Integer userRoleId);
	public boolean deleteUserRole(Integer userRoleId);
}

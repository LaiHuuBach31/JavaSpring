package com.project.dao;

import java.util.List;

import com.project.entities.Role;

public interface RoleDAO {
	public List<Role> getAll();
	public boolean create(Role role);
	public Role find(Integer roleId);
	public boolean update(Role role);
	public boolean delete(Integer roleId);
	public List<Role> pading(Integer pageNo, Integer pageSize);
	public int count();
	public List<Role> searchRole(String keyWord, Integer pageNo, Integer pageSize);
	public int countRole(String keyWord);
}

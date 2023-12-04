package com.project.dao.impl;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.dao.UserDAO;
import com.project.entities.User;
import com.project.entities.UserRole;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User findByUserName(String username) {
		Session session = sessionFactory.openSession();
		try {
			User user = (User) session.createQuery("from User where userName = :userName")
			.setParameter("userName", username)
			.uniqueResult();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean register(User user) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return false;
	}

	@Override
	public boolean addUserRole(UserRole userRole) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(userRole);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return false;
	}

	@Override
	public List<User> getAll() {
		Session session = sessionFactory.openSession();
		try {
			List<User> list = session.createQuery("from User", User.class).list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<User> pading(Integer pageNo, Integer pageSize) {
		Session session = sessionFactory.openSession();
		try {
			List<User> list = session.createQuery("from User", User.class)
					.setFirstResult((pageNo - 1) * pageSize).setMaxResults(pageSize).getResultList();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public int count() {
		int total = 0;
		Session session = sessionFactory.openSession();
		try {
			total = session.createQuery("from User", User.class).list().size();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return total;
	}

	@Override
	public List<User> searchUser(String keyWord, Integer pageNo, Integer pageSize) {
		Session session = sessionFactory.openSession();
		try {
			List<User> list = session
					.createQuery("from User where lower(userName) like lower(:keyword)", User.class)
					.setParameter("keyword", "%" + keyWord + "%").setFirstResult((pageNo - 1) * pageSize)
					.setMaxResults(pageSize).getResultList();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public int countUser(String keyWord) {
		int total = 0;
		Session session = sessionFactory.openSession();
		try {
			total = session.createQuery("from User where lower(userName) like lower(:keyword)", User.class)
					.setParameter("keyword", "%" + keyWord.toLowerCase() + "%").list().size();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return total;
	}

	@Override
	public User find(Integer userId) {
		Session session = sessionFactory.openSession();
		try {
			User user = session.get(User.class, userId);
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	
	@Override
	public boolean delete(Integer userId) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.delete(find(userId));
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public List<UserRole> listByUser(Integer userId) {
		Session session = sessionFactory.openSession();
		try {
			List<UserRole> list = session
					.createQuery("from UserRole where userId = :userId", UserRole.class)
					.setParameter("userId", userId).list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public UserRole findUserRole(Integer userRoleId) {
		Session session = sessionFactory.openSession();
		try {
			UserRole userRole = session.get(UserRole.class, userRoleId);
			return userRole;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean deleteUserRole(Integer userRoleId) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.delete(findUserRole(userRoleId));
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return false;
	}

	
}

package com.project.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.project.dao.CartDAO;
import com.project.dao.UserDAO;
import com.project.entities.Cart;
import com.project.entities.CustomUserDetails;
import com.project.entities.User;

@Repository
public class CartDAOImpl implements CartDAO {

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private UserDAO userDAO;

	@Override
	public List<Cart> getAll() {
		Session session = sessionFactory.openSession();
		CustomUserDetails auth = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		User user = userDAO.findByUserName(auth.getUsername());

		try {
			List<Cart> list = session.createQuery("from Cart where userId=:userId", Cart.class)
					.setParameter("userId", user.getId()).list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public Boolean create(Cart cart) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(cart);
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
	public Cart find(Integer cartID) {
		Session session = sessionFactory.openSession();
		try {
			Cart cart = session.get(Cart.class, cartID);
			return cart;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public Boolean update(Cart cart) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(cart);
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

	@Override
	public Boolean delete(Integer cartID) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.delete(find(cartID));
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

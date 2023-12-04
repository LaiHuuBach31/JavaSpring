package com.project.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.dao.OrderDAO;
import com.project.entities.Order;
import com.project.entities.OrderDetail;

@Repository
public class OrderDAOImpl implements OrderDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Order> getAll() {
		Session session = sessionFactory.openSession();
		try {
			List<Order> list = session.createQuery("from Order", Order.class).list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;

	}

	@Override
	public Boolean createOrder(Order order) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(order);
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
	public Order find(Integer orderId) {
		Session session = sessionFactory.openSession();
		try {
			Order order = session.get(Order.class, orderId);
			return order;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	
	@Override
	public Boolean updateOrder(Order order) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(order);
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
	public Boolean deleteOrder(Integer orderId) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.delete(find(orderId));
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
	public Boolean createOrderDetail(OrderDetail orderDetail) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(orderDetail);
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
	public OrderDetail findOrderDetail(Integer orderDetailId) {
		Session session = sessionFactory.openSession();
		try {
			OrderDetail orderDetail = session.get(OrderDetail.class, orderDetailId);
			return orderDetail;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<OrderDetail> listByOrder(Integer orderId) {
		Session session = sessionFactory.openSession();
		try {
			List<OrderDetail> list = session
					.createQuery("from OrderDetail where orderId = :orderId", OrderDetail.class)
					.setParameter("orderId", orderId).list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public Boolean deleteOrderDetail(Integer orderId) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.delete(findOrderDetail(orderId));
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

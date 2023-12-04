package com.project.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.dao.RoleDAO;
import com.project.entities.Role;

@Repository
public class RoleDAOImpl implements RoleDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Role> getAll() {
		Session session = sessionFactory.openSession();
		try {
			List<Role> list = session.createQuery("from Role", Role.class).list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean create(Role role) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(role);
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
	public Role find(Integer roleId) {
		Session session = sessionFactory.openSession();
		try {
			Role category = session.get(Role.class, roleId);
			return category;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean update(Role role) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(role);
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
	public boolean delete(Integer roleId) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.delete(find(roleId));
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
	public List<Role> pading(Integer pageNo, Integer pageSize) {
		Session session = sessionFactory.openSession();
		try {
			List<Role> list = session.createQuery("from Role", Role.class)
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
			total = session.createQuery("from Role", Role.class).list().size();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return total;
	}

	@Override
	public List<Role> searchRole(String keyWord, Integer pageNo, Integer pageSize) {
		Session session = sessionFactory.openSession();
		try {
			List<Role> list = session
					.createQuery("from Role where lower(name) like lower(:keyword)", Role.class)
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
	public int countRole(String keyWord) {
		int total = 0;
		Session session = sessionFactory.openSession();
		try {
			total = session.createQuery("from Role where lower(name) like lower(:keyword)", Role.class)
					.setParameter("keyword", "%" + keyWord.toLowerCase() + "%").list().size();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return total;
	}
	
}

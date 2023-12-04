package com.project.dao.impl;

import java.util.List;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.dao.CategoryDAO;
import com.project.entities.Category;

@Repository
public class CategoryDAOImpl implements CategoryDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Category> getAll() {
		Session session = sessionFactory.openSession();
		try {
			List<Category> list = session.createQuery("from Category c order by c.id desc", Category.class).list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public Boolean create(Category category) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(category);
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
	public Category find(Integer categoryID) {
		Session session = sessionFactory.openSession();
		try {
			Category category = session.get(Category.class, categoryID);
			return category;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public Boolean update(Category category) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(category);
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
	public Boolean delete(Integer categoryID) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.delete(find(categoryID));
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
	public Boolean existsByUsername(String name) {
		Session session = sessionFactory.openSession();
		int count;
		boolean bl = false;
		try {
			 count = session
					.createQuery("from Category c where lower(c.name) = :name", Category.class)
					.setParameter("name", name.toLowerCase()).list().size();
			 System.out.println(count);
			bl = count > 0 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return bl;
	}

	@Override
	public List<Category> search(String keyWord) {
		Session session = sessionFactory.openSession();
		try {
			List<Category> list = session
					.createQuery("from Category where lower(name) like :keyword", Category.class)
					.setParameter("keyword", "%" + keyWord.toLowerCase() + "%").list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<Category> pading(Integer pageNo, Integer pageSize) {
		Session session = sessionFactory.openSession();
		try {
			List<Category> list = session.createQuery("from Category", Category.class)
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
			total = session.createQuery("from Category", Category.class).list().size();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return total;
	}

	@Override
	public List<Category> searchCategory(String keyWord, Integer pageNo, Integer pageSize) {
		Session session = sessionFactory.openSession();
		try {
			List<Category> list = session
					.createQuery("from Category where lower(name) like lower(:keyword)", Category.class)
					.setParameter("keyword", "%" + keyWord.toLowerCase() + "%").setFirstResult((pageNo - 1) * pageSize)
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
	public int countCategory(String keyWord) {
		int total = 0;
		Session session = sessionFactory.openSession();
		try {
			total = session.createQuery("from Category where lower(name) like lower(:keyword)", Category.class)
					.setParameter("keyword", "%" + keyWord.toLowerCase() + "%").list().size();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return total;
	}

}

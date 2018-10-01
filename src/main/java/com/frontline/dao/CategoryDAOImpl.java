package com.frontline.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.frontline.model.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	SessionFactory sessionfactory;
	
	@Override
	public boolean addCategory(Category category)
	{
		try
		{
		sessionfactory.getCurrentSession().save(category);	
		return true;
		}
		catch(Exception e)
		{
		return false;	
		}
	}

	@Override
	public boolean deleteCategory(Category category) 
	{
		try
		{
		sessionfactory.getCurrentSession().delete(category);	
		return true;
		}
		catch(Exception e)
		{
		return false;	
		}
	}

	@Override
	public boolean updateCategory(Category category) 
	{
		try
		{
		sessionfactory.getCurrentSession().update(category);	
		return true;
		}
		catch(Exception e)
		{
		return false;	
		}
	}

	@Override
	public List<Category> listCategories() 
	{
		Session session=sessionfactory.openSession();
		Query query=session.createQuery("from Category");
		List<Category> listCategories=query.list();
		session.close();
		return listCategories;
	}

	@Override
	public Category getCategory(int categoryId) 
	{
		Session session=sessionfactory.openSession();
		Category category=(Category)session.get(Category.class, categoryId);
		session.close();
		return category;
	}
	
	
}

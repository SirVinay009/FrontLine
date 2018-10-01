package com.frontline.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.frontline.model.Category;
import com.frontline.model.Item;

@Repository("itemDAO")
@Transactional
public class ItemDAOImpl implements ItemDAO {

	@Autowired
	SessionFactory sessionfactory;
	
	@Override
	public boolean addItem(Item item)
	{
		try
		{
			sessionfactory.getCurrentSession().save(item);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}
	

	@Override
	public boolean deleteItem(Item item) 
	{
		try
		{
		sessionfactory.getCurrentSession().delete(item);	
		return true;
		}
		catch(Exception e)
		{
		return false;	
		}
	}

	
	@Override
	public boolean updateItem(Item item)
	{
		try
		{
			sessionfactory.getCurrentSession().update(item);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
		
	}
	
	@Override
	public List<Item> listItems()
	{
		
		Session session = sessionfactory.openSession();
		Query query = session.createQuery("from Item");
		List<Item> listItems = query.list();
		session.close();
		return listItems;
	}
	
	@Override
	public Item getItem(int itemid)
	{
		
		Session session = sessionfactory.openSession();
		Item item = session.get(Item.class, itemid);
		session.close();
		return item;
		
	}
	
	}
	
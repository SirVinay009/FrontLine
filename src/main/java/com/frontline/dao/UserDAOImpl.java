package com.frontline.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.frontline.model.User;

public class UserDAOImpl implements UserDAO {

	@Autowired 
	SessionFactory sessionfactory;
	
	@Override
	public boolean registerUser(User user) 
	{
		try
		{
			sessionfactory.getCurrentSession().save(user);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean modifyUser(User user) {
		try
		{
			sessionfactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public User getUser(String username)
	{
		Session session=sessionfactory.openSession();
		User user=session.get(User.class,username);
		session.close();
		return user;
	}


}

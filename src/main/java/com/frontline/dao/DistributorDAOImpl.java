package com.frontline.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.frontline.model.Distributor;

@Repository("distributorDAO")
@Transactional
public class DistributorDAOImpl implements DistributorDAO {


	@Autowired
	SessionFactory sessionfactory;
	
	@Override
	public boolean addDistributor(Distributor distributor)
	{
		try
		{
		sessionfactory.getCurrentSession().save(distributor);	
		return true;
		}
		catch(Exception e)
		{
		return false;	
		}
	}

	@Override
	public boolean deleteDistributor(Distributor distributor) 
	{
		try
		{
		sessionfactory.getCurrentSession().delete(distributor);	
		return true;
		}
		catch(Exception e)
		{
		return false;	
		}
	}

	@Override
	public boolean updateDistributor(Distributor distributor) 
	{
		try
		{
		sessionfactory.getCurrentSession().update(distributor);	
		return true;
		}
		catch(Exception e)
		{
		return false;	
		}
	}
	
	public List<Distributor> listDistributors()
	{
		
		Session session = sessionfactory.openSession();
		Query query = session.createQuery("from Distributor");
		List<Distributor> listDistributors = query.list();
		session.close();
		return listDistributors;
	}
	
	public Distributor getDistributor(int distributorid) 
	{
		Session session = sessionfactory.openSession();
		Distributor distributor = (Distributor)session.get(Distributor.class, distributorid);
		session.close();
		return distributor;
	}
	
}

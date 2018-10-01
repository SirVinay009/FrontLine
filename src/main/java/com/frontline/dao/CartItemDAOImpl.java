package com.frontline.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.frontline.model.CartItemPurchase;

@Repository("cartDAO")
@Transactional
public class CartItemDAOImpl {

	@Autowired
	SessionFactory sessionfactory;
	

	public boolean addCartItemPurchase(CartItemPurchase cartitempurchase)
	{
		try
		{
			sessionfactory.getCurrentSession().save(cartitempurchase);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
	}
	

	public boolean deleteCartItemPurchase(CartItemPurchase cartitempurchase)
	{
		try
		{
			sessionfactory.getCurrentSession().delete(cartitempurchase);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}


	public boolean updateCartItemPurchase(CartItemPurchase cartitempurchase) 
	{
		try
		{
			sessionfactory.getCurrentSession().update(cartitempurchase);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public List<CartItemPurchase> retrieveCartItemsPurchase(String username)
	{
	
		Session session = sessionfactory.openSession();
		Query query = session.createQuery("from CartItemPurchase where username := uname and pstatus = 'NP'");
		query.setParameter("uname", username);
		List<CartItemPurchase> listCartItemPurchase = query.list();
		session.close();
		return listCartItemPurchase;
	}
	
	public CartItemPurchase getCartItemPurchase(int cartitempurchaseid) 
	{
		Session session=sessionfactory.openSession();
		CartItemPurchase cartitempurchase=session.get(CartItemPurchase.class, cartitempurchaseid);
		session.close();
		return cartitempurchase;
	}

	
}

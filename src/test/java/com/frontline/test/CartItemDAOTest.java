package com.frontline.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.frontline.dao.CartItemDAO;
import com.frontline.model.CartItemPurchase;

public class CartItemDAOTest {

	static CartItemDAO cartitemdao;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.frontline");
		context.refresh();
		cartitemdao = (CartItemDAO)context.getBean("cartitemdao");
	}


	@Ignore
	@Test
	public void addCartItemPurchaseTest()
	{
		CartItemPurchase cartitempurchase = new CartItemPurchase();
		cartitempurchase.setItemid(1);
		cartitempurchase.setItemname("Dell");
		cartitempurchase.setQuantity(10);
		cartitempurchase.setPrice(12000);
		cartitempurchase.setUsername("Rahul");
		cartitempurchase.setPstatus("NP");
		
		assertTrue("Problem in Adding the Cart Item Purchased:", cartitemdao.addCartItemPurchase(cartitempurchase));
	}
	
	@Test
	public void retrieveCartItemTest()
	{
		List<CartItemPurchase> listCartItems = cartitemdao.retrieveCartItemsPurchase("Rahul");
		
		assertTrue("Problem in Retrieving the Cart Items:",listCartItems.size()>0);
		
		for(CartItemPurchase cartitems : listCartItems)
		{
			System.out.print(cartitems.getItemname() + ":::");
			System.out.print(cartitems.getQuantity() + ":::");
			System.out.println(cartitems.getItemid() + ":::");
		}
	}


}

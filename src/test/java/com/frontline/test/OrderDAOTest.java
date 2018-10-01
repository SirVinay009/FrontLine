package com.frontline.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.frontline.dao.ItemDAO;
import com.frontline.dao.OrderDAO;
import com.frontline.model.Item;
import com.frontline.model.OrderDetail;

public class OrderDAOTest {

	static OrderDAO orderdao;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.frontline");
		context.refresh();
	    orderdao = (OrderDAO)context.getBean("orderdao");
	}
	
	@Test
	public void insertOrderTest()
	{
		OrderDetail order = new OrderDetail();
		order.setUsername("Vivek");
		order.setTotalshoppingamount(51000);
		order.setPmode("NP");
		
		assertTrue("Problem in adding Order to menu", orderdao.insertOrderDetail(order));
	}


}

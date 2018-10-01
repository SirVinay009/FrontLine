package com.frontline.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.frontline.dao.ItemDAO;
import com.frontline.model.Item;

public class ItemDAOTest {

	static ItemDAO itemdao;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.frontline");
		context.refresh();
	    itemdao = (ItemDAO)context.getBean("itemdao");
	}
	
	@Test
	public void addItemTest()
	{
		Item item = new Item();
		item.setItemname("Dell");
		item.setItemdesc("Laptop with i5 Processor");
		item.setQuantity(2);
		item.setPrice(52000);
		item.setSupplierid(2);
		item.setCategoryid(2);
		
		assertTrue("Problem in adding Item", itemdao.addItem(item));
	}


}

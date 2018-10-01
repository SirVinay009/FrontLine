package com.frontline.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.frontline.dao.ItemDAO;
import com.frontline.dao.UserDAO;
import com.frontline.model.Item;
import com.frontline.model.User;

public class UserDAOTest {

	static UserDAO userdao;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.frontline");
		context.refresh();
	    userdao = (UserDAO)context.getBean("userdao");
	}
	
	@Test
	public void registerUserTest()
	{
		User user = new User();
		user.setUsername("Ravi");
		user.setPassword("ravi99");
		user.setCustomerName("kishore");
		user.setEmailId("ravi87@gmail.com");
		user.setRole("specialist");
		user.setEnabled("NP");
		
		assertTrue("Problem in adding User", userdao.registerUser(user));
	}


	
}

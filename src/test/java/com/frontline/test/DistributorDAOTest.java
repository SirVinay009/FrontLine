package com.frontline.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.frontline.dao.CategoryDAO;
import com.frontline.dao.DistributorDAO;
import com.frontline.model.Category;
import com.frontline.model.Distributor;

public class DistributorDAOTest {

	static DistributorDAO distributordao;
	
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.frontline");
		context.refresh();
		distributordao = (DistributorDAO)context.getBean("distributordao");
	}

	

	@Ignore
	@Test
	public void addDistributorTest()
	{
		Distributor distributor = new Distributor();
		distributor.setDistributorname("Vashi");
		distributor.setDistributordesc("Good Efficiency");
		assertTrue("Problem in Adding Distributor:", distributordao.addDistributor(distributor));
	}
	@Ignore
	@Test
	public void updateDistributorTest()
	{
		Distributor distributor = distributordao.getDistributor(3);
		distributor.setDistributordesc("all the suppliers");
		assertTrue("Probem in Updating the Distributor", distributordao.updateDistributor(distributor));
	}
	@Ignore
	@Test
	public void deleteDistributorTest()
	{
		Distributor distributor = distributordao.getDistributor(4);
		assertTrue("Probem in deleting the Distributor", distributordao.deleteDistributor(distributor));
	}
	
	@Test
	public void listDistributorsTest()
	{
		List<Distributor> listDistributors = distributordao.listDistributors();
		assertNotNull("Problem in Listing Distributors",listDistributors);
		
		for(Distributor distributor: listDistributors)
		{
			System.out.print(distributor.getDistributorid()+":::");
			System.out.print(distributor.getDistributorname()+":::");
			System.out.println(distributor.getDistributordesc());
		}
	}



}

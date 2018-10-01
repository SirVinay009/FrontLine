package com.frontline.test;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.frontline.dao.CategoryDAO;
import com.frontline.model.Category;

public class CategoryDAOTest {


	static CategoryDAO categorydao;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.frontline");
		context.refresh();
		categorydao = (CategoryDAO)context.getBean("categorydao");
	}
	@Ignore
	@Test
	public void addCategoryTest()
	{
		Category category = new Category();
		category.setCategoryname("Lenovo");
		category.setCategorydesc("powerful i3 Processor");
		assertTrue("Problem in Adding Category:",categorydao.addCategory(category));
	}
	@Ignore
	@Test
	public void updateCategoryTest()
	{
		Category category = categorydao.getCategory(3);
		category.setCategorydesc("All the Lenovo Laptops");
		assertTrue("Probem in Updating the Category", categorydao.updateCategory(category));
	}
	@Ignore
	@Test
	public void deleteCategoryTest()
	{
		Category category = categorydao.getCategory(4);
		assertTrue("Probem in deleting the Category", categorydao.deleteCategory(category));
	}
	
	@Test
	public void listCategoriesTest()
	{
		List<Category> listCategories = categorydao.listCategories();
		assertNotNull("Problem in Listing Categories",listCategories);
		
		for(Category category:listCategories)
		{
			System.out.print(category.getCategoryid()+":::");
			System.out.print(category.getCategoryname()+":::");
			System.out.println(category.getCategorydesc());
		}
	}


}

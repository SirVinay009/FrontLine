package com.frontline.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.frontline.model.CartItemPurchase;
import com.frontline.model.Category;
import com.frontline.model.Distributor;
import com.frontline.model.Item;
import com.frontline.model.OrderDetail;
import com.frontline.model.User;

@Configuration
@EnableTransactionManagement
@EnableWebMvc
public class DBConfig {

	@Bean(name="dataSource")
	public DataSource getH2DataSource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
		dataSource.setUsername("sa");
		dataSource.setPassword("123456");
		return dataSource;
	}
	
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		Properties hibernateProperties=new Properties();
		hibernateProperties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		
		LocalSessionFactoryBuilder localsessionFactory=new LocalSessionFactoryBuilder(getH2DataSource());
		localsessionFactory.addProperties(hibernateProperties);
		
		localsessionFactory.addAnnotatedClass(CartItemPurchase.class);
		localsessionFactory.addAnnotatedClass(Category.class);
		localsessionFactory.addAnnotatedClass(Distributor.class);
		localsessionFactory.addAnnotatedClass(Item.class);
		localsessionFactory.addAnnotatedClass(OrderDetail.class);
		localsessionFactory.addAnnotatedClass(User.class);
		
		SessionFactory sessionFactory=localsessionFactory.buildSessionFactory();
		
		return sessionFactory;
	}
	
	@Bean(name="txManager")
	public HibernateTransactionManager getHibernateTransactionmanager(SessionFactory sessionFactory)
	{
		return new HibernateTransactionManager(sessionFactory);
	}

	
	
}

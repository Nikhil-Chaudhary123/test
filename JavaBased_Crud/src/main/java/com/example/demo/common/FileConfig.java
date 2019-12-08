package com.example.demo.common;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.example.demo.model.Student;

@Configuration
public class FileConfig {

	@Value("${db.driver}")
	private String driver;
	
	@Value("${db.url}")
	private String url;
	
	@Value("${db.username}")
	private String username;
	
	@Value("${db.password}")
	private String password;
	
	@Value("${hibernate.hbm2ddl.auto}")
	private String hbm2ddl_auto;
	
	@Value("${hibernate.show_sql}")
	private String show_sql;
	
	@Value("${hibernate.dialect}")
	private String dialect;
	
	@Value("${entityToScan}")
	private String entityScan;
	
	@Bean
	public DataSource getDataSource()
	{
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		return ds;
	}
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory()
	{
		LocalSessionFactoryBean ls=new LocalSessionFactoryBean();
		ls.setDataSource(getDataSource());
		Properties p=new Properties();
		p.put("hibernate.hbm2ddl.auto", hbm2ddl_auto);
		p.put("hibernate.Dialect",dialect);
		p.put("hibernate.show_sql", show_sql);
		p.put("entityToScan", entityScan);
		ls.setHibernateProperties(p);
		
		ls.setAnnotatedClasses(Student.class);
		return ls;
		
	}
}

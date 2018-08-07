package com.yourdelicacy.restaurant;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletPath;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@ComponentScan("com.yourdelicacy")
@PropertySource("classpath:application.properties")
@EntityScan("com.yourdelicacy.restaurant.model")
@Configuration
@EnableJpaRepositories("com.yourdelicacy.restaurant.repository")
public class ApplicationConfiguration implements WebMvcConfigurer {

	private static final String PROPERTY_NAME_DATABASE_DRIVER = "db.driver";
	private static final String PROPERTY_NAME_DATABASE_PASSWORD = "db.password";
	private static final String PROPERTY_NAME_DATABASE_URL = "db.url";
	private static final String PROPERTY_NAME_DATABASE_USERNAME = "db.username";

	private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
	private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
	private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "entitymanager.packages.to.scan";

	@Autowired
	private ResourceLoader resourceLoader;
	@Resource
	private Environment environment;
	
	

	/**
	 * Initializes global settings.
	 */
	@PostConstruct
	public void init() {
		String servletBaseUri = null;
		try {
			servletBaseUri = resourceLoader.getResource("WEB-INF").getURI().toString();
			servletBaseUri = servletBaseUri.substring(0, servletBaseUri.indexOf("/WEB-INF"));
			IciApplicationContextInitializer.setRuntimeProperty("servletBaseUri", servletBaseUri);
			System.out.println(servletBaseUri);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ApplicationConfiguration.class, args);
	}


	@Bean
	public DispatcherServlet dispatcherServlet() {
	    return new DispatcherServlet();
	}

	/**
	 * Register dispatcherServlet programmatically
	 *
	 * @return ServletRegistrationBean
	 */
	//@Bean
	public ServletRegistrationBean dispatcherServletRegistration() {

	    ServletRegistrationBean registration = new ServletRegistrationBean(
	            dispatcherServlet(), "/repository/");

	    registration
	            .setName(DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_REGISTRATION_BEAN_NAME);
	    Map<String,String> params = new HashMap<String,String>();
        //params.put("org.atmosphere.servlet","org.springframework.web.servlet.DispatcherServlet");
        params.put("contextClass","org.springframework.web.context.support.AnnotationConfigWebApplicationContext");
        params.put("contextConfigLocation","com.yourdelicacy.restaurant.ApplcationConfiguration.java");
        registration.setInitParameters(params);
	    return registration;
	}
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName(environment.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
		dataSource.setUrl(environment.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
		dataSource.setUsername(environment.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
		dataSource.setPassword(environment.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));

		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		entityManagerFactoryBean
				.setPackagesToScan(environment.getRequiredProperty(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN));

		entityManagerFactoryBean.setJpaProperties(hibProperties());

		return entityManagerFactoryBean;
	}
	

	private Properties hibProperties() {
		Properties properties = new Properties();
		properties.put(PROPERTY_NAME_HIBERNATE_DIALECT,
				environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
		properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL,
				environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
		return properties;
	}

	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}

/*	*//**
	 * Gets the view resolver.
	 * 
	 * @see MustacheViewResolver
	 * @return the view resolver
	 *//*
	@Bean
	public ViewResolver getViewResolver() {
		final MustacheViewResolver resolver = new MustacheViewResolver(new MustacheTemplateRenderer(resourceLoader));
		resolver.setPrefix("/WEB-INF/templates/");
		resolver.setSuffix(".ms");
		resolver.setOrder(1);
		return resolver;
	}*/
}

/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */

package com.yourdelicacy.restaurant;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.io.support.ResourcePropertySource;

/**
 * Configures the Spring profile from a property file.
 * 
 * @author klm22366
 *
 */
public class IciApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

	private static final Logger LOGGER = LoggerFactory.getLogger(IciApplicationContextInitializer.class);
	private static final Properties RUNTIME_PROPERTIES = new Properties();

	/**
	 * Injects custom properties into the application context.
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void initialize(ConfigurableApplicationContext applicationContext) {
		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		try {
			LOGGER.info("Initializing ApplicationContext with properties from {}", getPropertySource());
			environment.getPropertySources()
					.addLast(new PropertiesPropertySource("ici runtime properties", RUNTIME_PROPERTIES));
			environment.getPropertySources().addLast(new ResourcePropertySource(getPropertySource()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Sets a global runtime property.
	 * 
	 * @param key
	 *            property key
	 * @param value
	 *            property value
	 */
	public static void setRuntimeProperty(String key, String value) {
		RUNTIME_PROPERTIES.setProperty(key, value);
	}

	/**
	 * @return default property source
	 */
	public String getPropertySource() {
		return "classpath:application.properties";
	}

}

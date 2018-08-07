/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */

package com.yourdelicacy.restaurant;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.MustacheException;

/**
 * A factory for creating ResourceLoaderAwareMustache objects.
 * 
 * @author TCS (557957)
 * @version 1.0
 * @since 18 May, 2013
 */
public class ResourceLoaderAwareMustacheFactory extends DefaultMustacheFactory {

	private final ResourceLoader resourceLoader;

	/**
	 * Instantiates a new resource loader aware mustache factory.
	 * 
	 * @param resourceLoader
	 *            the resource loader
	 */
	public ResourceLoaderAwareMustacheFactory(ResourceLoader resourceLoader) {
		super();
		this.resourceLoader = resourceLoader;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Reader getReader(String resourceName) {
		final Resource resource = resourceLoader.getResource(resourceName);
		if (resource != null && resource.exists()) {
			return processResource(resource);
		}
		throw new MustacheException(String.format("Template %s does not exist.", resourceName));
	}

	/**
	 * Process the resource.
	 * 
	 * @param resource
	 *            the resource to be processed
	 * @return the InputStreamReader
	 */
	private Reader processResource(final Resource resource) {
		try {
			return new InputStreamReader(resource.getInputStream(), "UTF-8");
		} catch (IOException exception) {
			throw new MustacheException("failed to load template ".concat(resource.getFilename()), exception);
		}
	}

}

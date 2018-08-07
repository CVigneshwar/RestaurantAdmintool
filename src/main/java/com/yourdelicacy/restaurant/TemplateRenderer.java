/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package com.yourdelicacy.restaurant;

import java.io.Writer;
import java.util.Map;

/**
 * Defines the possible rendering method for mustache template.
 * 
 * @author TCS (557957)
 * @version 1.0
 * @since 20 May, 2013
 * @see MustacheTemplateRenderer
 */
public interface TemplateRenderer {

	/**
	 * Render the template & return string
	 * 
	 * @param templateLocation
	 *            the template location
	 * @param model
	 *            the model
	 * @return the string - the complete html
	 */
	public String render(String templateLocation, Map<String, Object> model);

	/**
	 * Render the template & write it by using the writer passed
	 * 
	 * @param templateLocation
	 *            the template location
	 * @param model
	 *            the model
	 * @param writer
	 *            the writer
	 */
	public void render(String templateLocation, Map<String, Object> model, Writer writer);

}

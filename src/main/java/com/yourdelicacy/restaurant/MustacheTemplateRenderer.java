
package com.yourdelicacy.restaurant;

import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

import org.springframework.core.io.ResourceLoader;

import com.github.mustachejava.MustacheFactory;

/**
 * Renders the Mustache template with model of type map
 * 
 * @author TCS (557957)
 * @version 1.0
 * @since 20 May, 2013
 */
public class MustacheTemplateRenderer implements TemplateRenderer {

	private final MustacheFactory mustacheFactory;

	/**
	 * * Instantiates a new mustache template renderer.
	 * 
	 * @param resourceLoader
	 *            the ResourceLoader
	 */
	public MustacheTemplateRenderer(ResourceLoader resourceLoader) {
		this.mustacheFactory = new ResourceLoaderAwareMustacheFactory(resourceLoader);
	}

	/**
	 * {@inheritDoc}
	 */
	public String render(String templateLocation, Map<String, Object> model) {
		final StringWriter buffer = new StringWriter();
		mustacheFactory.compile(templateLocation).execute(buffer, model);
		return buffer.toString();
	}

	/**
	 * {@inheritDoc}
	 */
	public void render(String templateLocation, Map<String, Object> model, Writer writer) {
		mustacheFactory.compile(templateLocation).execute(writer, model);
	}

}

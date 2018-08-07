/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package com.yourdelicacy.restaurant;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractTemplateView;

/**
 * The type of the view is Mustache template view.
 * 
 * @author TCS (557957)
 * @version 1.0
 * @since 20 May, 2013
 * @see AbstractTemplateView
 */
public class MustacheView extends AbstractTemplateView {

	private TemplateRenderer templateRenderer;

	/**
	 * Initializes defaults for HTML output.
	 */
	public MustacheView() {
		setContentType("text/html;charset=UTF-8");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void renderMergedTemplateModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		templateRenderer.render(getUrl(), model, response.getWriter());
	}

	/**
	 * Sets the renderer.
	 * 
	 * @param templateRenderer
	 *            the renderer type to set
	 */
	public void setRenderer(TemplateRenderer templateRenderer) {
		this.templateRenderer = templateRenderer;
	}

}

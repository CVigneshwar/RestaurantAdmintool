/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */

package com.yourdelicacy.restaurant;

import java.util.Locale;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.AbstractTemplateViewResolver;
import org.springframework.web.servlet.view.AbstractUrlBasedView;

/**
 * Resolves mustache template with spring UI
 * {@code {@link org.springframework.ui.Model}
 * 
 * @author TCS (557957)
 * @version 1.0
 * @since 18 May, 2013
 * @see AbstractTemplateViewResolver
 * @see org.springframework.web.servlet.view.UrlBasedViewResolver
 * @see org.springframework.web.servlet.view.AbstractCachingViewResolver
 */
public class MustacheViewResolver extends AbstractTemplateViewResolver {

	private final TemplateRenderer renderer;

	/**
	 * Instantiates a new mustache view resolver.
	 * 
	 * @param renderer
	 *            the renderer
	 */
	public MustacheViewResolver(TemplateRenderer renderer) {
		this.renderer = renderer;
		super.setViewClass(MustacheView.class);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected AbstractUrlBasedView buildView(String viewName) throws Exception {
		MustacheView mustacheView = (MustacheView) super.buildView(viewName);
		mustacheView.setRenderer(renderer);
		return mustacheView;
	}

	/**
	 * Creates a customized (server-relative) redirect view for "redirect:" view
	 * name.
	 * 
	 * {@inheritDoc}
	 */
	@Override
	protected View createView(String viewName, Locale locale) throws Exception {
		if (viewName.startsWith(REDIRECT_URL_PREFIX)) {
			String redirectUrl = viewName.substring(REDIRECT_URL_PREFIX.length());
			return new CustomRedirectView(redirectUrl);
		}
		return super.createView(viewName, locale);
	}

}
/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package com.yourdelicacy.restaurant;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.view.RedirectView;

/**
 * A custom redirect view that supports server-relative redirects and doesn't
 * include model values into the redirect URL.
 * 
 * @author klm22366
 * 
 */
public class CustomRedirectView extends RedirectView {

	/**
	 * Constructs a new instance.
	 * 
	 * @param redirectUrl
	 *            the target URL
	 */
	public CustomRedirectView(String redirectUrl) {
		super(redirectUrl, false, true);
		setStatusCode(HttpStatus.FOUND);
		setExposeModelAttributes(false);
		setExposePathVariables(false);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		final int idxColon = getUrl().indexOf(':');
		if (!getUrl().startsWith("/") && (idxColon < 0 || idxColon > 6)) {
			final String baseUri = request.getRequestURI();
			final int idx = baseUri.lastIndexOf('/');
			setUrl(baseUri.substring(0, idx + 1) + getUrl());
		}
		super.render(model, request, response);
	}

}

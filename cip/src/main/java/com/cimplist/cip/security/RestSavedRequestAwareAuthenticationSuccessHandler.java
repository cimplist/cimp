package com.cimplist.cip.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * By default, form login will answer a successful authentication request with a 301 or 302
 * status code; this makes sense in the context of an actual login form which needs to redirect after login. 
 * For a RESTful web service however, the desired response for a successful authentication should be 200 OK.
 * 
 * This is done by injecting a custom authentication success handler in the form login filter, 
 * to replace the default one. The new handler implements the exact same login as 
 * the default org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler 
 * with one notable difference ? the redirect logic is removed:
 * */
@Component
public class RestSavedRequestAwareAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    protected final Log logger = LogFactory.getLog(this.getClass());

    private RequestCache requestCache = new HttpSessionRequestCache();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws ServletException, IOException {
    	String contentType = request.getContentType();
    	logger.info(contentType);
        SavedRequest savedRequest = requestCache.getRequest(request, response);

        if (savedRequest == null) {
        	clearAuthenticationAttributes(request);
            return;
        }
        String targetUrlParameter = getTargetUrlParameter();
        if (isAlwaysUseDefaultTargetUrl() || (targetUrlParameter != null && StringUtils.hasText(request.getParameter(targetUrlParameter)))) {
            requestCache.removeRequest(request, response);
            clearAuthenticationAttributes(request);
            return;
        }

        clearAuthenticationAttributes(request);
    }

    public void setRequestCache(RequestCache requestCache) {
        this.requestCache = requestCache;
    }
}

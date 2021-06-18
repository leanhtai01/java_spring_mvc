// File: SalesManagementWebAppInitializer.java
// Configuring DispatcherServlet
// Author: 1760169 - Le Anh Tai
// Email: leanhtai01@gmail.com
// GitHub: https://github.com/leanhtai01
package com.team18.salesmanagement.config;

import org.springframework.web.servlet.support.
    AbstractAnnotationConfigDispatcherServletInitializer;

public class SalesManagementWebAppInitializer
    extends AbstractAnnotationConfigDispatcherServletInitializer {
    // map DispatcherServlet to /
    @Override
    protected String[] getServletMappings() {
	return new String[] { "/" };
    }

    // define beans for DispatcherServlet's application context
    @Override
    protected Class<?>[] getServletConfigClasses() {
	return new Class<?>[] { WebConfig.class };
    }

    // configure the application context created by ContextLoaderListener
    @Override
    protected Class<?>[] getRootConfigClasses() {
	return new Class<?>[] { RootConfig.class };
    }
} // end class SalesManagementWebAppInitializer

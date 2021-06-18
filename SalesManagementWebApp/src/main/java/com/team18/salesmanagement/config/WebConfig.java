// File: WebConfig.java
// Spring MVC configuration
// Author: 1760169 - Le Anh Tai
// Email: leanhtai01@gmail.com
// GitHub: https://github.com/leanhtai01
package com.team18.salesmanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation
    .DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc // enable Spring MVC
@ComponentScan("com.team18.salesmanagement.web")
public class WebConfig implements WebMvcConfigurer {
    // configure a JSP view resolver
    @Bean
    public ViewResolver viewResolver() {
	InternalResourceViewResolver resolver =
	    new InternalResourceViewResolver();

	resolver.setPrefix("/WEB-INF/views/");
	resolver.setSuffix(".jsp");
	resolver.setExposeContextBeansAsAttributes(true);

	return resolver;
    }

    // configure static content handling
    @Override
    public void configureDefaultServletHandling(
        DefaultServletHandlerConfigurer configurer) {
	configurer.enable();
    }
} // end class WebConfig

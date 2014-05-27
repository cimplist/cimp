package com.cimplist.cip.framework.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wordnik.swagger.model.ApiInfo;

@Configuration
public class CIPSwaggerConfig {
	/**
	   * API Info as it appears on the swagger-ui page
	   */
	@Bean
	  public ApiInfo apiInfo() {
	    ApiInfo apiInfo = new ApiInfo(
	        "Demo Spring MVC swagger 1.2 api",
	        "CIP spring mvc api based on the swagger 1.2 spec",
	        "http://en.wikipedia.org/wiki/Terms_of_service",
	        "sanjays30@yahoo.com",
	        "Apache 2.0",
	        "http://www.apache.org/licenses/LICENSE-2.0.html"
	    );
	    return apiInfo;
	  }
}

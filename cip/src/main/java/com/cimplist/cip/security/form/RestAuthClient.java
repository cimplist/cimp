package com.cimplist.cip.security.form;

import java.util.LinkedList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class RestAuthClient {
	String baseUrl = "http://localhost:8888/yakshop";
	public String authenticateGetCookie(String user, String password){
		HttpMessageConverter<MultiValueMap<String, ?>> formHttpMessageConverter = new FormHttpMessageConverter();
		
		HttpMessageConverter<String> stringHttpMessageConverternew = new StringHttpMessageConverter();
		
		List<HttpMessageConverter<?>> messageConverters = new LinkedList<HttpMessageConverter<?>>();
		
		messageConverters.add(formHttpMessageConverter);
		messageConverters.add(stringHttpMessageConverternew);
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("j_username", user);
		map.add("j_password", password);
		
		String authURL = baseUrl+"/j_spring_security_check";
		RestTemplate restTemplate = new RestTemplate();
		
		restTemplate.setMessageConverters(messageConverters);

		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(map,
				requestHeaders);
		
		ResponseEntity<String> result = restTemplate.exchange(authURL, HttpMethod.POST, entity, String.class);
		HttpHeaders respHeaders = result.getHeaders();		
		System.out.println(respHeaders.toString());
		
		System.out.println(result.getStatusCode());
		
		String cookies = respHeaders.getFirst("Set-Cookie");
		return cookies;
	}
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
}

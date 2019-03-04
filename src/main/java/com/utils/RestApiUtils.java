package com.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.utils.Utils.LOG_MESSAGE;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RestApiUtils {

	final RestTemplate restTemplate = new RestTemplate(); 
	
	public <T> T doGet(String url, Class<T> clazz) {
			return restTemplate.getForObject(url, clazz);
	}
	
	public <T> String doPost(String url, T param) {
			return restTemplate.postForObject(url, param, String.class);
	}
}
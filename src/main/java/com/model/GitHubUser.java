package com.model;

import org.springframework.stereotype.Component;

import lombok.Data;


@Component
@Data
public class GitHubUser {

	private String login;
	
	private int id;
	
}

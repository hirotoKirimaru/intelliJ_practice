package com.form;

import org.springframework.stereotype.Component;

import lombok.Data;


@Component
@Data
public class UserForm {

	private int userId;
	
	private int name;
	
	private int sex;
	
	private int version;
	
}

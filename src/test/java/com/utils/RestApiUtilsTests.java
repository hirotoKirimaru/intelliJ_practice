package com.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.model.GitHubUser;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestApiUtilsTests {

	@Autowired
	RestApiUtils testClass;
	
	/**
	 * doGet
	 * GitHubApi v3へのアクセス
	 */
	@Test
	public void doGet_1() {
		String param1 = "https://api.github.com/users/hirotoKirimaru";
		GitHubUser actual = testClass.doGet(param1, GitHubUser.class);
		
		assertEquals(actual.getLogin() , "hirotoKirimaru");
		assertEquals(actual.getId() ,  30658134);
	}
}

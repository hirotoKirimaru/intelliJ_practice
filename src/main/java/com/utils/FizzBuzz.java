package com.utils;

import org.springframework.stereotype.Component;

@Component
public class FizzBuzz {

	
	/**
	 * FizzBuzzを実装するメソッド　
	 * 
	 * @param 数値
	 * @return FizzBuzz
	 */
	public String fizzBuzz(int num) {		
		StringBuilder sb = new StringBuilder();
		
		if (num % 3 == 0) {
			sb.append("Fizz");
		}
		
		if (num % 5 == 0) {
			sb.append("Buzz");
		}
		
		if (sb.length() == 0) {
			sb.append(num);
		}
		
		return sb.toString();
	}
	
}

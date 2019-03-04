package com.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FizzBuzzTests {

	@Autowired
	FizzBuzz testClass;
	
	static String FIZZ = "Fizz";
	static String BUZZ= "Buzz";
	static String FIZZBUZZ = "FizzBuzz";
	
	public  static enum FizzBuzzTestParam{
		PARAM_1(1,"1"),
		PARAM_2(2, "2"),
		PARAM_3(3, FIZZ),
		PARAM_4(4, "4"),
		PARAM_5(5, BUZZ),
		PARAM_6(6, FIZZ),
		PARAM_7(7, "7"),
		PARAM_8(8, "8"),
		PARAM_9(9, FIZZ),
		PARAM_10(10, BUZZ),
		PARAM_11(11, "11"),
		PARAM_12(12, FIZZ),
		PARAM_13(13, "13"),
		PARAM_14(14, "14"),
		PARAM_15(15, FIZZBUZZ),
		PARAM_16(16, "16"),
		PARAM_17(17, "17"),
		PARAM_18(18, FIZZ),
		PARAM_19(19, "19"),
		PARAM_20(20, BUZZ),
		PARAM_21(21, FIZZ),
		PARAM_22(22, "22"),
		PARAM_23(23, "23"),
		PARAM_24(24, FIZZ),
		PARAM_25(25, BUZZ),
		PARAM_26(26, "26"),
		PARAM_27(27, FIZZ),
		PARAM_28(28, "28"),
		PARAM_29(29, "29"),
		PARAM_30(30, FIZZBUZZ),
		PARAM_31(31, "31"),
		;
		private int param;
		private String expect;
		
	   FizzBuzzTestParam(int param, String expect) {
			this.param = param;
			this.expect = expect;
		}
		
		  public int getParam(){
			    return this.param;
			  }
		  
		  public String getExpect(){
			    return this.expect;
			  }
	}
	
	@Test
	public void fizzBuzzTest_1() {
		
		String actual;
		for (FizzBuzzTestParam param : FizzBuzzTestParam.values()) {
			actual = testClass.fizzBuzz(param.getParam());
			assertEquals(param.getExpect(), actual);
		}
	}
}

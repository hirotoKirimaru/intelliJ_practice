package com.utils;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class Utils {

	public enum LOG_MESSAGE {
		LOG_START(" 開始 "),
		LOG_END(" 終了 ");

	  private String message;

	  LOG_MESSAGE(String message){
	    this.message = message;
	  }
	  public String getMessage(){
	    return this.message;
	  }
	}
	
	public int maxInt(List<Integer> a) {
		Optional<Integer> b = a.stream().max(Comparator.naturalOrder());
		if (b.isPresent()) {
			return b.get();
		} else {
			return 0;
		}
	}
	
	/**
	  * リストの中からパラメータbに最も近く、かつ大きい値を取得する。
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public int nearIntToMax(List<Integer> a, int b) {		
		Optional<Integer> c = a.stream().filter(x -> x >= b).min(Comparator.naturalOrder());
		if (c.isPresent()) {
			return c.get();
		} else {
			return 0;
		}
	}
	
	public static String getClassName() {
		return Thread.currentThread().getStackTrace()[2].getClassName();
	}
	
	public static String getMethodName() {
		return Thread.currentThread().getStackTrace()[2].getMethodName();
	}
	
}

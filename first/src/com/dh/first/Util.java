package com.dh.first;

public class Util {
	public static int parseStringToInt(String str) {
		int result = 0;
		try {
			result = Integer.parseInt(str);
		} catch(Exception e) {}
		return result;
	}
}

package com.kwon1.sb;

public class Utils {

	public static int parseStringToInt(String v) {
		int result = 0;
		try {
			return Integer.parseInt(v);
		} catch (Exception e) {
			result =  0;
		}
		return result;
	}
}
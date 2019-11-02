package com.kwon1.sb;

public class Utils {

	public static int parseStringToInt(String v) {
		try {
			return Integer.parseInt(v);
		} catch (Exception e) {
			return 0;
		}
	}
}
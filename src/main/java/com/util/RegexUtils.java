package com.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {

	public static boolean matches(String INPUT, String REGEX) {
		Pattern pattern = Pattern.compile(REGEX);
		Matcher matcher = pattern.matcher(INPUT);
		return matcher.matches();
	}

	public static List<String> getContentByPattern(String INPUT, String REGEX) {
		List<String> resultList = new ArrayList<>();
		Pattern p = Pattern.compile(REGEX);

		if (INPUT == null) {
			System.out.println("INPUT不能为NULL！");
			return resultList;
		}

		if (p == null) {
			System.out.println("构造Pattern时发生错误！");
			return resultList;
		}
		Matcher m = p.matcher(INPUT);
		while (m.find()) {
			resultList.add(m.group());
		}
		return resultList;
	}

	public static String getFirstMatch(String INPUT, String REGEX) {
		List<String> ss = getContentByPattern(INPUT, REGEX);
		if (ss.size() > 0) {
			return ss.get(0);
		} else {
			return null;
		}

	}

	public static String replaceContentByPattern(String INPUT, String REGEX, String REPLACE) {
		Pattern p = Pattern.compile(REGEX);
		Matcher m = p.matcher(INPUT);
		return m.replaceAll(REPLACE);
	}

	public static String findFirstNumber(String INPUT) {
		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(INPUT);
		if (m.find()) {
			return m.group();
		} else {
			return null;
		}
	}

	public static void main(String[] args) {
		System.out.println(matches("2016", "\\d{4}"));
		System.out.println(matches("2016-03-15 20:50:00", "^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}$"));
	}
}

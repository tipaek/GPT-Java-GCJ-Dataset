//package com.codejam.year2020.round_1C;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	private static final boolean DEBUG = false;

	public static void main(String[] args) throws FileNotFoundException {
		long beginTime = System.nanoTime();
		InputStream is = DEBUG ? new FileInputStream(
				"C:\\Users\\Gowtham\\Desktop\\sample.in.txt")
				: System.in;
		try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
			int testCount = scanner.nextInt();
			// System.out.println("testCount :: " + testCount);
			for (int testNumber = 1; testNumber <= testCount; testNumber++) {
				Number n1 = new Number("1");
				Number n2 = new Number("2");
				Number n3 = new Number("3");
				Number n4 = new Number("4");
				Number n5 = new Number("5");
				Number n6 = new Number("6");
				Number n7 = new Number("7");
				Number n8 = new Number("8");
				Number n9 = new Number("9");
				Number n0 = new Number("0");
				
				int u = scanner.nextInt();
				for (long i = 0; i < 9999; i++) {
					//System.out.println("i :: " + i);
					String q = scanner.next();
					String r = scanner.next();
					if("-1".equals(q)) {
						continue;
					}
					if(q.length() == r.length()) {
					//if(true) {
						for (int j = 0; j < r.length(); j++) {
							char qi = q.charAt(j);
							char ri = r.charAt(j);
							switch (qi) {
							case '0':
								n0.update(ri);
								break;
							case '1':
								n1.update(ri);
								break;
							case '2':
								n2.update(ri);
								break;
							case '3':
								n3.update(ri);
								break;
							case '4':
								n4.update(ri);
								break;
							case '5':
								n5.update(ri);
								break;
							case '6':
								n6.update(ri);
								break;
							case '7':
								n7.update(ri);
								break;
							case '8':
								n8.update(ri);
								break;
							case '9':
								n9.update(ri);
							default:
								break;
							}
						}
					}
				}
				
				String resStr = "" + n0.maxChar() + n1.maxChar() + n2.maxChar() + n3.maxChar() + n4.maxChar() +
						n5.maxChar() + n6.maxChar() + n7.maxChar() + n8.maxChar() + n9.maxChar();
				
				System.out.println("Case #" + testNumber + ": " + resStr );
			}
		}
		System.err.println("Done in " + ((System.nanoTime() - beginTime) / 1e9) + " seconds.");
	}

}

class Number {
	
	private String name;
	private Map<String,Long> num = new HashMap<String,Long>(); 
	
	Number(String name){
		this.name = name;
	}
	
	public void update(char c) {
		if(num.containsKey("" + c)) {
			num.put("" + c, 1 + num.get("" + c));
		} else {
			num.put("" + c, (long) 1);
		}
		//System.out.println(name + " " + num.toString());
	}

	public String maxChar() {
		System.out.println(name + " " + num.toString());
		Long max = (long) 0;
		String res = "-";
		Set<String> keys = num.keySet();
		for (String key : keys) {
			if(num.get(key) > max) {
				max  = num.get(key); 
				res = key;
			}
		}
		return res;
	}
}

/**
 * 
 */
//package com.sanjay.google.code.jam.qual.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author s0t01cz
 *
 */
//4
//0000
//101
//111000
//1
//
//  
//Case #1: 0000
//Case #2: (1)0(1)
//Case #3: (111)000
//Case #4: (1)
class Solution {

	// 4
	// 0000
	// 101
	// 111000
	// 1
	//
	//
	// Case #1: 0000
	// Case #2: (1)0(1)
	// Case #3: (111)000
	// Case #4: (1)
	public static void main(String[] args) {

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Integer T = Integer.parseInt(br.readLine());

			int count = 0;
			while (T > 0) {
				String number = br.readLine();
				// Integer number = Integer.parseInt(NStr);

				String bracketResult = findBrackets(number);
				count++;
				System.out.println("Case #" + count + ": " + bracketResult);
				T--;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static String findBrackets(String number) {
		Queue<String> queue = new ArrayDeque<String>();
		// StringBuilder result = new StringBuilder();
		if (number == null) {
			return null;
		}
		int prev = 0;
		int openBrackets = 0;
		for (int i = 0; i < number.length(); i++) {
			int ch = Integer.parseInt(number.charAt(i)+"");
//			int prev = (int) number.charAt(i + 1);
			int diff = ch - prev;
			if (i == 0) {
				for (int j = 0; j < ch; j++) {
					queue.add("(");
				}
				openBrackets = ch;
				queue.add(String.valueOf(ch));
			} else if (diff == 0) {
				queue.add(String.valueOf(ch));
			} else if (diff < 0) {
				for (int j = 0; j < Math.abs(diff); j++) {
					queue.add(")");
				}
				queue.add(String.valueOf(ch));
				openBrackets = openBrackets - Math.abs(diff);

			} else if (diff > 0) {
				for (int j = 0; j < diff; j++) {
					queue.add("(");
				}
				queue.add(String.valueOf(ch));
				openBrackets = ch;
			}
			prev = (int) ch;
		}
		if (openBrackets != 0) {
			for (int i = 0; i < openBrackets; i++) {
				queue.add(")");
			}
		}

		String result = convertQueueToString(queue);

		return result;
	}

	private static String convertQueueToString(Queue<String> queue) {
		StringBuilder result = new StringBuilder();
		for (String ch : queue) {
			result.append(ch);
		}
		return result.toString();
	}

}

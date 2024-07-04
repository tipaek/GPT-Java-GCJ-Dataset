/**
 * 
 */
//package com.sanjay.google.code.jam.round1a.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
/**
 * @author s0t01cz
 *
 */
public class Solution {

	/**
	 * @param args
	 */
//	 4
//	  H*O
//	  HELLO*
//	  *HELLO
//	  HE*

	private static final String IMPOSSIBLE = "*";

	public static void main(String[] args) {

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Integer T = Integer.parseInt(br.readLine());

			int count = 0;
			while (T > 0) {
				String No = br.readLine();
				String str = "";
				int N = Integer.parseInt(No);
				String[] arr = new String[N];
				for (int i = 0; i < N; i++) {
					str = br.readLine();
					arr[i] = str;
				}

				String result = formStringandValidate(arr, N);
				count++;
				System.out.println("Case #" + count + ": " + result);

				T--;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static String formStringandValidate(String[] patternArr, int n) {
		if (patternArr == null || patternArr.length == 0) {
			return null;
		}
		String str = formString(patternArr, n);
		//System.out.println("str " + str);
		boolean flag = false;
		for (String pattern : patternArr) {
			flag = strmatch(str, pattern, str.length(), pattern.length());
			//flag = matchRegex(str.toCharArray(), pattern.toCharArray());
			//System.out.println(pattern);
			//pattern = pattern.replace(IMPOSSIBLE, "\\*");
//			Pattern patternM = Pattern.compile(pattern);
//			Matcher m = patternM.matcher(str); 
//			if(m.find())
//			{
//				flag = true;
//			}
			//flag = Pattern.matches(pattern, str);
			//System.out.println("flag " + flag);
			if (!flag) {
				return IMPOSSIBLE;
			}
		}
		return str;
	}

	private static String formString(String[] patternArr, int n) {
		String result = null;
		String prefix = findLongestLength(patternArr, n);
		result = prefix;
		for (String pattern : patternArr) {
			if (!prefix.equalsIgnoreCase(pattern)) {
				result = compareTwoStrings(prefix, pattern);
			}
		}
		result = result.replace(IMPOSSIBLE, "");
		return result;
	}

	private static String compareTwoStrings(String prefix, String pattern) {
		// String result = prefix;
		for (int i = 0; i < pattern.length(); i++) {
			char ch = pattern.charAt(i);
			if (Character.isAlphabetic(ch)) {
				if (prefix.indexOf(ch) == -1) {
					int index = prefix.indexOf(IMPOSSIBLE);
					prefix = prefix.substring(0, index) + ch + prefix.substring(index);
				}
			}
		}
		return prefix;
	}

	private static String findLongestLength(String[] patternArr, int n) {
		int max = patternArr[0].length();
		String result = patternArr[0];
		for (int i = 1; i < patternArr.length; i++) {
			if (patternArr[i].length() > max) {
				max = patternArr[i].length();
				result = patternArr[i];
			}
		}
		return result;
	}

	

	static boolean strmatch(String str, String pattern, int n, int m) {
		if (m == 0)
			return (n == 0);

		boolean[][] dp = new boolean[n + 1][m + 1];

		for (int i = 0; i < n + 1; i++)
			Arrays.fill(dp[i], false);

		dp[0][0] = true;

		for (int j = 1; j <= m; j++)
			if (pattern.charAt(j - 1) == '*')
				dp[0][j] = dp[0][j - 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (pattern.charAt(j - 1) == '*')
					dp[i][j] = dp[i][j - 1] || dp[i - 1][j];

				else if (pattern.charAt(j - 1) == '?' || str.charAt(i - 1) == pattern.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1];

				else
					dp[i][j] = false;
			}
		}

		return dp[n][m];
	}

}

// package codejam.Y2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
	private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(in.readLine());
		for (int x = 1; x <= t; x++) {
			System.out.println("Case #" + x + ": ");
			solve();
		}
	}

	public static void solve() throws IOException {
		int n = Integer.parseInt(in.readLine());
		StringBuilder builder = new StringBuilder(in.readLine());
		boolean flag = true;
		for (int i = 1; i < n; i++) {
			String pattern = in.readLine();
			int startK = builder.indexOf("*");

			int j, k;
			for (j = 0, k = 0; j < pattern.indexOf('*') && k < startK; j++, k++) {
				if (pattern.charAt(j) != builder.charAt(k)) {
					flag = false;
					break;
				}
			}
			if (!flag) break;
			int start = j;

			for (j = pattern.length() - 1, k = builder.length() - 1;
				 j > pattern.lastIndexOf('*') && k > builder.lastIndexOf("*");
				 j--, k--) {
				if (pattern.charAt(j) != builder.charAt(k)) {
					flag = false;
					break;
				}
			}
			if (!flag) break;
			int end = j;

			builder.replace(startK, startK + 1, pattern.substring(start, end + 1));
		}
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < builder.length(); i++) {
			if (builder.charAt(i) != '*') result.append(builder.charAt(i));
		}
		System.out.println(flag ? (result.length() > 0 ? result.toString() : "A") : "*");
	}
}

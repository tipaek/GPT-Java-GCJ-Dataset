// package codejam.Y2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
	private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(in.readLine());
		for (int x = 1; x <= t; x++) {
			System.out.print("Case #" + x + ": ");
			solve();
		}
	}

	public static void solve() throws IOException {
		int u = Integer.parseInt(in.readLine());
		String[] s;
		Pair[] pairs = new Pair[10000];
		for (int i = 0; i < 10000; i++) {
			s = in.readLine().split(" ");
			pairs[i] = new Pair(Long.parseLong(s[0]), s[1]);
		}
		Arrays.sort(pairs, Comparator.comparingLong(a -> a.m));

		StringBuilder result = new StringBuilder();
		int i;
		for (i = 0; i < 10000 && result.length() < 10; i++) {
			for (int j = 0; j < pairs[i].result.length(); j++) {
				char ch = pairs[i].result.charAt(j);
				if (result.toString().indexOf(ch) == -1) {
					if (result.length() == 9) {
						result.insert(0, ch);
					} else {
						result.append(ch);
					}
				}
			}
		}

		System.out.println(result);
	}

	static class Pair {
		long m;
		String result;

		Pair(long m, String s) {
			this.m = m;
			result = s;
		}
	}
}
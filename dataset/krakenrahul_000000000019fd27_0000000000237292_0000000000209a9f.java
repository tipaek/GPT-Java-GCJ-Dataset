/*
 *created by Kraken on 29-03-2020 at 14:17
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		int tt = sc.nextInt();
		for (int t = 1; t <= tt; t++) {
			String in = sc.next();
			StringBuilder res = new StringBuilder();
			int[] x = new int[in.length()];
			for (int i = 0; i < in.length(); i++) x[i] = in.charAt(i) - '0';
			int nd = 0;
			for (int i : x) {
				if (i > nd) {
					add(res, '(', i - nd);
					res.append(i);
					nd = i;
				} else {
					add(res, ')', nd - i);
					res.append(i);
					nd = i;
				}
			}
			add(res, ')', nd);
			System.out.printf("Case #%d: %s\n", t, res.toString());
		}
	}

	private static void add(StringBuilder res, char c, int cnt) {
		for (int i = 0; i < cnt; i++) {
			res.append(c);
		}
	}

	static class FastReader {

		BufferedReader br;

		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}

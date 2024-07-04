

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String args[]) throws Exception {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));

		int t = sc.nextInt();
		for(int k = 1; k <= t; k++) {
			String s = sc.nextLine();
			String res = "";
			int first = s.charAt(0) - '0';
			while (first > 0) {
				res += "(";
				first--;
			}
			first = s.charAt(0) - '0';
			res += s.charAt(0);
			if(s.length() == 1) {
				while(first > 0) {
					res += ")";
					first--;
				}
				System.out.println("Case #" + k + ": " + res);
				continue;
			}
			first = s.charAt(0) - '0';
			int prev = first;
			int cur = 0, diff = 0;
			for (int i = 1; i < s.length(); i++) {
				cur = s.charAt(i) - '0';
				diff = prev - cur;
				if (diff > 0) {
					while (diff > 0) {
						res += ")";
						diff--;
					}

				} else {
					diff *= -1;
					while (diff > 0) {
						res += "(";
						diff--;
					}

				}
				res += s.charAt(i);
				prev = cur;
			}
			while(cur > 0) {
				res += ")";
				cur--;
			}
			System.out.println("Case #" + k + ": " + res);
		}

	}

	public static PrintWriter out;

	public static class MyScanner {
		BufferedReader br;
		StringTokenizer st;

		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
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
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}

	}

}

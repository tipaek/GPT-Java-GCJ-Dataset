import java.io.*;
import java.util.*;

public class Solution {
	static class word implements Comparable<word> {
		String s;
		int l;

		public word(String S, int L) {
			s = S;
			l = L;
		}

		public int compareTo(word o) {
			return this.l - o.l;
		}
	}

	public static void main(String[] args) {
		FastReader sc = new FastReader();
		Solution sup = new Solution();
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			word[] s = new word[n];
			for (int i = 0; i < n; i++) {
				String s1 = sc.next();
				s[i] = new word(s1, s1.length());
			}
			Arrays.sort(s);
			boolean flag = true;
			String s4 = s[n - 1].s;
			if (s4.substring(0, 1).equals("*")) {
				s4 = s4.substring(1);
			}
			p: for (int i = 0; i < n - 1; i++) {
				String s2 = s[i].s;
				String s3 = s[i + 1].s;
				if (s2.substring(0, 1).equals("*")) {
					s2 = s2.substring(1);
				}
				if (s3.substring(0, 1).equals("*")) {
					s3 = s3.substring(1);
				}
				if (!s3.substring(s3.length() - s2.length()).equals(s2)) {
					flag = false;
					break p;
				}
			}
			if (flag) {
				System.out.println("Case #" + t + ": " + s4);
			} else {
				System.out.println("Case #" + t + ": *");
			}
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

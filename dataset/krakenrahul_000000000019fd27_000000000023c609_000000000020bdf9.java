/*
 *created by Kraken on 29-03-2020 at 14:17
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
	static class Pair {
		int x, y, idx;
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getIdx() {
			return idx;
		}

		public void setIdx(int idx) {
			this.idx = idx;
		}

		@Override
		public String toString() {
			return "[" + x + ", " + y + "]";
		}
	}

	public static void main(String[] args) {
		FastReader sc = new FastReader();
		int tt = sc.nextInt();
		for (int t = 1; t <= tt; t++) {
			int n = sc.nextInt();
			Pair[] p = new Pair[n];
			for (int i = 0; i < n; i++) {
				p[i] = new Pair(sc.nextInt(), sc.nextInt());
				p[i].setIdx(i);
			}
			Arrays.sort(p, (o1, o2) -> {
				if (o1.x == o2.x) return o1.y - o2.y;
				else return o1.x - o2.x;
			});
//			System.out.println(Arrays.toString(p));
			boolean fine = true;
			char[] res = new char[n];
			int c = 0, j = 0;
			for (Pair i : p) {
				if (c <= i.x) {
					res[i.getIdx()] = 'C';
					c = i.y;
				} else if (j <= i.x) {
					res[i.getIdx()] = 'J';
					j = i.y;
				} else {
					fine = false;
					break;
				}
			}
			if (fine) {
				StringBuilder sb = new StringBuilder();
				for (char i : res) sb.append(i);
				System.out.println(sb.toString());
			} else {
				System.out.println("IMPOSSIBLE");
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

import java.util.*;
import java.io.*;

public class Solution {
	public void run() throws Exception {
		FastReader file = new FastReader();
		int times = file.nextInt();
		for (int asdf = 0; asdf < times; asdf++) {
			String s = file.next();
			String res = "";
			int curMax = 0;
			for (int i = 0; i < s.length(); i++) {
				int parse = Integer.parseInt("" + s.charAt(i));
				if (parse > curMax) {
					int temp = parse - curMax;
					for (int j = 0; j < temp; j++) res += "(";
					res += "" + parse;
					curMax = parse;
				}
				else if (parse < curMax) {
					int temp = curMax - parse;
					for (int j = 0; j < temp; j++) res += ")";
					res += "" + parse;
					curMax = parse;
				}
				else {
					res += "" + parse;
				}
			}
			for (int i = 0; i < Integer.parseInt("" + s.charAt(s.length() - 1)); i++) res += ")";
			System.out.println(res);
		}
	}

	public static void main(String[] args) throws Exception {
		new Solution().run();
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

import java.util.*;
import java.io.*;

public class Solution {
	public void run() throws Exception {
		FastReader file = new FastReader();
		int times = file.nextInt();
		for (int asdf = 0; asdf < times; asdf++) {
			int cur = file.nextInt();
			System.out.println("Case #" + (asdf + 1) + ":");
			if (cur <= 500) {
				for (int i = 1; i <= cur; i++) {
					System.out.println(i + " " + 1);
				}
			} else {
				System.out.println("1 1\n2 1\n3 2");
				for (int i = 3; i < 500; i++)
					System.out.println(i + " " + 1);
			}
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

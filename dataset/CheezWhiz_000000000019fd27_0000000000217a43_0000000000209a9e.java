import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		FastReader sc = new FastReader();

		int T = sc.nextInt();
		int b = sc.nextInt();
		for (int t = 0; t < T; t++) {	
			System.out.println(1);
			System.out.flush();
			sc.next();
			String s = "";
			for (int i = 1; i <= b; i++) {
				System.out.println(i);
				System.out.flush();
				s += sc.next();
			}
			System.out.println(s);
			if(sc.next().equals("N")) {
				return;
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

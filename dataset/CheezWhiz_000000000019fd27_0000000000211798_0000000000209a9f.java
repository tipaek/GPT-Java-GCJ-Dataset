import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		FastReader sc = new FastReader();
		
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			String s = sc.next();
			System.out.print("Case #"+t+": ");
			for(int i=0; i<s.length(); i++) {
				for(int j=0; j<s.charAt(i)-'0'; j++) {
					System.out.print("(");
				}System.out.print(s.charAt(i));
				for(int j=0; j<s.charAt(i)-'0'; j++) {
					System.out.print(")");
				}
			}System.out.println();
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



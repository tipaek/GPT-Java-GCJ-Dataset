import java.util.*;
import java.io.*;
import java.text.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int t = sc.nextInt();
		int tc = 1;
		while (t-- > 0) {
			int r = sc.nextInt();
			int s = sc.nextInt();
			pw.printf("Case #%d: ", tc++);
			if (r == 2) {
				pw.println(s - 1);
				for (int i = 0; i < s - 1; i++) {
					pw.println(((s - 1) * 2 - i) + " " + 1);
				}
			} else if (r == 3) {
				if (s == 2) {
					pw.println(2);
					pw.println(3 + " " + 2);
					pw.println(2 + " " + 1);
				} else if (s == 3) {
					pw.println(4);
					pw.println(6 + " " + 2);
					pw.println(5 + " " + 2);
					pw.println(4 + " " + 1);
					pw.println(3 + " " + 1);
				} else {
					pw.println(6);
					pw.println(9 + " " + 2);
					pw.println(8 + " " + 2);
					pw.println(7 + " " + 2);
					pw.println(6 + " " + 1);
					pw.println(5 + " " + 1);
					pw.println(4 + " " + 1);
				}
			} else if (r == 4) {
				if (s == 2) {
					pw.println(3);
					pw.println(4 + " " + 3);
					pw.println(3 + " " + 2);
					pw.println(2 + " " + 1);
				} else {
					pw.println(6);
					pw.println(8 + " " + 3);
					pw.println(7 + " " + 3);
					pw.println(6 + " " + 2);
					pw.println(5 + " " + 2);
					pw.println(4 + " " + 1);
					pw.println(3 + " " + 1);
				}
			} else {
				pw.println(4);
				pw.println(5 + " " + 4);
				pw.println(4 + " " + 3);
				pw.println(3 + " " + 2);
				pw.println(2 + " " + 1);
			}

		}
		pw.close();
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public Scanner(FileReader r) {
			br = new BufferedReader(r);
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		public int[] nextIntArr(int n) throws IOException {
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++)
				arr[i] = nextInt();
			return arr;
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}
}

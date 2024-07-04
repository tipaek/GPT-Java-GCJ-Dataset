import java.util.*;
import java.io.*;

public class Solution {
	static int memo[][];
	static int n, v, m, e, t;
	static ArrayList[] edgeList;
	static int[][] matrix;
	static int[] a;
	final static int Infinity = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);

		t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			pw.print("Case #" + (i + 1) + ": ");
			String s = sc.next();
			int pre = 0;
			for (int j = 0; j < s.length(); j++) {
				int x = Integer.parseInt("" + s.charAt(j));
				while ((pre - x) > 0)
				{
					pre--;
					pw.print(')');
				}
				while(pre<x) {
					pw.print("(");
					pre++;
				}
				pw.print(x);
			}
			while(pre-->0)
				pw.print(")");
			pw.println();
		}

		pw.flush();
		pw.close();
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream system) {
			br = new BufferedReader(new InputStreamReader(system));
		}

		public Scanner(String file) throws Exception {
			br = new BufferedReader(new FileReader(file));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		public char nextChar() throws IOException {
			return next().charAt(0);
		}

		public Long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

		public void waitForInput() throws InterruptedException {
			Thread.sleep(3000);
		}
	}
}
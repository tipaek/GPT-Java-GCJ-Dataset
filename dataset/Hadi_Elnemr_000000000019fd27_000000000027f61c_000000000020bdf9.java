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
		int start[], end[];
		t: for (int i = 0; i < t; i++) {
			pw.print("Case #" + (i + 1) + ": ");
			n = sc.nextInt();
			ArrayList<Act> arr = new ArrayList<Act>();
			for (int j = 0; j < n; j++)
				arr.add(new Act(sc.nextInt(), sc.nextInt(), j));

			arr.sort(null);
			boolean c = false;
			boolean j = false;
			Act cam = null;
			Act jam = null;
			char[] out = new char[n];

			for (int k = 0; k < arr.size(); k++) {
				Act cur = arr.get(k);
				if (c && cam != null && cam.end <= cur.start) {
					c = false;
					cam = null;
				}
				if (j && jam != null && jam.end <= cur.start) {
					j = false;
					jam = null;
				}

				if (!c) {
					c = true;
					cam = cur;
					out[cur.idx] = 'C';
				} else if (!j) {
					j = true;
					jam = cur;
					out[cur.idx] = 'J';
				} else {
					pw.println("IMPOSSIBLE");
					continue t;
				}
			}
			for (char x : out)
				pw.print(x);
			pw.println();
		}
		pw.flush();
		pw.close();
	}

	static class Act implements Comparable<Act> {
		int idx;
		int start;
		int end;

		public Act(int start, int end, int idx) {
			this.idx = idx;
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Act o) {
			if (start > o.start)
				return 1;
			if (start < o.start)
				return -1;
			if (end > o.end)
				return 1;
			if (end < o.end)
				return -1;
			return 0;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return start + " " + end;
		}
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
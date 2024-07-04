import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) {
		new Solution().run();
	}

	BufferedReader br;
	StringTokenizer st;
	PrintWriter out;
	boolean eof = false;

	void run() {
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}

	String nextToken() {
		while (st == null || !st.hasMoreTokens()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (Exception e) {
				eof = true;
				return "0";
			}
		}
		return st.nextToken();
	}

	int nextInt() {
		return Integer.parseInt(nextToken());
	}

	long nextLong() {
		return Long.parseLong(nextToken());
	}

	double nextDouble() {
		return Double.parseDouble(nextToken());
	}

	class Job implements Comparable<Job> {
		int start, end, id;
		char c;

		public Job(int nextInt, int nextInt2, int i) {
			start = nextInt;
			end = nextInt2;
			id = i;
		}

		@Override
		public int compareTo(Job j) {
			return start < j.start ? -1 : 1;
		}
	}

	private void solve() {
		int testn = nextInt();
		tests: for (int test = 1; test <= testn; test++) {
			out.print("Case #" + test + ": ");
			int n = nextInt();
			Job[] a = new Job[n];
			for (int i = 0; i < a.length; i++) {
				a[i] = new Job(nextInt(), nextInt(), i);
			}
			Arrays.sort(a);
			int c = 0;
			int j = 0;
			for (int i = 0; i < a.length; i++) {
				if (c <= a[i].start) {
					a[i].c = 'C';
					c = a[i].end;
				} else if (j <= a[i].start) {
					a[i].c = 'J';
					j = a[i].end;
				} else {
					out.println("IMPOSSIBLE");
					continue tests;
				}
			}
			char[] s = new char[a.length];
			for (int i = 0; i < s.length; i++) {
				s[a[i].id] = a[i].c;
			}
			for (int i = 0; i < s.length; i++) {
				out.print(s[i]);
			}
			out.println();
		}
	}
}

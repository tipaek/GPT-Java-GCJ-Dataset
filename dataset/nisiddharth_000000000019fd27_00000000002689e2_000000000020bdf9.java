import java.io.*;
import java.util.*;

class Solution {
	static void solve() throws IOException {
		int n = nextInt(), c = 0, j = 0;
		char ans[] = new char[n];
		Pair a[] = new Pair[n];
		for(int i = 0; i < n; i++) {
			a[i] = new Pair(nextInt(), nextInt(), i);
		}
		Arrays.sort(a);
		for(int i = 0; i < n; i++) {
			if(c <= a[i].first) {
				ans[a[i].index] = 'C';
				c = a[i].second;
			} else if(j <= a[i].first) {
				ans[a[i].index] = 'J';
				j = a[i].second;
			} else {
				out.println("IMPOSSIBLE");
				return;
			}
		}
		out.println(new String(ans));
	}

	static class Pair implements Comparable<Pair> {
		int first, second, index;

		Pair(int a, int b, int i) {
			first = a;
			second = b;
			index = i;
		}

		public int compareTo(Pair p) {
			return this.second - p.second;
		}
	}

	public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int tt = nextInt();
		for(int test = 1; test <= tt; ++test) {
			out.print("Case #" + test + ": ");
			solve();
		}
		out.close();
	}

	static BufferedReader br;
	static StringTokenizer st;
	static PrintWriter out;

	static String next() {
		while (st == null || !st.hasMoreElements()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return st.nextToken();
	}

	static int nextInt() {
		return Integer.parseInt(next());
	}
}

import java.io.*;
import java.util.*;

public class Solution {
	static void solve() throws IOException {
		char s[] = nextLine().toCharArray();
		int n = s.length, within = 0, val, temp;
		String ans = "";
		for(int i = 0; i < n; i++) {
			val = s[i] - 48;
			temp = within - val;
			if(temp == 0) {
				ans = ans + s[i];
			} else if(temp > 0) {
				for(int j = 0; j < temp; j++) {
					ans = ans + ")";
				}
				ans = ans + s[i];
				within = val;
			} else {
				temp = Math.abs(temp);
				for(int j = 0; j < temp; j++) {
					ans = ans + "(";
				}
				ans = ans + s[i];
				within = val;
			}
		}
		for(int j = 0; j < within; j++) {
			ans = ans + ")";
		}
		out.println(ans);
	}

	public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// sieve();
		int tt = nextInt();
		// int tt = 1;
		for(int test = 1; test <= tt; ++test) {
			out.print("Case #" + test + ": ");
			solve();
		}
		out.close();
	}

	static class Pair implements Comparable<Pair> {
		int first, second;

		Pair(int a, int b) {
			first = a;
			second = b;
		}

		public int compareTo(Pair p) {
			return this.first - p.first;
		}
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

	static String nextLine() {
		String str = "";
		try {
			str = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}
}
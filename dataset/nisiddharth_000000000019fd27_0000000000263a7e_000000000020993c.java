import java.io.*;
import java.util.*;

class Solution {
	static void solve() throws IOException {
		int n = nextInt();
		int num, trace = 0, ar = 0, ac = 0;
		HashSet<Integer> row[] = new HashSet[n];
		HashSet<Integer> col[] = new HashSet[n];
		for(int i = 0; i < n; i++) {
			row[i] = new HashSet<>();
			col[i] = new HashSet<>();
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				num = nextInt();
				row[i].add(num);
				col[j].add(num);
				if(i == j) {
					trace += num;
				}
			}
		}
		for(int i = 0; i < n; i++) {
			if(row[i].size() != n) {
				ar++;
			}
			if(col[i].size() != n) {
				ac++;
			}
		}
		out.println(trace + " " + ar + " " + ac);
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static FastReader s;
	static PrintWriter out;

	static void solve() {
		int t = s.nextInt();
		int a = 1;
		while (t-- > 0) {
			int n = s.nextInt();
			int[][] arr = new int[n][2];
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < n; i++) {
				arr[i][0] = s.nextInt();
				arr[i][1] = s.nextInt();
			}
			Arrays.sort(arr, (o1, o2) -> Integer.compare(o1[1], o2[1]));
			int ctime = 0, jtime = 0;
			boolean flag = false;
			for (int[] it : arr) {
				if (ctime <= it[0]) {
					sb.append("C");
					ctime = it[1];
				} else if (jtime <= it[0]) {
					sb.append("J");
					jtime = it[1];
				} else {
					flag = true;
					break;
				}
			}
			if (flag)
				sb = new StringBuilder("IMPOSSIBLE");
			System.out.println("Case #" + a + ": " + sb.toString());
			a++;
		}
	}

	public static void main(String[] args) {
		out = new PrintWriter(System.out);
		s = new FastReader();
		solve();
		out.flush();
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
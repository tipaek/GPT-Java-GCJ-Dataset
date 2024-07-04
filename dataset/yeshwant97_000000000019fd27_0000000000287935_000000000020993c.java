import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {
	static FastReader s;
	static PrintWriter out;

	static void solve() {
		int t = s.nextInt();
		int a = 1;
		while (t-- > 0) {
			int n = s.nextInt();
			int[][] arr = new int[n][n];
			int row = 0, col = 0, sum = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = s.nextInt();
					if (i == j)
						sum += arr[i][j];
				}
			}
			for (int i = 0; i < n; i++) {
				HashMap<Integer, Integer> map = new HashMap<>(), map1 = new HashMap<>();
				for (int j = 0; j < n; j++) {
					if (map.containsKey(arr[i][j])) {
						row++;
						break;
					} else
						map.put(arr[i][j], 1);
				}
				for (int j = 0; j < n; j++) {
					if (map1.containsKey(arr[j][i])) {
						col++;
						break;
					} else
						map1.put(arr[j][i], 1);
				}
			}
			System.out.println("Case #" + a + ": " + sum + " " + row + " " + col);
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

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

class Solution {

	public static void solve() {
		int t = s.nextInt();
		for(int z = 1; z <= t; z++) {
			int n = s.nextInt();
			int[][] arr = new int[n][n];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					arr[i][j] = s.nextInt();
				}
			}
			int cr = 0,  cc = 0, trace = 0;
			for(int i = 0; i < n; i++) {
				HashSet<Integer> helper = new HashSet<Integer>();
				for(int j = 0; j <  n; j++) {
					helper.add(arr[i][j]);
					if(i == j) {
						trace += arr[i][j];
					}
				}
				if(helper.size()!=n) {
					cr++;
				}
			}
			for(int i = 0; i < n; i++) {
				HashSet<Integer> helper = new HashSet<Integer>();
				for(int j = 0; j < n; j++) {
					helper.add(arr[j][i]);
				}
				if(helper.size() != n) {
					cc++;
				}
			}
			out.println("Case #"+z+": "+trace+" "+cr+" "+cc);
		}
	}

	public static void main(String[] args) {
		out = new PrintWriter(new BufferedOutputStream(System.out));
		s = new FastReader();
		solve();
		out.close();
	}

	public static FastReader s;
	public static PrintWriter out;

	public static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return str;
		}
	}

	
}

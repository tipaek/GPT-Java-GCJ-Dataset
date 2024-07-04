
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Solution {

	public static void solve() {
		int t = s.nextInt();
		for(int z = 1; z <= t; z++) {
			String str = s.next();
			int n = str.length();
			StringBuilder ans = new StringBuilder();
			int prev = 0;
			for(int i = 0; i < n; i++) {
				char cc = str.charAt(i);
				int count = 1;
				int j = i + 1;
				while(j < n && str.charAt(j) == cc) {
					j++;
					count++;
				}
				i = j - 1;
				int curr = cc - '0';
				if(curr > prev) {
					int diff = curr - prev;
					for(int k = 0; k < diff; k++) {
						ans.append('(');
					}
				}else if(curr < prev) {
					int diff = prev - curr;
					for(int k = 0; k < diff; k++) {
						ans.append(')');
					}
				}
				for(int k = 0; k < count; k++) {
					ans.append(cc);
				}
				prev = curr;
			}
			for(int i = 0; i < prev; i++) {
				ans.append(')');
			}
			out.println("Case #"+z+": "+ans);
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

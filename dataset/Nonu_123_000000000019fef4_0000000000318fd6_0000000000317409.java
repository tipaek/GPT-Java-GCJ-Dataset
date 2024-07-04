import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Solution {

	public static void solve(int t) {
		String imp = "IMPOSSIBLE";
		int x = s.nextInt();
		int y = s.nextInt();
		String str = s.next();
		int min = Integer.MAX_VALUE;
		for(int i = 0; i <= str.length(); i++) {
			int dis = Math.abs(x) + Math.abs(y);
			if(dis <= i) {
				min = i;
				break;
			}
			if(i != str.length()) {
				char cc = str.charAt(i);
				if(cc == 'N') {
					y++;
				}else if(cc == 'S') {
					y--;
				}else if(cc == 'E'){
					x++;
				}else {
					x--;
				}
			}
		}
		if(min == Integer.MAX_VALUE) {
			out.println("Case #"+t+": "+imp);
		}else {
			out.println("Case #"+t+": "+min);
		}
	}

	public static void main(String[] args) {
		out = new PrintWriter(new BufferedOutputStream(System.out));
		s = new FastReader();
		int t = s.nextInt();
		for(int i = 1; i <= t; i++) {
			solve(i);
		}
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

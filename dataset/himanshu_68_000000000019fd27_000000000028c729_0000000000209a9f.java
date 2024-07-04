
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;

class Solution {
	public static void solve() {
		int t = s.nextInt();
		int count = 1;

		while (t-- > 0) {
			String str = s.next();
			Stack<Integer> stack = new Stack<>();
			int val=0;
			StringBuilder res = new StringBuilder();
			for (int i = 0; i <str.length(); i++) {
				val = str.charAt(i) - '0';
				if (stack.isEmpty()) {
					for (int j = 0; j < val; j++) {
						res.append('(');
					}
					res.append(val);
				} else {
					int temp = val - stack.pop();
					if (temp > 0) {
						for (int j = 0; j < temp; j++) {
							res.append('(');
						}
						res.append(val);
					} else if (temp < 0) {
						for (int j = 0; j < Math.abs(temp); j++) {
							res.append(')');
						}
						res.append(val);
					} else {
						res.append(val);
					}
				}
				stack.push(val);
			}
			int ans=stack.pop();
			for(int j=0;j<ans;j++) {
				res.append(')');
			}
			
			System.out.println("Case #" + count + ": "+ res);
			count++;
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

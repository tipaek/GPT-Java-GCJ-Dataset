import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

	public static void solve(int t) {
		long x = s.nextLong();
		long y = s.nextLong();
		if(Math.abs(x%2) == Math.abs(y%2)) {
			out.println("Case #"+t+": IMPOSSIBLE");
			return;
		}
		if(Math.abs(x) < Math.abs(y)) {
			long posx = Math.abs(x);
			long posy = Math.abs(y);
			long ans = -1;
			int[] dir_x = new int[36];
			for(long max_bits = 0; max_bits < 35; max_bits++) {
				long curr_y = 0;
				for(long j = max_bits; j >= 0; j--) {
					if((posx&(1L<<j)) == 0) {
						if(curr_y > posy) {
							curr_y -= (1L<<j);
						}else {
							curr_y += (1L<<j);
						}
					}
				}
				if(curr_y == posy) {
					ans = max_bits;
					break;
				}
			}
			if(ans == -1) {
				out.println("Case #"+t+": IMPOSSIBLE");
				return;
			}
			int[] dir_y = new int[(int)ans+1];
			long curr_y = 0;
			for(long j = ans; j >= 0; j--) {
				if((posx&(1L<<j)) == 0) {
					if(curr_y > posy) {
						curr_y -= (1L<<j);
						dir_y[(int)j] = -1;
					}else {
						curr_y += (1L<<j);
						dir_y[(int)j] = +1;
					}
				}else {
					dir_x[(int)j] = +1;
				}
			}
			int sign_x = x > 0 ? 1 : -1;
			int sign_y = y > 0 ? 1 : -1;
			StringBuilder finalAns = new StringBuilder();
			for(int i = 0; i <= ans; i++) {
				if(dir_x[i] != 0) {
					int new_sign = sign_x * dir_x[i];
					if(new_sign == -1) finalAns.append('W');
					else finalAns.append('E');
				}else if(dir_y[i] != 0) {
					int new_sign = sign_y * dir_y[i];
					if(new_sign == -1) finalAns.append('S');
					else finalAns.append('N');
				}else {
					out.println("Case #"+t+": IMPOSSIBLE");
					return;
				}
			}
			out.println("Case #"+t+": "+finalAns);
 		}else {
 			long temp = y;
 			y = x;
 			x = temp;
 			long posx = Math.abs(x);
			long posy = Math.abs(y);
			long ans = -1;
			int[] dir_x = new int[36];
			for(long max_bits = 0; max_bits < 35; max_bits++) {
				long curr_y = 0;
				for(long j = max_bits; j >= 0; j--) {
					if((posx&(1L<<j)) == 0) {
						if(curr_y > posy) {
							curr_y -= (1L<<j);
						}else {
							curr_y += (1L<<j);
						}
					}
				}
				if(curr_y == posy) {
					ans = max_bits;
					break;
				}
			}
			if(ans == -1) {
				out.println("Case #"+t+": IMPOSSIBLE");
				return;
			}
			int[] dir_y = new int[(int)ans+1];
			long curr_y = 0;
			for(long j = ans; j >= 0; j--) {
				if((posx&(1L<<j)) == 0) {
					if(curr_y > posy) {
						curr_y -= (1L<<j);
						dir_y[(int)j] = -1;
					}else {
						curr_y += (1L<<j);
						dir_y[(int)j] = +1;
					}
				}else {
					dir_x[(int)j] = +1;
				}
			}
			int sign_x = x > 0 ? 1 : -1;
			int sign_y = y > 0 ? 1 : -1;
			StringBuilder finalAns = new StringBuilder();
			for(int i = 0; i <= ans; i++) {
				if(dir_x[i] != 0) {
					int new_sign = sign_x * dir_x[i];
					if(new_sign == -1) finalAns.append('S');
					else finalAns.append('N');
				}else if(dir_y[i] != 0) {
					int new_sign = sign_y * dir_y[i];
					if(new_sign == -1) finalAns.append('W');
					else finalAns.append('E');
				}else {
					out.println("Case #"+t+": IMPOSSIBLE");
					return;
				}
			}
			out.println("Case #"+t+": "+finalAns);
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

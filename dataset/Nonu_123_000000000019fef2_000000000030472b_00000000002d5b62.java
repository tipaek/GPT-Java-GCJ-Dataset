import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

	public static void solve(int t) {
//		long m = s.nextLong();
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
						}else if(curr_y < posy){
							curr_y += (1L<<j);
						}else {
							break;
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
					}else if(curr_y < posy){
						curr_y += (1L<<j);
						dir_y[(int)j] = +1;
					}else {
						continue;
					}
				}else {
					dir_x[(int)j] = +1;
				}
			}
			int sign_x = x > 0 ? 1 : -1;
			int sign_y = y > 0 ? 1 : -1;
			char[] temp_ans = new char[(int)ans+1];
			for(int i = 0; i <= ans; i++) {
				if(dir_x[i] != 0) {
					int new_sign = sign_x * dir_x[i];
					if(new_sign == -1) temp_ans[i] = 'W';
					else temp_ans[i] = 'E';
				}else if(dir_y[i] != 0) {
					int new_sign = sign_y * dir_y[i];
					if(new_sign == -1) temp_ans[i] = 'S';
					else temp_ans[i] = ('N');
				}else {
					if(i == 1) {
						char cc = temp_ans[0];
						char pc = temp_ans[0];
						if(cc == 'N') {
							cc = 'S';
						}else if(cc == 'S') {
							cc = 'N';
						}else if(cc == 'E') {
							cc = 'W';
						}else {
							cc = 'E';
						}
						temp_ans[0] = cc;
						temp_ans[1] = cc;
						int j = i + 1;
						while(j <= ans && dir_x[j] == 0 && dir_y[j] == 0) {
//							j++;
							temp_ans[j] = cc;
							j++;
						}
						i = j - 1;
						temp_ans[i] = pc;
					}else {
						out.println("Case #"+t+": IMPOSSIBLE");
						return;
					}
				}
			}
			out.print("Case #"+t+": ");
			for(int i = 0; i <= ans; i++) {
				out.print(temp_ans[i]);
			}
			out.println();
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
						}else if(curr_y < posy){
							curr_y += (1L<<j);
						}else {
							break;
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
					}else if(curr_y < posy){
						curr_y += (1L<<j);
						dir_y[(int)j] = +1;
					}else {
						continue;
					}
				}else {
					dir_x[(int)j] = +1;
				}
			}
			int sign_x = x > 0 ? 1 : -1;
			int sign_y = y > 0 ? 1 : -1;
			char[] temp_ans = new char[(int)ans+1];
 			for(int i = 0; i <= ans; i++) {
				if(dir_x[i] != 0) {
					int new_sign = sign_x * dir_x[i];
					if(new_sign == -1) temp_ans[i] = ('S');
					else temp_ans[i] = ('N');
				}else if(dir_y[i] != 0) {
					int new_sign = sign_y * dir_y[i];
					if(new_sign == -1) temp_ans[i] = ('W');
					else temp_ans[i] = ('E');
				}else {
					if(i == 1) {
						char cc = temp_ans[0];
						char pc = temp_ans[0];
						if(cc == 'N') {
							cc = 'S';
						}else if(cc == 'S') {
							cc = 'N';
						}else if(cc == 'E') {
							cc = 'W';
						}else {
							cc = 'E';
						}
						temp_ans[0] = cc;
						temp_ans[1] = cc;
						int j = i + 1;
						while(j <= ans && dir_x[j] == 0 && dir_y[j] == 0) {
//							j++;
							temp_ans[j] = cc;
							j++;
						}
						i = j - 1;
						temp_ans[i] = pc;
					}else {
						out.println("Case #"+t+": IMPOSSIBLE");
						return;
					}
				}
			}
			out.print("Case #"+t+": ");
			for(int i = 0; i <= ans; i++) {
				out.print(temp_ans[i]);
			}
			out.println();
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

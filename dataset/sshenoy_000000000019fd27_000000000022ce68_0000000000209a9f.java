import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		FastScanner in = new FastScanner(System.in);
		int T = in.nextInt();
		
		for(int aa = 1; aa <= T; aa++) {
			

			String s = in.next();
			System.out.print("Case #"+aa+": ");
			
			int N = s.length();
			
			int num [] = new int [N];			
			int dif [] = new int [N+1];
			
			for(int i = 0; i < N; i++) {
				num[i] = s.charAt(i) - '0';
			}
			
			dif[0] = num[0];
			
			for(int i = 1; i < N; i++) {
				dif[i] = num[i]-num[i-1];
			}
			dif[N] = -num[N-1];
			
			for(int i = 0; i < N; i++) {
				int mag = dif[i];
				boolean par = false;
				if(dif[i] < 0) {
					par = true;
					mag = -dif[i];
				}
				for(int j = 0; j < mag; j++) {
					if(par) {
						System.out.print(")");
					}else {
						System.out.print("(");
					}
				}
				System.out.print(num[i]);
			}
			
			for(int i = 0; i < -dif[N]; i++) {
				System.out.print(")");
			}
			System.out.println();
			
			
		}

	}
	
	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		public FastScanner(InputStream stream) {
			br = new BufferedReader(new InputStreamReader(stream));
			st = new StringTokenizer("");
		}

		public FastScanner(String fileName) throws Exception {
			br = new BufferedReader(new FileReader(new File(fileName)));
			st = new StringTokenizer("");
		}

		public String next() throws Exception {
			while (!st.hasMoreTokens()) {
				st = new StringTokenizer(br.readLine());
			}
			return st.nextToken();
		}

		public int nextInt() throws Exception {
			return Integer.parseInt(next());
		}

		public long nextLong() throws Exception {
			return Long.parseLong(next());
		}

		public Double nextDouble() throws Exception {
			return Double.parseDouble(next());
		}

		public String nextLine() throws Exception {
			if (st.hasMoreTokens()) {
				StringBuilder str = new StringBuilder();
				boolean first = true;
				while (st.hasMoreTokens()) {
					if (first) {
						first = false;
					} else {
						str.append(" ");
					}
					str.append(st.nextToken());
				}
				return str.toString();
			} else {
				return br.readLine();
			}
		}
	}


}

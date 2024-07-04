package codejam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class vestigium {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		FastScanner in = new FastScanner(System.in);
		
		int T = in.nextInt();
		
		for(int aa = 1; aa <= T; aa++) {
			int N = in.nextInt();
			
			int mat [][] = new int [N][N];
			
			int trace = 0;
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					mat[i][j] = in.nextInt();
					if(i == j) {
						trace+=mat[i][j];
					}
				}
			}
			
			// count row recounts
			int row = 0;
			
			for(int i = 0; i < N; i++) {
				int count [] = new int [N];
				for(int j = 0; j < N; j++) {
					count[mat[i][j]-1]++;
				}

				for(int j = 0; j < N; j++) {
					if(count[j] > 1) {
						row++;
						break;
					}
				}
			}
			
			int col = 0;
			
			for(int j = 0; j < N; j++) {
				int count [] = new int [N];
				
				for(int i = 0; i < N; i++) {
					count[mat[i][j]-1]++;
				}
				
				for(int i = 0; i < N; i++) {
					if(count[i] > 1) {
						col++;
						break;
					}
				}
			}
			
			System.out.println("Case #"+aa+": "+trace+" "+row+" "+col);
			
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

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
			int N = in.nextInt();
			
			int time [][] = new int [2*N][3];
			
			for(int i = 0; i < N; i++) {
				time[2*i][0] = 2;
				time[2*i][2] = in.nextInt();
				time[2*i][1] = i;
				
				time[2*i+1][0] = 1;
				time[2*i+1][2] = in.nextInt();
				time[2*i+1][1] = i;
			}
			
			
			java.util.Arrays.sort(time, new java.util.Comparator<int[]>() {
				public int compare(int[] a, int[] b) {
					if(a[2] == b[2]) {
						return Integer.compare(a[0], b[0]);
					}else {
						return Integer.compare(a[2], b[2]);
					}
				}
			});
			
			// sorted by endpoint
			int who [] = new int [N];
			
			boolean doable = true;
			
			boolean c = true;
			boolean j = true;
			for(int i = 0; i < 2*N; i++) {
				if(time[i][0] == 2) {
					if(c == true) {
						who[time[i][1]] = 1;  // 1 = cameron
						c = false;            // cameron is now busy
					}else if(j == true) {
						who[time[i][1]] = 2;  // 2 = jamie
						j = false;            // jamie is now busy
					}else {
						doable = false;
						break;
					}
				}else {
					int pos = time[i][1];
					if(who[pos] == 1) {
						c = true;             // cameron is now free
					}else {
						j = true;             // jamie is now free
					}
				}
			}
			
			System.out.print("Case #"+aa+": ");
			
			if(doable) {
				for(int i = 0; i < N; i++) {
					if(who[i] == 1) {
						System.out.print("C");
					}else {
						System.out.print("J");
					}
				}
				System.out.println();
			}else {
				System.out.println("IMPOSSIBLE");
			}
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
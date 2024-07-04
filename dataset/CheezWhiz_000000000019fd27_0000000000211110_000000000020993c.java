import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		FastReader sc = new FastReader();
		
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int n = sc.nextInt();
			int arr[][] = new int[n][n];
			int count = 0;
			int r = 0;
			int c = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					arr[i][j] = sc.nextInt();
					if(i==j) {
						count+=arr[i][j];
					}
				}
			}
			for(int i=0; i<n; i++) {
				Set<Integer> rr = new HashSet<Integer>();
				Set<Integer> cc = new HashSet<Integer>(); 
				for(int j=0; j<n; j++) {
					rr.add(arr[i][j]);
					cc.add(arr[j][i]);
				}
				if(rr.size()!=n) {
					r++;
				}if(cc.size()!=n) {
					c++;
				}
			}
			
			System.out.println("Case #1: "+count+" "+r+" "+c);
			
		}
		
		
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



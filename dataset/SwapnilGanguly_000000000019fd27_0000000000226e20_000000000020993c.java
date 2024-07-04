

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution{
	
	public static void main(String args[]) throws Exception {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		
		int t = sc.nextInt();
		for(int k = 1; k <= t; k++) {
			
			int n = sc.nextInt();
			int ar[][] = new int[n][n];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++)
					ar[i][j] = sc.nextInt();
			}
			long trace = 0;
			for(int i = 0; i < n; i++) {
				trace += ar[i][i];
			}
			int rowrep = 0, columnrep = 0;
			for(int i = 0; i < n; i++) {
				HashSet<Integer> rows = new HashSet<>();
				HashSet<Integer> columns = new HashSet<>();
				boolean a = true, b = true;
				for(int j = 0; j < n; j++) {
					if(rows.contains(ar[i][j]) == true)
						a = false;
					if(columns.contains(ar[j][i]) == true)
						b = false;
					
					rows.add(ar[i][j]);
					columns.add(ar[j][i]);
				}
				if(a == false)
					rowrep++;
				if(b == false)
					columnrep++;
			}
			System.out.println("Case #" + k + ": " + trace + " " + rowrep + " " + columnrep);
		}
	}
	
	public static PrintWriter out;

	public static class MyScanner {
		BufferedReader br;
		StringTokenizer st;

		public MyScanner() {
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

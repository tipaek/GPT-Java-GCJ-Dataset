

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String args[]) throws Exception {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		
		int t = sc.nextInt();
		for(int k = 1; k <= t; k++) {
			int n = sc.nextInt();
			int a[] = new int[n];
			int b[] = new int[n];
			
			for(int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
				b[i] = sc.nextInt();
			}
			
			for(int i = 0; i < a.length; i++) {
				for(int j = 0; j < a.length - 1 - i; j++) {
					if(a[j] > a[j + 1]) {
						int temp = a[j];
						a[j] = a[j + 1];
						a[j + 1] = temp;
						temp = b[j];
						b[j] = b[j + 1];
						b[j + 1] = temp;
					}
				}
			}
			
			if(n == 2) {
				System.out.println("Case #" + k + ": " + "JC");
				continue;
			}
			int jstart = a[0], cstart = a[1], jend = b[0], cend = b[1];
			String res = ""; boolean flag = true;
			res += "JC";
			for(int i = 2; i < n; i++) {
				int start = a[i];
				int end = b[i];
				
				if(start >= jend) {
					res += "J";
					jend = end;
				}
				else if(start >= cend) {
					
					res += "C";
					cend = end;
				}
				else {
					flag = false;
					break;
				}
			}
			System.out.print("Case #" + k + ": ");
			System.out.println((flag == true) ? res : "IMPOSSIBLE");
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

import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		FastReader scan = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		Task solver = new Task();
		int t = scan.nextInt();
		//int t = 1;
		for(int i = 1; i <= t; i++) solver.solve(i, scan, out);
		out.close();
	}

	static class Task {

		public void solve(int testNumber, FastReader sc, PrintWriter pw) {
			int n = sc.nextInt();
			int[][] mat= new int[n][n];
			int x = 0;
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					mat[i][j]=sc.nextInt();
					if(i==j)x+=mat[i][j];
				}
			}
			int r = 0;
			for(int i=0;i<n;i++){
				int[] freq = new int[n+1];
				for(int j=0;j<n;j++){
					if(freq[mat[i][j]]>0){
						r++;
						break;
					}
					freq[mat[i][j]]++;
				}
			}
			int c = 0;
			for(int i=0;i<n;i++){
				int[] freq = new int[n+1];
				for(int j=0;j<n;j++){
					if(freq[mat[j][i]]>0){
						c++;
						break;
					}
					freq[mat[j][i]]++;
				}
			}
			pw.printf("Case #%d: %d %d %d%n",testNumber,x,r,c);
		}
	}

	static void shuffle(int[] a) {
		Random get = new Random();
		for (int i = 0; i < a.length; i++) {
			int r = get.nextInt(a.length);
			int temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}

	static void shuffle(long[] a) {
		Random get = new Random();
		for (int i = 0; i < a.length; i++) {
			int r = get.nextInt(a.length);
			long temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public FastReader(String s) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(new File(s)));
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
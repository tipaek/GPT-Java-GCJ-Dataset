import java.io.*;
import java.util.*;
public class Solution{
	public static void main(String[] args) throws IOException{
		FastScanner sc = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int cas = sc.nextInt();
		test:for(int t=1; t<=cas; t++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			String str = sc.nextToken();
			int n = str.length();
			int path[] = new int[n];
			for(int i=0; i<n; i++) {
				if(str.charAt(i)=='N')
					path[i] = 0;
				else if(str.charAt(i)=='E')
					path[i] = 1;
				else if(str.charAt(i)=='S')
					path[i] = 2;
				else if(str.charAt(i)=='W')
					path[i] = 3;
			}
			int best = Integer.MAX_VALUE;
			int cnt = 0;
			for(int i=0; i<n; i++) {
				//System.out.println(x + " " + y + " " + cnt);
				if(dist(x,y)<=cnt) best = Math.min(cnt, best);
				if(path[i]==0) {
					y++;
				}else if(path[i]==2) {
					y--;
				}else if(path[i]==1) {
					x++;
				}else if(path[i]==3) {
					x--;
				}
				cnt++;
			}
			if(dist(x,y)<=cnt) best = Math.min(cnt, best);
			if(best== Integer.MAX_VALUE) {
				System.out.println("Case #" + t + ": " + "IMPOSSIBLE");
			}else {
				System.out.println("Case #" + t + ": " + best);
			}
		}
		out.close();
  	}
	public static int dist(int x, int y) {
		return Math.abs(x)+Math.abs(y);
	}
	public static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		public FastScanner(String s) {
			try {
				br = new BufferedReader(new FileReader(s));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		public FastScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String nextToken() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
          return st.nextToken();
		}

		String nextLine() {
			st = null;
			try {
				return br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}

		int nextInt() {
			return Integer.parseInt(nextToken());
		}

		long nextLong() {
			return Long.parseLong(nextToken());
		}

		double nextDouble() {
			return Double.parseDouble(nextToken());
		}
	}
}
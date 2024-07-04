import java.io.*;
import java.util.*;
public class Solution{
	public static void main(String[] args) throws IOException{
		FastScanner sc = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int cas = sc.nextInt();
		for(int t=1; t<=cas; t++) {
			int r = sc.nextInt();
			int s = sc.nextInt();
			int y = (r*s-2)/2;
			
			out.println("Case #" + t + ": " + y);
			int numgood = 1;
			int num = r;
			for(int i=0; i<y; i++) {
				if(numgood==s) {
					numgood=1;
					num--;
				}
				out.println(((s-numgood)*num) + " " + (num-1));
				numgood++;
			}
		}
		out.close();
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
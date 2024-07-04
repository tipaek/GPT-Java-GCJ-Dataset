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
			int y = (r-1)*(s-1);
			
			out.println("Case #" + t + ": " + y);
			int mult = 1;
			int num = r;
			int idx = 1;
			for(int i=0; i<y; i++) {
				if(num<=1) {
					mult++;
					num = r;
					idx = 1;
				}
				int a,b;
				if(idx%2==1) {
					a= num*mult;
					b = num-1;
				}else {
					a = num;
					b = (num-1)*mult;
				}
				out.println(a + " " + b);
				num--;
				idx++;
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
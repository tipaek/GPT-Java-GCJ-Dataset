import java.io.*;
import java.util.*;
public class Solution{
	public static void main(String[] args) throws IOException{
		FastScanner sc = new FastScanner();
		int t = sc.nextInt();
		for(int i=1; i<=t; i++) {
			int n = sc.nextInt();
			if(n==1000) {
				System.out.println("Case #"+(i)+": ");
				int k=1;
				while(k<=498) {
					System.out.println(k + " " + k);
					if(k==4) {
						System.out.println(5 + " "  + 4);
					}
					if(k==498) {
						System.out.println(499 + " " + 498);
					}
					k++;
				}
			}else if(n>500) {
				int diff = n-500;
				System.out.println("Case #"+(i)+": ");
				int k=1;
				while(k<=499) {
					System.out.println(k + " " + k);
					if(k==diff) {
						System.out.println((k+1) + " " + k);
					}
					k++;
				}
				
			}else if(n>1000) {
				System.out.println("LMAO");
			}else {
				System.out.println("Case #"+(i)+": ");
				int k = 1;
				while(k<=n) {
					System.out.println(k + " " + k);
					k++;
				}
			}
		}
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
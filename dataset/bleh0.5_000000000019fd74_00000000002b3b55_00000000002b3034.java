import java.io.*;
import java.util.*;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		FastReader scan = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		//PrintWriter out = new PrintWriter("file.out");
		Task solver = new Task();
		int t = scan.nextInt();
		//int t = 1;
		for(int i = 1; i <= t; i++) solver.solve(i, scan, out);
		out.close();
	}

	static class Task {
		static final int inf = Integer.MAX_VALUE;
		public void solve(int testNumber, FastReader sc, PrintWriter pw) {
			//CHECK FOR QUICKSORT TLE
			//***********************//
			//CHECK FOR INT OVERFLOW
			//***********************//
			int n = sc.nextInt();
			StringBuilder start = new StringBuilder();
			StringBuilder mid = new StringBuilder();
			StringBuilder end = new StringBuilder();
			String ans = "";
			loop:
			for(int i=0;i<n;i++){
				StringBuilder start1 = new StringBuilder();
				StringBuilder end1 = new StringBuilder();
				String str = sc.nextLine();
				int pos = 0;
				for(int j=0;j<str.length();j++){
					if(str.charAt(j)=='*'){
						pos = 1;
					}
					else if(pos == 1) mid.append(str.charAt(j));
					else start1.append(str.charAt(j));
				}
				String comp1 = start1.toString();
				String comp2 = start.toString();
				for(int j=0;j<Math.min(comp1.length(),comp2.length());j++){
					if(comp1.charAt(j)!=comp2.charAt(j)){
						ans = "*";
						break loop;
					}
				}
				if(comp1.length()>comp2.length()){
					start=start1;
				}
				for(int j=str.length()-1;j>=0;j--){
					if(str.charAt(j)=='*'){
						break;
					}
					end1.append(str.charAt(j));
				}
				comp1 = end1.toString();
				comp2 = end.toString();
				for(int j=0;j<Math.min(comp1.length(),comp2.length());j++){
					if(comp1.charAt(j)!=comp2.charAt(j)){
						ans = "*";
						break loop;
					}
				}
				if(comp1.length()>comp2.length()){
					end=end1;
				}
			}
			if(ans.length()==0){
				ans=start.toString()+mid.toString()+end.reverse().toString();
			}
			//pw.println(start);
			//pw.println(mid);
			//pw.println(end.reverse());
			pw.printf("Case #%d: %s%n",testNumber,ans);
		}
	}
	static long binpow(long a, long b, long m) {
		a %= m;
		long res = 1;
		while (b > 0) {
			if ((b & 1) == 1)
				res = res * a % m;
			a = a * a % m;
			b >>= 1;
		}
		return res;
	}
	static void sort(int[] x){
		shuffle(x);
		Arrays.sort(x);
	}
	static void sort(long[] x){
		shuffle(x);
		Arrays.sort(x);
	}
	static class tup implements Comparable<tup>{
		int a, b;
		tup(int a,int b){
			this.a=a;
			this.b=b;
		}
		@Override
		public int compareTo(tup o){
			return Integer.compare(o.b,b);
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
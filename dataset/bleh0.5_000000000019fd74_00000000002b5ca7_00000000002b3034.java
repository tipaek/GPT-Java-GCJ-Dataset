import java.io.*;
import java.util.*;

public class Solution{
	
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
			for(int i=0;i<n;i++){
				String str = sc.next();
				int k = str.length();
				int l = 0;
				int r = k-1;
				StringBuilder o2 = new StringBuilder();
				for(;l<k;l++){
					if(str.charAt(l)=='*')break;
					o2.append(str.charAt(l));
				}
				for(int j=0;j<Math.min(o2.length(),start.length());j++){
					if(start.charAt(j)!=o2.charAt(j)){
						ans = "*";
					}
				}
				StringBuilder o3 = new StringBuilder();
				for(;r>=0;r--){
					if(str.charAt(r)=='*')break;
					o3.append(str.charAt(r));
				}
				for(int j=0;j<Math.min(o3.length(),end.length());j++){
					if(end.charAt(j)!=o3.charAt(j)){
						ans = "*";
					}
				}
				if(o2.length()>start.length())start=o2;
				if(o3.length()>end.length())end=o3;
				for(;l<r;l++){
					if(str.charAt(l)!='*')mid.append(str.charAt(l));
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
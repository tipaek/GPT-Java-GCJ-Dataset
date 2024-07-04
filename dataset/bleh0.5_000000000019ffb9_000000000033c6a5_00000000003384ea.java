
// Problem : Incremental House of Pancakes
// Contest : Google Coding Competitions - Round 2 2020 - Code Jam 2020
// URL : https://codingcompetitions.withgoogle.com/codejam/round/000000000019ffb9/00000000003384ea
// Memory Limit : 1024 MB
// Time Limit : 20000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

import java.io.*;
import java.util.*;

public class Solution implements Runnable{
	
    public static void main(String[] args) {
        new Thread(null, new Solution(), "process", 1<<26).start();
    }
	public void run() {
		FastReader scan = new FastReader();
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		//PrintWriter out = new PrintWriter("file.out");
		Task solver = new Task();
		int t = scan.nextInt();
		//	int t = 1;
		for(int i = 1; i <= t; i++) solver.solve(i, scan, out);
		out.close();
	}

	static class Task {
		static final int inf = Integer.MAX_VALUE;
		long sea = 0;
		long n, m;
		public void solve(int testNumber, FastReader sc, PrintWriter pw) {
			//CHECK FOR QUICKSORT TLE
			//***********************//
			//CHECK FOR INT OVERFLOW
			//***********************//
			n = sc.nextLong();
			m = sc.nextLong();
			long x = Math.abs(n - m);
			sea = x;
			x = search();
			int count = 0;
			if(n < m){ 
				m -= func(x);
			}
			else n -= func(x);
			if(n <= m){
				long move = search2(m, n, x);
				n -= func3((move + 1) / 2) - func3((x + 1) / 2);
				m -= func2(move / 2) - func2(x / 2);
				pw.printf("Case #%d: %d %d %d%n", testNumber, move, n, m);
			}
			else{
				long move = search2(n, m, x);
				m -= func3((move + 1) / 2) - func3((x + 1) / 2);
				n -= func2(move / 2) - func2(x / 2);
				pw.printf("Case #%d: %d %d %d%n", testNumber, move, n, m);
			}
		}
		public long search(){
			long lo = 0, hi = 1_000_000_003;
		    for(int i=0;i<64;i++) {
		        long mid = (lo+hi)/2;
		        if (func(mid) <= sea) {
		            lo = mid;
		        } else {
		            hi = mid - 1;
		        }
		    }
		        if (func(Long.max(lo, hi)) <= sea) {
		        	return Long.max(lo, hi);
		        } else {
		        	return Long.min(lo, hi);
		        }
		}
		public long search2(long n, long m, long off){ //n > m
			long lo = off, hi = 1_000_000_003;
		    for(int i=0;i<64;i++) {
		        long mid = (lo+hi)/2;
		        long odds = (mid + 1) / 2;
		        long odda = (off + 1) / 2;
		        long evens = mid / 2;
		        long evena = (off) / 2;
		        if (n - func3(odds) + func3(odda) >= 0 && m - func2(evens) + func2(evena) >= 0) {
		          	lo = mid;
		        } else {
		            hi = mid;
		        }
		    }
		    long mid = Math.max(lo, hi);
		    long odds = (mid + 1) / 2;
		    long odda = (off + 1) / 2;
		    long evens = mid / 2;
		    long evena = (off) / 2;
		    if (n - func3(odds) + func3(odda) >= 0 && m - func2(evens) + func2(evena) >= 0) {
		      	return mid;
		    } else {
		        return Math.min(lo, hi);
		    }
		    
		}
		long func(long a){
			return a * (a + 1) / 2;
		}
		long func2(long a){
			return a * (a + 1);
		}
		long func3(long a){
			return a * a;
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
			int r = get.nextInt(i + 1);
			int temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}

	static void shuffle(long[] a) {
		Random get = new Random();
		for (int i = 0; i < a.length; i++) {
			int r = get.nextInt(i + 1);
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
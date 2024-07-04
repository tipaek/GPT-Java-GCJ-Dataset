import java.io.*;
import java.util.*;

public class Solution {
	static void solve() throws IOException {
		long n = nextLong();
		if(n == 1l) {
			out.println("1 1");
		} else {
			long p = highestPowerof2(n);
			long sumHave = (long)Math.pow(2, p) - 1;
			long makeSum = n - sumHave;
			// long next = (long)Math.pow(2, p+1);
			// if(makeSum>next) {
			// 	makeSum-=next;
			// 	p++;
			// }
			long levels = p;
			// out.println(levels);
			for(long i=1;i<=levels;i++) {
				if(i%2==0) {
					for(long j=i;j>=1;j--) {
						out.println(i+" "+j);
					}
				} else {
					for(long j=1;j<=i;j++) {
						out.println(i+" "+j);
					}
				}
			}
			long sum=0;
			if(levels%2==0) {
				++levels;
				while(makeSum > sum) {
					out.println((levels+sum)+" "+1);
					++sum;
				}
			} else {
				++levels;
				while(makeSum > sum) {
					out.println((levels+sum)+" "+(levels+sum));
					++sum;
				}
			}
		}
	}

	static long highestPowerof2(long n) {

		long p = (long)(Math.log(n) /
		              Math.log(2));
		return p;
	}

	public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// sieve();
		int tt = nextInt();
		// int tt = 1;
		for(int test = 1; test <= tt; ++test) {
			out.println("Case #" + test + ": ");
			solve();
		}
		out.close();
	}

	static class Pair implements Comparable<Pair> {
		int first, second;

		Pair(int a, int b) {
			first = a;
			second = b;
		}

		public int compareTo(Pair p) {
			return this.first - p.first;
		}
	}

	static BufferedReader br;
	static StringTokenizer st;
	static PrintWriter out;

	static String next() {
		while (st == null || !st.hasMoreElements()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return st.nextToken();
	}

	static int nextInt() {
		return Integer.parseInt(next());
	}

	static String nextLine() {
		String str = "";
		try {
			str = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}

	static long nextLong() {
		return Long.parseLong(next());
	}

	static double nextDouble() {
		return Double.parseDouble(next());
	}
}
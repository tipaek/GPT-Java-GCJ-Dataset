import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Solution {
	static void solve() throws IOException {
		int n = nextInt();
		String ans = "", inp,prev;
		int maxlen=0;
		for(int i=1;i<=n;i++) {
			inp = nextLine();
			if(inp.length()>maxlen) {
				maxlen=inp.length();
				prev=ans;
				ans=inp.replaceAll("\\*","");
				if(!ans.contains(prev)) {
					out.println("*");
					for(i++;i<=n;i++)
						nextLine();
					return;
				}
			} else {
				if(!ans.contains(inp.replaceAll("\\*",""))) {
					out.println("*");
					for(i++;i<=n;i++)
						nextLine();
					return;
				}
			}
		}
		if(ans.equals(""))
			out.println("*");
		else
			out.println(ans);
	}

	public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// sieve();
		int tt = nextInt();
		// int tt = 1;
		for(int test = 1; test <= tt; ++test) {
			out.print("Case #" + test + ": ");
			solve();
		}
		out.close();
	}

	// static final int MAXN = 100001;
	// static int spf[] = new int[MAXN];

	// static void sieve() {
	// 	spf[1] = 1;
	// 	for (int i = 2; i < MAXN; i++)
	// 		spf[i] = i;
	// 	for (int i = 4; i < MAXN; i += 2)
	// 		spf[i] = 2;

	// 	for (int i = 3; i * i < MAXN; i++) {
	// 		if (spf[i] == i) {
	// 			for (int j = i * i; j < MAXN; j += i)
	// 				if (spf[j] == j)
	// 					spf[j] = i;
	// 		}
	// 	}
	// }

	static final long mod = (long) (1e9 + 7);
	static final int inf = (int) (1e9 + 1);

	static class Pair implements Comparable<Pair> {
		int first, second;

		Pair(int a, int b) {
			first = a;
			second = b;
		}

		public int compareTo(Pair p) {
			return this.first - p.first;
		}

		public boolean equals(Object p) {
			Pair p1 = (Pair) p;
			return (first == p1.first && second == p1.second);
		}

		public String toString() {
			return this.first + " " + this.second;
		}

		public int hashCode() {
			return (int) ((1l * (inf + 1) * this.first + this.second) % mod);
		}
	}

	public static int lowerBound(int[] array, int length, int value) {
		int low = 0;
		int high = length;
		while (low < high) {
			final int mid = (low + high) / 2;
			if (value <= array[mid]) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}

	public static int upperBound(int[] array, int length, int value) {
		int low = 0;
		int high = length;
		while (low < high) {
			final int mid = (low + high) / 2;
			if (value >= array[mid]) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
	}

	static int gcd(int a, int b) {
		if (a == 0)
			return b;
		return gcd(b % a, a);
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

	static long nextLong() {
		return Long.parseLong(next());
	}

	static double nextDouble() {
		return Double.parseDouble(next());
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

	static int[] nextIntArray(int n) {
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = nextInt();
		}
		return a;
	}

	static int[] memset(int n, int val) {
		int ar[] = new int[n];
		Arrays.fill(ar, val);
		return ar;
	}

	static void debug(Object... a) {
		System.out.print("> ");
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}

	static void debug(int a[]) {
		debugnsp(Arrays.stream(a).boxed().toArray());
	}

	static void debug(long a[]) {
		debugnsp(Arrays.stream(a).boxed().toArray());
	}

	static void debugnsp(Object a[]) {
		System.out.print("> ");
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}
}

/*
 * Jai Sita Ram Ji
 *
 * @author: Nishchal Siddharth Pandey
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

 class Solution {
	public static void main(String[] args) throws Exception {
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			System.out.print("Case #" + i + ": ");
			solve();
		}

	}

	// **SOLUTION**
	public static void solve() throws Exception {
		int n = sc.nextInt();

		Pair[] pairs = new Pair[n];
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			pairs[i] = new Pair(a, b, i);
		}

		outer: for (int sub = 0; sub < Math.pow(2, n); sub++) {
			String s = bin(sub, n);
			
			int[] C = new int[1500];//
			int[] J = new int[1500];//
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) - '0' == 0) {
					C[pairs[i].s]++;
					C[pairs[i].e]--;
				} else {
					J[pairs[i].s]++;
					J[pairs[i].e]--;
				}
			}
			if (sub==19) {
				int g = 0;
				g++;
			}
			int c = 0, j = 0;
			for (int i = 0; i < C.length; i++) {
				c += C[i];
				j += J[i];
				if (c == 2 || j == 2)
					continue outer;
			}
			for (int i = 0; i < s.length(); i++)
				System.out.print(s.charAt(i) - '0' == 0 ? "C" : "J");
			System.out.println();
			return;
		}

		System.out.println("IMPOSSIBLE");
	}

	public static String bin(int x, int l) {
		StringBuilder sb = new StringBuilder("");
		String s = Integer.toBinaryString(x);
		for (int i = 0; i < l - s.length(); i++)
			sb.append(0);
		sb.append(s);
		return sb.toString();
	}

	private static StringBuilder rec(int idx, Pair[] pairs, int C, int J) {
		if (idx >= pairs.length) {
			return new StringBuilder("");
		}

		if (C <= pairs[idx].s) {// C can work
			StringBuilder sb = rec(idx + 1, pairs, pairs[idx].e, J);
			if (sb != null) {
				sb.append("C");
				return sb;
			}
		}

		if (J <= pairs[idx].s) {// J can work
			StringBuilder sb = rec(idx + 1, pairs, C, pairs[idx].e);
			if (sb != null) {
				sb.append("J");
				return sb;
			}
		}

		return null;
	}

	public static class Pair implements Comparable<Pair> {
		int s, e, id;

		Pair(int s, int e, int id) {
			this.s = s;
			this.e = e;
			this.id = id;
		}

		@Override
		public int compareTo(Pair o) {
			int a = this.s - o.s;
			if (a == 0)
				return this.e - o.e;
			return a;
		}

		public String toString() {
			return "{" + this.s + " " + this.e + "}";
		}
	}

	public static InputStreamReader r = new InputStreamReader(System.in);

	public static BufferedReader br = new BufferedReader(r);

	public static Scanner sc = new Scanner(System.in);
}

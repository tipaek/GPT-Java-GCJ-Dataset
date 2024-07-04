import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
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

		char[] who = new char[n];

		Pair[] pairs = new Pair[n];
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			pairs[i] = new Pair(a, b, i);
		}

		Arrays.sort(pairs);

		StringBuilder sb = rec(0, pairs, 0, 0);

		if (sb == null) {
			System.out.println("IMPOSSIBLE");
		} else {
			for (int i = 0; i < n; i++)
				who[pairs[i].id] = sb.charAt(i);
			for (int i = 0; i < who.length; i++)
				System.out.println(who[i]);
			System.out.println();
		}
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

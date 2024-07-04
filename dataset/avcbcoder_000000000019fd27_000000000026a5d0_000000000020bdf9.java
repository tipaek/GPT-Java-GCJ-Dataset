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

		Pair[] pairs = new Pair[n];
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			pairs[i] = new Pair(a, b, i);
		}

		Arrays.sort(pairs);

		// int[][][] dp = new int[n][1500][1500];
		// for (int[][] d : dp)
		// for (int[] dd : d)
		// Arrays.fill(d, -1);

		boolean ans = rec(0, pairs, 0, 0);

		if (!ans) {
			System.out.println("IMPOSSIBLE");
		} else {
			boolean[] isC = new boolean[n];
			for (int i = 0; i < n; i++)
				isC[pairs[i].id] = pairs[i].work == 0;
			for (int i = 0; i < n; i++)
				System.out.print(isC[i] ? "C" : "J");
			System.out.println();
		}
	}

	private static boolean rec(int idx, Pair[] pairs, int C, int J) {
		if (idx >= pairs.length) {
			return true;
		}

		// if (dp[idx][C][J] != -1)
		// return dp[idx][C][J] == 1;

		if (C <= pairs[idx].s) {// C can work
			boolean a = rec(idx + 1, pairs, pairs[idx].e, J);
			if (a) {
				// dp[idx][C][J] = 1;
				pairs[idx].work = 0;
				return true;
			}
		}

		if (J <= pairs[idx].s) {// J can work
			boolean b = rec(idx + 1, pairs, C, pairs[idx].e);
			if (b) {
				// dp[idx][C][J] = 1;
				pairs[idx].work = 1;
				return true;
			}
		}

		// dp[idx][C][J] = 0;
		return false;
	}

	public static class Pair implements Comparable<Pair> {
		int s, e, id;
		int work = -1;

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

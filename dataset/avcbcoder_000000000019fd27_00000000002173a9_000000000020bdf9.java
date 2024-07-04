import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author avcbcoder last modified @04-Apr-2020 @5:11:16 AM codejam 2020 - TODO
 */

class Solution {
	public static void main(String[] args) throws Exception {
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			isPossible = false;
			System.out.print("Case #" + i + ": ");
			solve();
		}

	}

	public static boolean isPossible = false;

	// **SOLUTION**
	public static void solve() throws Exception {
		int n = sc.nextInt();

		int[] who = new int[n];
		Arrays.fill(who, -1);

		Pair[] pairs = new Pair[n];
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			pairs[i] = new Pair(a, b);
		}

		Arrays.sort(pairs);

		// System.out.println(Arrays.toString(pairs));
		HashSet<Integer> dp = new HashSet<>();
		rec(0, pairs, 0, 0, who, dp);

		if (!isPossible) {
			System.out.println("IMPOSSIBLE");
		}
	}

	// private static void getOrdering(Pair[] pairs) {
	// int []time=new int[24*60+10];
	// for (int i = 0; i < pairs.length; i++) {
	// time[pairs[i].s]++;
	// time[pairs[i].e]++;
	// }
	// int pos=1;
	// for (int i = 0; i < time.length; i++) {
	// if(time)
	// }
	// for (int i = 0; i < pairs.length; i++) {
	// pairs[i].s=time
	// time[pairs[i].e]=true;
	// }
	// }

	private static boolean rec(int idx, Pair[] pairs, int C, int J, int[] who, HashSet<Integer> dp) {
		if (idx >= who.length) {
			if (isPossible)
				return true;
			for (int i = 0; i < who.length; i++)
				System.out.print(who[i] == 0 ? "C" : "J");
			System.out.println();
			isPossible = true;
			return true;
		}
		int key = C * 2000 + J;

		if (dp.contains(key))
			return false;

		if (isPossible)
			return true;

		boolean a = false, b = false;

		if (C <= pairs[idx].s) {// C can work
			who[idx] = 0;
			a = rec(idx + 1, pairs, pairs[idx].e, J, who, dp);
			who[idx] = -1;
		}

		if (isPossible)
			return true;

		if (J <= pairs[idx].s) {// J can work
			who[idx] = 1;
			b = rec(idx + 1, pairs, C, pairs[idx].e, who, dp);
			who[idx] = -1;
		}

		if (isPossible)
			return true;

		dp.add(key);

		return a || b;
	}

	public static class Pair implements Comparable<Pair> {
		int s, e;

		Pair(int s, int e) {
			this.s = s;
			this.e = e;
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

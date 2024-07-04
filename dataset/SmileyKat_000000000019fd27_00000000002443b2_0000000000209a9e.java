import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	private static Scanner sc;

	private static int get(int pos) {
		System.out.println(pos + 1); System.out.flush();
		return sc.nextInt();
	}

	private static void print(int[] a) {
		StringBuilder sb = new StringBuilder();
		for (int i : a) sb.append(i);
		System.out.println(sb.toString()); System.out.flush();
	}

	private static void simpleSolve(int n) {
		int[] a = new int[n];
		for (int i = 0; i < n; ++i) {
			a[i] = get(i);
		}
		print(a);
		String res = sc.next();
		if (res.equals("N")) System.exit(0);
	}

	private static void reverse(int[] a) {
		int n = a.length, tmp;
		for (int i = 0; i < n / 2; ++i) {
			tmp = a[i];
			a[i] = a[n-1-i];
			a[n-1-i] = tmp;
		}
	}

	private static void flip(int[] a) {
		for (int i = 0; i < a.length; ++i) {
			if (a[i] < 0) continue;
			a[i] = 1 - a[i];
		}
	}

	private static void solve(int n) {
		int[] a = new int[n];
		Arrays.fill(a, -1);
		int samePos = -1, diffPos = -1;
		int round = 0, cur = 0;
		while (cur < n / 2) {
			int remainQuery = 5;
			if (round > 0) {
				if (samePos >= 0 && diffPos >= 0) {
					int s0 = a[samePos], d0 = a[diffPos];
					int s1 = get(samePos), d1 = get(diffPos);
					if (s0 == s1) {
						if (d0 == d1) {
							// no change
						} else {
							reverse(a);
						}
					} else {
						if (d0 == d1) {
							reverse(a);
							flip(a);
						} else {
							flip(a);
						}
					}
				} else if (samePos >= 0) {
					int s0 = a[samePos];
					int s1 = get(samePos);
					if (s0 != s1) flip(a);
					get(samePos);
				} else { // diffPos >= 0
					int d0 = a[diffPos];
					int d1 = get(diffPos);
					if (d0 != d1) flip(a);
					get(diffPos);
				}
				remainQuery = 4;
			}
			for (int max = cur + remainQuery; cur < max && cur < n / 2; ++cur) {
				a[cur] = get(cur);
				a[n-1-cur] = get(n-1-cur);
				if (samePos < 0 && a[cur] == a[n-1-cur]) samePos = cur;
				if (diffPos < 0 && a[cur] != a[n-1-cur]) diffPos = cur;
			}
			++round;
		}
		print(a);
		String res = sc.next();
		if (res.equals("N")) System.exit(0);
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int numTest = sc.nextInt(), n = sc.nextInt();
		for (int test = 1; test <= numTest; ++test) {
			if (n <= 10) simpleSolve(n);
			else solve(n);
		}
		sc.close();
	}

}

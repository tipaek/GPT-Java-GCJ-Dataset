import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	private static void solve(int[] a, int[] open, int[] close, int l, int r) {
		if (l > r) return;
		int min = 10, max = 0;
		for (int i = l; i <= r; ++i) {
			min = Math.min(min, a[i]);
			max = Math.max(max, a[i]);
		}
		if (min == 0 && max == 0) return;

		open[l] += min; close[r] += min;

		int prev = -1;
		for (int i = l; i <= r; ++i) {
			a[i] -= min;
			if (a[i] > 0) {
				if (prev < 0) prev = i;
			} else {
				if (prev >= 0) solve(a, open, close, prev, i - 1);
				prev = -1;
			}
		}
		if (prev >= 0) solve(a, open, close, prev, r);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numTest = sc.nextInt();
		for (int test = 1; test <= numTest; ++test) {
			String s = sc.next();
			int n = s.length();
			int[] a = new int[n];
			for (int i = 0; i < n; ++i) a[i] = s.charAt(i) - '0';

			int[] open = new int[n], close = new int[n];
			Arrays.fill(open, 0); Arrays.fill(close, 0);
			solve(a, open, close, 0, n - 1);

			System.out.printf("Case #%d: ", test);
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < open[i]; ++j) System.out.print("(");
				System.out.print(s.charAt(i));
				for (int j = 0; j < close[i]; ++j) System.out.print(")");
			}
			System.out.println();
		}
		sc.close();
	}

}

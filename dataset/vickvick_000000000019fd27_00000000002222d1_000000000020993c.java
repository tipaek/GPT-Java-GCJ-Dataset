
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		long t = scan.nextInt(); // Scanner has functions to read ints, longs,
									// strings, chars, etc.
		for (long it = 1; it <= t; ++it) {
			int n = scan.nextInt();
			int[][] nums = new int[110][110];
			for (int in = 0; in < n; ++in) {
				for (int jn = 0; jn < n; ++jn) {
					int num = scan.nextInt();
					nums[in][jn] = num;
				}
			}
			String res = cal(nums, n);
			System.out.println("Case #" + it + ": " + res);
		}
		scan.close();
	}

	private static String cal(int[][] nums, int n) {
		int k = 0, r = 0, c = 0;
		for (int i = 0; i < n; ++i) {
			k += nums[i][i];
		}

		for (int i = 0; i < n; ++i) {
			boolean[] has = new boolean[110];
			boolean dup = false;
			for (int j = 0; j < n; ++j) {
				if (has[nums[i][j]]) {
					dup = true;
					break;
				} else {
					has[nums[i][j]] = true;
				}
			}
			if (dup)
				++r;
		}

		for (int i = 0; i < n; ++i) {
			boolean[] has = new boolean[110];
			boolean dup = false;
			for (int j = 0; j < n; ++j) {
				if (has[nums[j][i]]) {
					dup = true;
					break;
				} else {
					has[nums[j][i]] = true;
				}
			}
			if (dup)
				++c;
		}
		return k + " " + r + " " + c;
	}

}
// package codejam.Y2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

 class Solution {
	private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(in.readLine());
		for (int x = 1; x <= t; x++) {
			System.out.print("Case #" + x + ": ");
			solve();
		}
	}

	public static void solve() throws IOException {
		String[] s = in.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int d = Integer.parseInt(s[1]);

		long[] angle = new long[n];
		HashSet<Long> set = new HashSet<>();
		s = in.readLine().split(" ");
		for (int i = 0; i < n; i++)  {
			angle[i] = Long.parseLong(s[i]);
			set.add(angle[i]);
		}

		Arrays.sort(angle);

		int max = 1;
		int currentMax = 1;
		long element = angle[0];
		for (int i = 1; i < n; i++) {
			if (angle[i] == angle[i - 1]) currentMax++;
			else {
				if (max < currentMax) {
					max = currentMax;
					element = angle[i - 1];
				}

				currentMax = 1;
			}
		}
		if (max < currentMax) {
			max = currentMax;
			element = angle[n - 1];
		}


		if (d == 2) {
			if (max >= 2) System.out.println(0);
			else System.out.println(1);
		} else if (d == 3) {
			if (max >= 3) System.out.println(0);
			else if (max == 2) {
				if (n == 2) {
					System.out.println(2);
				} else {
					if (angle[n - 1] > element || (element % 2 == 0 && set.contains(element / 2))) {
						System.out.println(1);
					} else {
						System.out.println(2);
					}
				}
			} else {
				for (int i = 0; i < n; i++) {
					if (set.contains(2 * angle[i])) {
						System.out.println(1);
						return;
					}
				}
				System.out.println(2);
			}
		}
	}
}

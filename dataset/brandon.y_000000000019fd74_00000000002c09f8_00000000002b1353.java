import java.util.*;
import java.io.*;
import java.lang.Math;

// java Solution < input.txt > output.txt
// java Solution < input.txt > output.txt; cat output.txt
// https://code.google.com/codejam/resources/quickstart-guide
// https://code.google.com/codejam/resources/faq

public class Solution {
	// https://www.geeksforgeeks.org/pascal-triangle/
	static int binom(int n, int k) {
		// Custom
		n -= 1; k -= 1;


		int res = 1;
		if (k > n - k)
		k = n - k;
		for (int i = 0; i < k; ++i)
		{
			res *= (n - i);
			res /= (i + 1);
		}
		return res;
	}

	public static void main (String[] args) {
		boolean debug = false;
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();	// Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			// int n = in.nextInt();
			// int m = in.nextInt();

			int tt = in.nextInt();
			int sum = 0;
			int testSum = 0; boolean valid = false;
			int n = 1; int k = 1;
			System.out.println("Case #" + i + ": ");
			while (sum < tt) {
				testSum = sum;

				if (n == 3) {
					k = 2;
				}
				if (n == 5) {
					k = 3;
				}

				testSum += binom(n, k);
				if (testSum < tt) {
					int testSum2 = testSum + binom(n+1, k);

					if (testSum2 > tt) {
						k--;
					} else {
						valid = true;
					}
				} else if (testSum == tt) {
					// Just right!
					valid = true;
				} else {
					// Sum too high! Go one layer out, one row back.
					k--;
				}

				if (valid) {
					if (debug) {
						System.out.println(n + " " + k + " -- " + testSum);
					} else {
						System.out.println(n + " " + k);
					}
					sum = testSum;
					n++;
				}
			}
			if (debug) {
				System.out.println(sum);
			}
		}
	}
}

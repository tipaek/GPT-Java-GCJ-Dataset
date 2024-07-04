import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			long L = in.nextLong(), R = in.nextLong(), n = 0;
			if (L > R) {
				n = f(L - R);
				L -= g(n);
			} else if (L < R) {
				n = f(R - L);
				R -= g(n);
			}
			if (L >= R) {
				long a = h(L, n), b = j(R, n);
				L -= i(a, n);
				R -= k(b, n);
				n += a + b;
			} else {
				long a = h(R, n), b = j(L, n);
				L -= k(b, n);
				R -= i(a, n);
				n += a + b;
			}
			System.out.println("Case #" + i + ": " + n + " " + L + " " + R);
		}
	}

	private static long f(long n) {
		long left = 0, right = 1;
		while (g(right) <= n) {
			right *= 2;
		}
		while (left < right) {
			long mid = (left + right + 1) / 2;
			if (g(mid) <= n) {
				left = mid;
			} else {
				right = mid - 1;
			}
		}
		return left;
	}

	private static long g(long n) {
		return n % 2 == 0 ? n / 2 * (n + 1) : (n + 1) / 2 * n;
	}

	private static long h(long n, long k) {
		long left = 0, right = 1;
		while (i(right, k) <= n) {
			right *= 2;
		}
		while (left < right) {
			long mid = (left + right + 1) / 2;
			if (i(mid, k) <= n) {
				left = mid;
			} else {
				right = mid - 1;
			}
		}
		return left;
	}

	private static long i(long n, long k) {
		return k * n + n * n;
	}

	private static long j(long n, long k) {
		long left = 0, right = 1;
		while (k(right, k) <= n) {
			right *= 2;
		}
		while (left < right) {
			long mid = (left + right + 1) / 2;
			if (k(mid, k) <= n) {
				left = mid;
			} else {
				right = mid - 1;
			}
		}
		return left;
	}

	private static long k(long n, long k) {
		return (k + 1) * n + n * n;
	}
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.function.LongUnaryOperator;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(System.out);

		int t = Integer.parseInt(reader.readLine());
		for (int tt = 0; tt < t; tt++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			long a = Long.parseLong(tokenizer.nextToken());
			long b = Long.parseLong(tokenizer.nextToken());
			long diff = Math.max(a, b) - Math.min(a, b);
			// binary search on diff
			long maxBinSearch = 5000000000L; // 5e9
			long x = lowerBound(diff, 0, maxBinSearch, Solution::f);
			if (b > a) {
				b -= f(x);
			} else {
				a -= f(x);
			}
			//writer.println(x + ": " + a + " - " + b);
			long leftK = b > a ? x : x - 1;
			long rightK = b > a ? x - 1 : x;
			maxBinSearch = 1000000000L;
			long y = lowerBound(a, 0, maxBinSearch, (n) -> {
				return g(n, leftK);
			});
			a -= g(y, leftK);
			long z = lowerBound(b, 0, maxBinSearch, (n) -> {
				return g(n, rightK);
			});
			b -= g(z, rightK);

			long answer = x + y + z;
			writer.printf("Case #%d: %d %d %d\n", tt + 1, answer, a, b);
		}

		reader.close();
		writer.close();
	}
	public static long f(long x) {
		return x * (x + 1) / 2;
	}
	public static long g(long n, long k) {
		long answer = n * (n + 1) + k * n;
		return answer < 0 ? Long.MAX_VALUE : answer;
	}
	public static long lowerBound(long value, long min, long max, LongUnaryOperator function) {
		// binary search
		long left = min;
		long right = max;
		while (left < right) {
			if (right - left <= 1) {
				// 2 options
				if (function.applyAsLong(right) <= value) {
					return right;
				} else {
					return left;
				}
			}
			long mid = ((right - left) >> 1) + left;
			if (function.applyAsLong(mid) <= value) {
				left = mid;
			} else {
				right = mid - 1;
			}
		}
		return left;
	}
}

import java.util.Scanner;

// 1e18 1e18

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t = 1; t <= T; t++) {
			long L = in.nextLong();
			long R = in.nextLong();
			long lo = 0, hi = (long) 2e9;

			while (lo < hi) {
				long mid = (lo + hi + 1) / 2;

				long max = Math.max(L, R) - sum(mid);
				long min = Math.min(L, R);
				if (max < min) {
					hi = mid - 1;
				} else {
					lo = mid;
				}
			}

			if (L >= R) {
				L -= sum(lo);
			} else {
				R -= sum(lo);
			}
			

			long base = lo;

			lo = 0;
			hi = (long) 4e9;
			long ansL = L, ansR = R;
			while (lo < hi) {
				long mid = (lo + hi + 1) / 2;
				long stepsBig = (mid + 1) / 2;
				long stepsSmall = (mid) / 2;

				long sumBig = (base+1) * stepsBig + 2 * sum(stepsBig - 1);// sum of base...base+2*stepsBig by 2's
				long sumSmall = (base + 2) * stepsSmall + 2 * sum(stepsSmall - 1); // sum of base+1...base+1+stepsSmall
				if (Math.max(L, R) - sumBig < 0 || Math.min(L, R) - sumSmall < 0) {
					hi = mid - 1;
				} else {
					lo = mid;
					ansL = (L >= R ? L - sumBig : L - sumSmall);
					ansR = (L < R ? R - sumBig : R - sumSmall);
				}
			}

			long n = base + lo;

			System.out.printf("Case #%d: %d %d %d\n", t, n, ansL, ansR);
		}
	}

	static long steps(long n) {
		long lo = 0, hi = (long) 2e9;
		while (lo < hi) {
			long mid = (lo + hi + 1) / 2;
			if (sum(mid) > n) {
				hi = mid - 1;
			} else {
				lo = mid;
			}
		}
		return lo;
	}

	static long sum(long n) {
		return n * (n + 1) / 2;
	}
}

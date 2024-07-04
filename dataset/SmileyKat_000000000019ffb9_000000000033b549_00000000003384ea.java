import java.util.Scanner;

public class Solution {

	private static final Scanner sc = new Scanner(System.in);
	private static final StringBuilder sb = new StringBuilder();

	private static void solve(int testId) {
		sb.append("Case #").append(testId).append(": ");

		long L0 = sc.nextLong(), R0 = sc.nextLong();

		long L = L0, R = R0;
		long cur = 1, d, count = 0;

		if (L > R) {
			d = L - R;
			long x = find(d, 1, 1);
			count += x;
			cur = x + 1;
			L -= x * (x + 1) / 2;
		} else if (R > L) {
			d = R - L;
			long x = find(d, 1, 1);
			if (x * (x + 1) / 2 < d) ++x;
			if (x * (x + 1) / 2 > R) --x;
			count += x;
			cur = x + 1;
			R -= x * (x + 1) / 2;
		}

		// now L >=R and L - R < cur
		long nL = find(L, cur, 2);
		long nR = find(R, cur + 1, 2);
		if (nL > 0 && nR > 0) {
			long min = Math.min(nL, nR);
			count += 2 * min;
			L -= sum(cur, 2, min);
			R -= sum(cur + 1, 2, min);
			cur += 2 * min;
		}

		if (nL > nR) {
			long n = find(L, cur, 1);
			if (n > 0) {
				count += n;
				L -= sum(cur, 1, n);
			}
		} else if (nR > nL) {
			long n = find(R, cur, 1);
			if (n > 0) {
				count += n;
				R -= sum(cur, 1, n);
			}
		}

		sb.append(count).append(' ').append(L).append(' ').append(R).append('\n');
	}

	private static long find(long max, long start, long step) {
		long l = 0, r = (long) Math.sqrt((double) max / step * 2);
		if (l > r) return -1;
		long res = -1;
		while (l <= r) {
			long m = l + (r - l) / 2;
//			long sum = (2 * start + m * step) * (m + 1) / 2;
			long sum = sum(start, step, m + 1);
			if (sum == max) return m + 1;
			else if (sum < max) {
				res = m;
				l = m + 1;
			} else r = m - 1;
		}
		return res < 0 ? -1 : res + 1;
	}

	private static long sum(long start, long step, long num) {
		return num * (start + start + step * (num - 1)) / 2;
	}

	public static void main(String[] args) {
		int numTest = sc.nextInt();
		for (int i = 1; i <= numTest; ++i) solve(i);
		System.out.print(sb.toString());
	}

}

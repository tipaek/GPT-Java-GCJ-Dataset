import java.util.Scanner;

public class Solution {
	static Scanner sc = new Scanner(System.in);
//	static SplittableRandom rnd = new SplittableRandom();

	public static void main(String[] args) {
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			System.out.print("Case #" + i + ":");
			solve();
		}
	}

	static void solve() {
		long L = sc.nextLong();
		long R = sc.nextLong();
//		long L = rnd.nextLong(100000000000000L);
//		long R = rnd.nextLong(1000000000000L);
//		{
//			long v1 = L;
//			long v2 = R;
//			for (long i = 1; ; i++) {
//				if (Math.max(v1, v2) < i) {
//					System.err.println("\n" + (i - 1) + " " + v1 + " " + v2);
//					break;
//				}
//				if (v1 >= v2) {
//					v1 -= i;
//				} else {
//					v2 -= i;
//				}
//			}
//		}
		long lo = 0;
		long diff = Math.abs(R - L);
		long hi = (long) Math.sqrt(diff) * 2;
		while (hi - lo > 1) {
			long mid = (lo + hi) / 2;
			if (mid * (mid + 1) / 2 > diff) {
				hi = mid;
			} else {
				lo = mid;
			}
		}
		if (R > L) {
			R -= lo * (lo + 1) / 2;
		} else {
			L -= lo * (lo + 1) / 2;
		}
		long ans = lo;
		long min = Math.min(R, L);
		lo = 0;
		hi = (long) Math.sqrt(min) * 2;
		while (hi - lo > 1) {
			long mid = (lo + hi) / 2;
			long count = (ans + 2) * mid + mid * (mid - 1);
			if (count > min) {
				hi = mid;
			} else {
				lo = mid;
			}
		}
		long count = (ans + 2) * lo + lo * (lo - 1);
		if (R > L) {
			R -= count - lo;
			L -= count;
		} else {
			L -= count - lo;
			R -= count;
		}
		ans += lo * 2;
		if (Math.max(L, R) >= ans + 1) {
			ans++;
			if (R > L) {
				R -= ans;
			} else {
				L -= ans;
			}
		}
		System.err.println(ans + " " + L + " " + R);
	}

}

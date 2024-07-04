import java.util.Scanner;

public class Solution {

	private static Scanner sc;
	private static long A, B;

	private static final long MAX = 1_000_000_000L;

	private static final int CENTER = 0;
	private static final int HIT = 1;
	private static final int MISS = 2;

	private static int test(long x, long y) {
//		System.err.println(x + " " + y); System.err.flush();
		System.out.println(x + " " + y); System.out.flush();
		String s = sc.next();
		if (s.equalsIgnoreCase("CENTER")) return CENTER;
		else if (s.equalsIgnoreCase("HIT")) return HIT;
		else return MISS;
	}

	private static void solve(int test) {
		// find first point inside dartboard
		long[] p = findFirst();
		if (p == null) return;
		long x0 = p[0], y0 = p[1];

		Long p1 = findY(x0, y0, MAX, 1);
		if (p1 == null) return;
//		System.err.println("p1=" + p1);
		Long p2 = findY(x0, -MAX, y0, -1);
		if (p2 == null) return;
//		System.err.println("p2=" + p2);
		long Y = (p1 + p2) / 2;
//		System.err.println("Y=" + Y);

		Long p3 = findX(y0, x0, MAX, 1);
		if (p3 == null) return;
//		System.err.println("p3=" + p3);
		Long p4 = findX(y0, -MAX, x0, -1);
		if (p4 == null) return;
//		System.err.println("p4=" + p4);
		long X = (p3 + p4) / 2;
//		System.err.println("X=" + X);

		for (long x = X - 1; x < X + 1; ++x) {
			for (long y = Y - 1; y < Y + 1; ++y) {
				int status = test(x, y);
				if (status == CENTER) return;
			}
		}
//		int status = test(X, Y); // expect CENTER
	}

	private static long[] findFirst() {
		long x = 0, y = 0;
		for (int i = 1; i <= 3; ++i) {
			x = -MAX + MAX * i / 2;
			for (int j = 1; j <= 3; ++j) {
				y = -MAX + MAX * j / 2;
				int status = test(x, y);
				if (status == HIT) return new long[] {x, y};
				else if (status == CENTER) return null;
			}
		}
		return null; // not happen
	}

	private static Long findY(long x, long L, long R, int d) {
		long y;
		int status;
		while (L <= R) {
			y = L + (R - L) / 2;
			status = test(x, y);
			if (status == CENTER) {
				return null;
			} else if (status == HIT) {
				if (d > 0) L = y + 1;
				else R = y - 1;
			} else {
				if (d > 0) R = y - 1;
				else L = y + 1;
			}
		}
		return L;
	}

	private static Long findX(long y, long L, long R, int d) {
		long x;
		int status;
		while (L <= R) {
			x = L + (R - L) / 2;
			status = test(x, y);
			if (status == CENTER) {
				return null;
			} else if (status == HIT) {
				if (d > 0) L = x + 1;
				else R = x - 1;
			} else {
				if (d > 0) R = x - 1;
				else L = x + 1;
			}
		}
		return L;
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int numTest = sc.nextInt();
		A = sc.nextLong(); B = sc.nextLong();
//		System.err.printf("T=%d A=%d B=%d\n", numTest, A, B);
		for (int test = 1; test <= numTest; ++test) {
			solve(test);
		}
		sc.close();
	}

}

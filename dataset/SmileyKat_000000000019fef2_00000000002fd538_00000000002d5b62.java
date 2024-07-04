import java.util.Scanner;

public class Solution {

	private static Scanner sc;

	private static long[] P2 = new long[34];

	private static void solve(int test) {
		long X = sc.nextLong(), Y = sc.nextLong();
		StringBuilder sb = new StringBuilder();
		while (X != 0 || Y != 0) {
			boolean oddX = Math.abs(X) % 2 != 0;
			boolean oddY = Math.abs(Y) % 2 != 0;
			if ((oddX && oddY) || (!oddX && !oddY)) {
				System.out.printf("Case #%d: IMPOSSIBLE\n", test);
				return;
			}
			if (oddX) {
				long x1 = (X + 1) / 2; char step1 = 'W';
				long x2 = (X - 1) / 2; char step2 = 'E';
				if (x1 % 2 == 0) {
					long tmp1 = x1; x1 = x2; x2 = tmp1;
					char tmp2 = step1; step1 = step2; step2 = tmp2;
				}
				// x1 - odd, x2 - even

				Y /= 2;
				if (Y == 0 && (x1 == 0 || x2 == 0)) {
					if (x1 == 0) sb.append(step1);
					if (x2 == 0) sb.append(step2);
					break;
				}
				if (Math.abs(Y) % 2 == 0) {
					X = x1; sb.append(step1);
				} else {
					X = x2; sb.append(step2);
				}
			} else { // oddY
				long y1 = (Y + 1) / 2; char step1 = 'S';
				long y2 = (Y - 1) / 2; char step2 = 'N';
				if (y1 % 2 == 0) {
					long tmp1 = y1; y1 = y2; y2 = tmp1;
					char tmp2 = step1; step1 = step2; step2 = tmp2;
				}
				// y1 - odd, y2 - even

				X /= 2;
				if (X == 0 && (y1 == 0 || y2 == 0)) {
					if (y1 == 0) sb.append(step1);
					if (y2 == 0) sb.append(step2);
					break;
				}
				if (Math.abs(X) % 2 == 0) {
					Y = y1; sb.append(step1);
				} else {
					Y = y2; sb.append(step2);
				}
			}
		}
		System.out.printf("Case #%d: %s\n", test, sb.toString());
	}

	public static void main(String[] args) {
		P2[0] = 1;
		for (int i = 1; i < P2.length; ++i) {
			P2[i] = 2L * P2[i - 1];
		}

		sc = new Scanner(System.in);
		int numTest = sc.nextInt();
		for (int test = 1; test <= numTest; ++test) {
			solve(test);
		}
		sc.close();
	}

}

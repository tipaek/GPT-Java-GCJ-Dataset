import java.util.Scanner;

public class Solution {
	static Scanner sc = new Scanner(System.in);
	static long[][] P = new long[501][501];

	public static void main(String[] args) {
		for (int i = 0; i < P.length; i++) {
			P[i][0] = P[i][i] = 1;
		}
		for (int i = 0; i < P.length; i++) {
			for (int j = 1; j < i; j++) {
				P[i][j] = P[i - 1][j] + P[i - 1][j - 1];
			}
		}
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			System.out.println("Case #" + i + ": ");
			solve();
		}
	}

	static void solve() {
		int N = sc.nextInt();
		for (int i = 30; i >= 0; i--) {
			long r = N - i - 1;
			if (r < 0) continue;
			boolean[] use = new boolean[i + 1];
			for (int j = i; j > 0; j--) {
				if (r >= (1 << j) - 1) {
					r -= (1 << j) - 1;
					use[j] = true;
				}
			}
			System.out.println("1 1");
			int col = 1;
			for (int j = 1; j <= i; j++) {
				if (use[j]) {
					if (col == 1) {
						for (int k = 1; k <= j + 1; k++) {
							System.out.println((j + 1) + " " + k);
						}
						col = j + 1;
					} else {
						for (int k = j + 1; k >= 1; k--) {
							System.out.println((j + 1) + " " + k);
						}
						col = 1;
					}
				} else {
					col = col == 1 ? 1 : j + 1;
					System.out.println((j + 1) + " " + col);
				}
			}
			for (int j = i + 1; r > 0; j++, r--) {
				col = col == 1 ? 1 : j + 1;
				System.out.println((j + 1) + " " + col);
			}
			return;
		}
	}
}

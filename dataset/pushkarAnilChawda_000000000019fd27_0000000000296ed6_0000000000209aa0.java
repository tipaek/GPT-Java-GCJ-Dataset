import java.util.Scanner;

public class Solution {
	static int result[][] = null;
	static boolean rotateRight = false;
	static int start = -1;

	public static void main(String[] args) {
		boolean possible = false;
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			start = -1;
			rotateRight = false;
			result = new int[N][N];
			if (N % 2 == 0) {
				possible = performEven(N, K);
			} else {
				possible = performOdd(N, K);
			}

			performMatrixGen(N);

			if (possible) {
				System.out.println("Case #" + i + ": POSSIBLE");
				for (int l = 0; l < N; l++) {
					for (int m = 0; m < N; m++) {
						if (m == N - 1)
							System.out.print(result[l][m]);
						else
							System.out.print(result[l][m] + " ");
					}
					System.out.println();
				}
			} else {
				System.out.println("Case #" + i + ": IMPOSSIBLE");
			}
		}

		sc.close();
	}

	private static void performMatrixGen(int n) {
		int tempStart = start;
		if (!rotateRight) {
			for (int l = 0; l < n; l++) {
				for (int m = 0; m < n; m++) {
					result[l][m] = tempStart;
					tempStart++;
					if (tempStart > n) {
						tempStart = tempStart % n;
						// start++;
					}
				}
				start++;
				if (start > n) {
					start = start % n;
					tempStart = start;
					// start++;
				}
			}
		} else {
			for (int l = 0; l < n; l++) {
				for (int m = 0; m < n; m++) {
					result[l][m] = tempStart;
					if(m != n-1)
						tempStart++;
					if (tempStart > n) {
						tempStart = tempStart % n;
						// start++;
					}
				}
			}
		}

	}

	private static boolean performOdd(int n, int k) {

		if (performCommon(n, k)) {
			return true;
		}

		int kDash = 0;

		for (int i = 1; i <= n; i++) {
			kDash = kDash + i;
		}

		if (kDash == k) {
			rotateRight = false;
			start = 1;
			return true;
		}

		return false;
	}

	private static boolean performEven(int n, int k) {

		if (performCommon(n, k)) {
			return true;
		}

		int kDash = 0;

		for (int i = 1; i <= n; i += 2) {
			kDash = kDash + i;
		}

		for (int i = 1; i <= n; i += 2) {
			kDash = kDash + i;
		}

		if (kDash == k) {
			rotateRight = false;
			start = 1;
			return true;
		}

		kDash = 0;

		for (int i = 2; i <= n; i += 2) {
			kDash = kDash + i;
		}

		for (int i = 2; i <= n; i += 2) {
			kDash = kDash + i;
		}

		if (kDash == k) {
			rotateRight = false;
			start = 2;
			return true;
		}

		return false;
	}

	private static boolean performCommon(int n, int k) {

		for (int i = 1; i <= n; i++) {
			int kDash = i * n;
			if (kDash == k) {
				rotateRight = true;
				start = i;
				return true;
			}
		}

		return false;
	}

}

import java.util.*;
class Solution {
	public static void main(String[] commands) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t = 1; t <= T; t++) {
			int n = in.nextInt();
			int d = in.nextInt();

			if (d % n == 0 && d <= n * n) {
				System.out.printf("Case #%d: POSSIBLE\n", t);
				int[][] m = new int[n][n];
				int c = 0;
				for (int i = 0; i < n; i++) {
					int k = d / n;
					for (int j = 0; j < n; j++) {
						m[i][(c+j) % n] = k;
						k++;
						if (k > n) k = 1;
					}
					c++;
				}
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						System.out.print(m[i][j] + (j == n-1? "" : " "));
					}
					System.out.println();
				}
			} else {
				System.out.printf("Case #%d: IMPOSSIBLE\n", t);
			}
		}
	}
}
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			int t = sc.nextInt();
			for (int k = 1; k <= t; k++) {
				int n = sc.nextInt();
				int matrix[][] = new int[n][n];
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						matrix[i][j] = sc.nextInt();
					}
				}
				solution(matrix, k);

			}

		}

	}

	public static void solution(int[][] m, int num) {
		int k = 0, c = 0, r = 0;
		for (int i = 0; i < m.length; i++) {
			k += m[i][i];
			boolean[] cr = checkFoDuplicates(m, i);
			if (cr[0]) {
				c++;
			}
			if (cr[1]) {
				r++;
			}
		}

		System.out.printf("Case #%d: %d %d %d%n", num, k, r, c);
	}

	public static boolean[] checkFoDuplicates(int[][] m, int n) {
		boolean c = false, r = false;
		for (int i = 0; i < m.length; i++) {
			int a = m[i][n];
			int b = m[n][i];
			for (int j = i + 1; j < m.length; j++) {
				if (a == m[j][n]) {
					c = true;
				}

				if (b == m[n][j]) {
					r = true;
				}
				if (c & r) {
					return new boolean[] { c, r };
				}
			}
		}
		return new boolean[] { c, r };

	}

}
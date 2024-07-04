import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) {
			int n = sc.nextInt();
			int mat[][] = new int[n][n];
			int sum = 0;
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					mat[j][k] = sc.nextInt();
					if (j == k)
						sum += mat[j][k];
				}
			}

			int rowCnt = 0;
			int colCnt = 0;

			for (int j = 0; j < n; j++) {
				Set<Integer> set = new HashSet<>();
				for (int k = 0; k < n; k++) {
					if (set.contains(mat[j][k])) {
						rowCnt++;
						break;
					}
					set.add(mat[j][k]);
				}
			}

			for (int j = 0; j < n; j++) {
				Set<Integer> set = new HashSet<>();
				for (int k = 0; k < n; k++) {
					if (set.contains(mat[k][j])) {
						colCnt++;
						break;
					}
					set.add(mat[k][j]);
				}
			}

			System.out.println("Case #" + i + ": " + sum + " " + rowCnt + " " + colCnt);
		}

		sc.close();

	}

}
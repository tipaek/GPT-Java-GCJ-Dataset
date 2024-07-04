

import java.util.Scanner;

public class Solution {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {

		int t = s.nextInt();
		for (int i = 0; i < t; i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			check(a, b, i);
		}
	}

	private static void check(int a, int b, int caseNo) {
		int k = 1, i, j, sum = 0, act = 1;
		int[][] mat = new int[a][a];
		if (a == b) {
			k = 1;
		}
		while (k <= a) {sum=0;
			act = k;
			for (i = 0; i < a; i++) {
				for (j = 0; j < a; j++) {
					if (i > 0 && j == 0) {
						k = mat[i - 1][a - 1];
					}
					mat[i][j] = k;System.out.print(mat[i][j] + " ");
					if (k >= a) {
						k = 1;
					} else {
						k++;
					}
					if (i == j) {
						sum += mat[i][j];
					}
				}System.out.println();
			}
			if (sum == b) {
				act = 0;
				break;
			}
			k = act++;
		}
		String type = "IMPOSSIBLE";

		if (act == 0) {
			type = "POSSIBLE";
			System.out.println("Case #" + (caseNo + 1) + ": " + type);
			for (i = 0; i < a; i++) {
				for (j = 0; j < a; j++) {
					System.out.print(mat[i][j] + " ");
				}
				System.out.println();
			}
		} else {
			System.out.println("Case #" + (caseNo + 1) + ": " + type);
			for (i = 0; i < a; i++) {
				for (j = 0; j < a; j++) {
					System.out.print(mat[i][j] + " ");
				}
				System.out.println();
			}
		}

	}

}

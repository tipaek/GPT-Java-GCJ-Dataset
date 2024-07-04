import java.util.Scanner;

public class Solution {
	static Scanner s = new Scanner(System.in);
	static int t = s.nextInt();
	static int[] a = new int[t];
	static int[] b = new int[t];

	public static void main(String[] args) {

		for (int i = 0; i < t; i++) {
			a[i] = s.nextInt();
			b[i] = s.nextInt();
			check(a[i], b[i], i);
		}
		/*
		 * for(int i=0;i<t;i++){ check(a[i], b[i], i); }
		 */
	}

	private static void check(int a, int b, int caseNo) {
		int k = 2, i, j, sum = 0, act = 1, find = 1;
		int[][] mat = new int[a][a];
		if (a == b) {
			k = 1;
		}
		if (b > a * a) {
			k = a + 1;
		}
		while (k <= a) {
			sum = 0;
			act = k;
			while (a - find != 0) {
				for (i = 0; i < a; i++) {
					for (j = 0; j < a; j++) {
						if (i > 0 && j == 0) {
							k = mat[i - 1][a - find];
						}
						mat[i][j] = k;
						if (k >= a) {
							k = 1;
						} else {
							k++;
						}
						if (i == j) {
							sum += mat[i][j];
						}
					}
				}
				if (sum == b) {
					act = 0;
					break;
				}
				find++;
				sum = 0;
			}
			if (act == 0) {
				break;
			}
			find = 1;
			k = act + 1;
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
		}

	}

}

import java.util.*;

public class Solution {
	static class Mask {
		long right = 0;
		long left = 0;
	}

	static void solve(int[][] a, int caseNum) {
		int repeatedRows = 0, repeatedCol = 0, sum = 0;
		int N = a.length;

		// Expected bit mask using two longs
		Mask expectedRes = new Mask();

		// 63 is max number of bit for long
		if (N > 63) {
			expectedRes.right = Long.MAX_VALUE;
			expectedRes.left = ((long) 1 << (N - 63)) - 1;
		} else {
			expectedRes.right = ((long) 1 << N) - 1;
		}

		Mask[] colMasks = new Mask[N];
		for (int i = 0; i < colMasks.length; i++) {
			colMasks[i] = new Mask();
		}

		Mask rowMask;
		long temp;

		for (int i = 0; i < N; i++) {
			rowMask = new Mask();

			for (int j = 0; j < N; j++) {
				// Diagonal sum
				if (i == j) {
					sum += a[i][j];
				}

				// Repeated rows
				if (a[i][j] > 63) {
					temp = ((long) 1 << (a[i][j] - 63 - 1));

					// Repeated rows
					rowMask.left = rowMask.left | temp;

					// Repeated cols
					colMasks[j].left = colMasks[j].left | temp;
				} else {
					temp = ((long) 1 << (a[i][j] - 1));

					// Repeated rows
					rowMask.right = rowMask.right | temp;

					// Repeated cols
					colMasks[j].right = colMasks[j].right | temp;
				}

			}

			if (rowMask.right != expectedRes.right || rowMask.left != expectedRes.left) {
				repeatedRows++;
			}
		}

		for (int i = 0; i < N; i++) {
			if (colMasks[i].right != expectedRes.right || colMasks[i].left != expectedRes.left) {
				repeatedCol++;
			}
		}

		System.out.println("Case #" + caseNum + ": " + sum + " " + repeatedRows + " " + repeatedCol);
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		int N;
		int[][] a;

		for (int i = 1; i <= t; i++) {
			N = in.nextInt();
			a = new int[N][N];

			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					a[j][k] = in.nextInt();
				}
			}
			solve(a, i);
		}

		in.close();
	}
}
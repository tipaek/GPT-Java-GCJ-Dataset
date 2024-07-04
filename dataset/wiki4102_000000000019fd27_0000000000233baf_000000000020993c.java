package Assingment;

import java.util.Scanner;

public class Practice1 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int sum[] = new int[T];
		int row_max[] = new int[T];
		int col_max[] = new int[T];
		for (int i = 0; i < T; i++) {
			int size = sc.nextInt();
			int latin[][] = new int[size][size];
			for (int k = 0; k < size; k++) {
				for (int j = 0; j < size; j++) {
					latin[k][j] = sc.nextInt();
				}
			}

			int row, col;

			for (int k = 0; k < size; k++) {
				for (int j = 0; j < size; j++) {
					if (k == j) {
						sum[i] += latin[k][k];
					}
				}
			}
			for (int k = 0; k < size; k++) {
				row = 0;
				col = 0;
				for (int j = 0; j < size - 1; j++) {

					if (latin[k][j] == latin[k][j + 1]) {
						row++;
					}
					if (latin[j][k] == latin[j + 1][k]) {
						col++;
					}
				}
				row_max[i] = Math.max(row_max[i], row);
				col_max[i] = Math.max(col_max[i], col);
			}
			if (row_max[i] > 0)
				row_max[i] += 1;
			if (col_max[i] > 0)
				col_max[i] += 1;

		}
		for (int i = 0; i < T; i++) {
			System.out.println("Case #" + (i + 1) + ": " + sum[i] + " " + row_max[i] + " " + col_max[i]);
		}
		sc.close();
	}
}

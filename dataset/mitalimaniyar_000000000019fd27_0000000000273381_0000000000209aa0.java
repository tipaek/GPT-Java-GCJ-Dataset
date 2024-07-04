import java.util.Scanner;


public class Solution {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int t = s.nextInt();

		int matrices[][][] = new int[t][][];
		String[] answers = new String[t];
		for (int count = 0; count < t; count++) {

			int n = s.nextInt();
			int k = s.nextInt();

			matrices[count] = new int[n][n];

			int matrix[][] = new int[n][n];
			for (int i = 0; i < n; i++) {
				matrix[0][i] = i + 1;
			}

			for (int i = 1; i < n; i++) {
				int mod = i % n;
				for (int j = 0; j < n; j++) {
					matrix[i][j] = matrix[0][(j + mod) % n];
				}
			}

			int currentTrace = 0;
			int rowSwaps[][] = new int[n][n];
			int colSwaps[][] = new int[n][n];

			rowSwaps = calcRS(matrix, n);
			colSwaps = calcCS(matrix, n);

			int[] rowsA = new int[n];
			int[] colsA = new int[n];

			for (int i = 0; i < n; i++) {
				currentTrace += matrix[i][i];
			}

			boolean possible = true;
			matrix = rearrangeMatrix(n, matrix, rowsA, colsA, currentTrace, k, rowSwaps, colSwaps);

			if (matrix == null) {
				possible = false;
			}

			if (possible) {
				answers[count] = "POSSIBLE";
				matrices[count] = matrix;
			} else {
				answers[count] = "IMPOSSIBLE";
			}
		}

		for (int count = 0; count < t; count++) {

			System.out.println("Case #" + (count + 1) + ": " + answers[count]);
			if (answers[count].equals("POSSIBLE")) {
				int matrix[][] = matrices[count];
				for (int i = 0; i < matrix.length; i++) {
					for (int j = 0; j < matrix[i].length; j++) {
						System.out.print(matrix[i][j]);
						if (j < matrix[i].length - 1) {
							System.out.print(" ");
						}
					}
					System.out.println();
				}
			}
		}
	}

	private static int[][] calcCS(int[][] matrix, int n) {
		int[][] colSwaps = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int o1 = matrix[i][i];
				int n1 = matrix[i][j];

				int o2 = matrix[j][j];
				int n2 = matrix[j][i];

				int val = (n1 - o1) + (n2 - o2);

				colSwaps[i][j] = val;
				colSwaps[j][i] = val;
			}
		}

		return colSwaps;
	}

	private static int[][] calcRS(int[][] matrix, int n) {
		int[][] rowSwaps = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int o1 = matrix[i][i];
				int n1 = matrix[j][i];

				int o2 = matrix[j][j];
				int n2 = matrix[i][j];

				int val = (n1 - o1) + (n2 - o2);

				rowSwaps[i][j] = val;
				rowSwaps[j][i] = val;
			}
		}
		return rowSwaps;
	}

	public static int[][] rearrangeMatrix(int n, int[][] matrix, int[] rowsA, int[] colsA, int currentTrace, int k,
			int[][] rowSwaps, int[][] colSwaps) {

		if (currentTrace == k)
			return matrix;

		int distance = k - currentTrace;
		int s = -1, t = -1, type = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (rowSwaps[i][j] == distance) {
					s = i;
					t = j;
					type = 1;
					break;
				} else if (colSwaps[i][j] == distance) {
					s = i;
					t = j;
					type = 2;
					break;
				}
			}
		}

		if (s != -1 && t != -1) {

			for (int i = 0; i < n; i++) {
				if (type == 1) {
					int temp = matrix[s][i];
					matrix[s][i] = matrix[t][i];
					matrix[t][i] = temp;
				} else {
					int temp = matrix[i][s];
					matrix[i][s] = matrix[i][t];
					matrix[i][t] = temp;
				}
			}

			return matrix;

		} else {
//
//			int rowSwaps2[][] = new int[n][n];
//			int colSwaps2[][] = new int[n][n];
//
//			rowSwaps2 = calcRS(matrix, n);
//			colSwaps2 = calcCS(matrix, n);
//
//			int trace = 0;
//			for (int i = 0; i < n; i++) {
//				trace += matrix[i][i];
//			}
//
//			if (trace != k)
//				matrix = rearrangeMatrix(n, matrix, rowsA, colsA, trace, k, rowSwaps2, colSwaps2);
			return null;
		}
	}

}
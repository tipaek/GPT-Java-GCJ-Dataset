import java.util.*;

class Solution {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();

		int tcase = 1;
		while (t-- > 0) {
			int n = scanner.nextInt();
			int k = scanner.nextInt();
			if (k < n || k > n * n) {
				printImposiible(tcase++);
				continue;
			}
			int[][] matrix = new int[n][n];
			preProcess(n, k, matrix);
			if (canWeFormLatinSquare(n, k) && fillUpSpaceOtherThanTraceWithUniqueValues(matrix, n)) {
				System.out.println("Case #" + tcase++ + ": " + "POSSIBLE");
				print(matrix, n);
			} else {
				printImposiible(tcase++);
			}

		}
	}

	private static void printImposiible(int tcase) {
		System.out.println("Case #" + tcase + ": " + "IMPOSSIBLE");
	}

	private static void preProcess(int n, int k, int[][] matrix) {

		fillUpTrace(n, k, matrix);

		if (firstTwoDiagonalElementsNotEqual(n, matrix)) {
			matrix[1][1]--;
			matrix[2][2]++;
		} else if (lastTwoDiagonalElementsAreEqual(n, matrix)) {
			matrix[n - 2][n - 2]--;
			matrix[n - 3][n - 3]++;
		}
	}

	private static boolean lastTwoDiagonalElementsAreEqual(int n, int[][] matrix) {
		return n > 2 && matrix[n - 1][n - 1] != matrix[n - 2][n - 2];
	}

	private static boolean firstTwoDiagonalElementsNotEqual(int n, int[][] matrix) {
		return n > 2 && matrix[0][0] != matrix[1][1];
	}

	private static void fillUpTrace(int n, int k, int[][] matrix) {
		int minSumForTrace = k / n;
		int reminder = k - (n * minSumForTrace);
		if (k % n == 0)
			for (int x = 0; x < n; x++) {
				matrix[x][x] = k / n;
			}
		else {
			for (int x = 0; x < n; x++) {
				if (x >= (n - reminder)) {
					matrix[x][x] = minSumForTrace + 1;
				} else {
					matrix[x][x] = minSumForTrace;
				}
			}
		}
	}

	private static void print(int[][] matrix, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j]);
				if (j != n - 1) {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	private static boolean canWeFormLatinSquare(int n, int k) {
		if (n == 2 || n == 3)
			return k <= n * n && k % n == 0;
		return k != n + 1 && k != (n * n) - 1;
	}

	private static boolean fillUpSpaceOtherThanTraceWithUniqueValues(int[][] matrix, int n) {
		int row = -1, col = -1;
		boolean isSolved = true;
		outer: for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					row = i;
					col = j;
					isSolved = false;
					break outer;
				}
			}
		}
		if (isSolved) {
			return true;
		}

		for (int i = 1; i <= n; i++) {
			if (isSafe(matrix, i, row, col, n)) {
				matrix[row][col] = i;
				if (fillUpSpaceOtherThanTraceWithUniqueValues(matrix, n)) {
					return true;
				} else {
					matrix[row][col] = 0;
				}
			}
		}
		return false;
	}

	private static boolean isSafe(int[][] matrix, int number, int row, int col, int n) {
		for (int i = 0; i < n; i++) {
			if (matrix[row][i] == number) {
				return false;
			}
		}
		for (int i = 0; i < n; i++) {
			if (matrix[i][col] == number) {
				return false;
			}
		}
		return true;
	}
}

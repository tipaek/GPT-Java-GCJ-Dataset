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
				System.out.println("Case #" + tcase++ + ": " + "IMPOSSIBLE");
			}
			else{
    			
    			int[][] matrix = new int[n][n];
    			preCheck(n, k, matrix);
    			if (canForm(n, k) && fillSudoku(matrix, n)) {
    				System.out.println("Case #" + tcase++ + ": " + "POSSIBLE");
    				printMatrix(matrix, n);
    			} else {
    				System.out.println("Case #" + tcase++ + ": " + "IMPOSSIBLE");
    			}
    			    
			}
		}
	}

	private static void preCheck(int n, int k, int[][] matrix) {

		enterTrace(n, k, matrix);

		if (n > 2 && matrix[0][0] != matrix[1][1]) {
			matrix[1][1]--;
			matrix[2][2]++;
		} else if (n > 2 && matrix[n - 1][n - 1] != matrix[n - 2][n - 2]) {
			matrix[n - 2][n - 2]--;
			matrix[n - 3][n - 3]++;
		}
	}

	private static void enterTrace(int n, int k, int[][] matrix) {
		int minSum = k / n;
		int remain = k - n * minSum;
		if (k % n == 0)
			for (int x = 0; x < n; x++) {
				matrix[x][x] = k / n;
			}
		else {
			for (int x = 0; x < n; x++) {
				if (x >= (n - remain)) {
					matrix[x][x] = minSum + 1;
				} else {
					matrix[x][x] = minSum;
				}
			}
		}
	}

	private static void printMatrix(int[][] matrix, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j]);
				if (j != (n - 1)) {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	private static boolean canForm(int n, int k) {
		if (n == 2 || n == 3)
			return k <= n * n && k % n == 0;
		return k != n + 1 && k != (n * n) - 1;
	}

	private static boolean fillSudoku(int[][] matrix, int n) {
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
				if (fillSudoku(matrix, n)) {
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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	private static String resultTest;

	static final String POSSIBLE = "POSSIBLE";
	static final String IMPOSSIBLE = "IMPOSSIBLE";

	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		// one line with a number of test cases
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

		// boucle for testCases #x = i
		for (int itc = 1; itc <= t; ++itc) {
			int n = in.nextInt(); // N size de la matriz
			int k = in.nextInt(); // K sum de la traza

			// Init matrix
			int[][] matrix = new int[n][n];
			int[] sumandos = descomponKenNsumandos(k, n);

			rellenarMatriz(matrix, sumandos);

			if (solveSudoku(matrix, n)) {
				System.out.println("Case #" + itc + ": " + POSSIBLE);
				System.out.println(pintarMatrix(n, matrix)); // print solution
			} else {
				System.out.println("Case #" + itc + ": " + IMPOSSIBLE);
			}
		}
	}

	private static boolean solveSudoku(int[][] board, int n) {
		int row = -1;
		int col = -1;
		boolean isEmpty = true;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 0) {
					row = i;
					col = j;

					// we still have some remaining
					// missing values in Sudoku
					isEmpty = false;
					break;
				}
			}
			if (!isEmpty) {
				break;
			}
		}

		// no empty space left
		if (isEmpty) {
			return true;
		}

		// else for each-row backtrack
		for (int num = 1; num <= n; num++) {
			if (isSafe(board, row, col, num)) {
				board[row][col] = num;
				if (solveSudoku(board, n)) {
					// print(board, n);
					return true;
				} else {
					board[row][col] = 0; // replace it
				}
			}
		}
		return false;
	}

	public static boolean isSafe(int[][] board, int row, int col, int num) {
// row has the unique (row-clash) 
		for (int d = 0; d < board.length; d++) {
// if the number we are trying to  
// place is already present in  
// that row, return false; 
			if (board[row][d] == num) {
				return false;
			}
		}

// column has the unique numbers (column-clash) 
		for (int r = 0; r < board.length; r++) {
// if the number we are trying to 
// place is already present in 
// that column, return false; 

			if (board[r][col] == num) {
				return false;
			}
		}

// if there is no clash, it's safe 
		return true;
	}

	static int[] descomponKenNsumandos(int k, int n) {
		// n < k < n**2
		// 1 < numeros < n

		int[] sumandos = new int[n];
		Arrays.fill(sumandos, 0, sumandos.length, n);

		int index = 0;
		while (sumArray(sumandos) != k) {
			if (sumandos[index] == 1) {
				index = index + 1;
			} else {
				sumandos[index] = sumandos[index] - 1;
			}
		}
		return sumandos;
	}

	static void rellenarMatriz(int[][] matrix, int[] sumandos) {
		for (int i = 0; i < sumandos.length; i++) {
			matrix[i][i] = sumandos[i];
		}
	}

	private static int sumArray(int[] array) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum = sum + array[i];
		}
		return sum;
	}

	private static int sumTraza(int[][] matrix) {
		int sum = 0;
		for (int i = 0; i < matrix.length; i++) {
			sum = sum + matrix[i][i];
		}
		return sum;
	}

	static String pintarMatrix(int n, int[][] matrix) {
		// pintamos la matriz
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(matrix[i][j]);
				sb.append(" ");
			}
			if (i != (n - 1)) {
				sb.append("\r\n");
			}
		}
		return sb.toString();
	}

	public static String getResultTest() {
		return resultTest;
	}

	public static void setResultTest(String result) {
		resultTest = result;
	}
}

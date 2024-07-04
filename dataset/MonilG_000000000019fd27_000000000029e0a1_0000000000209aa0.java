 import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			for (int i = 0; i < t; i++) {
				
				String kr = br.readLine();
				int n = Integer.parseInt(kr.split(" ")[0]);
				int k = Integer.parseInt(kr.split(" ")[1]);
				
				int[][] matrix = new int[n][n];
				int[][] valPresent = new int[n][n];

				int initialValue = getLargeValue(k, n);

				if (solveIndicium(matrix, valPresent, 0, 0, n, k, initialValue)) {
					System.out.format("Case #%d: POSSIBLE%n", i);
					printMatrix(matrix);
				} else {
					System.out.format("Case #%d: IMPOSSIBLE%n", i);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static boolean solveIndicium(int[][] m, int[][] valPresent, int col, int row, int n, int k,
			int initialValue) {

		if (row == n) {
			return true;
		}

		if (initialValue <= 0) {
			return false;
		}

		for (int i = 0; i < n; i++) {
			m[row][i] = 0;
			valPresent[row][i] = 0;
		}

		m[row][row] = initialValue;
		valPresent[row][initialValue - 1] = 1;
		int cellIndex = row == 0 ? 1 : 0;

		boolean workd = false;
		if (placeRemainingRowValues(m, valPresent, row, col, n, cellIndex, initialValue)) {
			initialValue = getNewInitialValue(m, k, n, row);
			workd = checkAndUpdateValue(m, valPresent, col, row + 1, n, k, initialValue);
		} else {
			workd = checkAndUpdateValue(m, valPresent, col, row, n, k, m[row][row] - 1);
		}

		if (isValueZero(m) || !checkTrace(m, k)) {
			workd = checkAndUpdateValue(m, valPresent, col, row, n, k, m[row][row] - 1);
		}

		return workd;
	}

	public static boolean checkAndUpdateValue(int[][] m, int[][] valPresent, int col, int row, int n, int k,
			int initialValue) {
		if (row == n) {
			return true;
		}

		return solveIndicium(m, valPresent, 0, row, n, k, initialValue);
	}

	public static boolean placeRemainingRowValues(int[][] m, int[][] valPresent, int row, int col, int n, int cellIndex,
			int initialValue) {

		if (cellIndex >= n) {
			return true;
		}

		boolean workd = false;
		int[] alreadyVisited = new int[n];
		if (cellIndex == row || isCellInsertionSuccessful(m, valPresent, row, col, n, cellIndex, 0, alreadyVisited)) {
			workd = placeRemainingRowValues(m, valPresent, row, col, n, cellIndex + 1, initialValue);
		} else {

			workd = false;
		}

		return workd;
	}

	public static boolean isCellInsertionSuccessful(int[][] m, int[][] valPresent, int row, int col, int n,
			int cellIndex, int startIndex, int[] alreadyVisited) {
		boolean successful = false;

		int fistRemainingValue = getFirstRemainingValue(m, valPresent, row, col, n, cellIndex, startIndex,
				alreadyVisited);

		if (fistRemainingValue != -1) {
			m[row][cellIndex] = fistRemainingValue;
			valPresent[row][fistRemainingValue - 1] = 1;
			successful = true;

		} else {
			successful = false;
		}

		return successful;
	}

	public static int getFirstRemainingValue(int[][] m, int[][] valPresent, int row, int col, int n, int cellIndex,
			int startIndex, int[] alreadyVisited) {
		int val = -1;
		for (int i = startIndex; i < n; i++) {
			if (valPresent[row][i] != 1) {
				val = i + 1;
				startIndex = i;
				break;
			}
		}
		if (val != -1) {
			if (isValuePresentInColumn(m, row - 1, cellIndex, val)) {
				val = getFirstRemainingValue(m, valPresent, row, col, n, cellIndex, startIndex + 1, alreadyVisited);
			}
		}

		if (val == -1) {

			for (int i = 0; i < startIndex; i++) {
				if (alreadyVisited[i] == 1) {
					val = -1;
					break;
				} else if (valPresent[row][i] != 1) {
					val = i + 1;
					startIndex = i;
					alreadyVisited[i] = 1;
					break;
				}
			}
		}
		if (val != -1) {
			if (isValuePresentInColumn(m, row - 1, cellIndex, val)) {
				val = getFirstRemainingValue(m, valPresent, row, col, n, cellIndex, startIndex + 1, alreadyVisited);
			}
		}
		return val;
	}

	public static boolean isValuePresentInColumn(int[][] m, int rowCount, int col, int value) {
		boolean present = false;

		for (int i = 0; i <= rowCount; i++) {
			if (m[i][col] == value) {
				present = true;
				break;
			}
		}

		return present;
	}

	public static boolean checkTrace(int[][] m, int k) {
		int count = 0;
		for (int i = 0; i < m.length; i++) {
			count += m[i][i];
		}
		return k == count;
	}

	public static boolean isValueZero(int[][] m) {
		boolean present = false;
		for (int i = 0; i < m.length; i++) {
			if (m[i][i] == 0) {
				present = true;
				break;
			}
		}
		return present;
	}

	public static int getNewInitialValue(int[][] m, int k, int n, int row) {
		int count = 0;
		for (int i = 0; i <= row; i++) {
			count += m[i][i];
		}
		return (k - count > n) ? n : (k - count);
	}

	public static int getLargeValue(int k, int n) {
		return k > n ? n : k;
	}

	public static void printMatrix(int[][] m) {
		int rowLen = m.length;
		int colLen = m[0].length;

		for (int i = 0; i < rowLen; i++) {
			for (int j = 0; j < colLen; j++) {
				System.out.print(m[i][j]);
				if ((j + 1) != colLen) {
					System.out.print(" ");
				}
			}
			System.out.println("");
		}
	}
}

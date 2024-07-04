import java.util.*;

/**
 * Made and solved successfully by the Prodigy Programmer
 * @author Julian Paniagua
 */
public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int squareSize = scanner.nextInt();
			int[][] matrix = new int[squareSize][squareSize];
			int trace = scanner.nextInt();
			if ((trace % squareSize) == 0) {
				//Fill matrix
				int traceSum = trace / squareSize;
				for (int i = 0; i < squareSize; i++)
					matrix[i][i] = traceSum;
				for (int col = 0; col < squareSize; col++) {
					boolean past = false;
					int value = traceSum;
					for (int row = col; true; row++) {
						if (row >= squareSize) {
							row = 0;
							past = true;
						}
						int cell = matrix[row][col];
						if (cell == traceSum) {
							if (past) break;
							else continue;
						}
						value++;
						if (value > squareSize) {
							value = 1;
						}
						matrix[row][col] = value;
					}
				}
				System.out.println("Case #" + t + ": POSSIBLE");
				printMatrix(matrix);
			} else {
				System.out.println("Case #" + t + ": IMPOSSIBLE");
			}
		}
	}

	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
				if (matrix.length >= 10 && j < 10)
					System.out.print(" ");
			}
			System.out.println();
		}
	}

}
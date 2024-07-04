import java.util.Scanner;

public class Vestigium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int numOfTestCases = sc.nextInt();
		int matrixSize = 0, cases = 0, i = 0, j = 0, k = 0;
		int[] diagonalSum = new int[numOfTestCases], rowRepeat = new int[numOfTestCases],
				colRepeat = new int[numOfTestCases];
		int[][] originalMatrix = null;

		try {
			for (cases = 0; cases < numOfTestCases; cases++) {
				matrixSize = sc.nextInt();
				originalMatrix = new int[matrixSize][matrixSize];
				for (j = 0; j < matrixSize; j++) {
					for (k = 0; k < matrixSize; k++) {
						originalMatrix[j][k] = sc.nextInt();
					}
				}
				diagonalSum[cases] = 0;
				rowRepeat[cases] = 0;
				colRepeat[cases] = 0;
				for (i = 0; i < matrixSize; i++) {
					/* System.out.println(""); */
					for (j = 0; j < matrixSize; j++) {
						/* System.out.print(originalMatrix[i][j]+" "); */
						if (i == j)
							diagonalSum[cases] += originalMatrix[i][j];
					}
				}

				for (i = 0; i < matrixSize; i++) {
					for (j = 0; j < matrixSize; j++) {
						int currRowValue = originalMatrix[i][j];
						for (k = j + 1; k < matrixSize; k++) {
							if (currRowValue == originalMatrix[i][k]) {
								rowRepeat[cases] += 1;
								break;
							}
						}
						if (k < matrixSize) {
							if (currRowValue == originalMatrix[i][k])
								break;
						}
					}
				}

				for (i = 0; i < matrixSize; i++) {
					for (j = 0; j < matrixSize; j++) {
						int currColValue = originalMatrix[j][i];
						for (k = j + 1; k < matrixSize; k++) {
							if (currColValue == originalMatrix[k][i]) {
								colRepeat[cases] += 1;
								break;
							}
						}
						if (k < matrixSize) {
							if (currColValue == originalMatrix[k][i])
								break;
						}
					}
				}
			}
			for (cases = 0; cases < numOfTestCases; cases++) {
				System.out.println("Case #" + (cases + 1) + ": " + diagonalSum[cases] + " " + rowRepeat[cases] + " "
						+ colRepeat[cases]);
			}
			sc.close();
		} catch (Exception ex) {
			System.out.println("Error : " + ex.getMessage());
		}
	}
}

import java.util.Scanner;

public class Sol1 {

	public static void Main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int numberOfMatrices = scnr.nextInt();

		for (int i = 0; i < numberOfMatrices; i++) {
			scnr.nextLine();
			AnalyzeMatrix(scnr, i + 1);
		}

	}

	private static void AnalyzeMatrix(Scanner colScnr, int currMatrix) {
		int matrixSize = colScnr.nextInt();
		colScnr.nextLine();
		int[][] matrix = new int[matrixSize][matrixSize];
		int traceSize = 0;
		int columnRepeat = 0;
		int rowRepeat = 0;
		boolean repFound;
		for (int i = 0; i < matrixSize; i++) {// this gets the column and row of matrix
			repFound = false;
			for (int j = 0; j < matrixSize; j++) {
				matrix[i][j] = colScnr.nextInt();

				if (!repFound) {
					for (int k = 0; k < j; k++) {
						if (matrix[i][k] == matrix[i][j]) {
							repFound = true;
							rowRepeat++;
						}
					}

				}
				colScnr.nextLine();
			}
		}
		for (int i = 0; i < matrixSize; i++) {

			for (int j = 0; j < matrixSize; j++) {
				if(i==j) {
					traceSize+=matrix[i][j];	
				}
				if(matrix[i][i] == matrix[i][j]) {
					if(j<i) {
						traceSize+= matrix[i][j];
					}
					columnRepeat++;
					break;
				}
			}

		}
		System.out.println("Case #" + currMatrix + " " + matrixSize + " " + columnRepeat + " " + rowRepeat);
	}
}

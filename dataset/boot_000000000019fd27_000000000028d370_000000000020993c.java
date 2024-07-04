import java.util.Scanner;

public class Solution {

	private Scanner scanner;

	private int[][] matrix;
	private int matrixSize;

	public Solution(Scanner scanner) {
		this.scanner = scanner;
	}

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {

			Solution solution = new Solution(scanner);

			int testCases = scanner.nextInt();

			for (int tc = 1; tc <= testCases; tc++) {

				System.out.printf("Case #%d:", tc);

				solution.processInput();
				solution.solve();

				System.out.println();
			}
		}
	}

	void processInput() {
		matrixSize = scanner.nextInt();
		matrix = new int[matrixSize][matrixSize];

		for (int i = 0; i < matrixSize; i++) {
			for (int j = 0; j < matrixSize; j++) {
				matrix[i][j] = scanner.nextInt();
			}
		}
	}

	void solve() {
		int[][] ocurrencesCountInRow = new int[matrixSize][matrixSize + 1];
		int[][] ocurrencesCountInColumn = new int[matrixSize][matrixSize + 1];

		boolean[] rowHasRepeatedElements = new boolean[matrixSize];
		boolean[] columnHasRepeatedElements = new boolean[matrixSize];

		for (int i = 0; i < matrixSize; i++) {
			for (int j = 0; j < matrixSize; j++) {
				if (++ocurrencesCountInRow[i][matrix[i][j]] > 1) {
					rowHasRepeatedElements[i] = true;
				}
				if (++ocurrencesCountInColumn[j][matrix[i][j]] > 1) {
					columnHasRepeatedElements[j] = true;
				}
			}
		}

		int trace = 0;
		int rowsWithRepeatedElements = 0;
		int columnsWithRepeatedElements = 0;

		for (int i = 0; i < matrixSize; i++) {
			if (rowHasRepeatedElements[i]) {
				rowsWithRepeatedElements++;
			}
			if (columnHasRepeatedElements[i]) {
				columnsWithRepeatedElements++;
			}
			trace += matrix[i][i];
		}

		System.out.printf(" %d %d %d", trace, rowsWithRepeatedElements, columnsWithRepeatedElements);
	}
}
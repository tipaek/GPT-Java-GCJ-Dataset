import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {

		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int testCases = scanner.nextInt();

		if (100 < testCases || testCases < 1)
			extracted();

		int[][] output = new int[testCases][];

		for (int t = 0; t < testCases; t++) {

			int n = scanner.nextInt();
			
			if(n<2 || n>100)
				extracted();

			int[][] matrix = new int[n][n];

			for (int row = 0; row < n; row++) {
				for (int col = 0; col < n; col++) {

					int temp = scanner.nextInt();
					
					if(temp<1 || temp>n)
						extracted();
					
					matrix[row][col] = temp;

				}
			}

			int trace = 0;

			for (int row = 0; row < n; row++) {
				for (int col = 0; col < n; col++) {

					if (row == col) {
						trace += matrix[row][row];
					}

				}
			}

			boolean found = false;

			int dupCol = 0;

			for (int col = 0; col < n; col++) {
				for (int row = 0; row < n; row++) {
					for (int k = row + 1; k < n; k++) {

						if (matrix[row][col] == matrix[k][col]) {
							dupCol += 1;
							found = true;
							break;
						}

					}
					if (found) {
						found = false;
						break;
					}

				}
			}

			int dupRow = 0;

			for (int row = 0; row < n; row++) {
				for (int col = 0; col < n; col++) {
					for (int k = col + 1; k < n; k++) {

						if (matrix[row][col] == matrix[row][k]) {
							dupRow += 1;
							found = true;
							break;
						}

					}
					if (found) {
						found = false;
						break;
					}

				}
			}

			output[t] = new int[]{trace,dupRow,dupCol};

		}
		
		for (int i = 0; i < testCases; i++) {
			System.out.println("Case #" + (i + 1) + ": " + output[i][0] + " " + output[i][1] + " " + output[i][2]);
		}

	}

	private static void extracted() throws Exception {
		throw new Exception();
	}

}

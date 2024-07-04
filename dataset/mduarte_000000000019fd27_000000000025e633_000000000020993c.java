import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int testCase = 1; testCase <= t; ++testCase) {
			int size = in.nextInt();
			int[][] matrix = new int[size][size];

			int latin = 0;
			boolean[][] cols = new boolean[matrix.length][matrix.length];
			int countRows = 0;
			int[] arrCountCols = new int[matrix.length];

			for (int i = 0; i < matrix.length; i++) {
				boolean[] rows = new boolean[matrix.length];
				int lineRow = 0;
				for (int j = 0; j < matrix.length; j++) {
					int num = in.nextInt();
					matrix[i][j] = num;
					if (i == j) {
						latin += matrix[i][j];
					}
					if (rows[num-1]) {
						lineRow = 1;
					}
					rows[num-1] = true;
					if (cols[j][num-1]) {
						arrCountCols[j] = 1;
					}
					cols[j][num-1] = true;
				}
				countRows += lineRow;
			}
			int countCols = 0;
			for (int i = 0; i < matrix.length; i++) {
				countCols += arrCountCols[i];
			}

			System.out.println("Case #" + testCase + ": " + latin + " " + countRows + " " + countCols);
		}
		in.close();

	}

	private static void readMatrix(Scanner in, int[][] matrix) {

	}

}

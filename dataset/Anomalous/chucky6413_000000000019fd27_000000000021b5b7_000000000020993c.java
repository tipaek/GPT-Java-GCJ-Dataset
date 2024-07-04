import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	private static final Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	private static final PrintWriter writer = new PrintWriter(System.out);
	private static final StringBuilder result = new StringBuilder();
	private static final String NEW_LINE = "\n";

	public static void main(String[] args) {
		int testCases = scanner.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int size = scanner.nextInt();
			int[][] matrix = new int[size][size];
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					matrix[i][j] = scanner.nextInt();
				}
			}

			result.append(String.format("Case #%d: ", t))
				.append(computeResult(size, matrix))
				.append(NEW_LINE);
		}
		writer.print(result.toString());
		writer.close();
	}

	private static String computeResult(int size, int[][] matrix) {
		int trace = 0;
		int rowDuplicates = 0;
		int colDuplicates = 0;

		for (int i = 0; i < size; i++) {
			Set<Integer> rowSet = new HashSet<>();
			Set<Integer> colSet = new HashSet<>();
			for (int j = 0; j < size; j++) {
				if (i == j) {
					trace += matrix[i][j];
				}
				rowSet.add(matrix[i][j]);
				colSet.add(matrix[j][i]);
			}
			if (rowSet.size() < size) {
				rowDuplicates++;
			}
			if (colSet.size() < size) {
				colDuplicates++;
			}
		}

		return trace + " " + rowDuplicates + " " + colDuplicates;
	}
}
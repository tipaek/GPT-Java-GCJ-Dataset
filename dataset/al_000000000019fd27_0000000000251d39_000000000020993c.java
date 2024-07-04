import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCount = scanner.nextInt();

		for (int i = 0; i < testCount; i++) {
			int size = scanner.nextInt();
			int[][] matrix = new int[size][size];
			for (int row = 0; row < size; row++) {
				for (int column = 0; column < size; column++) {
					matrix[row][column] = scanner.nextInt();
				}
			}
			solve(matrix, i + 1);
		}

	}

	private static void solve(int[][] matrix, int problemCount) {
		Map<Integer, Set<Integer>> shownRow = new HashMap<>();
		Map<Integer, Set<Integer>> shownColumn = new HashMap<>();
		int duplicatedRowCount = 0;
		int duplicatedColumnCount = 0;
		int diagonalSum = 0;
		for (int row = 0; row < matrix.length; row++) {
			for (int column = 0; column < matrix.length; column++) {
				int value = matrix[row][column];
				if (row == column) {
					diagonalSum += value;
				}

				if (!shownRow.containsKey(row)) {
					shownRow.put(row, new HashSet<>());
				}
				Set<Integer> rowValues = shownRow.get(row);
				if (rowValues.contains(value) && rowValues.size() == column) {
					duplicatedRowCount++;
				}
				if (!shownColumn.containsKey(column)) {
					shownColumn.put(column, new HashSet<>());
				}
				Set<Integer> columnValues = shownColumn.get(column);
				if (columnValues.contains(value) && columnValues.size() == row) {
					duplicatedColumnCount++;
				}
				rowValues.add(value);
				columnValues.add(value);
			}
		}
		System.out.println("Case #" + problemCount + ": " + diagonalSum + " " + duplicatedRowCount + " " + duplicatedColumnCount);
	}

}

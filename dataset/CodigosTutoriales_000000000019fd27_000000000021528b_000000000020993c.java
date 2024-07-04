import java.util.*;

/**
 * Made and solved successfully by the Prodigy Programmer
 * @author Julian Paniagua
 */
public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		for (int i = 1; i <= testCases; i++) {
			int matrixSize = scanner.nextInt();
			int[][] matrix = new int[matrixSize][matrixSize];
			int duplicateRows = 0;
			int duplicateCols = 0;
			for (int row = 0; row < matrix.length; row++) {
				for (int col = 0; col < matrix[row].length; col++) {
					int enteredColumn = scanner.nextInt();
					matrix[row][col] = enteredColumn;
				}
				if (containsDuplicates(matrix[row])) duplicateRows++;
			}
			for (int col = 0; col < matrixSize; col++) {
				int[] rowsInColumn = new int[matrixSize];
				for (int row = 0; row < matrixSize; row++) {
					rowsInColumn[row] = matrix[row][col];
				}
				if (containsDuplicates(rowsInColumn)) duplicateCols++;
			}
			System.out.println("Case #" + i + ": " + getMatrixTrace(matrix) + " " + duplicateRows + " " + duplicateCols);
		}
	}

	public static int getMatrixTrace(int[][] matrix) {
		int row = 0;
		int col = 0;
		int trace = 0;
		for (int i = 0; i < matrix.length; i++) {
			trace += matrix[row][col];
			row++;
			col++;
		}
		return trace;
	}

	public static boolean containsDuplicates(final int[] intvalues)
	{
		Set<Integer> lump = new HashSet<>();
		for (int i : intvalues)
		{
			if (lump.contains(i)) return true;
			lump.add(i);
		}
		return false;
	}

}
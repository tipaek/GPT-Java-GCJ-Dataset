import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
public class Solution {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			int[][] matrix = new int[n][n];
			for (int j = 0; j < n; j++) {
				for (int j2 = 0; j2 < n; j2++) {
					matrix[j][j2] = in.nextInt();
				}
			}
			printSummary(i, n, matrix);
		}
		in.close();
	}
	

	public static void printSummary(int testCase, int matrixLength , int[][] matrix) {

		int rowCount = 0;
		int columnCount = 0;
		int trace = 0;
		List<HashSet<Integer>> allColumnCounts = new ArrayList<HashSet<Integer>>(matrixLength);
		for (int j = 0; j < matrix.length; j++) {
			Set<Integer> rows = new HashSet<Integer>();
			for (int j2 = 0; j2 < matrix.length; j2++) {
				if(j == 0)allColumnCounts.add(new HashSet<Integer>());
				rows.add(matrix[j][j2]);
				if(j == j2) {
					trace += matrix[j][j2];
				}
				allColumnCounts.get(j2).add(matrix[j][j2]);
			}
			if(rows.size() != matrixLength) rowCount++;
		}
		for (HashSet<Integer> columns : allColumnCounts) {
			if(columns.size() != matrixLength) columnCount++;
		}
		System.out.println(String.format("Case #%s: %s %s %s", testCase, trace, rowCount, columnCount));
	}

	private static int[][] convertToArray(int matrixLength, String[] lines) {
		int[][] matrix = new int[matrixLength][matrixLength];
		int i = 0;
		for (int j = 0; j <matrixLength; j++, i++) {
			String[] row= lines[j].split(" ");
			int k = 0;
			for (String string : row) {
				matrix[i][k++] = Integer.parseInt(string);
			}
		}
		return matrix;
	}

}

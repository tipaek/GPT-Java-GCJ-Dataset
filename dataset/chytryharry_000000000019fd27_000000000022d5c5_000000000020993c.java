import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int matrixSize = in.nextInt();
			int[][] matrix = new int[matrixSize][matrixSize];
			for (int j = 0; j < matrixSize; j++) {
				for (int k = 0; k < matrixSize; k++) {
					matrix[j][k] = in.nextInt();
				}
			}
			System.out.println("Case #" + i + ": " + analyzeMatrix(matrix, matrixSize));
		}
	}
	
public static String analyzeMatrix(int[][] matrix, int matrixSize) {
		int trace = 0;
		int repeatedRows = 0;
		int repeatedColumns = 0;
		for (int i = 0;i<matrixSize;i++) {
				trace+=matrix[i][i];
		}

		for (int i = 0;i < matrixSize;i++) {
			List<Integer> list = new ArrayList<>();
			list.add(matrix[i][0]);
			for (int j = 1; j < matrixSize; j++) {
				if (list.contains(matrix[i][j])) {
					repeatedRows++;
					break;
				} else {
					list.add(matrix[i][j]);
				}
			}
		}

		for (int i = 0;i < matrixSize;i++) {
			List<Integer> list = new ArrayList<>();
			list.add(matrix[0][i]);
			for (int j = 1; j < matrixSize; j++) {
				if (list.contains(matrix[j][i])) {
					repeatedColumns++;
					break;
				} else {
					list.add(matrix[j][i]);
				}
			}
		}
		return trace + " " + repeatedRows + " " + repeatedColumns;
	}
 
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int numberOfTests = in.nextInt();
		for (int i = 1; i <= numberOfTests; i++) {
			int actualSizeOfSquare = in.nextInt();
			int[][] matrix = new int[actualSizeOfSquare][actualSizeOfSquare];
			for (int j = 0; j < actualSizeOfSquare; j++) {
				for (int k = 0; k < actualSizeOfSquare; k++) {
					matrix[j][k] = in.nextInt();
				}
			}
			int trace = calculateTrace(matrix);
			int row = calculateRepeatedElementsInRow(matrix);
			int col = calculateRepeatedElementsInCol(matrix);
			printMatrix(matrix, i, trace, row, col);			
		}
	}

	private static int calculateRepeatedElementsInRow(int[][] matrix) {
		int result = 0;
		for (int i = 0; i < matrix.length; i++) {
			int[] actualRow = matrix[i];
			List<Integer> list = new LinkedList<Integer>();
			for (int j = 0; j < actualRow.length; j++) {
				list.add(actualRow[j]);
			}
			Collections.sort(list);
			for (int j = 0; j < list.size()-1; j++) {
				if(list.get(j) == list.get(j+1)) {
					result++;
					break;
				}
			}
		}
		return result;
	}
	
	private static int calculateRepeatedElementsInCol(int[][] matrix) {
		int result = 0;
		for (int i = 0; i < matrix.length; i++) {
			int[] actualCol = new int[matrix[0].length];
			for (int j = 0; j < matrix[i].length; j++) {
				actualCol[j] = matrix[j][i];
			}
			List<Integer> list = new LinkedList<Integer>();
			for (int j = 0; j < actualCol.length; j++) {
				list.add(actualCol[j]);
			}
			Collections.sort(list);
			for (int j = 0; j < list.size()-1; j++) {
				if(list.get(j) == list.get(j+1)) {
					result++;
					break;
				}
			}
		}
		return result;
	}

	private static int calculateTrace(int[][] matrix) {
		int result = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if(i == j)
					result += matrix[i][j];
			}
		}
		return result;
	}

	public static void print(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void printMatrix(int[][] matrix, int number, int trace, int row, int col) {
		System.out.println("Case #" + number + ": " + trace + " " + row + " " + col);
	}
}

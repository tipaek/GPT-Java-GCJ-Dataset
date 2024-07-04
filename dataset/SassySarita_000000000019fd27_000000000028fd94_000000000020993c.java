import java.util.*;
import java.io.*;

/**
 * Problem 1
 */
public class Solution {
	
	public static void main(String[] args) {
		 
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		//fetch the number of test cases
		int testCaseNumber = in.nextInt();
		//fetch the first matrix number
		for (int test = 1; test <= testCaseNumber; test++) {
			int size = in.nextInt();
			int[][] matrix = new int[size][size];
		
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					int element = in.nextInt();
					matrix[i][j] = element;
				}
			}
		findOutput(test, size, matrix);
		}
		in.close();
	}

	private static void findOutput(int number, int size1, int[][] matrix) {
		int trace = 0;
		//calculate trace
		for (int i = 0; i < size1; i++) {
			trace = trace + matrix [i][i];
		}
		//calculate duplicate
		int duplicateRows = 0;
		int duplicateColumns = 0;
		for (int i = 0; i < size1; i++) {
			for (int j = 0; j < size1; j++) {
				boolean isRow = ifDuplicateRow(matrix, i, j, size1);
				if (isRow) {
					duplicateRows++;
					break;
				}
			}
		}
		for (int j = 0; j < size1; j++) {
			for (int i = 0; i < size1; i++) {
				boolean isColumn = ifDuplicateColumn(matrix, i, j , size1);
				if (isColumn) {
					duplicateColumns++;
					break;
				}
			}
		}
		System.out.println("Case #" + number + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
	}

	private static boolean ifDuplicateRow(int[][] matrix, int hindex, int vindex, int size) {
		int element = matrix[hindex][vindex];
	    for (int i = 0; i < size; i++) {
		   if (i != vindex) {
			   if (matrix[hindex][i] == element) {
				   return true;
			   }
		   }
	   }
		return false;
	}
	
	private static boolean ifDuplicateColumn(int[][] matrix, int hindex, int vindex, int size) {
		int element = matrix[hindex][vindex];
	    for (int i = 0; i < size; i++) {
		   if (i != hindex) {
			   int compareElement = matrix[i][vindex];
			   if (compareElement == element) {
				   return true;
			   }
		   }
	   }
		return false;
	}
}
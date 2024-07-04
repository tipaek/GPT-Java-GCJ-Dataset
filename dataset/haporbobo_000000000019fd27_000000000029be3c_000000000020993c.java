import java.util.*;
import java.io.*;

class Vestigium {
	public static void main(String[] args) {
		//input:
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int numOfTestCase = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc. //# of Test cases
		for (int t = 1; t <= numOfTestCase; t++) {
			int size = in.nextInt();
			int[][] matrix = new int[size][size];
			for (int i = 0; i < size; i ++) {
				for (int j = 0; j < size; j++) {
					matrix[i][j] = in.nextInt();
				}
			}
			int k = computeTrace(matrix, matrix[0].length);
			int r = getNumOfRepeatedRows(matrix, matrix[0].length);
			int c = getNumOfRepeatedCols(matrix, matrix[0].length);
			System.out.println("Case #" + t + ": " + k + " " + r + " " + c);
		}
		
		// int[][] matrix = {{0, 1, 2, 3}, {1, 2, 3, 0}, {2, 3, 0, 1}, {3, 0, 1, 2}};
		// int[][] matrix = {{0, 3, 0, 3}, {1, 0, 1, 0}, {2, 1, 2, 1}, {3, 2, 3, 2}};
		// int k = computeTrace(matrix, matrix[0].length);
		// int r = getNumOfRepeatedRows(matrix, matrix[0].length);
		// int c = getNumOfRepeatedCols(matrix, matrix[0].length);
		// System.out.println("k: " + k + " r: " + r + " c: " + c);
	}

	
	//sum of the values on the main diagonal (k)
	public static int computeTrace(int[][] matrix, int size) {
		// sum: 0
		// i from 0 to (size-1)
		// 	sum += matix[i][i]
		int sum = 0;
		for (int i = 0; i < size; i ++) {
			sum += matrix[i][i];
		}
		return sum;
	}

	//r
	public static int getNumOfRepeatedRows(int[][] matrix, int size) {
		//NumOfRepeatedRows: 0
		//for i : from 0 to (size - 1) //row
		//	hashSetPerRow stores value: marix[i][j]
		// 	for j: from 0 to (size - 1) //col
		// 		if hashSetPerRow has the same value as current: NumOfRepeatedRows++ and break loop
		// 		else hashSetPerRow stores the current value
		int numOfRepeatedRows = 0;
		for (int i = 0; i < size; i++) {
			Set hashSetPerRow = new HashSet<>();
			for (int j = 0; j < size; j++) {
				if (hashSetPerRow.contains(matrix[i][j])) {
					numOfRepeatedRows++;
					break;
				} else {
					hashSetPerRow.add(matrix[i][j]);
				}
			}
		}
		return numOfRepeatedRows;
	}

	//c
	public static int getNumOfRepeatedCols(int[][] matrix, int size) {
		//NumOfRepeatedRows: 0
		//for i : from 0 to (size - 1) //row
		//	hashSetPerRow stores value: marix[i][j]
		// 	for j: from 0 to (size - 1) //col
		// 		if hashSetPerRow has the same value as current: NumOfRepeatedRows++ and break loop
		// 		else hashSetPerRow stores the current value
		int numOfRepeatedCols = 0;
		for (int j = 0; j < size; j++) {
			Set hashSetPerCol = new HashSet<>();
			for (int i = 0; i < size; i++) {
				if (hashSetPerCol.contains(matrix[i][j])) {
					numOfRepeatedCols++;
					break;
				} else {
					hashSetPerCol.add(matrix[i][j]);
				}
			}
		}
		return numOfRepeatedCols;
	}
}

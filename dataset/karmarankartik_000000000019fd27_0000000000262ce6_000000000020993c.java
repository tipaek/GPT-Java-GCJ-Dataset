package test;

import java.util.HashSet;
import java.util.Scanner;

 class Answer {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		short noOfTestCases = sc.nextShort();

		for (int k = 1; k <= noOfTestCases; k++) {
			int size = sc.nextInt();
			int[][] matrix = new int[size][size];

			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					matrix[i][j] = sc.nextInt();
				}
			}

			generateOutput(matrix, size, k);

		}
     sc.close();
	}

	private static void generateOutput(int matrix[][], int size, int test) {
		int sum = 0;
		HashSet<Integer> rowSet = new HashSet<>();
		boolean rowRepeatFlag = false;
		HashSet<Integer> colSet = new HashSet<>();
		boolean colRepeatFlag = false;
		int noOfDuplicateRows = 0;
		int noOfDuplicateColumns = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i == j) {
					sum += matrix[i][j];
				}
				if (rowSet.add(matrix[i][j]) == false && !rowRepeatFlag) {
					noOfDuplicateRows++;
					rowRepeatFlag = true;
				}
				if (colSet.add(matrix[j][i]) == false && !colRepeatFlag) {
					noOfDuplicateColumns++;
					colRepeatFlag = true;
				}

			}
			rowSet.clear();
			colSet.clear();
			rowRepeatFlag = false;
			colRepeatFlag = false;
		}
		System.out.println("Case #" + test + ": " + sum + " " + noOfDuplicateRows + " " + noOfDuplicateColumns);

	}

}
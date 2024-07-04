
package com.ing.app.riskrater.taglib;

import java.util.HashSet;
import java.util.Scanner;


public class LatinSquare {

	public static void readMatrixByUser() {
		int i, j, m;
		
		Scanner in = null;
		try {

			in = new Scanner(System.in);
			int testcases = in.nextInt();
			
			int[][] resultMatrix = new int[testcases][3];
			// Read the matrix values
			for (m = 0; m < testcases; m++) {
				
				int matrixSize = in.nextInt();

				// Declare the matrix
				int matrix[][] = new int[matrixSize][matrixSize];
				
				for (i = 0; i < matrixSize; i++) {
					for (j = 0; j < matrixSize; j++)
						matrix[i][j] = in.nextInt();

				}
				int[] result = calculate(matrix);
				resultMatrix[m] = result;

			}

			for (i = 1; i <=  resultMatrix.length; i++) {
				System.out.print("Case #"+i+":");
				for (j = 0; j < resultMatrix[0].length; j++)
					System.out.print(resultMatrix[i][j]+ " ");
				System.out.println();
			}

		} catch (Exception e) {
		} finally {
			in.close();
		}
	}

	public static void main(String[] args) {
		readMatrixByUser();
	}

	static int[] calculate(int[][] matrix) {
		int[] result = new int[3];
		int sum = 0;
		int row = 0;
		int col = 0;

		for (int i = 0; i < matrix.length; i++) {
			HashSet<Integer> rowUnique = new HashSet<Integer>();
			HashSet<Integer> collUnique = new HashSet<Integer>();
			for (int j = 0; j < matrix.length; j++) {
				rowUnique.add(matrix[i][j]);
				collUnique.add(matrix[j][i]);
				if (i == j)
					sum = sum + matrix[i][j];
				
			}
			if (rowUnique.size() != matrix.length)
				row = row + 1;
			if (collUnique.size() != matrix.length)
				col = col + 1;
			
		}
		result[0] = sum;
		result[1] = row;
		result[2] = col;
		return result;
	}

}

import java.util.*;
import java.io.*;

class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCases = sc.nextInt();

		for(int testCase =1; testCase <=testCases ; testCase++) {

			int matrixSize = sc.nextInt();
			int[][] matrix = new int[matrixSize][matrixSize];
			for(int row=0; row<matrixSize ;row++)
			{
				for(int col=0; col<matrixSize; col++)
				{
					matrix[row][col] = sc.nextInt();
				}
			}
			determineNaturalMatrix(matrix, matrixSize, testCase);
		}


	}
	private static void determineNaturalMatrix(int[][] matrix, int matrixSize, int testCase) {

		int squareSum = 0;
		int repeatedRows = 0;
		int repeeatedCol = 0;

		for(int row=0; row<matrixSize ;row++)
		{
			boolean isRowRepeated = false;
			boolean isColRepeated = false;
			Map<Integer,Integer> rowMap = new HashMap<Integer,Integer>();
			Map<Integer,Integer> colMap = new HashMap<Integer,Integer>();
			for(int col=0; col<matrixSize; col++)
			{
				if( row == col) {
					squareSum += matrix[row][col];
				}

				if(rowMap.get(matrix[row][col]) != null && !isRowRepeated) {
					isRowRepeated = true;
					repeatedRows++;
				} else {
					rowMap.put(matrix[row][col], 1);
				}

				if(colMap.get(matrix[col][row]) != null && !isColRepeated) {
					isColRepeated = true;
					repeeatedCol++;
				}  else {
					colMap.put(matrix[col][row], 1);
				}
			}
		}
		
		display(squareSum ,repeatedRows, repeeatedCol, testCase);
		
		
	}
	private static void display(int squareSum, int repeatedRows, int repeeatedCol, int testCase) {

		System.out.println("Case #" +testCase + ": " + squareSum + " " + repeatedRows +" " + repeeatedCol);
	}

}

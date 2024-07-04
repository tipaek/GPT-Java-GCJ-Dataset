import java.util.*;
import java.io.*;
public class Solution {
	public static void printMatrix(int[][] matrix,int size) {
		for (int i=0;i<size;i++) {
			System.out.println();
			for (int j=0;j<size;j++) {
				System.out.print(matrix[i][j]+" ");
			}
		}
		System.out.println();
	}
	public static void processMatrix(int[][] matrix,int size) {
		int trace = 0;
		int countRowRepeat = 0;
		int countColumnRepeat =0;
		for (int i=0;i<size;i++)
		{
			// For each row
			boolean rowRepeat = false;
			boolean columnRepeat = false;
			for (int j=0;j<size;j++)
			{
				if (i==j) {
					trace = trace + matrix[i][j];
				}
				
				if (!rowRepeat) {
					int num = matrix[i][j];
					for (int k=j+1;k<size;k++) {
						if (num == matrix[i][k] ) {
							rowRepeat = true;
							break;
						}
					}
				}
				
				if (!columnRepeat) {
					int num1 = matrix[j][i];
					for (int k=j+1;k<size;k++) {
						if (num1 == matrix[k][i] ) {
							columnRepeat = true;
							break;
						}
					}
					
				}
			}
			if (rowRepeat)
				countRowRepeat++;
			if (columnRepeat)
				countColumnRepeat++;
		}
		System.out.print(trace+" "+countRowRepeat+" "+countColumnRepeat);
	}
	public static void main(String[] args){
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCases = in.nextInt();
		//System.out.println("There are "+testCases+" test cases");

		for (int i=0;i<testCases;i++)
		{
			// For each test case, read the size of the matrix
			int matrixSize = in.nextInt();
			//System.out.println("There are "+matrixSize+" lines in test case "+i);
			
			int[][] matrix = new int[matrixSize][matrixSize];
			for (int j=0;j<matrixSize;j++) {
				for (int k=0;k<matrixSize;k++) {
					matrix[j][k]=in.nextInt();
				}
			}// Matrix created
			//printMatrix(matrix,matrixSize);
			System.out.print("Case #"+(i+1)+": ");
			processMatrix(matrix,matrixSize);
			System.out.println();
		}	
		
	}

}

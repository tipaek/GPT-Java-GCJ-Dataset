import java.io.*;
import java.util.*;

/**
 * This is problem of matrix of size NxN, where we've to
 * return three things - 
 * 
 * 1. Trace count, sum of all elements falling on diagonal starting from top-left to bottom-right
 * 2. Count of rows having duplicate elements
 * 3. Count of columns having duplicate elements.
 * 
 * @author smandaokar
 *
 */
public class Solution {
	
	public static void main(String[] args) throws IOException {
		 Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		//System.out.println("Enter total number of test-cases.");
		int testCases = in.nextInt();
		int testCounter=1;
		
		while (testCounter <= testCases) {
//			System.out.println("Enter the size of matrix.. ");
			int N = in.nextInt();
			int[][] matrix = new int[N][N];
//			System.out.println("Enter " + N + " lines each containing matrix elements separated by space.");
			int count = 0;
			while (count < N) {
				
				int[] currArr = new int[N];
				for(int j=0; j<N; ++j) {
					currArr[j]=in.nextInt();
				}
				matrix[count] = currArr;
				count++;
			}
			
			//displayMatrix(matrix);
			computeMatrix(matrix, N, testCounter);
			testCounter++;
		}		
	}

	private static void computeMatrix(int[][] matrix, int n, int testCounter) {
		
		int traceCount=0, rowCount=0, columnCount=0;
		int rowIdx=0, colIdx=0; 
		
		 while(true) {
			 
			 if(rowIdx >= n || colIdx >= n) {
				 break;
			 }
			 
			 HashSet<Integer> processedData = new HashSet();
			 
			 //1. Compute trace count
			 if(rowIdx == colIdx) {
				 traceCount+= matrix[rowIdx][colIdx];
			 }
			 
			 //2. Compute row count
			 boolean duplicateRowFound=false;
			 for(int tempColumnIndex = 0; tempColumnIndex<n; ++tempColumnIndex) {
				 
				 if(!processedData.add(matrix[rowIdx][tempColumnIndex]) && (!duplicateRowFound)){
					 rowCount++;
					 duplicateRowFound=true;
				 }
			 }
			 processedData.clear();
			 
			//2. Compute row count
			 duplicateRowFound=false;
			 for(int tempRowIndex = 0; tempRowIndex<n; ++tempRowIndex) {
				 
				 if(!processedData.add(matrix[tempRowIndex][colIdx]) && (!duplicateRowFound)){
					 columnCount++;
					 duplicateRowFound=true;
				 }
			 }
			 processedData.clear();
			 
			 rowIdx++; colIdx++;
			 
		 }
		 
		 System.out.println("Case #"+testCounter+": " + traceCount + " " + rowCount+" " + columnCount);
		
	}

	private static void displayMatrix(int[][] matrix) {
			
		for(int i=0; i<matrix.length; ++i) {
			for(int j=0; j<matrix[i].length; j++) {
				System.out.print(matrix[i][j]+"\t");
			}
			System.out.println();
		}
	}

	private static int[] getMatrixElements(String[] matrixElements) {
		int[] outputArr = new int[matrixElements.length];
		
		for(int i=0; i< matrixElements.length; ++i) {
			outputArr[i] = Integer.valueOf(matrixElements[i]);
		}
		return outputArr;
	}

}

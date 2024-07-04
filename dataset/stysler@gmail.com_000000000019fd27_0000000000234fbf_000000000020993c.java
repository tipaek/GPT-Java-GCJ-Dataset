import java.util.*;
import java.io.*;
public class Solution{
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int testCase = 1; testCase <= testCases; ++testCase) {
        //each test case has matrix size
          int matrixSize = in.nextInt();
          int[][] matrix = new int[matrixSize][matrixSize];
          for(int row =0; row < matrixSize; row++) {
        	  for(int col=0; col< matrixSize; col++) {
        		  matrix[row][col]= in.nextInt();
        	  }        	  
          }
          System.out.println("Case #" + testCase + ": " + getMatrixTrace(matrix) + " " + getNumberOfRepeatedValuesInRows(matrix) + " " + getNumberOfRepeatedValuesInColumns(matrix));
        }
        in.close();
    }
    
    private static int getMatrixTrace(int[][] matrix) {
    	int result = 0;
    	for(int i = 0; i < matrix.length; i++) {
    		result += (matrix[i][i]);
    	}
		return result;
	}

	private static int getNumberOfRepeatedValuesInRows(int[][] matrix) {
		int totalRepeatedValues =0;
		for(int row = 0; row< matrix.length; row++) {
			HashSet<Integer> rowValues = new HashSet<>();
			for(int col = 0; col< matrix.length; col++) {
				rowValues.add(matrix[row][col]);
			}
			if(matrix.length - rowValues.size() != 0)totalRepeatedValues++;
		}
		return totalRepeatedValues;
	}
	

	private static int getNumberOfRepeatedValuesInColumns(int[][] matrix) {
		int totalRepeatedValues =0;
		for(int col = 0; col< matrix.length; col++) {
			HashSet<Integer> colValues = new HashSet<>();
			for(int row = 0; row< matrix.length; row++) {
				colValues.add(matrix[row][col]);
			}
			if(matrix.length - colValues.size() !=0) totalRepeatedValues++ ;			
		}
		return totalRepeatedValues;
	}    
    
}
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args)  {
		
		Scanner in = new Scanner(System.in);
		
	    int testNumber = in.nextInt();
	    
	    for (int k = 1; k <= testNumber; ++k) {

		    int matrixDimension = in.nextInt();
		    int trace = 0;
		    int row = 0;
		    int column = 0;
		    int[][] matrix = new int[matrixDimension][matrixDimension];
		    long sum = (matrixDimension * (matrixDimension + 1)) / 2;
		    // System.out.println("sum: " + sum);

		    int [] orderedArray = new int[matrixDimension];
		    
		    for (int i = 0; i < matrixDimension; i++) {
		    	orderedArray[i] = i + 1;
		    }
		    
		    for (int i = 0; i < matrixDimension; i++) {
		    	
		    	int rowSum = 0;
		    	int[] unorderedArray = new int[matrixDimension];

			    for (int j = 0; j < matrixDimension; j++) {
			    	
			    	matrix[i][j] = in.nextInt();
			    	rowSum += matrix[i][j];
			    	unorderedArray [j] = matrix[i][j];
			    	
			    }
			    
			    trace += matrix[i][i];
			    // System.out.println("i: " + i + "rowSum: " + rowSum);

			    if (rowSum != sum) {
			    	row ++;
			    } else {
			    	
			    	Arrays.sort(unorderedArray);
			    	if (!Arrays.equals(unorderedArray, orderedArray)) {
				    	row ++;
			    	}
			    	
			    }
			    
		    }
		    
		    for (int j = 0; j < matrixDimension; j++) {
		    	
		    	int columnSum = 0;
		    	int[] unorderedArray = new int[matrixDimension];

			    for (int i = 0; i < matrixDimension; i++) {
			    	
			    	columnSum += matrix[i][j];
			    	unorderedArray [i] = matrix[i][j];
			    	
			    }
			    
			    // System.out.println("j: " + j + "columnSum: " + columnSum);
			    if (columnSum != sum) {
			    	column ++;
			    } else {

			    	Arrays.sort(unorderedArray);
			    	if (!Arrays.equals(unorderedArray, orderedArray)) {
			    		column ++;
			    	}
			    	
			    }
		    	
		    }
	      
	    	System.out.println("Case #" + k + ": " + trace + " " + row + " " + column);
	      
	    }
		
	    
	}

}

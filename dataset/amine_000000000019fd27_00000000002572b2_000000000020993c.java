import java.util.Scanner;

public class Vestigium {

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
		    
		    for (int i = 0; i < matrixDimension; i++) {
		    	
		    	int rowSum = 0;

			    for (int j = 0; j < matrixDimension; j++) {
			    	
			    	matrix[i][j] = in.nextInt();
			    	rowSum += matrix[i][j];
			    	
			    }
			    
			    trace += matrix[i][i];
			    
			    if (rowSum != sum) {
			    	row ++;
			    }
			    
		    }
		    
		    for (int j = 0; j < matrixDimension; j++) {
		    	
		    	int columnSum = 0;

			    for (int i = 0; i < matrixDimension; i++) {
			    	
			    	columnSum += matrix[i][j];
			    	
			    }

			    if (columnSum != sum) {
			    	column ++;
			    }
		    	
		    }
	      
	    	System.out.println("Case #" + k + ": " + trace + " " + row + " " + column);
	      
	    }
		
	    
	}

}
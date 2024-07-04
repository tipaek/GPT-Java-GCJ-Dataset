import java.io.*;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in;
		try {
			in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
			int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		    
		    for (int counter = 1; counter <= t; ++counter) {
		    	int n = in.nextInt();
			    int[][] matrix =new int[n][n];
		      for(int i = 0 ; i < n; i++) {
		    	  for(int j = 0; j < n; j++) {
		    		  matrix[i][j] = in.nextInt();
		    	  }
		      }
		      
		    int trace = 0;
			int repeatedNumRow = 0; 
			int repeatedNumColumn = 0;
			boolean stop = false;
			for(int i = 0; i < n ; i++) {
				stop = false;
				for(int j = 0 ; j< n && !stop; j++)
					for(int k = 0 ; k< n && !stop; k++)
					if(k!=j && matrix[i][k] == matrix[i][j]) {
						repeatedNumRow++;
						stop = true;
					}
			    trace += matrix[i][i];   
			}  
		      
			for(int j = 0; j < n ; j++) {
				stop = false;
				for(int i = 0 ; i< n && !stop; i++)
					for(int k = 0 ; k< n && !stop; k++)
					if(k!=i && matrix[i][j] == matrix[k][j]) {
						repeatedNumColumn++;
						stop = true;
					}
			}    
			System.out.println("Case #" + counter + ": " + trace + " " + repeatedNumRow + " " + repeatedNumColumn);
		    }
		    in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	   
	    
	}
}

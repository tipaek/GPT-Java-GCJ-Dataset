import java.util.*;
import java.io.*;
public class Solution {

	public static void main(String[] args) {
		
		 Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		    int t = in.nextInt(); //number of test cases
		    for (int i = 1; i <= t; ++i) {
		    	int n = in.nextInt();
		    	int mat[][] = new int [n][n];
		    	for (int j = 0; j < n; j++) {
		    		for (int k = 0; k < n; k++) {
		    			mat[j][k] = in.nextInt(); //might have a problem if this overfills?
		    		}
		    	}
		    	
		    	//System.out.println(Arrays.deepToString(mat));
		    	
		    	int diag = 0; 
		        for (int z = 0; z < n; z++) { 
		            for (int j = 0; j < n; j++) {
		                if (z == j) 
		                    diag += mat[z][j];
		                    //System.out.println("diag " + diag);
		            }
		        }
		        
		        int row = 0;
		        for (int z = 0; z < n; z++) {
		            outerloop:
		            for (int j = 0; j < n; j++) {
		            	for (int c = j+1; c < n; c++) {
		            		if(mat[z][j] == mat[z][c]) {
			            		row = row + 1;
			            		//System.out.println("row " + row);
			            		break outerloop;
			            	}
			            	
		            	}
		            	
		            }    
		        }
		        
		        int column = 0;
		        for (int p = 0; p < n; p++) { 
		            outerloop:
		            for (int j = 0; j < n; j++) {
		            	for (int c = j+1; c < n; c++) {
		            		if(mat[j][p] == mat[c][p]) {
			            		column = column + 1;
			            		//System.out.println("column " + column);
			            		break outerloop;
			            	}
			            	
		            	}
		            	
		            }    
		        }
		      
		      System.out.println("Case #" + i + ": " + (diag) + " " + (row) + " " + (column));
		    }
	}
}
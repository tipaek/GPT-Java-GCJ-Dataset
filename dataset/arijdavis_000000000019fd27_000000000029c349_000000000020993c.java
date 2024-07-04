import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		//input
		Scanner stdin = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int cases = stdin.nextInt();  
	    
	    for(int t = 0; t < cases; t++) {
	    	
	    	//get matrix size
	    	int n = stdin.nextInt();
	    	
	    	//int[][] matrix = new int[n][n];
	    	//Arrays.fill(matrix, 0);
	    	
	    	int[][] row_freq = new int[n+1][n+1];	    	
	    	int[][] col_freq = new int[n+1][n+1];
	    	
	    	for(int i = 0; i < n+1; i++) {
	    		for(int j = 0; j < n+1; j++) {
	    			row_freq[i][j] = 0;
	    			col_freq[i][j] = 0;
	    		}
	    	}
	    	
	    	int trace = 0;
	    	int rows_w_reps = 0;
	    	int cols_w_reps = 0;
	    	
	    	boolean[] is_row_w_rep = new boolean[n+1];
	    	boolean[] is_col_w_rep = new boolean[n+1];
	    	
	    	//analyze NxN matrix read in
	    	for(int i = 1; i <= n; i++) {
	    		for(int j = 1; j <= n; j++) {
	    			
	    			//get value M at (i,j)
	    			int m = stdin.nextInt();
	    			
	    			//calculate trace
	    			if (i == j) {
	    				trace = trace + m;
	    			}
	    			
	    			//calculate freq of values in rows/columns
	    			row_freq[i][m]+= 1;
	    			col_freq[j][m]+= 1;
	    			
	    			//check if there exists repetition
	    			if (row_freq[i][m] > 1 && is_row_w_rep[i] == false) {
	    				is_row_w_rep[i] = true;
	    				rows_w_reps++;
	    			}
	    			
	    			if (col_freq[j][m] > 1 && is_col_w_rep[j] == false) {
	    				is_col_w_rep[j] = true;
	    				cols_w_reps++;
	    			}
	    		}
	    	}
	    	
	    	//output
	    	int x = t + 1;
		    System.out.println("Case #" + x + ": " + trace + " " + rows_w_reps + " " + cols_w_reps);
	    }
	}

}

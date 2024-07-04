import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
      
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  
    for (int k = 1; k <= t; ++k) {
        int n = in.nextInt();
     
        int[][] mat = new int[n][n];
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                mat[i][j] = in.nextInt();
            }
        }
        
        process(mat, n, k);
      
    }
  }
  
  private static void process(int[][] mat, int n, int x) {
	    
	    int k = 0;
	    int r = 0;
	    int c = 0;
	    
	    
	    for(int i=0; i<n; i++) {
	        Set<Integer> rowSet = new HashSet<>();
	        Set<Integer> colSet = new HashSet<>();
	        boolean rowDup = false;
	        boolean colDup = false;
	        
	        for(int j=0; j<n; j++) {
	            
	            if(!rowSet.add(mat[i][j])) {
	                rowDup = true;
	            }
	            
	            if(!colSet.add(mat[j][i])) {
	                colDup = true;
	            }
	            
	            if(i==j) {
	                k += mat[i][j];
	            }
	        }
	        
	        if(rowDup) {
	            r++;
	        }
	        
	        if(colDup) {
	            c++;
	        }
	    }
	    
	    System.out.println("Case #" + x + " " + k + " " + r + " " + c);
	    
	}
} 
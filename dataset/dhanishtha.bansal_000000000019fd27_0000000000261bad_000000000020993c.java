import java.util.*;
import java.lang.*;
import java.io.*;
class Solution
 {
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int test = Integer.parseInt(br.readLine()); 
        int idx = 1;
	    while(test > 0) {
	        int n = Integer.parseInt(br.readLine());
	        int col = 0;
	        int row = 0;
	        int[][] mat = new int[n][n];
	        int max = (n*(n+1))/2;
	        int[] colMax = new int[n];
	        int diag = 0;
	        
	        for(int i = 0; i < n; i++) {
	            colMax[i] = max;
	        }
	        for(int  i = 0 ; i < n; i++) {
	            int rowMax = max;
	            String[] vals = br.readLine().trim().split(" ");
	            for(int j = 0; j < n; j++) {
	                mat[i][j] = Integer.parseInt(vals[j]);
	                rowMax -= mat[i][j];
	                colMax[j] -= mat[i][j];
	                if(i == j) {
	                    diag += mat[i][j];
	                }
	            }
	            if(rowMax != 0) {
	                row++;
	            }
	        }
	        for(int i = 0; i < n; i++) {
	            if(colMax[i] != 0) {
	                col++;
	            }
	        }
	        
	        System.out.print("Case #" + idx + ": ");
	        System.out.println(diag + " " + row + " " + col);
	        test--;
	        idx++;
	    }
    }
	 
}

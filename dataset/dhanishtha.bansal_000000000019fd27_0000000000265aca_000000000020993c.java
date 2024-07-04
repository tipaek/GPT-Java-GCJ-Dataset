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
	        int colCount = 0;
	        int rowCount = 0;
	        int[][] mat = new int[n][n];
	        int diag = 0;
	        
	        for(int  i = 0 ; i < n; i++) {
	            HashSet<Integer> row = new HashSet<>();
	            boolean duplicate = false;
	            String[] vals = br.readLine().trim().split(" ");
	            for(int j = 0; j < n; j++) {
	                mat[i][j] = Integer.parseInt(vals[j]);
	                if(!row.contains(mat[i][j])) {
	                    row.add(mat[i][j]);
	                   
	                }
	                else {
	                     duplicate = true;
	                }
	                if(i == j) {
	                    diag += mat[i][j];
	                }
	            }
	            if(duplicate) {
	                rowCount++;
	            }
	        }
	        for(int  i = 0 ; i < n; i++) {
	            HashSet<Integer> col = new HashSet<>();
	            boolean duplicate = false;
	            for(int j = 0; j < n; j++) {
	                if(!col.contains(mat[j][i])) {
	                    col.add(mat[j][i]);
	                    
	                }
	                else {
	                     duplicate = true;
	                }
	            }
	            if(duplicate) {
	                colCount++;
	            }
	        }

	        
	        System.out.print("Case #" + idx + ": ");
	        System.out.println(diag + " " + rowCount + " " + colCount);
	        test--;
	        idx++;
	    }
    }
	 
}

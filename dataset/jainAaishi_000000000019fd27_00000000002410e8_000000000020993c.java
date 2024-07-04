import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Solution {
	public static void main(String[] args) throws Exception{
        FS sc=new FS(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = sc.nextInt();
        int rc = sc.nextInt();
        while(t-- != 0){
             int[][] matrix = new int[rc][rc];
             for(int i = 0;i < rc;i++){
                 for(int j = 0;j < rc;j++){
                    matrix[i][j] = sc.nextInt();    
                 }
             }
        boolean duplicate = checkTrace(matrix);
        int duplicateRows = duplicateRowCount(matrix);
        int duplicateColumn = duplicateColumnCount(matrix);
        int diagonal =0;
        //Does not contains a duplcate element in row or column
        if(!duplicate){
                for(int i= 0;i < rc; i++){
                    for(int j=0;j< rc ;j++){
                    diagonal+=matrix[i][i];    
                   }
                }
                out.printf("Case #%d: %s %s %s",t,diagonal,0,0);
            }
        // Contains a duplicate element in row and column
        else{
        	out.printf("Case #%d: %s %s %s",t,diagonal,duplicateRows,duplicateColumn);     
            }
        out.close();
        }
    }
	  public static int duplicateRowCount(int[][] matrix){
	        int duplicateRows = 0;
	        for(int row = 0;row < matrix.length;row++){
	          for(int col = 0;col < matrix[0].length;col++){
	             int num = matrix[row][col];
	             for(int otherCol=col+1;otherCol < col;otherCol++){
	                 if(num == matrix[row][otherCol]){
	                    duplicateRows++; 
	                 }
	              }   
	           }
	        }
	        return duplicateRows;
	    }
	    public static int duplicateColumnCount(int[][] matrix){
	        int duplicateColumn=0;
	        int row=0;
	        while(row<matrix.length){
	             for(int col = 0;col < matrix[0].length;row++){
	             int num = matrix[row][col];
	             for(int otherCol=col+1;otherCol < col;otherCol++){
	                 if(num == matrix[row][otherCol]){
	                    duplicateColumn++; 
	                   }
	                }  
	            row++;
	           }
	        }
	        return duplicateColumn;
	    }
	    public static boolean checkTrace(int[][] matrix){
	        for(int row = 0;row < matrix.length;row++){
	            for(int col = 0;col < matrix[0].length;col++){
	                int num = matrix[row][col];
	                for(int otherCol = col+1;otherCol < matrix.length;otherCol++){
	                    if(num == matrix[row][otherCol]){
	                        return true;
	                    }
	                }
	            }
	        }
	        return false;
	    }
	  private static class FS{
	        BufferedReader br;
	        StringTokenizer st;
	        FS(InputStream in){
	            br = new BufferedReader(new InputStreamReader(in));
	            st = new StringTokenizer("");
	        }
	         int nextInt() throws Exception
	        {
	            return Integer.parseInt(next());
	        }
	        
	        String next() throws Exception
	        {
	            if (st.hasMoreTokens())
	                return st.nextToken();
	            st = new StringTokenizer(br.readLine());
	            return next();
	        }
	    }
}


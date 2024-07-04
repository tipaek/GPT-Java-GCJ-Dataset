//Java program to demonstrate BufferedReader 
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
public class Solution   
{ 
 public static void main(String[] args) throws IOException  
 { 
     //Enter data using BufferReader 
     BufferedReader reader =  
                new BufferedReader(new InputStreamReader(System.in)); 
      
     // Reading data using readLine 
     int numCases = Integer.parseInt(reader.readLine());
     String response = "";
     for(int i = 0; i< numCases; i++) {
         int mtx = Integer.parseInt(reader.readLine());
         int[][] matrix = new int[mtx][mtx];
         for(int j = 0; j < mtx; j++) {
             String[] row = (reader.readLine()).split(" ");
             for(int k = 0; k < row.length; k++) {
            	 int num = Integer.parseInt(row[k]);
            	 matrix[j][k] = num;
             }

         }
         //trace
         int trace = 0; 
         for (int t=0; t<mtx; t++) 
        	 trace += matrix[t][t]; 
         
         //find if num twice in row
         int numRows = 0;
         int y;
         for(int g = 0; g < mtx; g++) {
        	 int row = 0;
	         for (int r = 0; r < mtx; r++)  
	         { 
	             for (y = r + 1; y < mtx; y++)  
	             { 
	                 if (matrix[g][r] == matrix[g][y]) {  
	                	 row+=1;
	                	 break;
	                 }	
	             }
	             if(row != 0)
	            	 break;
	         }
	         if(row!=0)
	        	 numRows+=1;
         }
         
         //find if num twice in column
         int numCols = 0;
         int z;
         for(int g = 0; g < mtx; g++) {
        	 int col = 0;
	         for (int r = 0; r < mtx; r++)  
	         { 
	             for (z = r + 1; z < mtx; z++)  
	             { 
	                 if (matrix[r][g] == matrix[z][g]) {  
	                	 col+=1;
	                	 break;
	                 }	
	             }
	             if(col != 0)
	            	 break;
	         }
	         if(col!=0)
	        	 numCols+=1;
         }
         response += "Case #" + (i+1) + ": "+ trace + " "+ numRows +" " + numCols;
         if(i != numCases-1) {
        	 response += "\n";
         }        	  
     }
     System.out.println(response);
     
 } 
}

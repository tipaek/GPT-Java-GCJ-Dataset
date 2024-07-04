import java.util.Arrays;
import java.util.Scanner;

class LatinMatrix {
	
	public static void main(String[] args) {
		
		int m, i, j,tcNbr; 
        Scanner in = null; 
        
       
		 try { 
        	 in = new Scanner(System.in);
            
            tcNbr =  in.nextInt(); 
            
            for(int c =1 ; c<=tcNbr; c++) {
           
            m = in.nextInt(); 

  
            // Read the matrix values 
            
            int val=0;
            
            int rowDup =0;
    		int colDup =0;
    		int trace =0;
    		int[] rowSet = new int[m+1]; 
    		int[][] mat = new int[m][m];
            for (i = 0; i < m; i++) {
            	boolean isCountRow = false;
                for (j = 0; j < m; j++) {
                	val = in.nextInt(); 
                  if(i==j) {
    				 trace = trace + val;
    				}
                  if(rowSet[val]!=0 && !isCountRow) {
  					isCountRow = true;
  					rowDup++;
  					
  				   }
                  rowSet[val]=val;
                  mat[i][j] = val;

                  
                }
                Arrays.fill(rowSet, 0);
               }
            int[] colSet = new int[m+1]; 
            for (i = 0; i < m; i++) {
            	for (j = 0; j < m; j++) {
            		if(colSet[mat[j][i]] != 0) {
            			colDup++;
            			break;
            		}
            		colSet[mat[j][i]] = mat[j][i];
            	}
            	Arrays.fill(colSet, 0);
            }
            
            
            System.out.println("Case #"+c+": "+trace+" "+rowDup+" "+colDup);
            
           }
            
        } 
        catch (Exception e) { 
        	e.printStackTrace();
        } 
        finally { 
            in.close(); 
        } 
		
		
	}

}

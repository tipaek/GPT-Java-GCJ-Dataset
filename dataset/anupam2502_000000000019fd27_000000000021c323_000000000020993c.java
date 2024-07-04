import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class LatinMatrix {
	
	
	public static void checkLatinMatrix(int[][] mat) {
		
		int rowNum = mat.length;
		int colLen = mat[0].length;
		
		int rowDup = checkRepeatedValRow(mat,rowNum,colLen);
		int colDup = checkRepeatedValCol(mat,rowNum,colLen);
		
		int trace = findTrace(mat,rowNum,colLen);
		
		System.out.println(trace+" "+rowDup+" "+colDup);
		
		
	}


	private static int findTrace(int[][] mat, int rowNum, int colLen) {
		int i = 0;
		int j =0;
		
		int sum = 0;
		
		while(i<rowNum) {
			sum = sum + mat[i++][j++];
		}
		
		return sum;
	}


	private static int checkRepeatedValRow(int[][] mat, int rowNum, int colLen) {
		
		
		int count = 0;
		for(int i = 0; i<rowNum; i++ ) {
			Set<Integer> set = new HashSet<>();
			for(int j =0; j<colLen; j++ ) {
				boolean val = set.add(mat[i][j]);
				if(!val) {
					count++;
					break;
				}
			}
		}
		
		return count;
		
	}
	
	private static int checkRepeatedValCol(int[][] mat, int rowNum, int colLen) {
		
		
		int count = 0;
		for(int j = 0; j<colLen; j++ ) {
			Set<Integer> set = new HashSet<>();
			for(int i = 0; i<rowNum; i++ ) {
				boolean val = set.add(mat[i][j]);
				if(!val) {
					count++;
					break;
				}
				
			}
			
		}
		return count;
	}
	
	
	public static void main(String[] args) {
		LatinMatrix lm = new LatinMatrix();
		
		int m, i, j; 
        Scanner in = null; 
        try { 
            in = new Scanner(System.in); 
           
            m = in.nextInt(); 

            int mat[][] = new int[m][m]; 
  
            // Read the matrix values 
           
            for (i = 0; i < m; i++) 
                for (j = 0; j < m; j++) 
                	mat[i][j] = in.nextInt(); 
            
            
            if(mat.length != m) {
            	System.out.println();
            }else {
           
             checkLatinMatrix(mat);
            }

        } 
        catch (Exception e) { 
        	e.printStackTrace();
        } 
        finally { 
            //in.close(); 
        } 
		
		
	}

}

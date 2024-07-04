import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int numCases = input.nextInt();
        for (int n = 0; n < numCases; n++) {
        	int size = input.nextInt();
        	int trace=input.nextInt();
        	int[][] mat=new int[size][size];
        	
        	System.out.printf("Case #%d: ", n + 1);
        	if(solve(size,trace,mat)){
        		System.out.println("POSSIBLE");
        		for(int i=0;i<size;i++){
            		for(int j=0;j<size;j++){
            			System.out.print(mat[i][j]+" ");
            		}
            		System.out.println();
            	}
        	}
        	else{
        		System.out.print("IMPOSSIBLE");
        	}
            
        }
    }
    public static boolean solve(int size,int trace,int[][] matrix){
    	 int row = -1; 
    	    int col = -1; 
    	    boolean isEmpty = true; 
    	    for (int i = 0; i < size; i++) 
    	    { 
    	        for (int j = 0; j < size; j++)  
    	        { 
    	            if (matrix[i][j] == 0)  
    	            { 
    	                row = i; 
    	                col = j; 
    	                isEmpty = false;  
    	                break; 
    	            } 
    	        } 
    	        if (!isEmpty) 
    	        { 
    	            break; 
    	        } 
    	    } 
    	    if (isEmpty)  
    	    { 
    	    		int sum=0;
	    	       for(int i=0;i<size;i++){
	    	    	   sum+=matrix[i][i];
	    	       }
	    	       if(sum==trace){
	    	    	   return true;
	    	       }else{
	    	    	   return false;
	    	       }
    	    } 
	    	for(int num=1;num<=size;num++){
	    		if(isSafe(matrix, row, col, size,num)){
	    			matrix[row][col] = num; 
	    	            if (solve(size,trace, matrix))  
	    	            { 
	    	                return true; 
	    	            }  
	    	            else
	    	            { 
	    	            	matrix[row][col] = 0; 
	    	            } 
	    		}
	    	}
	    	return false; 
    	}
    public static boolean isSafe(int[][] matrix,int i,int j, int size,int num){
    	for (int d = 0; d < size; d++)  
        { 
            if (matrix[i][d] == num)  
            { 
                return false; 
            } 
        } 
        for (int r = 0; r < size; r++) 
        { 
      
            if (matrix[r][j] == num) 
            { 
                return false; 
            } 
        } 
      return true;
    }
}

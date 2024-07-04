import java.util.*;


class Problem1 {
    public static void main(String args[] ) throws Exception {
        //Scanner
        Scanner s = new Scanner(System.in);
        int tests = s.nextInt();
        
         
        for (int t=1;t<=tests;t++) 
        {
        	int N = s.nextInt();
        	int[][] matrix = new int [N+1][N+1];
        	int trace=0;
        	int duplicateRows =0;
            int duplicateCols =0;
            for (int i=1;i<=N;i++) 
        	{
        	    for (int j=1;j<=N;j++) 
	           { 
	        	   matrix[i][j]= s.nextInt();
	        	   if (i ==j) {
	        		   trace = trace + matrix[i][j];
	        	   }
	           }
        	}
            
        	for (int i=1;i<=N;i++) 
        	{
        	   HashMap<Integer,Integer> rowCount = new HashMap<Integer,Integer>();
        	   
	           for (int j=1;j<=N;j++) 
	           { 
	               int temp;
	        	  
	        	   if(rowCount.get(matrix[i][j])  == null ) {
	        		   temp=1;
	        	   }else {
	        	     temp =rowCount.get(matrix[i][j]) +1;
	        	   }
	        	   if(temp >1) {
	        		   duplicateRows++;
	        		   break;
	        	   }
	        	   rowCount.put(matrix[i][j] ,temp);
	           }
        	}
        	
        	for (int j=1;j<=N;j++) 
        	{
        	   HashMap<Integer,Integer> colCount = new HashMap<Integer,Integer>();
        	   
	           for (int i=1;i<=N;i++) 
	           {
	        	   int temp;
	        	   if(colCount.get(matrix[i][j])  == null ) {
	        		   temp=1;
	        	   }else {
	        	     temp =colCount.get(matrix[i][j]) +1;
	        	   }
	        	   if(temp >1) {
	        		   duplicateCols++;
	        		   break;
	        	   }
	        	   colCount.put(matrix[i][j] ,temp);
	           }
        	}
        	
            System.out.println("Case #"+t+": "+trace+" "+duplicateRows+" "+duplicateCols);
        }
    }
}
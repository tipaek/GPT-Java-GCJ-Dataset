
import java.util.*;

import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Solution   
{
	
	
	
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner in=new Scanner(System.in);
		
		int T=in.nextInt();
		for(int i=0;i<T;i++){
		    int x=in.nextInt();
		    int trace=0;
		    int[][] matrix=new int[x][x];
		    
		    for(int j=0;j<x;j++) {
		    	for(int k=0;k<x;k++) {
		    		int y=in.nextInt();
		    		if(j==k) {
		    			trace=trace+y;
		    		}
		    		matrix[j][k]=y;
		    	}
		    }
		    
		    
		    int row=0;
		    int column=0;
		    
		    for(int j=0;j<x;j++) {
		    	HashMap<Integer,Integer> map_row=new HashMap<Integer,Integer>();
		    	
		    	for(int k=0;k<x;k++) {
		    		
		    		if(map_row.containsKey(matrix[j][k])) {
		    			row++;
		    			break;
		    		}
		    		else {
		    			map_row.put(matrix[j][k], 1);
		    		}
		    		
		    		
		    	}
		    }
		    
		    for(int j=0;j<x;j++) {
		    	HashMap<Integer,Integer> map_col=new HashMap<Integer,Integer>();
		    	
		    	for(int k=0;k<x;k++) {
		    		
		    		if(map_col.containsKey(matrix[k][j])) {
		    			column++;
		    			break;
		    		}
		    		else {
		    			map_col.put(matrix[k][j], 1);
		    		}
		    		
		    		
		    	}
		    }
		    
		    
		   
		    
		    
		    
		    
		 System.out.print("Case #"+(i+1)+": "+trace+" "+row+" "+column);
		 
		    
		}    
		
	}
}

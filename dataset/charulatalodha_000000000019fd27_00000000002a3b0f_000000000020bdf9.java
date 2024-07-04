import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		  int nt= sc.nextInt();
		  int n=0;
		  String result="";
		  for(int t=0; t< nt;t++)
		  {
		     n=sc.nextInt()	;
		     int first[][] = new int[n][2]; 
		     for (int i = 0; i < n; i++) 
	                for (int j = 0; j < 2; j++) 
	                {  first[i][j] = sc.nextInt();
	                   
	                } 

		     result = result.concat("Case #"+(t+1)+": "+ helper(first)+ "\n"); 
		  }
		  
	System.out.print(result);
		  
	}
	
	
	private static String helper(int[][] interval) {
		// TODO Auto-generated method stub
	    int n=interval.length;
	    
	    
	    Arrays.sort(interval, (i1, i2) -> Integer.compare(i1[0], i2[0]));
	    int cEnd=interval[0][1],jEnd=0;
	    String result="C";
	    
	      
	    for (int i = 1; i < n; i++) 
	    {   
	    
	    	if(interval[i][0] >= cEnd)
	    		 { 
	    		  cEnd=interval[i][1]; 
	    		 result +=""+ "C";
	    	
	    		 }
	    	else if(interval[i][0] >= jEnd)
	    	   { jEnd=interval[i][1];
	    	   result +=""+ "J";
	    	
	    	   } 
	    	else
	    		{return "IMPOSSIBLE";}
	      
	    }
	     
	    
	    
	 return(result);
	}

}

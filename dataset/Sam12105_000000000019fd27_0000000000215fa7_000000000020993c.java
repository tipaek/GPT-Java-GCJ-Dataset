/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.util.HashMap; 
import java.util.Map;

public class Solution {
	public static void main (String[] args) {
	    
	   
	    
	    Scanner sc = new Scanner(System.in); 
	    int t=sc.nextInt();
	    while(t!=0)
	    {
	        int flag=1;
	        int n=sc.nextInt();
	        int M[][]=new int[n][n];
	        int trace=0;
	        int rcount=0,colcount=0;
	        for (int i=0;i<n;i++)
	        {
	            for (int j=0;j<n;j++)
	            {
	                    M[i][j]=sc.nextInt();
	                    if(i==j)
	                    trace+=M[i][j];
	            }
	            
	        }
	        
	        
	        for (int i = 0; i < M.length; i++)  
    {  
  
        HashSet<Integer> hs = new HashSet<>();   
  
        
        for (int j = 0; j < M[i].length; j++)  
        {  
  
          
            hs.add(M[i][j]);  
        }  
  
         
        if (hs.size()!=n)  
            rcount++;  
    }  
    
	 for (int i = 0; i < M.length; i++)  
    {  
  
        HashSet<Integer> hs = new HashSet<>();  
  
        
        for (int j = 0; j < M[i].length; j++)  
        {  
  
          
            hs.add(M[j][i]);  
        }  
  
         
        if (hs.size()!=n)  
            colcount++;  
    }  
   
	System.out.println("Case #"+flag+": "+trace+" "+rcount+" "+colcount);
	        t--;
	        flag++;;
	    }
	    
	    
	        
	    
	}
}
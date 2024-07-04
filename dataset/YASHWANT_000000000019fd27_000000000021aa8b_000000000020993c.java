import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution 
{
	static void trace(int a[][], int n, int t) 
    {
		int k = 0, r = 0, c = 0;
		
		int y[][]=new int[n][n];
		
		boolean visited[] = new boolean[n];
		
      	Arrays.fill(visited, false);
		
		for (int i = 0; i < n; i++) 
	    {
            for(int j = 0; j < n; j++)
			{
		
				if(i == j)
				{
					k = k + a[i][j];	
				}
				
				if (visited[j] == true) 
            		continue; 
				
		        int count = 1;
				
        		for (int l = j + 1; l < n; l++) 
				{ 
			
            			if (a[i][j] == a[i][l]) 
						{ 
                			visited[l] = true; 
                			count++; 
            			} 
        		} 
        	
				if(count>1)
				{
					r++;
				}
			}
        }
		for (int i = 0; i < n; i++) 
    	{
         	for(int j = 0; j < n; j++)
			{
				y[i][j] = a[j][i];
			}
       	}	
		
		Arrays.fill(visited, false); 
  		
		for (int i = 0; i < n; i++) 
	    {
        
			for(int j = 0; j < n; j++)
			{
				
				if (visited[j] == true) 
            		continue;  
		    
				int count = 1; 
					
				for (int l = j + 1; l < n; l++) 
				{ 
            			if (y[i][j] == y[i][l]) 
						{ 
                			visited[l] = true; 
                			count++; 
            			} 
        		} 
        		
				if(count>1)
				{
					c++;
				}
			}
        }
		System.out.println("Case #"+(t+1)+": "+k+" "+r+" "+c);
	}

	public static void main(String[] args) 
   	{
    
		Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int TItr = 0; TItr < T; TItr++) 
		{
			int n = sc.nextInt();
		
			int a[][]=new int[n][n];
		
    		for (int i = 0; i < n; i++) 
    		{
          		for(int j = 0; j < n; j++)
				{
					a[i][j] = sc.nextInt();
				}
       		}
	    
    		trace(a,n,TItr);
       	}
   	}
}

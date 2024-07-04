import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution 
{
	static void trace(byte a[][], byte n, byte t) 
    {
		int k = 0, r = 0, c = 0;
		
		byte y[][]= new byte[n][n];
		
		boolean visited[] = new boolean[n];
		
      	Arrays.fill(visited, false);
		
		for (byte i = 0; i < n; i++) 
	    {
            byte found=0;
			for(byte j = 0; j < n; j++)
			{
					
				if (visited[j] == true) 
            		continue; 
				
		        byte count = 1;
				
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
					found = 1;
					break;
				}
			}
			if(found == 1)
			{
				r++;
			}	
        }
		for (byte i = 0; i < n; i++) 
    	{
         	for(byte j = 0; j < n; j++)
			{
				y[i][j] = a[j][i];
				
				if(i == j)
				{
					k = k + a[i][j];	
				}
			}
       	}	
		
		Arrays.fill(visited, false); 
  		
		for (byte i = 0; i < n; i++) 
	    {
			byte found=0;
			for(byte j = 0; j < n; j++)
			{
				
				if (visited[j] == true) 
            		continue;  
		    
				byte count = 1; 
					
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
					found = 1;
					break;
				}
			}
			if(found == 1)
			{
				c++;
			}
        }
		System.out.println("Case #"+(t+1)+": "+k+" "+r+" "+c);
	}

	public static void main(String[] args) 
   	{
    
		Scanner sc = new Scanner(System.in);

        byte T = sc.nextByte();

        for (byte TItr = 0; TItr < T; TItr++) 
		{
			byte n = sc.nextByte();
		
			byte a[][]=new byte[n][n];
		
    		for (byte i = 0; i < n; i++) 
    		{
          		for(byte j = 0; j < n; j++)
				{
					a[i][j] = sc.nextByte();
				}
       		}
	    
    		trace(a,n,TItr);
       	}
   	}
}


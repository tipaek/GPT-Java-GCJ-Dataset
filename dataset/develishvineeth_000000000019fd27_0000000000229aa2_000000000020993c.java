

import java.awt.SecondaryLoop;
import java.io.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

/* package codechef; // don't place package name! */

import java.util.*;



import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Main
{
	
	
	static Scanner s;
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		s=new Scanner(System.in);
		int t=s.nextInt();
		int Case=1;
		while(t-->0)
		{
			
			int n=s.nextInt();
			int r=0;int c=0;
			int trace=0;
			int[][] arr=new int[n][n];
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
				arr[i][j]=s.nextInt();
			for(int i=0;i<n;i++)
				trace+=arr[i][i];
			int sum=0;
			for(int i=1;i<=n;i++)
				sum^=i;
			
			for(int i=0;i<n;i++)
			{
				int ans=0;
			
				for(int j=0;j<n;j++)
					ans^=arr[i][j];
				if(sum!=ans)
					r++;
			}
			
			for(int i=0;i<n;i++)
			{
				int ans=0;
			
				for(int j=0;j<n;j++)
					ans^=arr[j][i];
				if(sum!=ans)
					c++;
			}
			System.out.println("Case #"+Case+": "+trace+" "+r+" "+c);
			Case++;
			}
			
		}
		    
		}

	
	


      
        	
        
        


	

	
	


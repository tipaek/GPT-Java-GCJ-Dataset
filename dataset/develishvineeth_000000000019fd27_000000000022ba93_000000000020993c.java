

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


public class Solution
{
	
	
	static Scanner s;
	public static void main (String[] args) throws java.lang.Exception
	{
	
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
			HashSet<Integer> HS=new HashSet<Integer>();
			
			for(int i=1;i<=n;i++)
					HS.add(i);
			
			for(int i=0;i<n;i++)
			{
				HashSet<Integer> hs=new HashSet<Integer>(HS);
				boolean flag=false;
				for(int j=0;j<n;j++)
					{
					int ele=arr[i][j];
					if(hs.contains(ele))
					{
						hs.remove(ele);
					}
					else
					{
						flag=true;
						break;
					}
					}
				if(flag)
					r++;
			}
			
			for(int i=0;i<n;i++)
			{
				HashSet<Integer> hs=new HashSet<Integer>(HS);
				boolean flag=false;
				for(int j=0;j<n;j++)
				{	int ele=arr[j][i];
				if(hs.contains(ele))
				{
					hs.remove(ele);
				}
				else
				{
					flag=true;
					break;
				}
				}
			if(flag)
				c++;
			}
			System.out.println("Case #"+Case+": "+trace+" "+r+" "+c);
			Case++;
			}
			
		}
		    
		}

	
	


      
        	
        
        


	

	
	


/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc=new Scanner(System.in);
		int t1=sc.nextInt();
		int d=1;
		while(t1-->0)
		{
		    
		    int n=sc.nextInt();
		    int a[][]=new int[n][n];
		    int r=0,c=0,t=0;
		    int c1[][]=new int[n][n];
		    for(int i=0;i<n;i++)
		    {
		        for(int j=0;j<n;j++)
		        {
		            a[i][j]=sc.nextInt();
		            if(i==j)
		            t=t+a[i][j];
		            if(c1[i][a[i][j]-1]==0)
		            c1[i][a[i][j]-1]++;
		            else if(c1[i][a[i][j]-1]!=0 && r<i+1)
		            r++;
		        }
		    }
		    int c2[][]=new int[n][n];
		    for(int j=0;j<n;j++)
		    {
		        for(int i=0;i<n;i++)
		        {
		            if(c2[a[i][j]-1][j]==0)
		           c2[a[i][j]-1][j]++;
		           else if(c2[a[i][j]-1][j]!=0 && c<j+1)
		           c++;
		        }
		    }
		    System.out.println("Case #"+d+": "+t+" "+r+" "+c);
		    d++;
		}
	}
}

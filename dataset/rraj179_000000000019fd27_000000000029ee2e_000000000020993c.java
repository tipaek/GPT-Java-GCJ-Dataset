import java.util.*;
import java.lang.*;
import java.io.*;


class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner sc= new Scanner(System.in);
	    int t= sc.nextInt();
	    for( int p=1; p<=t; p++)
	    {
	         int n= sc.nextInt();
	         int row=0;
	         int col=0;
	         int trace=0;
	         int a[][]= new int[n][n];
	         for(int i=0;i<n;i++)
	         {
	             for(int j=0; j<n; j++)
	             {
	                 a[i][j]= sc.nextInt();
	             }
	         }
	         for (int i = 0; i < n; i++)
	         {
	             for(int j=0; j<n; j++)
	             {
	                 int key= a[i][j];
	                 for (int k = j+1; k < n; k++)
	        	    {
		            	if (key==(a[i][k])) 
		            	{
		            		row++;
		            		j=n;
		            		break;
		            	}
		            }
	              }
	         }
	         for (int i = 0; i < n; i++)
	         {
	             for(int j=0; j<n; j++)
	             {
	                 int key= a[j][i];
	                 for (int k = j+1; k < n; k++)
	        	    {
		            	if (key==(a[k][i])) 
		            	{
		            		col++;
		            		j=n;
		            		break;
		            	}
		            }
	              }
	         }
	         
	         for (int i = 0; i < n; i++)
	         {
	             trace= trace+ a[i][i];
	         }
	         System.out.println("Case #"+p+":"+" "+trace+" "+row+" "+col);
	  
	
    	}
	}
	
}
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
		
		int t=sc.nextInt();
		int st=1;
		
		while(t>0)
		{
		    int n=sc.nextInt();
		    	    
		    int[][] arr=new int[n][n];
		    
		    for(int i=0;i<n;i++)
		    {
		        for(int j=0;j<n;j++)
		        {
		            arr[i][j]=sc.nextInt();
		        }
		    }
		    
		    int k=0,r=0,c=0;
		    
		    for(int j=0;j<n;j++)
		        {
		            k+=arr[j][j];
		        }
		        
		        
		        
		     for(int i=0;i<n;i++)
		    {
		        ArrayList<Integer> a1=new ArrayList<Integer>();
		          
		        for(int j=0;j<n;j++)
		        {
		            if(a1.contains(arr[i][j])==true)
		            {
		                r++;
		                break;
		            }
		            else
		            {
		                a1.add(arr[i][j]);
		            }
		            
		        }
		    }   
		    
		      
		     for(int i=0;i<n;i++)
		    {
		        ArrayList<Integer> a1=new ArrayList<Integer>();
		          
		        for(int j=0;j<n;j++)
		        {
		            if(a1.contains(arr[j][i])==true)
		            {
		                c++;
		                break;
		            }
		            else
		            {
		                a1.add(arr[j][i]);
		            }
		            
		        }
		    } 
		    
		    
		    
		    
		   System.out.println("Case #"+st+": "+k+" "+r+" "+c);
		   
		   st++;
		   t--;
		    
		}
	}
}

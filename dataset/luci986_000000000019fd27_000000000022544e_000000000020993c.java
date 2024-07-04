/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner in = new Scanner(System.in);
		int t=in.nextInt();
		
		while(t>0)
		{
		    
		    int n=in.nextInt();
		    
		   // int[] a= new int[n+1];
		    
		   // int mat[][]= new int[n][n];
		    //int ans=n*(1+n)/2;
		    int[][] a= new int[n][n];
		    //System.out.println(ans);
		    int row=0,col=0;
		    int count[] = new int[n+1];
		    
		    for(int i=0;i<n;i++)
		    {
		         int flag=0;
		        
		        for(int j=0;j<n;j++)
		        {
		            a[i][j]=in.nextInt();
		            if(count[a[i][j]]>0)
		            {
		                flag=1;
		                //System.out.println(a[i][j]);
		            }
		            else
		            {
		                count[a[i][j]]++;
		            }
		           // sum+=a[i][j];
		        }
		        
		        if( flag==1)
		        {
		            row++;
		            //System.out.println(row);
		        }
		        
		        
		         for(int m=1;m<=n;m++)
		        {
		         count[m]=0;   
		        }
		        
		        //for(itnt )
		    }
		    
		    
		  
		    
		    
		 
		    for(int i=0;i<n;i++)
		    {
		       // int sum=0;
		        int flag=0;
		        
		        
		        
		        
		        
		        for(int j=0;j<n;j++)
		        {
		           // a[][j]=in.nextInt();
		            //sum+=a[j][i];
		            
		            
		           
		            if(count[a[j][i]]==0)
		            {
		                count[a[j][i]]++;
		            }
		            else
		            {
		                flag=1;
		                //System.out.println(i+" "+a[j][i]);
		                break;
		            }
		        }
		        
		        
		        
		        
		        if(flag==1)
		        {
		            col++;
		            //System.out.println(col);
		        }
		        
		        for(int jj=1;jj<=n;jj++)
		        {
		            count[jj]=0;
		        }
		        
		       // System.out.println(i);
		        
		        
		    }
		    int trace=0;
		    for(int i=0;i<n;i++)
		    {
		        trace+=a[i][i];
		    }
		    
		    
		    System.out.println("Case #1: "+trace+" "+row+" "+col);
		    
		    
		    t--;
		}
	}
}

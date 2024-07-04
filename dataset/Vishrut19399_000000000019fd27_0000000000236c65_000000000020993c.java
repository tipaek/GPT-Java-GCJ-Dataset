
import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int k=sc.nextInt();
		int flag=0;
	for(int t=1;t<=k;t++)
	{
	    int n=sc.nextInt();
	    int rows=0;
	    int columns=0;
	    
	    int arr[][]=new int[n][n];
		int arr2[][]=new int[n+1][n+1];
		int arr3[][]=new int[n+1][n+1];
	    int sum=0;
	    for(int i=0;i<n;i++)
	    {
	        int flagr=0;
	       // int flagc=0;
	        for(int j=0;j<n;j++)
	        {
	            
	            arr[i][j]=sc.nextInt();
	           // System.out.println(arr[i][j]);
	            if(i==j)
	            {
	                sum+=arr[i][j];
	            }
	            if(arr2[i][arr[i][j]]==0)
	            arr2[i][arr[i][j]]+=1;
	            else{
	                flagr=1;
	            }
	            
	        }
	        if(flagr==1)
	        {
	            ++rows;
	        }

	        
	    }
	    
	    for(int i=0;i<n;i++)
	    {
	        int flagc=0;
	        for(int j=0;j<n;j++)
	        {
	            
	            if(arr3[i][arr[j][i]]==0)
	            {
	               arr3[i][arr[j][i]]+=1;
	            }
	            else{
	                flagc=1;
	            }
	            
	        }
	        if(flagc==1)
	        {
	            ++columns;
	        }
	    }
	
	System.out.println("Case #"+t+": "+sum+" "+rows+" "+columns);
	    
	}
	    
	}
}
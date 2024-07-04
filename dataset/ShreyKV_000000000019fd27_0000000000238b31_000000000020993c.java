import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
    public static void main(String [] args)throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine().trim());
        String a[]=new String[t];
        int f=0;
        while(t-->0)
        {
            int n=Integer.parseInt(br.readLine().trim());
            int arr[][]=new int[n][n];
            for(int i=0;i<n;i++)
            {   String s[]=br.readLine().split(" ");
                for(int j=0;j<n;j++)
                {
                    arr[i][j]=Integer.parseInt(s[j].trim());
                }
            }
            a[f]=Vestigium(arr, n);
            f++;

        }
        for(int i=0;i<a.length;i++)
        {
        	System.out.println("Case #"+(i+1)+": "+a[i]);
            
        }
    }
    private static String Vestigium(int a[][],int n)
    {
    	int k=0,r=0,c=0;
    	int v[][]=new int[n][n];
    	for(int i=0;i<n;i++)
    	{
    		for(int j=0;j<n;j++)
    		{
    			v[i][j]=a[j][i];
    		}
    	}
    	for(int i=0;i<n;i++)
    	{
    		
    		for(int j=0;j<n;j++)
    		{
    			if(i==j)
    			{
    				k+=a[i][j];
    			}
    			
    			
    		}
    	}
    	
    	for(int i=0;i<n;i++)
    	{
    		int flag=1;
    		Arrays.sort(a[i]);
    		for(int j=0;j<n-1;j++)
    		{
    			
    			if((a[i][j]^a[i][j+1])==0)
    			{
    			  flag=0;
    			  break;
    			  
    			}
    			
    		}
    		if(flag==0)
    		{
    			r++;
    		}
    	}
    	
    	for(int i=0;i<n;i++)
    	{
    		int flag=1;
    		Arrays.sort(v[i]);
    		for(int j=0;j<n-1;j++)
    		{
    			
    			if((v[i][j]^v[i][j+1])==0)
    			{
    			  flag=0;
    			  break;
    			  
    			}
    			
    		}
    		if(flag==0)
    		{
    			c++;
    		}
    	}
		
		
		
		 
		return k+" "+r+" "+c;
    	
		
		
    }
    
    
}
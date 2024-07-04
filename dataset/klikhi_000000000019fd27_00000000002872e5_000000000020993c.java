

import java.util.*;
import java.lang.*;
import java.io.*;


class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int t=1;t<=T;t++)
		{
		    int trace=0,row=0,col=0,flag=0;
		    int N=sc.nextInt();
		    int [][]arr=new int[N][N];
		    int check[]=new int[N+1];
		    for(int i=0;i<N;i++)
		    {
		        for(int j=0;j<N;j++)
		        {
		            arr[i][j]=sc.nextInt();
		            if(check[arr[i][j]]==1 && flag==0)
		            {
		                row++;
		                flag=1;
		            }
		            else
		            {
		                check[arr[i][j]]=1;
		            }
		            if(i==j)
		            trace+=arr[i][j];
		        }
		        flag=0;
		        for(int k=1;k<=N;k++)
		        check[k]=0;
		    }
		    for(int i=0;i<N;i++)
		    {
		        for(int j=0;j<N;j++)
		        {
		            if(check[arr[j][i]]==1 && flag==0)
		            {
		                col++;
		                flag=1;
		            }
		            else
		            {
		                check[arr[j][i]]=1;
		            }
		        }
		        flag=0;
		        for(int k=1;k<=N;k++)
		        check[k]=0;
		        
		    }
		    System.out.println("Case #"+t+":"+" "+trace+" "+row+" "+col);
		    
		    
		}
	}
}

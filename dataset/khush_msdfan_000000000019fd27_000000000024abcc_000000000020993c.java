
import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution {
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int cs=1;
        while(t-->0)
        {
        	int n=sc.nextInt();
        	int sum=0;
        	int rep_col=0;
        	int rep_row=0;
        	int[][] arr=new int[n][n];
        	int ans=0;
        	
        	for(int i=1;i<=n;i++)
        	{
        		ans^=i;
        	}
        	for(int i=0;i<n;i++)
        	{
        		for(int j=0;j<n;j++)
        		{
        			
        			arr[i][j]=sc.nextInt();
        			if(i==j)
        			{
        				sum+=arr[i][j];
        			}
        		}
        	}
        	for(int i=0;i<n;i++)
        	{
        		
        		int row_xor=0,col_xor=0;
        		for(int j=0;j<n;j++)
        		{
        			row_xor^=arr[i][j];
        			col_xor^=arr[j][i];
        		}
        		if(row_xor!=ans)
        		{
        			rep_row++;
        		}
        		if(col_xor!=ans)
        		{
        			rep_col++;
        		}
        	}
        	System.out.println("Case #"+(cs++)+": "+sum+" "+rep_row+" "+rep_col);
        }
    }
}

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
        		
        		int[] row_hash=new int[n+1];
        		int[] col_hash=new int[n+1];
        		for(int j=0;j<n;j++)
        		{
        			int ele=arr[i][j];
        			if(row_hash[ele]>0)
        			{
        				rep_row++;
        				break;
        			}
        			row_hash[ele]++;
        		}
        		for(int j=0;j<n;j++)
        		{
        			int ele=arr[j][i];
        			if(col_hash[ele]>0)
        			{
        				rep_col++;
        				break;
        			}
        			col_hash[ele]++;
        		}
        		
        	}
        	System.out.println("Case #"+(cs++)+": "+sum+" "+rep_row+" "+rep_col);
        }
    }
}
//package test;

import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = sc.nextInt();
    for(int i=0;i<t;i++)
    {
    	int n = sc.nextInt();
    	int[][] arr= new int[n][n];
    	for(int row=0;row<n;row++)
    	{
    		for(int col=0;col<n;col++)
    			{
    			arr[row][col]=sc.nextInt();
    			}
    	 
    	}
    	
    	//counting sum
    	int sum=0;
    	for(int j=0;j<n;j++)
    		sum+= arr[j][j];
    	
    	//repeated.
    	int rs=0,cs=0;
    	for(int j=0;j<n;j++)
    	{
    		Set<Integer> set = new HashSet<Integer>();
    		for(int col=0;col<n;col++)
    		{
    			set.add(arr[j][col]);
    		}
    		if (set.size()!=n)
    			rs++;
    			
    	}
    	
    	for(int j=0;j<n;j++)
    	{
    		Set<Integer> set = new HashSet<Integer>();
    		for(int col=0;col<n;col++)
    		{
    			set.add(arr[col][j]);
    		}
    		if (set.size()!=n)
    			cs++;
    			
    	}
    	
    System.out.println("Case #" + i+1 + ": " + sum+" "+rs+" "+cs);
    } 
   }
    
  }
 
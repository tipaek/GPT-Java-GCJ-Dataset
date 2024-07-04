import java.util.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
public class Solution {
	
	public static void main(String[] args) {
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int test = in.nextInt();  
	    for (int t = 1; t <= test; ++t) {
	      int n = in.nextInt();
	      int arr[][] = new int[n+1][n+1];
	      for(int i=0;i<n;i++)
	      {
	    	  for(int j=0;j<n;j++)
	    	  {
	    		  arr[i][j]=in.nextInt();
	    	  }
	      }
       int sum=0,repeatedRow=0,repeatedColumn=0;
       
       for(int i=0;i<n;i++)
	      {   sum+=arr[i][i];
    	      HashSet<Integer> row = new HashSet<Integer>();
	          HashSet<Integer> column = new HashSet<Integer>();
	    	  for(int j=0;j<n;j++)
	    	  {
	    		  if(row.contains(arr[i][j])) 
	    				  {
	    			        repeatedRow++;
	    			        break;
	    				  }
	    		  row.add(arr[i][j]);
	    	  }
	    	  for(int j=0;j<n;j++)
	    	  {
	    		  if(column.contains(arr[j][i])) 
				  {
	    			  repeatedColumn++;
			          break;
				  }
	    		  column.add(arr[j][i]);
	    	  }
	      }
	    System.out.println("Case #" +t + ": " + sum + " " +repeatedRow + " "+repeatedColumn);
	    }
	  }
}
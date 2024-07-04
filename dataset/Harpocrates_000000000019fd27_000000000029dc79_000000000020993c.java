import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	public static void main(String[] args) {
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int t = Integer.parseInt(in.nextLine()); 
	    
	    for (int i = 1; i <= t; ++i) {
	      int n = in.nextInt();
	      int[][] arr = new int [n][n];
	      for(int j = 0; j < n; ++j) {
	    	  for(int k = 0; k < n; ++k) {
	    		  arr[j][k] = in.nextInt();
	    	  }
    	  }
	      
	      int row = 0, col = 0, sum = 0;
	      
	      
	      for(int j = 0; j < n; ++j) {
	    	  for(int k = 0; k < n; ++k) {
	    		  if(j == k) {
	    			  sum += arr[j][k];
	    		  }
	    	  }
	      }
	      
	      
	      for(int j = 0; j < n; ++j) {
	    	  Set<Integer> rowSet = new HashSet<Integer>();
	    	  boolean flag = false;
	    	  for(int k = 0; k < n; ++k) {
	    		  boolean add = rowSet.add(arr[j][k]);
	    		  if(!add) {
	    			  row++;
	    			  flag = true;
	    		  }
	    		  if(flag) {
	    			  break;
	    		  }
	    		  
	    	  }
	    	  
	    	  
	      }
	      
	      for(int j = 0; j < n; ++j) {
	    	  Set<Integer> rowSet = new HashSet<Integer>();
	    	  boolean flag = false;
	    	  for(int k = 0; k < n; ++k) {
	    		  boolean add = rowSet.add(arr[k][j]);
	    		  if(!add) {
	    			  col++;
	    			  flag = true;
	    		  }
	    		  if(flag) {
	    			  break;
	    		  }
	    		  
	    	  }
	    	  
	    	  
	      }
	      System.out.println("Case #" + i + ": " + sum + " " + row + " " + col);  
	    }
	    in.close();
	}
}

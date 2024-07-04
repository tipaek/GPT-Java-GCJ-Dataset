import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); 
    for (int i = 1; i <= t; i++) {
      int n = in.nextInt();
      int sum = 0;
      int count = 0;
      int[][] arr = new int[n][n];
      for(int j = 0; j<n; j++) {
    	  for(int k = 0; k<n; k++) {
    		  arr[j][k] = in.nextInt();
    	  }
      }
      for(int l = 0; l<n; l++){
    	  for(int m = 0; m<n; m++)
    		  if(m==l) {
    			  sum+=arr[m][l];
    		  }
      }	
      int row = 0;
      for(int o = 0; o<n; o++) {
    	  int temp = 0;
    	  for(int p = 0; p<n; p++) {
    		  int a = arr[o][p];
    		  for(int q = p+1; q<n; q++) {
    			  int b = arr[o][q];
    			  if(a==b) {
    				  row++;
    				  temp++;
    			  }
    			  if(temp>0) {
    				  break;
    			  }
    		  }
    		  if(temp>0) {
    			  break;
    		  }
    	  }
      }
      int col = 0;
      for(int o = 0; o<n; o++) {
    	  int temp = 0;
    	  for(int p = 0; p<n; p++) {
    		  int a = arr[p][o];
    		  for(int q = p+1; q<n; q++) {
    			  int b = arr[q][o];
    			  if(a==b) {
    				  col++;
    				  temp++;
    			  }
    			  if(temp>0) {
    				  break;
    			  }
    		  }
    		  if(temp>0) {
    			  break;
    		  }
    	  }
      }
      System.out.println("Case #" + i + ": " + sum + " " + row + " " + col);
    
  }
  }
}
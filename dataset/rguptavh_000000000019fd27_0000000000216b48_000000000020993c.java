import java.util.*;
class Solution {
  public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      int x = scan.nextInt();
      for (int y=0; y<x;y++) {
    	  int z= scan.nextInt();
    	  int[][] arr = new int[z][z];
    	  for (int a=0; a<z; a++) {
    		  for (int b=0 ; b<z; b++) {
    			  arr[a][b] = scan.nextInt();
    		  }
    	  }
    	  int cols =0;
    	  int rows =0;
    	  int trace =0;
    	  for (int c=0; c<arr.length;c++) {
    		  trace += arr[c][c];
    	  }
    	  for (int d=0; d<arr.length;d++) {
    		  HashSet<Integer> set = new HashSet<Integer>(); 
    		  for (int e=0; e<arr[0].length;e++) {
    	
    		     if (set.add(arr[d][e]) == false) {
    		        rows++;
    		        break;
    		     }
    		}
    	  }
    	  for (int d=0; d<arr.length;d++) {
    		  HashSet<Integer> set = new HashSet<Integer>(); 
    		  for (int e=0; e<arr[0].length;e++) {
    	
    		     if (set.add(arr[e][d]) == false) {
    		        cols++;
    		        break;
    		     }
    		}
    	  }
  		System.out.println("Case#"+(y+1) + ": " + trace+" "+ rows+" "+cols);
      }
  }
}

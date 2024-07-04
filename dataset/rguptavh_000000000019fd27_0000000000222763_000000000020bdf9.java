import java.util.*;
class Solution {
  public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      int x = scan.nextInt();
      for (int y=0; y<x;y++) {
    	  int z= scan.nextInt();
    	  int[][] arr = new int[z][4];
    	  for (int a=0; a<z; a++) {
    		  for (int b=0 ; b<2; b++) {
    			  arr[a][b] = scan.nextInt();
    		  }
   			  arr[a][2] = a;
    	  }
    	  Arrays.sort(arr,(int[] a, int[] b)->a[1]-b[1]);
    	  int start = arr[0][1];
    	  arr[0][3]=1;
    	  for (int a=1; a<arr.length;a++) {
    		  if (arr[a][0]>= start) {
    			  start = arr[a][1];
    			  arr[a][3]=1;
    		  }
    	  }
    	  int s1=-1;
    	  boolean im = false;
    	  for (int a=1; a<arr.length;a++) {
    		  if (arr[a][3]== 0) {
    			  if (s1==-1) {
    				  s1 = arr[a][1];
    			  }
    			  else if (arr[a][0]<s1) {
    				  im = true;
    			  }
    		  }
    	  }
    	  Arrays.sort(arr,(int[] a, int[] b)->a[2]-b[2]);
    	  String ans = "";
    	  for (int b=0; b<arr.length;b++) {
    		  if (arr[b][3]==1) {
    			  ans+="C";
    		  }
    		  else {
    			  ans+="J";
    	  }
      }
    	  if (im) {
    		  ans= "IMPOSSIBLE";
    	  }
    	  System.out.println("Case #" + (y+1) + ": " + ans);
  }
  }
}
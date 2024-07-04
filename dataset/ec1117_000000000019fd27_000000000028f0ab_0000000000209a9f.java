import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = Integer.parseInt(in.nextLine()); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      String s=in.nextLine().trim();
      int arr[]=new int[s.length()];
      for(int j=0;j<arr.length;j++) {
    	  arr[j]=Character.getNumericValue(s.charAt(j));
      }
      StringBuilder sb=new StringBuilder();
      for(int j=0;j<arr[0];j++) {
    	  sb.append('(');
      }
      sb.append(arr[0]);
      for(int j=1;j<arr.length;j++) {
//    	  System.out.println(j+" "+arr[j]+" "+arr[j-1]);
    	  if(arr[j]==arr[j-1]) {
    		  
    	  }
    	  else if(arr[j]<arr[j-1]) {
//    		  System.out.println("here");
    		  for(int k=0;k<arr[j-1]-arr[j];k++) {
//    			  System.out.println(k);
    			  sb.append(')');
    		  }
    	  }
    	  else {
    		  for(int k=0;k<arr[j]-arr[j-1];k++) {
    			  sb.append('(');
    		  }
    	  }
    	  sb.append(arr[j]);
      }
      for(int j=0;j<arr[arr.length-1];j++) {
    	  sb.append(')');
      }
      System.out.println("Case #" + i + ": " + sb);
      
    }
  }
}
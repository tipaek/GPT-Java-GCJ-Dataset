import java.util.*;
import java.io.*;
public class Solution{
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      int arr[][]=new int[n][n];
      for(int j=0;j<n;j++) {
    	  for(int k=0;k<n;k++) {
    		  arr[j][k]=in.nextInt();
    	  }
      }
      int trace=0;
      for(int j=0;j<n;j++) {
    	  trace+=arr[j][j];
      }
      int hdup=0;
      for(int j=0;j<n;j++) {
    	  HashSet<Integer> list=new HashSet<Integer>();
    	  for(int k=0;k<n;k++) {
    		  list.add(arr[j][k]);
    	  }
    	  if(list.size()!=n) {
    		  hdup++;
    	  }
      }
      int vdup=0;
      for(int j=0;j<n;j++) {
    	  HashSet<Integer> list=new HashSet<Integer>();
    	  for(int k=0;k<n;k++) {
    		  list.add(arr[k][j]);
    	  }
    	  if(list.size()!=n) {
    		  vdup++;
    	  }
      }
      System.out.println("Case #" + i + ": "+trace+" "+hdup+" "+vdup);
    }
  }
}
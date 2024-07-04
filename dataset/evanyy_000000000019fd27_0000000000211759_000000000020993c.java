import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; i++) {
      int n = in.nextInt();
      int [][] arr = new int[n][n];
      for (int j = 0; j < n; j++) {
    	  for (int q = 0; q < n; q++) {
    		  arr[j][q] = in.nextInt();
    	  }
    	  
      }
      System.out.println("Case #" + i + ": " + trace(arr) + " " + repeatedRows(arr) + " " + repeatedColumns(arr));
    }
  }
  public static int trace(int[][] a) {
	  int trace = 0;
	  for (int i = 0; i < a.length; i++) {
		  trace += a[i][i];
	  }
	  return trace;
  }
  public static int repeatedRows(int[][] a) {
	  int count = 0;
	  boolean flag  = true;
	  HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
	  for (int i = 0; i < a.length; i++) {
		  for (int j = 0; j < a.length; j++) {
			  map.put(a[i][j], map.getOrDefault(a[i][j], 0) + 1);
		  }
		  for (int num: map.values()) {
			  if (num > 1){
				  count++;
				  break;
			  }
		  }
		  map.clear();
	  }
	  return count;
  }
  public static int repeatedColumns(int[][] a) {
	  int count = 0;
	  boolean flag  = true;
	  HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
	  for (int i = 0; i < a.length; i++) {
		  for (int j = 0; j < a.length; j++) {
			  map.put(a[j][i], map.getOrDefault(a[j][i], 0) + 1);
		  }
		  for (int num: map.values()) {
			  if (num > 1){
				  count++;
				  break;
			  }
		  }
		  map.clear();
	  }
	  return count;
  }
  }
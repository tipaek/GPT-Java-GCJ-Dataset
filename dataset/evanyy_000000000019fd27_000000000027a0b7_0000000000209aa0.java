import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; i++) {
      int n = in.nextInt();
      int k = in.nextInt();
      int[][] a = matrix(n,k);
      if (a == null) {
    	  System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
      }
      else {
    	  System.out.println("Case #" + i + ": " + "POSSIBLE");
    	  for (int K = 0; K < a.length; K++) {
    		  for (int j = 0; j < a[0].length; j++) {
    			  System.out.print(a[K][j] + " ");
    		  }
    		  System.out.println();
    	  }
      }
      
    }
  }
  
  public static int[][] matrix(int n, int k){
	  int count = 0;
	  int[][] a = new int[n][n];
	  Random r = new Random();
	  while (count < 300000) {
		  for (int i = 0; i < n; i++) {
			  for (int j = 0; j < n; j++) {
				  a[i][j] = 1 + r.nextInt(n);
		  }
	  }
		  if (repeatedRows(a) == 0 && repeatedColumns(a) == 0 && trace(a) == k) {
			  return a;
		  }
		  count++;
  }
	  return null;
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
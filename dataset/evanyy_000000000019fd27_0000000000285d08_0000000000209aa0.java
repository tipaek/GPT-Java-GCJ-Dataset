import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; i++) {
      int n = in.nextInt();
      int k = in.nextInt();
      int[][] b = new int[n][n];
      int[][] a = new int[n][n];
      generateMatrix(b,n,0,0,k,a);
      if (trace(a) == 0) {
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
  public static void printMatrix(int[][] a){
	  for (int K = 0; K < a.length; K++) {
		  for (int j = 0; j < a[0].length; j++) {
			  System.out.print(a[K][j] + " ");
		  }
		  System.out.println();
	  }
	  System.out.println();
  }
  public static void generateMatrix(int[][] a, int n, int index1, int index2, int k, int[][] ans) {
	  if (trace(ans) == 0) {
//	  printMatrix(a);//	  System.out.println(index2);
		  for (int i = 1; i < n + 1; i++) {
			  boolean flag = true;
			  for (int j = 0; j < index1; j++) {
				  if (a[j][index2] == i) {
					  flag = false;
					  break;
				  }
			  }
			  for (int k1 = 0; k1 < index2; k1++) {
				  if (a[index1][k1] == i) {
					  flag = false;
					  break;
				  }
			  }
			  if (flag) {
				  a[index1][index2] = i;
				  if (index1 == n - 1 && index2 == n - 1) {
					  if (trace(a) == k) {
						  for (int f = 0; f < n; f++) {
							  for (int p = 0; p < n; p++) {
								  ans[f][p] = a[f][p];
							  }
						  }
						  return;
					  }
				  }
				  if (trace(a) < k) {
				  if (index1 < n - 1) {
					  generateMatrix(copy(a,n),n,index1+1,index2,k,ans);
				  }
				  else {
					  generateMatrix(copy(a,n),n,0,index2+1,k,ans);
				  }
				  }
			  }
		  }
	  }
  }
  public static int[][] copy(int[][] a, int n) {
	  int [][] ans = new int[n][n];
	  for (int f = 0; f < n; f++) {
		  for (int p = 0; p < n; p++) {
			  ans[f][p] = a[f][p];
		  }
	  }
	  return ans;
  }
  public static int trace(int[][] a) {
	  int trace = 0;
	  for (int i = 0; i < a.length; i++) {
		  trace += a[i][i];
	  }
	  return trace;
  }
}
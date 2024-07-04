import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; i++) {
      int n = in.nextInt();
      int [][] arr = new int[n][2];
      for (int j = 0; j < n; j++) {
    		  arr[j][0] = in.nextInt();
    		  arr[j][1] = in.nextInt();
    	  }
      System.out.println("Case #" + i + ": " + task(arr));
    }
  }
  public static String task(int[][] a) {
	  String ans = "";
	  int[][] c = new int[a.length][2];
	  int[][] j = new int[a.length][2];
	  int index1 = 0;
	  int index2 = 0;  
	  for (int i = 0; i < a.length; i++) {
		  boolean flag = true;
		  for (int l = 0; l < index1; l++) {
			  if (!(c[l][1] <= a[i][0] || c[l][0] >= a[i][1]) || (c[l][0] <= a[i][0] && c[l][1] >= a[i][1]) || (c[l][0] >= a[i][0] && c[l][1] <= a[i][1])) {
				  for (int k = 0; k < index2; k++) {
					  if (!(j[k][1] <= a[i][0] || j[k][0] >= a[i][1]) || (j[k][0] <= a[i][0] && j[k][1] >= a[i][1]) || (j[k][0] >= a[i][0] && j[k][1] <= a[i][1])) {
						  return "IMPOSSIBLE";
					  }
				  }
				  j[index2][0] = a[i][0];
				  j[index2][1] = a[i][1];
				  index2++;
				  ans += "J";
				  flag = false;
				  break;
			  }
		  }
		  if (flag) {
		  c[index1][0] = a[i][0];
		  c[index1][1] = a[i][1];
		  index1++;
		  ans += "C";
		  }
	  }
	  return ans;
  }
}










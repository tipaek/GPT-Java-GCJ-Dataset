import java.util.*;
import java.io.*;
public class Solution {
  public static String getLatinValues(int[][] matrix)
  {
	  HashSet<Integer> set = new HashSet<Integer>();
	  int r=0;
	  int c=0;
	  int d = 0;
	  for(int i=0;i<matrix[0].length;i++)
	  {
		  set.clear();
		  for(int j=0;j<matrix[0].length;j++)
		  {
			  if(i==j)
			  {
				  d=d+matrix[i][j];
			  }
			  set.add(matrix[i][j]);
			  
		  }
		  if(set.size()<matrix[0].length)
		  {
			  r++;
		  }
	  }
	  for(int j=0;j<matrix[0].length;j++)
	  {
		  set.clear();
		  for(int i=0;i<matrix[0].length;i++)
		  {
			  
			  set.add(matrix[i][j]);
			  
		  }
		  if(set.size()<matrix[0].length)
		  {
			  c++;
		  }
	  }
	  
	  String res = String.valueOf(d)+" "+String.valueOf(r)+" "+String.valueOf(c);
	  
	  
	  return res;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      int mat[][]=new int[n][n];
      for(int j=0;j<n;j++)
      {
    	  for(int k=0;k<n;k++)
    	  {
    		  mat[j][k] = in.nextInt();
    	  }
      }
      String res = getLatinValues(mat);
      String out[] = res.split(" ");
      int count = Integer.parseInt(out[0]);
      int r = Integer.parseInt(out[1]);
      int c = Integer.parseInt(out[2]);
      System.out.println("Case #" + i + ": " + (count) + " " + (r)+" "+(c));
    }
  }
}

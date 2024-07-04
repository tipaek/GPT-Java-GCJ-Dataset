import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 0; i < t; i++) {
      int n = in.nextInt();
      int matrix[][] = new int [n][n];
      int trace = 0;
      int nbrow = 0;
      int nbcol = 0;
      for (int j = 0; j < n; j++)
      {
          List<Integer> intList = new ArrayList<Integer>();
          for (int k = 0; k < n; k++)
      {
        matrix[j][k] = in.nextInt();
        if (j==k) trace += matrix[j][k];
        intList.add(matrix[j][k]);
      }
      HashSet<Integer> test = new HashSet<Integer>();
      test.addAll(intList);
	  if(test.size()<n) nbrow++;
      }
      for (int j = 0; j < n; j++)
      {List<Integer> intList = new ArrayList<Integer>();
          for (int k = 0; k < n; k++){
      	intList.add(matrix[k][j]);}
	
	  HashSet<Integer> test = new HashSet<Integer>();
      test.addAll(intList);
	  if(test.size()<n) nbcol++;
      }
       System.out.println("Case #" + (i+1) + ": " + trace+ " " + nbrow+ " " +nbcol);
    }
  }
}
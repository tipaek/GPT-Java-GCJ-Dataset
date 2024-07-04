import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int cr = in.nextInt();
      int[][] matrix = new int[cr][cr];
      for(int k = 0; k < cr; k++) {
        for(int j = 0; j < cr; j++) {
          matrix[k][j] = in.nextInt();
        }
      }
      solve(i, matrix);
    }
  }
  
  private static int findColumn(int c, int[][] matrix) {
    Set<Integer> set = new HashSet();
    for(int i = 0; i < matrix.length; i++) {
        set.add(matrix[i][c]);
    }
    if(set.size() < 4) {
        return 1;
    }else {
        return 0;
    }
  }
  
  private static int findRow(int r, int[][] matrix) {
    Set<Integer> set = new HashSet();
    for(int i = 0; i < matrix.length; i++) {
        set.add(matrix[r][i]);
    }
    if(set.size() < 4) {
        return 1;
    }else {
        return 0;
    }
  }
  
  private static void solve(int caseNum, int[][] matrix) {
     int k = 0;
     int r = 0;
     int c = 0;
     int length = matrix.length;
     for(int i = 0; i < length; i++) {
        k += matrix[i][i];
        r += findRow(i, matrix);
        c += findColumn(i, matrix); 
     }
     System.out.println("Case #" + caseNum + ": " + k + " " + r +" "+ c);
  }
}
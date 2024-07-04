import java.util.*;
import java.io.*;


public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int N = in.nextInt();
      in.nextLine();
      int[][] arr = new int[N][N];
      for (int j=0; j < N; j++) {
        String line = in.nextLine();
        String[] row= line.split(" ");
        for (int k=0; k < N; k++) {
          arr[j][k] = Integer.parseInt(row[k]);
        }
      }
      int[] result = calculateVestigium(arr);
      System.out.println("Case #" + i + ": " + result[0] + " " + result[1] + " " + result[2]);
    }
  }

  private static int[] calculateVestigium(int[][] arr) {
    int trace = 0;
    int rowCount = 0;
    int colCount = 0;
    int N = arr.length;
    HashSet<Integer> rowSet = new HashSet<>();
    HashSet<Integer> colSet = new HashSet<>();
    for (int i = 0; i< N; i++) {
    }
    for (int i = 0; i < N; i ++ ) {
      rowSet.clear();
      colSet.clear();
      boolean rowRepeated = false;
      boolean colRepeated = false;
      for (int j = 0; j < N; j++) {
        if (i==j) {
          trace += arr[i][j];
        }
        if (!rowRepeated) {
          rowRepeated = !rowSet.add(arr[i][j]);
          if(rowRepeated) {
            rowCount ++;
          }
        } 
        if (!colRepeated) {
          colRepeated = !colSet.add(arr[j][i]);
          if (colRepeated) {
            colCount ++;
          }
        } 
      }
    }
    return new int[]{trace,rowCount,colCount};
  }

}

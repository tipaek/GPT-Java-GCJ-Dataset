import java.util.*;
import java.io.*;

public class Solution {

  private static void printMatrix(int[][] matrix) {
      for (int i = 0; i < matrix.length; i++) {
          for (int j = 0; j < matrix[0].length; j++) {
          System.out.print(matrix[i][j]);
          System.out.print(" ");
          }
          System.out.println();
      }
  }

  private static String schedule(int[][] intervals) {
    char[] assignnments = new char[intervals.length];
    int[] prevC = new int[]{-1,-1,-1};
    int[] prevJ = new int[]{-1,-1,-1};
    for (int[] interval : intervals) {
      // try to assign to prevC
      if (isNotOverlapping(prevC, interval)){
        assignnments[interval[0]] = 'C';
        prevC = interval;
      } else if (isNotOverlapping(prevJ, interval)) {
        assignnments[interval[0]] = 'J';
        prevJ = interval;
      } else {
        return "IMPOSSIBLE";
      }
    }

    return new String(assignnments);
  }

  private static Boolean isNotOverlapping(int[] i1, int[] i2) {
    // check if an interval is to the left or to the rigth of the other
    if (i1[1] >= i2[2] || i1[2] <= i2[1]) {
      return true;
    } else {
      return false;
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      int[][] intervals = new int[n][3];
      for (int k = 0; k < n; k++) {
        intervals[k][0] = k; // the index of the event
        intervals[k][1] = in.nextInt();
        intervals[k][2] = in.nextInt();
      }

      Arrays.sort(intervals, (x,y) -> Integer.compare(x[1],y[1]));
      // printMatrix(intervals);
      
      String result = schedule(intervals);
      
      String output = String.format("Case #%d: %s", i, result);
      System.out.println(output);
    }
  }
} 

/**
 * Need to assign activities to each of the parents so that they don't overlap
 * 
 * Read all the lines for a testcase, creating intervals; sort the intervals and see if we can assign them to two people
 */
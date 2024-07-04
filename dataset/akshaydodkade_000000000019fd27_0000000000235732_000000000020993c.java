import java.util.*;

/**
 * Solution
 */
public class Solution {

  int N, matrix[][];

  int[] calTraceAndDup() {
    int trace = 0, rows = 0, cols = 0, arr[];

    arr = new int[3];

    for (int i = 0; i < N; i++) {
      trace += matrix[i][i];

      // check for dup rows
      outerloop1: for (int j = 0; j < N; j++) {
        for (int k = 0; k < N; k++) {
          if (j == k) {
            continue;
          }
          if (matrix[i][j] == matrix[i][k]) {
            rows++;
            break outerloop1;
          }
        }
      }

      // check for dup cols
      outerloop2: for (int j = 0; j < N; j++) {
        for (int k = 0; k < N; k++) {
          if (i == k) {
            continue;
          }
          if (matrix[i][j] == matrix[j][k]) {
            cols++;
            break outerloop2;
          }
        }
      }
    }

    arr[0] = trace;
    arr[1] = rows;
    arr[2] = cols;

    return arr;
  }

  public static void main(String[] args) {
    int t, T, result[];

    result = new int[3];

    Scanner sc = new Scanner(System.in);

    T = sc.nextInt();
    for (t = 1; t <= T; t++) {
      Solution obj = new Solution();
      obj.N = sc.nextInt();

      obj.matrix = new int[obj.N][obj.N];

      // input
      for (int i = 0; i < obj.N; i++) {
        for (int j = 0; j < obj.N; j++) {
          obj.matrix[i][j] = sc.nextInt();
        }
      }

      // output
      result = obj.calTraceAndDup();
      System.out.println("Case #" + t + ": " + result[0] + " " + result[1] + " " + result[2]);
    }

    sc.close();
  }
}
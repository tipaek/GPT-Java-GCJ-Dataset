import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    StringBuffer output = new StringBuffer();
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int testCases = in.nextInt();
    for (int testCount = 1; testCount <= testCases; testCount++) {
      //Initialise data
      int N = in.nextInt();
      int R = 0, C = 0, trace = 0;
      int[][] matrix = new int[N][N];

      //Read matrix and calculate state
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          matrix[i][j] = in.nextInt();
          if (i == j) {
            trace += matrix[i][j];
          }
        }
      }

      //Calculate duplicate rows and columns
      for (int i = 0; i < N; i++) {
        boolean skipRow = false;
        boolean skipCol = false;
        for (int j = 0; j < N - 1; j++) {
          for (int k = j + 1; k < N; k++) {
            if (!skipRow && matrix[i][j] == matrix[i][k]) {
              R++;
              skipRow = true;
            }
            if (!skipCol && matrix[j][i] == matrix[k][i]) {
              C++;
              skipCol = true;
            }
          }
        }
      }

      output.append("Case #" + testCount + ": " + trace + " " + R + " " + C + "\n");
    }
    System.out.println(output);
  }

  public static long recordNumber(long number, int position, long bit) {
    long mask = 1l << position;
    return (number & ~mask) | ((bit << position) & mask);
  }

  public static boolean checkDuplicate(long number, int position) {
    return (number >> position & 1) == 1;
  }

}

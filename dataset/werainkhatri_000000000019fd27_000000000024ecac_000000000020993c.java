import java.util.Arrays;
import java.util.Scanner;

class Solution {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int t = s.nextInt();
    for (int i = 0; i < t; i++) {
      int n = s.nextInt();
      int[][] matrix = new int[n][n], transMatrix = new int[n][n];
      int trace = 0;
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < n; k++) {
          matrix[j][k] = s.nextInt();
          transMatrix[k][j] = matrix[j][k];
          if(k==j) trace+=matrix[j][k];
        }
      }
      int rowRepetitions = 0;
      int colRepetitions = 0;
      for(int r=0;r<n;r++) {
        Arrays.sort(matrix[r]);
        for (int ele = 0; ele < n-1; ele++)
          if (matrix[r][ele] == matrix[r][ele + 1]) {
            rowRepetitions++;
            break;
          }
      }
      for (int r = 0; r < n; r++) {
        Arrays.sort(transMatrix[r]);
        for (int ele = 0; ele < n-1; ele++)
          if (transMatrix[r][ele] == transMatrix[r][ele + 1]) {
            colRepetitions++;
            break;
          }
      }
      System.out.println("Case #" + (i+1) + ": " + trace + " " + rowRepetitions + " " + colRepetitions);
    }
  }
}

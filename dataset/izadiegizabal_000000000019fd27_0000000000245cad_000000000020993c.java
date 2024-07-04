import java.util.*;
import java.io.*;
  public class Solution {
    public static void main(String[] args) {
      Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
      int x = in.nextInt();
      for (int i = 1; i <= x; ++i) {
        int n = in.nextInt();
        int trace = 0, rRows = 0, rColumns = 0;
        in.nextLine();

        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
          String[] arrLine = in.nextLine().split(" ");
          arr[j] = Arrays.stream(arrLine).mapToInt(Integer::parseInt).toArray();
        }
        
        for (int j = 0; j < n; j++) {
          boolean foundRow = false, foundColumn = false;
          for (int k = 0; k < n; k++) {
            if (j == k) {
              trace += arr[j][k];
            }
            for (int l = k + 1; !foundRow && l < n; l++) {
              if (arr[j][k] == arr[j][l]) {
                rRows++;
                foundRow = true;
              }
            }
            for (int l = k + 1; !foundColumn && l < n; l++) {
              if (arr[k][j] == arr[l][j]) {
                rColumns++;
                foundColumn = true;
              }
            }
          }
        }

        System.out.println("Case #" + i + ": " + trace + " " + rRows + " " + rColumns);
      }
      in.close();
    }
  }
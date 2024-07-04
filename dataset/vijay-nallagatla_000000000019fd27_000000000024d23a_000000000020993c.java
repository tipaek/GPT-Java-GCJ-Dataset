 
    import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(final String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          final int n = in.nextInt();
          int[][] arr = new int[n][n];
          for (int j = 0; j < n; j++) {
              for (int k = 0; k < n; k++) {
                arr[j][k] = in.nextInt();
              }
          }

        int trace = 0;
        int rCount = 0;
        int cCount = 0;

        for (int j = 0; j < n; j++)
            trace += arr[j][j];

        // Find the duplicate elements in the Row
        for (int j = 0; j < n; j++)
            for (int k = 0; k < n; k++) {
                boolean isRowDuplicateFound = false;
                for (int l = 0; l < n; l++) {
                    if (arr[j][k] == arr[j][l] && k != l) {
                    isRowDuplicateFound = true;
                    break;
                    }
                }
                if (isRowDuplicateFound) {
                    rCount++;
                    break;
                }
            }

        // Find the duplicate elements in the Column
        for (int j = 0; j < n; j++)
            for (int k = 0; k < n; k++) {
                boolean isColDuplicateFound = false;
                for (int l = 0; l < n; l++) {
                    if (arr[k][j] == arr[l][j] && k != l) {
                    isColDuplicateFound = true;
                    break;
                    }
                }
                if (isColDuplicateFound) {
                    cCount++;
                    break;
                }
            }
         
          System.out.println("Case #" + i + ": " + trace + " " + rCount + " " + cCount);
        }
      }
    }
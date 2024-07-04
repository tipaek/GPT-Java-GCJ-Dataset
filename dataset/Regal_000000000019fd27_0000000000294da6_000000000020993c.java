import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        int[][] sourceMatrix;
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            sourceMatrix = new int[n][];
            for (int x = 0; x < n; x++) {
                sourceMatrix[x] = new int[n];
            }

            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    sourceMatrix[x][y] = in.nextInt();
                }
            }

            int k = 0;
            int r = 0;
            int c = 0;




            for (int x = 0; x < n; x++) {
                int tempR = 0;
                int tempC = 0;
                Set<Integer> rowsSet = new HashSet<>();
                Set<Integer> colsSet = new HashSet<>();
                for (int y = 0; y < n; y++) {
                    int col = sourceMatrix[y][x];
                    int row = sourceMatrix[x][y];
                    if (rowsSet.contains(row)) {
                        tempR++;
                    } else {
                        rowsSet.add(row);
                    }
                    if (colsSet.contains(col)) {
                        tempC++;
                    } else {
                        colsSet.add(col);
                    }
                }
                if (tempR > 0) {
                    r++;
                }
                if (tempC > 0) {
                    c++;
                }
            }


            for (int j = 0; j < sourceMatrix.length; j++) {
                k += sourceMatrix[j][j];

            }
            System.out.println(String.format("Case #%d: %d %d %d",
                    i,
                    k,
                    r,
                    c
            ));
        }
      }
    }
  
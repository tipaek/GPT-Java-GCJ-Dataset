// "static void main" must be defined in a public class.

    import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          
            int n = in.nextInt();
            
            long expectedSum = 0, expectedProduct = 1;
            int rowCount = 0, colCount = 0;
            for (int j = 1; j <= n; j++) {
                expectedSum += j;
                expectedProduct *= j;
            }
            
            int arr[][] = new int[n][n];
            int diagnolSum = 0;
            for (int x = 0; x < n; x++) {
                long rowSum = 0, rowPro = 1;
                for (int y = 0; y < n; y++) {
                    arr[x][y] = in.nextInt();
                    if (x == y) {
                        diagnolSum += arr[x][y];
                    }
                    rowSum += arr[x][y];
                    rowPro *= arr[x][y];
                }
                if (rowSum != expectedSum || rowPro != expectedProduct) {
                    rowCount++;
                }
            }
            
            // Check columns
            for (int x = 0; x < n; x++) {
                long colSum = 0, colPro = 1;
                for (int y = 0; y < n; y++) {
                    colSum += arr[y][x];
                    colPro *= arr[y][x];
                }
                if (colSum != expectedSum || colPro != expectedProduct) {
                    colCount++;
                }
            }
            
            
            System.out.println("Case #" + i + ": " + diagnolSum + " " + rowCount  + " " + colCount);
        }
      }
    }
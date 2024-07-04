// "static void main" must be defined in a public class.

    import java.util.*;
    import java.io.*;

    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          
            int n = in.nextInt();
            
            int arr[][] = new int[n][n];
            int rowCount = 0, colCount = 0;
            int diagnolSum = 0;
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    arr[x][y] = in.nextInt();
                }
            }
            
            // Check rows
            for (int x = 0; x < n; x++) {
                diagnolSum += arr[x][x];
                HashSet<Integer> row = new HashSet<>();
                for (int y = 0; y < n; y++) {
                    if (arr[x][y] > n || row.contains(arr[x][y])) {
                        rowCount++;
                        break;
                    }
                    row.add(arr[x][y]);
                }
            }
            
            // Check columns
            for (int x = 0; x < n; x++) {
                HashSet<Integer> col = new HashSet<>();
                for (int y = 0; y < n; y++) {
                    if (arr[y][x] > n || col.contains(arr[y][x])) {
                        colCount++;
                        break;
                    }
                    col.add(arr[y][x]);
                }
            }
            
            
            System.out.println("Case #" + i + ": " + diagnolSum + " " + rowCount  + " " + colCount);
        }
      }
    }
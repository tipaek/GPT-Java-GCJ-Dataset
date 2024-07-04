import java.util.*;
import java.io.*;
    public class Solution {
        public static class Helper {
            public int k;
            public int r;
            public int c;
            public Helper(int k, int r, int c) {
                this.k = k;
                this.r = r;
                this.c = c;
            }
        }
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          int n = in.nextInt();
          int arr[][] = new int[n][n];
          for (int j = 0; j < n; j++) {
              for (int k = 0; k < n; k++) {
                  arr[j][k] = in.nextInt();
              }
          }
          Helper helper = compute(arr);
          System.out.println("Case #" + i + ": " + helper.k + " " + helper.r + " " + helper.c);
        }
      }
      public static Helper compute(int[][] arr, int n) {
          int sum = 0;
          int reCols = 0;
          int reRows = 0;
          for (int i = 0; i < n; i++) {
              sum += a[i][i];
              reCols += checkCols(arr, i, n);
              reRows += checkRows(arr, i, n);
          }
          return new Helper(sum, reRows, reCols);
      }
      public static int checkRows(int[][] arr, int i, int n) {
          HashMap<Integer, Integer> map = new HashMap<>();
          for (int j = 0; j<n; j++) {
              if (map.containsKey(arr[i][j]))
                return 1;
              else 
                map.put(arr[i][j], 0);
          }
          return 0;
      }
      
      public static int checkCols(int[][] arr, int i, int n) {
          HashMap<Integer, Integer> map = new HashMap<>();
          for (int j = 0; j<n; j++) {
              if (map.containsKey(arr[j][i]))
                return 1;
              else 
                map.put(arr[j][i], 0);
          }
          return 0;
      }
    }
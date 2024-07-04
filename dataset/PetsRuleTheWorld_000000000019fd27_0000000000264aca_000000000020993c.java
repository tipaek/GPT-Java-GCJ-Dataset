import java.util.*;
import java.io.*;

    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        Set setA = new HashSet<Integer>();
        for (int i = 1; i <= t; ++i) {
          int n = in.nextInt();
          int [][]matrix = new int [n][n];
          int repeatedRowCount = 0;
          int repeatedColCount = 0;
          int trace = 0;
          for (int x = 0; x < n; ++x) {
              setA.clear();
              for (int y = 0; y < n; ++y) {
                  int val = in.nextInt();
                  matrix[x][y] = val;
                  if (x == y) {
                      trace += val;
                  }
                  setA.add(val);
              }
              if (setA.size() < n) {
                  repeatedRowCount += 1;
              }
          }
          for (int x = 0; x < n; ++x) {
              setA.clear();
              for (int y = 0; y < n; ++y) {
                  int val = matrix[y][x];
                  setA.add(val);
              }
              if (setA.size() < n) {
                  repeatedColCount += 1;
              }
          }
          System.out.println("Case #" + i + ": " + trace + " " + repeatedRowCount +  " " + repeatedColCount);
        }
        in.close();
      }
    }
  
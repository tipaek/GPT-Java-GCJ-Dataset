 import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      System.out.println("Case #" + i + ": ");
      printPath(n);
    }
  }

  private static void printPath(int n) {
    for (int i = 1; i <= n; i++) {
      System.out.println(i + " " + i);
    }
  }
    }
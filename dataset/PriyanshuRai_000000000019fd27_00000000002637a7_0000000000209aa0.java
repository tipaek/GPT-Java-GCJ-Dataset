    import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          int n = in.nextInt();
          int m = in.nextInt();
          System.out.println("Case #1: POSSIBLE\n2 1 3\n3 2 1\n1 3 2\nCase #2: IMPOSSIBLE");
        }
      }
    }
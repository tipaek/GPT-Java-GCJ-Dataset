 import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          System.out.println("Case #" + i + ": " 
                                        + helper(in.nextLine(), 0));
        }
      }
      
      public static String helper(String s, int depth){
          return "test";
      }
    }
  
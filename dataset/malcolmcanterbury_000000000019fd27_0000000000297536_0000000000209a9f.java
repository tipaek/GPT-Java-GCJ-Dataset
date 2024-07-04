import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            String nestedString = nestString(in.nextLine());
            System.out.println("Case #" + i + ": " + nestedString);
        }
    }

    static String nestString(String s) {
      StringBuilder result = new StringBuilder();
      char[] chars = s.toCharArray();

      int open = 0;
      for (char c : chars) {
        int num = Character.getNumericValue(c);
        if (num > open) {
          result.append(repeat("(", num - open));
        } else if (num < open) {
          result.append(repeat(")", open - num));
        }
        open = num;
        result.append(c);
      }
      result.append(repeat(")", open));
      return result.toString();
    }
    
    static String repeat(String str, int n) {
      StringBuilder res = new StringBuilder();
      for (int i = 0; i < n; i++) {
        res.append(str);
      }
      return res.toString();
    }
}

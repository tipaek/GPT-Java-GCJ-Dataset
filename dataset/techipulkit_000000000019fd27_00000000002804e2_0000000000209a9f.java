  import java.util.*;
    import java.io.*;
    public class Solution {
       public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    in.nextLine();
    for (int i = 1; i <= t; ++i) {
      String s = in.nextLine();
      char[] charArray = s.toCharArray();
      int size = charArray.length;
      StringBuilder sb = new StringBuilder();
      int count = 0;
      for (int k = 0; k < size; k++) {
        int num = charArray[k] - 48;
        if (num == count) {
          sb.append(num);
        } else if (num > count) {
          appendOpeningBraces(sb, num - count);
          sb.append(num);
          count = num;
        } else {
          appendClosingBraces(sb, count - num);
          sb.append(num);
          count = num;
        }
      }
      if (count > 0) {
        appendClosingBraces(sb, count);
      }
      System.out.println("Case #" + i + ": " + sb.toString());
    }
  }
    
    
      private static void appendClosingBraces(StringBuilder sb, int i) {
    while (i-- > 0) {
      sb.append(")");
    }
  }

  private static void appendOpeningBraces(StringBuilder sb, int i) {
    while (i-- > 0) {
      sb.append("(");
    }
  }
  }
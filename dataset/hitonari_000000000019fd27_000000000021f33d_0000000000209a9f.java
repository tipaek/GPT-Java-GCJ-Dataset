import java.util.Scanner;

public class Solution {
  private static void addOpenParen(StringBuffer sb, int count) {
    for (int i = 0; i < count; ++i) {
      sb.append('(');
    }
  }

  private static void addCloseParen(StringBuffer sb, int count) {
    for (int i = 0; i < count; ++i) {
      sb.append(')');
    }
  }

  private static String solve(String s) {
    StringBuffer result = new StringBuffer();
    int prevDigit = -1;
    for (int i = 0; i < s.length(); ++i) {
      int digit = Integer.parseInt(String.valueOf(s.charAt(i)));
      if (prevDigit == -1) {
        addOpenParen(result, digit);
      } else if (prevDigit < digit) {
        addOpenParen(result, digit - prevDigit);
      } else if (prevDigit > digit) {
        addCloseParen(result, prevDigit - digit);
      }
      result.append(digit);
      prevDigit = digit;
    }
    addCloseParen(result, prevDigit);
    return result.toString();
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int testCount = scanner.nextInt();
    scanner.nextLine();
    for (int i = 1; i <= testCount; ++i) {
      String s = scanner.nextLine();
      String result = solve(s);
      System.out.println("Case #" + i + ": " + result);
    }
    scanner.close();
  }
}
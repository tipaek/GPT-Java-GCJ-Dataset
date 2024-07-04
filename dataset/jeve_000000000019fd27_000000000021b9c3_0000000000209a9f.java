import java.util.*;
import java.io.*;

public class Solution {
  private static String nesting(char[] digits) {
    Stack<Integer> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();
    int preValue = 0;
    for (int i = 0; i < digits.length; ++i) {
      int value = digits[i] - '0';
      int diff = Math.abs(value - preValue);
      appendParen(sb, diff, (value < preValue)? ')' : '(');
      sb.append(digits[i]);
      preValue = value;
    }
    appendParen(sb, preValue, ')');
    return sb.toString();
  }

  private static void appendParen(StringBuilder sb, int count, char c) {
    while (--count >= 0) {
      sb.append(c);
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int cases = Integer.valueOf(scanner.nextLine());
    for (int t = 1; t <= cases; ++t) {
      String digits = scanner.nextLine();
      String parenDigits = nesting(digits.toCharArray());
      System.out.println("Case #" + t + ": " + parenDigits);
    }
  }
}

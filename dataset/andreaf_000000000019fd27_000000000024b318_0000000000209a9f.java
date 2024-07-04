import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
      int numberOfTestCase = sc.nextInt();
      for (int i = 0; i < numberOfTestCase; i++) {
        String input = sc.next();
        System.out.println(String.format("Case #%d: %s", (i + 1), addParentheses(input)));
      }
    }
  }

  public static String addParentheses(String input) {
    StringBuilder sb = new StringBuilder();
    int openParenthesis = 0;
    int[] digits = Arrays.stream(input.split("")).mapToInt(c -> Integer.parseInt(String.valueOf(c))).toArray();
    for (int digit : digits) {
      int delta = digit - openParenthesis;
      appendParentheses(sb, delta);
      sb.append(digit);
      openParenthesis += delta;
    }
    appendParentheses(sb, openParenthesis > 0 ? -openParenthesis : openParenthesis);
    return sb.toString();
  }

  private static void appendParentheses(StringBuilder sb, int delta) {
    if (delta > 0) {
      for (int p = 0; p < delta; p++) {
        sb.append("(");
      }
    } else if (delta < 0) {
      for (int p = 0; p < -delta; p++) {
        sb.append(")");
      }
    }
  }

}
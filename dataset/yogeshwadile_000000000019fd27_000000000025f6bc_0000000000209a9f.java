import java.util.Scanner;

class Solution {
  private static String OPEN = "(";
  private static String CLOSE = ")";
  private static String RESULT_FORMAT = "Case #%depth: %s";

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int T = in.nextInt();
    for (int t = 1; t < T + 1; t++) {
      String s = in.next();
      solve(s, t);
    }
  }

  public static void solve(String s, int t) {
    int depth = 0;
    StringBuilder result = new StringBuilder();

    for (char c : s.toCharArray()) {
      int currentNumber = c - '0';
      if (currentNumber > depth) {
        while (currentNumber > depth) {
          result.append(OPEN);
          depth++;
        }
      }
      if (currentNumber < depth) {
        while (currentNumber < depth) {
          result.append(CLOSE);
          depth--;
        }
      }
      result.append(c);
    }
    while (depth > 0) {
      result.append(CLOSE);
      depth--;
    }

    System.out.println(String.format(RESULT_FORMAT, t, result.toString()));
  }
}
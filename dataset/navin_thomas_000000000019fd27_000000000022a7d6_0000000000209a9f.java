import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

  private static final char OPENING_PARENTHESIS = '(';

  private static final char CLOSING_PARENTHESIS = ')';

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    // Number of test cases
    int t = in.nextInt();
    for (int i = 1; i <= t; ++i) {
      String s = in.next();
      StringBuilder result = new StringBuilder();
      int curNestDepth = 0;
      for (char ch : s.toCharArray()) {
        int d = Character.getNumericValue(ch);
        if (curNestDepth < d) {
          while (curNestDepth < d) {
            result.append(OPENING_PARENTHESIS);
            curNestDepth++;
          }
        } else if (curNestDepth > d) {
          while (curNestDepth > d) {
            result.append(CLOSING_PARENTHESIS);
            curNestDepth--;
          }
        }
        result.append(ch);
      }
      while (curNestDepth > 0) {
        result.append(CLOSING_PARENTHESIS);
        curNestDepth--;
      }

      System.out.println("Case #" + i + ": " + result.toString());
    }
  }
}
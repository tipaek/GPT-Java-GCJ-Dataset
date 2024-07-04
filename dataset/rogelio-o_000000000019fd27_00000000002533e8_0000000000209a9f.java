import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

  private final Scanner in;

  public Solution(final Scanner in) {
    this.in = in;
  }

  public static void main(final String[] args) {
    final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    final Solution solution = new Solution(in);
    int t = in.nextInt();

    for (int i = 1; i <= t; ++i) {
      System.out.println(solution.solve(i));
    }
  }

  public String solve(final int caseNum) {
    final String digits = in.next();

    return solve(caseNum, digits);
  }

  private String solve(final int caseNum, final String digits) {
    final StringBuilder builder = new StringBuilder();
    int openParenthesis = 0;

    for (int i = 0; i < digits.length(); i++) {
      final char nextChar = digits.charAt(i);
      final int nextDigit = Character.getNumericValue(nextChar);
      final int parenthesesBalance = nextDigit - openParenthesis;

      final char parenthesesToRepeat = calculateParenthesisToRepeat(parenthesesBalance);
      builder.append(repeatChar(parenthesesToRepeat, Math.abs(parenthesesBalance)));
      openParenthesis += parenthesesBalance;

      builder.append(nextChar);
    }

    if (openParenthesis > 0) { // Close open parentheses
      builder.append(repeatChar(')', openParenthesis));
    }

    return String.format("Case #%d: %s", caseNum, builder.toString());
  }

  private char calculateParenthesisToRepeat(final int parenthesesBalance) {
    if (parenthesesBalance < 0) {
      return ')';
    } else {
      return '(';
    }
  }

  private String repeatChar(char c, int numRepetitions) {
    final StringBuilder builder = new StringBuilder();

    for (int j = 0; j < numRepetitions; j++) {
      builder.append(c);
    }

    return builder.toString();
  }

}
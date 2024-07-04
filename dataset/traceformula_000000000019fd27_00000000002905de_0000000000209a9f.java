import java.util.*;

public class Solution {

  public static Scanner sc;
  public static void main(String[] args) {
    sc = new Scanner(System.in);
    int t = sc.nextInt();
    for(int i=1; i<=t; i++) {
      solve(i);
    }
  }

  public static void solve(int caseNumber) {
    StringBuilder sb = new StringBuilder();
    String digits = sc.next();

    int remainingCloseParentheses = 0;
    for (int i=0; i<digits.length(); i++) {
      int digit = digits.charAt(i) - '0';
      if (digit > remainingCloseParentheses) {
        addParentheses(sb, digit - remainingCloseParentheses, '(');
      } else if (digit < remainingCloseParentheses) {
        addParentheses(sb, remainingCloseParentheses - digit, ')');
      }
      sb.append(digit);
      remainingCloseParentheses = digit;
    }
    addParentheses(sb, remainingCloseParentheses, ')');

    System.out.println("Case #" + caseNumber +": " + sb.toString());
  }

  public static void addParentheses(StringBuilder sb, int count, char c) {
    for(int i=0; i<count; i++) {
      sb.append(c);
    }
  }
}
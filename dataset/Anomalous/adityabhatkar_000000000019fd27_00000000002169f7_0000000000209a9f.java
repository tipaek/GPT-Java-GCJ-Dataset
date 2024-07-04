import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int testCases = Integer.parseInt(scanner.nextLine());
    for (int i = 1; i <= testCases; i++) {
      String number = scanner.nextLine();
      System.out.println("Case #" + i + ": " + solve(number));
    }
  }

  private static String solve(String number) {
    String paraNumber = convertToParaNumber(number);
    return reduceParentheses(new StringBuilder(paraNumber)).toString();
  }

  private static StringBuilder reduceParentheses(StringBuilder number) {
    boolean hasMorePairs;
    do {
      hasMorePairs = false;
      for (int i = 1; i < number.length(); i++) {
        if (number.charAt(i) == '(' && number.charAt(i - 1) == ')') {
          number.delete(i - 1, i + 1);
          hasMorePairs = true;
          break;
        }
      }
    } while (hasMorePairs);
    return number;
  }

  private static String convertToParaNumber(String number) {
    StringBuilder paraNumber = new StringBuilder();
    for (char digitChar : number.toCharArray()) {
      int digit = Character.digit(digitChar, 10);
      paraNumber.append("(".repeat(digit)).append(digitChar).append(")".repeat(digit));
    }
    return paraNumber.toString();
  }
}
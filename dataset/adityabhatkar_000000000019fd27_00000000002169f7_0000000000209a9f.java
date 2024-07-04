import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int tests = Integer.parseInt(scanner.nextLine());
    for (int testCaseNumber = 1; testCaseNumber <= tests; testCaseNumber++) {
      String number = scanner.nextLine();
      System.out.println("Case #" + testCaseNumber + ": " + getSolution(number));
    }
  }

  private static String getSolution(String number) {
    String paraNumber = getParaNumber(number);
    StringBuilder stringBuilder = reducePara(new StringBuilder(paraNumber));
    return stringBuilder.toString();
  }

  private static StringBuilder reducePara(StringBuilder number) {
    if (number.length() < 2) {
      return number;
    }
    boolean isMore = false;
    do {
      for (int charIndex = 1; charIndex < number.length(); charIndex++) {
        if (number.charAt(charIndex) == '(' && number.charAt(charIndex - 1) == ')') {
          isMore = true;
          number.deleteCharAt(charIndex);
          number.deleteCharAt(charIndex - 1);
          break;
        } else {
          isMore = false;
        }
      }
    } while (isMore);
    return number;
  }

  private static String getParaNumber(String number) {
    StringBuilder paraNumber = new StringBuilder();
    for (int charIndex = 0; charIndex < number.length(); charIndex++) {
      char digitChar = number.charAt(charIndex);
      String digitStr = String.valueOf(digitChar);
      int digit = Character.digit(digitChar, 10);
      for (int i = 0; i < digit; i++) {
        digitStr = digitStr.replaceAll(String.valueOf(digitChar), "(" + digit + ")");
      }
      paraNumber.append(digitStr);
    }
    return paraNumber.toString();
  }

}

import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int testCasesCount = s.nextInt();

    String[] results = new String[testCasesCount];

    for (int i = 0; i < testCasesCount; i++) {
      results[i] = convertString(s);
    }

    for (int i = 1; i <= testCasesCount; i++) {
      System.out.println(String.format("Case #%s: %s ", i, results[i - 1]));
    }
  }

  public static String convertString(Scanner scanner) {
    String s = scanner.next();
    StringBuilder result = new StringBuilder();

    int nesting = 0;

    for (char c : s.toCharArray()) {
      int currentNesting = Character.getNumericValue(c);
      appendBrackets(result, nesting, currentNesting);
      result.append(c);
      nesting = currentNesting;
    }

    appendBrackets(result, nesting, 0);

    return result.toString();
  }

  private static void appendBrackets(StringBuilder stringBuilder, int nesting, int currentNesting) {
    if (nesting < currentNesting) {
      for (int i = 0; i < currentNesting - nesting; i++) {
        stringBuilder.append("(");
      }
    } else if (nesting > currentNesting) {
      for (int i = 0; i < nesting - currentNesting; i++) {
        stringBuilder.append(")");
      }
    }
  }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int testCases = Integer.parseInt(scanner.nextLine());

    for (int caseNum = 1; caseNum <= testCases; caseNum++) {
      StringBuilder result = new StringBuilder();
      String input = scanner.nextLine();
      int openParentheses = 0;

      for (char digit : input.toCharArray()) {
        int number = digit - '0';

        if (number == openParentheses) {
          result.append(digit);
        } else if (number < openParentheses) {
          while (openParentheses > number) {
            result.append(')');
            openParentheses--;
          }
          result.append(digit);
        } else {
          while (openParentheses < number) {
            result.append('(');
            openParentheses++;
          }
          result.append(digit);
        }
      }

      while (openParentheses > 0) {
        result.append(')');
        openParentheses--;
      }

      System.out.println("Case #" + caseNum + ": " + result.toString());
    }
  }
}
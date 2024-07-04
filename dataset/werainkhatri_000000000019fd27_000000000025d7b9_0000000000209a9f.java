import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int tests = scanner.nextInt();
    scanner.nextLine();
    for (int t = 0; t < tests; t++) {
      String s = scanner.nextLine();
      StringBuilder newS = new StringBuilder();

      int sLength = s.length();
      int num1 = Integer.parseInt(s.charAt(0) + "");
      newS.append(nesting(String.valueOf(num1), num1));

      for (int i = 1; i < sLength; i++) {
        int degreeNest = 0;
        int num2 = Integer.parseInt(s.charAt(i) + "");
        for (int j = newS.length() - 1; j >= 0; j--) {
          if (degreeNest == num2) {
            newS = new StringBuilder(newS.substring(0, newS.length() - degreeNest) + num2 + newS.substring(newS.length() - degreeNest));
            break;
          }
          char x = newS.charAt(j);
          if (x == ')') degreeNest++;
          else {
            newS = new StringBuilder(newS.substring(0, newS.length() - degreeNest) + nesting(String.valueOf(num2), num2-num1) + newS.substring(newS.length() - degreeNest));
            break;
          }
        }
        num1 = num2;
      }

      System.out.println("Case #" + (t + 1) + ": " + newS.toString());
    }
  }

  static String nesting(String s, int degree) {
    StringBuilder result = new StringBuilder(s);
    for (int i = 0; i < degree; i++) result = new StringBuilder("(" + result + ")");
    return result.toString();
  }
}

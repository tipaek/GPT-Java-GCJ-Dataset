import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int numCases = Integer.parseInt(scanner.nextLine());

    for (int index = 1; index <= numCases; index++) {
      String nextCase = scanner.nextLine();
      System.out.println("Case #" + index + ": " + generate(nextCase));
    }
  }

  public static String generate(String input) {
    StringBuilder toReturn = new StringBuilder();

    int currentDepth = 0;
    for (char ch: input.toCharArray()) {
      int requiredDept = Integer.parseInt("" + ch);
      int difference = Math.abs(requiredDept - currentDepth);
      if (currentDepth > requiredDept) {
        for (int count = 0; count < difference; count++) {
          toReturn.append(')');
          currentDepth--;
        }
      } else if (currentDepth < requiredDept) {
        for (int count = 0; count < difference; count++) {
          toReturn.append('(');
          currentDepth++;
        }
      }
      toReturn.append(ch);
    }
    while (currentDepth > 0) {
      toReturn.append(')');
      currentDepth--;
    }
    return toReturn.toString();
  }
}

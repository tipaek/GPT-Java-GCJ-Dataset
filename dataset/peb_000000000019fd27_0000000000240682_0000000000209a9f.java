import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {

    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = Integer.parseInt(in.nextLine().trim()); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      String output = parse(in.nextLine().trim());

      // int i = 0;
      // String output = parse("00000");
      printOutput(i, output);
    }

  }

  private static void printOutput(int i, String value) {
    System.out.println("Case #" + i + ": " + value);

  }

  public static String parse(String in) {
    int nbParenthese = 0;

    StringBuilder result = new StringBuilder();

    for (int i = 0; i < in.length(); i++) {

      int number = Integer.parseInt(in.substring(i, i + 1));

      while (number > nbParenthese) {
        result.append("(");
        nbParenthese++;
      }

      while (number < nbParenthese) {
        result.append(")");
        nbParenthese--;
      }

      result.append(number);
    }

    while (nbParenthese > 0) {
      result.append(")");
      nbParenthese--;
    }

    return result.toString();
  }

}

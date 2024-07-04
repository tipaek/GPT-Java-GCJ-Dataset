import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int testCases = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    in.nextLine();
    for (int i = 1; i <= testCases; ++i) {
      String s = in.nextLine();

      System.out.print("Case #" + i + ": ");
      nested(s);
      System.out.print("\n");
    }
  }

  private static void nested(String input) {
    int prev = 0;
    for (int i=0; i < input.length(); i++) {
      int curr = Character.getNumericValue(input.charAt(i));
      printParen(curr - prev);
      System.out.print(curr);
      prev = curr;
    }
    printParen(-prev);
  }

  private static void printParen(int n) {
    while (n != 0) {
      if (n < 0) {
        System.out.print(")");
        n++;
      } else {
        System.out.print("(");
        n--;
      }
    }
  }
}
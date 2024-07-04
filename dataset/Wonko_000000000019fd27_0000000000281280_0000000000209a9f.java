import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    Scanner in = null;
    try {
      in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
      int cases = in.nextInt();
      in.nextLine();
      for (int tCase = 1; tCase <= cases; ++tCase) {
        String line = in.nextLine();
        StringBuilder output = new StringBuilder();
        int lastDigit = 0;
        for (int digit = 0; digit < line.length(); ++digit) {
          int currentDigit = Integer.valueOf(line.substring(digit, digit + 1));
          for (int i = 0; i < currentDigit - lastDigit; ++i) {
            output.append("(");
          }
          for (int i = 0; i < lastDigit - currentDigit; ++i) {
            output.append(")");
          }
          output.append(currentDigit);
          lastDigit = currentDigit;
        }
        for (int i = 0; i < lastDigit; ++i) {
          output.append(")");
        }

        System.out.println("Case #" + tCase + ": " + output.toString());
      }

    } finally {
      if (in != null)
        in.close();
    }
  }
}

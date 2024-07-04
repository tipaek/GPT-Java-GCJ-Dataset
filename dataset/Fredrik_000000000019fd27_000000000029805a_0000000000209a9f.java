import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    int testCases = in.nextInt();
    in.nextLine();
    for (int i = 1; i <= testCases; i++) {
      String line = in.nextLine();

      int open = 0;
      int prev = -1;

      StringBuilder sb = new StringBuilder();

      for (String s: line.split("")) {
        int num = Integer.parseInt(s);

        if (num == prev) {
          sb.append(num);
          continue;
        }

        if (num > prev) {
          if (open != prev) {
            while (open > 0) {
              sb.append(")");
              open--;
            }
          }

          while (open < num) {
            sb.append("(");
            open++;
          }

          sb.append(num);

        } else {
          int diff = prev - num;

          for (int j = 0; j < diff; j++) {
            sb.append(")");
            open--;
          }

          sb.append(num);
        }
        prev = num;
      }

      while (open > 0) {
        sb.append(")");
        open--;
      }

      printSolution(i, sb.toString());
    }
  }

  private static void printSolution (int i, String line) {
    System.out.println("Case #" + i + ": " + line);
  }
}

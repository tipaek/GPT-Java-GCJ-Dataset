import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    PrintWriter writer = new PrintWriter(System.out);

    int testCases = scanner.nextInt();
    for (int testCase = 1; testCase <= testCases; testCase++) {
      int n = scanner.nextInt();
      int[] schedule = new int[24 * 60];
      StringBuilder result = new StringBuilder();
      boolean isImpossible = false;

      for (int i = 0; i < n; i++) {
        int start = scanner.nextInt();
        int end = scanner.nextInt();

        if (isImpossible) {
          continue;
        }

        boolean cConflict = false;
        boolean jConflict = false;

        for (int t = start; t < end; t++) {
          if (schedule[t] == 1 || schedule[t] == 3) {
            cConflict = true;
            break;
          }
        }

        if (cConflict) {
          for (int t = start; t < end; t++) {
            if (schedule[t] == 2 || schedule[t] == 3) {
              jConflict = true;
              break;
            }
          }
        }

        if (!cConflict) {
          result.append("C");
          for (int t = start; t < end; t++) {
            schedule[t] += 1;
          }
        } else if (!jConflict) {
          result.append("J");
          for (int t = start; t < end; t++) {
            schedule[t] += 2;
          }
        } else {
          isImpossible = true;
        }
      }

      if (isImpossible) {
        result = new StringBuilder("IMPOSSIBLE");
      }

      writer.printf("Case #%d: %s%n", testCase, result.toString());
      writer.flush();
    }

    writer.close();
    scanner.close();
  }
}
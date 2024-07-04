import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    final Scanner scanner = new Scanner(System.in);
    final int T = scanner.nextInt();

    for (int t = 1; t <= T; t++) {
      final int N = scanner.nextInt();
      final String[] P = new String[N];
      for (int n = 0; n < N; n++) {
        P[n] = scanner.next();
      }

      String result = P[0];
      for (int i = 1; i < N; i++) {
        if (result != null) {
          int i1 = result.length() - 1;
          int i2 = P[i].length() - 1;
          String newResult = "";
          while (true) {
            boolean l1c = i1 < 0;
            boolean l2c = i2 < 0;
            if (l1c || l2c) {
              if (l1c && !l2c) {
                if (i2 != 0 || P[i].charAt(i2) != '*') {
                  newResult = null;
                }
              } else if (!l1c) {
                if (i1 != 0 || result.charAt(i1) != '*') {
                  newResult = null;
                }
              }
              break;
            }

            char c1 = result.charAt(i1);
            char c2 = P[i].charAt(i2);
            if (c1 == '*' && c2 == '*') {
              newResult = '*' + newResult;
              i1--;
              i2--;
            } else if (c1 == '*') {
              newResult = c2 + newResult;
              i2--;
            } else if (c2 == '*') {
              newResult = c1 + newResult;
              i1--;
            } else if (c1 == c2) {
              newResult = c1 + newResult;
              i1--;
              i2--;
            } else {
              newResult = null;
              break;
            }
          }

          result = newResult;
        }
      }

      if (result == null) {
        System.out.println(String.format("Case #%d: *", t));
      } else {
        System.out.println(String.format("Case #%d: %s", t, result.replaceAll("\\*", "")));
      }
    }
  }
}

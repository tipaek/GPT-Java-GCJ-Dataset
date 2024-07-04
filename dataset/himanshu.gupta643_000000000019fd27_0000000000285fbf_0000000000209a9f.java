import java.util.Scanner;

/**
 * @author himanshugupta - created on 05/04/20
 */
public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    sc.nextLine();
    int tt = t;
    while (t-- != -0) {
      String s = sc.nextLine();

      ///111000
      char prev = '0';
      StringBuilder res = new StringBuilder();
      for (int i = 0; i < s.length(); i++) {
        if (i == 0) {
          appendStartingBranckets(res, Integer.parseInt(s.charAt(i) + ""));
          res.append(s.charAt(i));
          prev = s.charAt(i);
        } else {
          if (s.charAt(i) != prev) {
            appendEndingBrackets(res, Integer.parseInt(prev + ""));
            appendStartingBranckets(res, Integer.parseInt(s.charAt(i) + ""));
            prev = s.charAt(i);
            res.append(s.charAt(i));
          } else {
            res.append(s.charAt(i));
          }
        }
      }
      appendEndingBrackets(res, Integer.parseInt(s.charAt(s.length() - 1) + ""));
      System.out.println("Case #" + (tt - t) + ": " + res);
    }
  }

  private static void appendEndingBrackets(StringBuilder res, int cnt) {
    for (int i = 0; i < cnt; i++) {
      res.append(")");
    }
  }

  private static void appendStartingBranckets(StringBuilder res, int cnt) {
    for (int i = 0; i < cnt; i++) {
      res.append("(");
    }
  }
}

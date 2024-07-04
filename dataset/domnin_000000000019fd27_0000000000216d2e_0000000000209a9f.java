
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    int cnt = 1;
    while (t-- > 0) {
      String s = in.next();
      String res = "";
      char prev = '0';
      for (char c : s.toCharArray()) {
        if (c == prev) res += c;
        else if (c > prev) {
          while (c > prev) {
            res += '(';
            prev++;
          }
          res += c;
        } else if (c < prev) {
          while (c < prev) {
            res += ')';
            prev--;
          }
          res += c;
        }
      }
      while ('0' < prev) {
        res += ')';
        prev--;
      }

      System.out.println("Case #" + cnt++ + ": " + res);
    }
    System.out.flush();
  }
}

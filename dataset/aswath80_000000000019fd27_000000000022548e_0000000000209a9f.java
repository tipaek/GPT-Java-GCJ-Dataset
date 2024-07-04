import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

   public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int tc = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    in.nextLine();
    for (int t = 1; t <= tc; t++) {
      String s = in.nextLine();
      solve(t, s);
    }
  }

  private static void solve(int t, String s) {
    // 0((2)1), (((3))1(2)), ((((4)))), ((22))(1)
    StringBuffer sb = new StringBuffer();
    int prev = 0;
    for (int i = 0; i < s.length(); i++) {
      int d = Character.getNumericValue(s.charAt(i));
      if (d > prev) {
        int diff = d - prev;
        for (int j = 0; j < diff; j++) {
          sb.append('(');
        }
      } else if (d < prev) {
        int diff = prev - d;
        for (int j = 0; j < diff; j++) {
          sb.append(')');
        }
      }
      sb.append(d);
      prev = d;
    }
    for (int j = 0; j < prev; j++) {
      sb.append(')');
    }
    System.out.println(String.format("Case #%s: %s", t, sb.toString()));
  }
}

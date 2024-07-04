import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int cases = in.nextInt();

    for (int t = 1; t <= cases; t++) {
      int x = in.nextInt();
      int y = in.nextInt();
      final char[] m = in.next().toCharArray();

      int d = 0;
      int i = 0;
      while (i < m.length) {
        char s = m[i];
        if (s == 'E' || s == 'W') {
          x += (s == 'E') ? 1 : -1;
        } else {
          y += (s == 'N') ? 1 : -1;
        }
        d = Math.abs(x) + Math.abs(y);
        i++;

        if (d <= i) {
          break;
        }
      }

      if (d > i) {
        System.out.println("Case #" + t + ": " + "IMPOSSIBLE");
      } else {
        System.out.println("Case #" + t + ": " + i);
      }
    }
  }
}
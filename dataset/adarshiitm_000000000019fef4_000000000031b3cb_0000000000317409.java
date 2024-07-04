import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String args[]) {
    Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int T = input.nextInt();
    for (int ks = 1; ks <= T; ks++) {
      System.out.println(
          "Case #" + ks + ": " + overexcited(input.nextInt(), input.nextInt(), input.next()));
    }
  }

  private static String overexcited(int x, int y, String path) {
    if (path.length() < x) {
      return "IMPOSSIBLE";
    }

    Integer minutes = 0;
    for (; minutes < x; minutes++) {
      y = y + ((path.charAt(minutes) == 'N') ? 1 : -1);
    }

    int loc = 0;

    while (y != loc && minutes < path.length()) {
      y = y + ((path.charAt(minutes) == 'N') ? 1 : -1);
      if (y > loc) {
        loc++;
      } else if (y < loc) {
        loc--;
      }
      minutes++;
    }

    if (y == loc) {
      return minutes.toString();
    }
    return "IMPOSSIBLE";
  }

}
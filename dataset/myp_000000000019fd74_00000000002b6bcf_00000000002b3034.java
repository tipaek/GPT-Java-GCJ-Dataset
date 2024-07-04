import java.util.*;
import java.io.*;

public class Solution {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int T = s.nextInt();
    for (int t = 1; t <= T; t++) {
      int n = s.nextInt();
      s.nextLine();
      String[] left = new String[n], right = new String[n];
      String start = "", end = "";
      boolean valid = true;
      for (int i = 0; i < n; i++) {
        String line = s.nextLine();
        int loc = line.indexOf('*');
        left[i] = line.substring(0, loc);
        right[i] = line.substring(loc + 1);

        start = getPrefix(start, left[i]);
        if (start == null) {
          valid = false;
        }

        end = getSuffix(end, right[i]);
        if (end == null) {
          valid = false;
        }
      }
      if (!valid) {
        System.out.println(String.format("Case #%d: *", t));
      } else {
        while (start.length() > 0 && isValid(start.substring(0, start.length() - 1) + end, left, right)) {
          start = start.substring(0, start.length() - 1);
        }

        System.out.println(String.format("Case #%d: %s", t, start + end));

      }
    }
  }

  private static String getPrefix(String a, String b) {
    if (a == null) return null;
      
    if (a.length() > b.length()) {
      return getPrefix(b, a);
    }
    if (!b.startsWith(a)) {
      return null;
    }
    return b;

  }

  private static String getSuffix(String a, String b) {
    if (a == null) return null;
    if (a.length() > b.length()) {
      return getSuffix(b, a);
    }
    if (!b.endsWith(a)) {
      return null;
    }
    return b;

  }

  private static boolean isValid(String str, String[] left, String[] right) {
    int n = left.length;
    for (int i = 0; i < n; i++) {
      if (str.length() < left[i].length() + right[i].length() || !str.startsWith(left[i]) || !str.endsWith(right[i])) {
        return false;
      }
    }
    return true;
  }


}

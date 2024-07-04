import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      String[] patterns = new String[n];
      String[] patternStarts = new String[n];
      String[] patternEnds = new String[n];
      int bigStart = 0;
      int binEnd = 0;
      for (int j = 0; j < n; j++) {
        patterns[j] = in.next();
        int loc = patterns[j].indexOf('*');
        patternStarts[j] = patterns[j].substring(0, loc);
        if (loc + 1 < patterns[j].length()) {
          patternEnds[j] = patterns[j].substring(loc + 1);
        } else {
          patternEnds[j] = "";
        }
        if (patternStarts[j].length() > patternStarts[bigStart].length()) {
          bigStart = j;
        }
        if (patternEnds[j].length() > patternEnds[binEnd].length()) {
          binEnd = j;
        }
      }

      boolean flag = true;
      for (String s : patternStarts) {
        if (!patternStarts[bigStart].contains(s)) {
          flag = false;
          break;
        }
      }
      if (flag) {
        for (String s : patternEnds) {
          if (!patternEnds[binEnd].contains(s)) {
            flag = false;
            break;
          }
        }
      }

      StringBuilder result = new StringBuilder();
      if (flag) {
        result.append(patternStarts[bigStart]).append(patternEnds[binEnd]);
      } else {
        result.append('*');
      }

      System.out.println("Case #" + i + ": " + result.toString());
    }
  }
}

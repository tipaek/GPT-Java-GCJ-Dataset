import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
      int bigEnd = 0;
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
        if (patternEnds[j].length() > patternEnds[bigEnd].length()) {
          bigEnd = j;
        }
      }

      boolean flag = true;
      for (String s : patternStarts) {
        Pattern pattern = Pattern.compile("^" + s + ".*");
        Matcher matcher = pattern.matcher(patternStarts[bigStart]);
        if (!matcher.matches()) {
          flag = false;
          break;
        }
      }
      if (flag) {
        for (String s : patternEnds) {
          Pattern pattern = Pattern.compile(".*" + s + "$");
          Matcher matcher = pattern.matcher(patternEnds[bigEnd]);
          if (!matcher.matches()) {
            flag = false;
            break;
          }
        }
      }

      StringBuilder result = new StringBuilder();
      if (flag) {
        result.append(patternStarts[bigStart]).append(patternEnds[bigEnd]);
      } else {
        result.append('*');
      }

      System.out.println("Case #" + i + ": " + result.toString());
    }
  }
}

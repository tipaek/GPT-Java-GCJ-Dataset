import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int tc = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    in.nextLine();
    for (int t = 1; t <= tc; t++) {
      int n = in.nextInt();
      in.nextLine();
      String[] patterns = new String[n];
      int maxLen = 0;
      for (int i = 0; i < n; i++) {
        String p = in.nextLine().trim();
        maxLen = p.length() > maxLen ? p.length() : maxLen;
        patterns[i] = p;
      }
      for (int i = 0; i < n; i++) {
        patterns[i] = resize(patterns[i], maxLen);
      }
      solve(t, patterns, maxLen);
    }
  }

  private static String resize(String pattern, int maxLen) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < maxLen - pattern.length(); i++) {
      sb.append('*');
    }
    sb.append(pattern);
    return sb.toString();
  }

  private static void solve(int tc, String[] patterns, int maxLen) {
    StringBuilder sb = new StringBuilder();
    for (int i = maxLen - 1; i >= 0; i--) {
      Character c = getSolutionChar(patterns, i);
      if (c == '$') {
        System.out.println(String.format("Case #%s: *", tc));
        return;
      } else if (c == '*') {
        sb.insert(0, 'A');
      } else {
        sb.insert(0, c);
      }
    }
    System.out.println(String.format("Case #%s: %s", tc, sb.toString()));
  }

  private static Character getSolutionChar(String[] patterns, int p) {
    Character c = '*';
    for (int i = 0; i < patterns.length; i++) {
      if (c == '*' && patterns[i].charAt(p) == '*') {
        continue;
      } else if (c == '*' && patterns[i].charAt(p) != '*') {
        c = patterns[i].charAt(p);
        continue;
      } else if (c != '*' && patterns[i].charAt(p) == '*') {
        continue;
      } else if (c != '*' && patterns[i].charAt(p) != c) {
        return '$';
      } else {
        continue;
      }
    }
    return c;
  }
}

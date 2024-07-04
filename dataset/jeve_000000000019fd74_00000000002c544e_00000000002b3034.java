import java.util.*;
import java.io.*;

public class Solution {
  private static String trace(String[] patterns) {
    String prefix = prefix(patterns);
    if (prefix.equals("*")) {
      return "*";
    }
    String suffix = suffix(patterns);
    if (suffix.equals("*")) {
      return "*";
    }

    StringBuilder sb = new StringBuilder();
    sb.append(prefix);
    for (int i = 0; i < patterns.length; ++i) {
      int begin = patterns[i].indexOf('*') + 1;
      int end = patterns[i].lastIndexOf('*');
      if (begin <= end) {
        String body = patterns[i].substring(begin, end);
        sb.append(body.replace("*", ""));
      }
    }
    sb.append(suffix);
    return sb.toString();
  }

  private static String prefix(String[] patterns) {
    String prefix = "";
    for (int i = 0; i < patterns.length; ++i) {
      String pre = patterns[i].substring(0, patterns[i].indexOf('*'));
      if (pre.length() > prefix.length()) {
        if (pre.startsWith(prefix)) {
          prefix = pre;
        } else {
          return "*";
        }
      } else if (!prefix.startsWith(pre)) {
        return "*";
      }
    }
    return prefix;
  }
  private static String suffix(String[] patterns) {
    String suffix = "";
    for (int i = 0; i < patterns.length; ++i) {
      String suf = patterns[i].substring(patterns[i].lastIndexOf('*') + 1);
      if (suf.length() > suffix.length()) {
        if (suf.endsWith(suffix)) {
          suffix = suf;
        } else {
          return "*";
        }
      } else if (!suffix.endsWith(suf)) {
        return "*";
      }
    }
    return suffix;
  }
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int cases = Integer.valueOf(scanner.nextLine());
    for (int t = 1; t <= cases; ++t) {
      int N = Integer.valueOf(scanner.nextLine());
      String[] patterns = new String[N];
      for (int i = 0; i < N; ++i) {
        patterns[i] = scanner.nextLine();
      }
      String result = trace(patterns);
      System.out.println("Case #" + t + ": " + result);
    }
  }
}

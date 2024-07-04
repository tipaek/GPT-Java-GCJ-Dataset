import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = Integer.parseInt(in.nextLine());
    for (int c = 1; c <= t; ++c) {
      int p = Integer.parseInt(in.nextLine());
      List<String> patterns = new ArrayList<>();
      while (p-- > 0) {
        patterns.add(in.nextLine());
      }
      //patterns.sort((o1, o2) -> Integer.compare(o2.length(), o1.length()));
      String res = null;
      for (String pat : patterns) {
        if (res == null) {
          res = pat;
          continue;
        }
        boolean resStartsWithAs = res.startsWith("*");
        boolean patStartsWithAs = pat.startsWith("*");
        Pattern resPattern = resStartsWithAs ? null : Pattern.compile(res);
        Matcher resMatch = resPattern == null ? null : resPattern.matcher(pat.replace("*", ""));
        Pattern patPattern = patStartsWithAs ? null : Pattern.compile(pat);
        Matcher patMatch = patPattern == null ? null : patPattern.matcher(res.replace("*", ""));
        boolean patInRes = resStartsWithAs ? res.endsWith(pat.replace("*","")) : resMatch.find();
        boolean resInPat = patStartsWithAs ? pat.endsWith(res.replace("*","")) : patMatch.find();
        if (patInRes || resInPat) {
          res = pat.length() > res.length() ? pat : res;
        } else {
          res = null;
          break;
        }
      }
      System.out.println(String.format("Case #%d: %s", c, res == null ? "*" : res.replace("*", "")));
    }
  }

  public static String longestSubstr(String s1, String s2) {
    StringBuffer res = new StringBuffer();
    for (int i = 0; i < s1.length() && i < s2.length(); i++) {
      if (s1.charAt(i) != s2.charAt(i)) {
        return res.toString();
      }
      res.append(s1.charAt(i));
    }
    return res.toString();
  }
}
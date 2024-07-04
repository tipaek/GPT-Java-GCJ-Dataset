
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    int tc = 1;
    outer:
    while (t-- > 0) {
      int N = in.nextInt();
      String patterns[] = new String[N];

      for (int i = 0; i < N; i++) patterns[i] = in.next();
      Set<String> pref = new HashSet<>(), suf = new HashSet<>(), pSet = new HashSet<>();
      for (String s : patterns) {
        pSet.add(s);
        if (s.charAt(0) != '*') {
          int p = s.indexOf('*');
          if (p < 0) pref.add(s);
          else pref.add(s.substring(0, p));
        }
        if (s.charAt(s.length() - 1) != '*') {
          int p = s.lastIndexOf('*');
          if (p < 0) suf.add(s);
          else suf.add(s.substring(p + 1));
        }
      }

      String mPref = maxS(pref);
      String sPref = pSet.contains(mPref) ? mPref : null;

      for (String s : pref) {
        if (!mPref.startsWith(s)) {
          System.out.println("Case #" + tc++ + ": *");
          continue outer;
        }
      }
      String mSuf = maxS(suf);
      String sSuf = pSet.contains(mSuf) ? mSuf : null;
      for (String s : suf) {
        if (!mSuf.endsWith(s)) {
          System.out.println("Case #" + tc++ + ": *");
          continue outer;
        }
      }
      if (sSuf != null && sPref != null) {
        if (!sSuf.equals(sPref)) {
          System.out.println("Case #" + tc++ + ": *");
          continue outer;
        }
        for (String p : patterns) {
          if (!isMatch(sPref, p)) {
            System.out.println("Case #" + tc++ + ": *");
            continue outer;
          }
        }
        System.out.println("Case #" + tc++ + ": " + sPref);
        continue outer;
      }
      int[] pPos = new int[N];
      String res = mPref;
      while (mPref.length() != 0) {
        for (int i = 0; i < N; i++) {
          if (patterns[i].length() == 0) {
            System.out.println("Case #" + tc++ + ": *");
            continue outer;
          }
          int c = patterns[i].charAt(0);
          if (c != '*') {
            if (c != mPref.charAt(0)) {
              int aa = 0;
            }
            patterns[i] = patterns[i].substring(1);
          }
        }
        mPref = mPref.substring(1);
      }
      // removed prefix
      boolean hasMore = false;
      do {
        hasMore = false;
        l2:
        for (int i = 0; i < N; i++) {
          while (patterns[i].length() != 0 && patterns[i].charAt(0) == '*') {
            if (patterns[i].length() == 1 && patterns[i].charAt(0) == '*')
              continue l2; // leave last *
            patterns[i] = patterns[i].substring(1);
          }
          if (patterns[i].length() == 0) {
            System.out.println("Case #" + tc++ + ": *");
            continue outer;
          }
          if (patterns[i].indexOf("*") > 0) {
            res += patterns[i].substring(0, patterns[i].indexOf("*"));
            patterns[i] = patterns[i].substring(patterns[i].indexOf("*") );
            hasMore = true;
          }
        }
      } while (hasMore);
      res += mSuf;
      System.out.println("Case #" + tc++ + ": " + res);
    }
    System.out.flush();
  }

  static boolean isMatch(String s, String p) {
    int i = 0;
    int j = 0;
    int starIndex = -1;
    int iIndex = -1;

    while (i < s.length()) {
      if (j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
        ++i;
        ++j;
      } else if (j < p.length() && p.charAt(j) == '*') {
        starIndex = j;
        iIndex = i;
        j++;
      } else if (starIndex != -1) {
        j = starIndex + 1;
        i = iIndex + 1;
        iIndex++;
      } else {
        return false;
      }
    }

    while (j < p.length() && p.charAt(j) == '*') {
      ++j;
    }

    return j == p.length();
  }

  static String maxS(Set<String> set) {
    int max = 0;
    String res = "";
    for (String s : set) {
      if (s.length() > max) {
        max = s.length();
        res = s;
      }
    }
    return res;
  }
}

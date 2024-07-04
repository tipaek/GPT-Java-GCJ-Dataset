/**
 * @author Finn Lidbetter
 */
import java.util.*;
import java.io.*;
import java.awt.geom.*;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
  
    int nTests = Integer.parseInt(br.readLine());
    for (int test=0; test<nTests; test++) {
      int n = Integer.parseInt(br.readLine());
      String[] patterns = new String[n];
      String[] fixStripped = new String[n];
      String maxSuffix = "";
      String maxPrefix = "";
      
      int starFree = -1;
      for (int i=0; i<n; i++) {
        patterns[i] = br.readLine();
        StringBuilder sb2 = new StringBuilder();
        for (int j=0; j<patterns[i].length(); j++) {
          if (patterns[i].charAt(j)=='*') {
            break;
          }
          sb2.append(patterns[i].charAt(j));
        }
        if (sb2.length()>maxPrefix.length()) {
          maxPrefix = sb2.toString();
        }
        if (sb2.length()==patterns[i].length()) {
          starFree = i;
        }
        int prefixLen = sb2.length();
        sb2 = new StringBuilder();
        for (int j=patterns[i].length()-1; j>=0; j--) {
          if (patterns[i].charAt(j)=='*') {
            break;
          }
          sb2.append(patterns[i].charAt(j));
        }
        sb2.reverse();
        if (sb2.length()>maxSuffix.length()) {
          maxSuffix = sb2.toString();
        }
        int suffixLen = sb2.length();
        if (prefixLen==patterns[i].length()) {
          fixStripped[i] = "";
        } else {
          String substr = patterns[i].substring(prefixLen, patterns[i].length()-suffixLen);
          StringBuilder strippedSb = new StringBuilder();
          for (char c: substr.toCharArray()) {
            if (c!='*')
              strippedSb.append(c);
          }
          fixStripped[i] = strippedSb.toString();
        }
      }
      String match = "";
      if (starFree>=0) {
        match = patterns[starFree];
        for (int i=0; i<n; i++) {
          if (!matchesSuffix(patterns[i], match) || !matchesPrefix(patterns[i], match)) {
            match = "*";
            break;
          }
        }
      } else {
        for (int i=0; i<n; i++) {
          if (!matchesSuffix(patterns[i], maxSuffix) || !matchesPrefix(patterns[i], maxPrefix)) {
            match = "*";
            break;
          }
        }
        if (!match.equals("*")) {
          StringBuilder matchSb = new StringBuilder(maxPrefix);
          for (int i=0; i<n; i++) {
            matchSb.append(fixStripped[i]);
          }
          matchSb.append(maxSuffix);
          match = matchSb.toString();
        }
      }
      
      sb.append(String.format("Case #%d: %s\n", test+1, match));
    }
    System.out.print(sb);
  }
  static boolean matchesSuffix(String text, String suff) {
    int tLen = text.length();
    int sLen = suff.length();
    for (int i=0; i<sLen; i++) {
      if (tLen-i-1<0) {
        return false;
      }
      if (text.charAt(tLen-i-1)=='*') {
        return true;
      } else if (text.charAt(tLen-i-1)!=suff.charAt(sLen-i-1)) {
        return false;
      }
    }
    return true;
  }
  static boolean matchesPrefix(String text, String pre) {
    int tLen = text.length();
    int pLen = pre.length();
    for (int i=0; i<pLen; i++) {
      if (tLen<=i) {
        return false;
      }
      if (text.charAt(i)=='*') {
        return true;
      } else if (text.charAt(i)!=pre.charAt(i)) {
        return false;
      }
    }
    return true;
  }
}

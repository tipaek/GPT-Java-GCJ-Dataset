import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String args[]) {
    Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int T = input.nextInt();
    for (int ks = 1; ks <= T; ks++) {
      System.out.println("Case #" + ks + ": " + solve(input));
    }
  }

  private static String solve(Scanner input) {
    int n = input.nextInt();
    String[] strs = new String[n];
    boolean single = true;
    boolean leftMost = true;
    int maxLen = 0;
    int maxIdx = 0;
    for (int i = 0; i < n; i++) {
      strs[i] = input.next();
      int idx = strs[i].indexOf('*');
      if (strs[i].substring(idx + 1).indexOf('*') > 0) {
        single = false;
        leftMost = false;
      }
      if (single && idx != 0) {
        leftMost = false;
      }
      if (strs[i].length() > maxLen) {
        maxLen = strs[i].length();
        maxIdx = i;
      }
    }

    if (single && leftMost) {
      StringBuilder stb = new StringBuilder();
      for (int idx = 0; idx < maxLen; idx++) {
        char c = strs[maxIdx].charAt(maxLen - idx - 1);
        for (int strIdx = 1; strIdx < strs.length; strIdx++) {
          String str = strs[strIdx];
          if (idx < str.length()) {
            char c1 = str.charAt(str.length() - idx - 1);
            if (c1 != '*' && c1 != c) {
              return "*";
            }
          }
        }
        if (c != '*') {
          stb.append(c);
        }
      }

      return stb.reverse().toString();
    } else if (single) {
      String[] leftStrs = new String[n];
      String[] rightStrs = new String[n];
      int leftLongest = 0;
      int rightLongest = 0;
      for (int strIdx = 0; strIdx < n; strIdx++) {
        String[] split = strs[strIdx].split("\\*");
        if (strs[strIdx].charAt(0) == '*') {
          leftStrs[strIdx] = "";
        } else {
          leftStrs[strIdx] = split[0];
        }

        if (strs[strIdx].charAt(strs[strIdx].length() - 1) == '*') {
          rightStrs[strIdx] = "";
        } else {
          rightStrs[strIdx] = reverse(split[1]);
        }

        if (leftStrs[strIdx].length() > leftStrs[leftLongest].length()) {
          leftLongest = strIdx;
        }
        if (rightStrs[strIdx].length() > rightStrs[rightLongest].length()) {
          rightLongest = strIdx;
        }
      }

      for (int strIdx = 0; strIdx < n; strIdx++) {
        if (leftStrs[leftLongest].indexOf(leftStrs[strIdx]) != 0 ||
            rightStrs[rightLongest].indexOf(rightStrs[strIdx]) != 0) {
          return "*";
        }
      }

      return leftStrs[leftLongest] + reverse(rightStrs[rightLongest]);
    } else {
      return "";
    }
  }

  private static String reverse(String s) {
    StringBuilder stringBuilder = new StringBuilder();
    return stringBuilder.append(s).reverse().toString();
  }

}
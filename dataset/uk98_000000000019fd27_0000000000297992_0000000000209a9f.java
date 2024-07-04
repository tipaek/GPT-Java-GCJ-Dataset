import java.util.*;
import java.io.*;
class Solution {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int t = s.nextInt();
    for (int i = 1; i <= t; ++i) {
      String str = s.next();
      String strAns = new String();
      int[] str2 = new int[str.length()];
      for (int j = 0; j < str2.length; j++) {
        str2[j] = Character.getNumericValue(str.charAt(j));
      }
      for (int j = 0; j < str2.length; j++) {
        for (int j2 = 0; j2 < str2[j]; j2++) {
          strAns += "(";
        }
        strAns += str2[j];
        for (int j2 = 0; j2 < str2[j]; j2++) {
          strAns += ")";
        }
      }
      while (!strAns.equals(strAns.replace(")(", ""))) {
        strAns = strAns.replace(")(", "");
      }
      System.out.println("Case #" + i + ": " + strAns);
    }
  }
}
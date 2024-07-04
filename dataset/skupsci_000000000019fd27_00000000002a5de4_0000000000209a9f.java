 import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      String str = in.next();
      String strAns = new String();
      int[] inp = new int[str.length()];
      for (int j = 0; j < inp.length; j++) {
        inp[j] = Character.getNumericValue(str.charAt(j));
      }
      for (int j = 0; j < inp.length; j++) {
        for (int j2 = 0; j2 < inp[j]; j2++) {
          strAns += "(";
        }
        strAns += inp[j];
        for (int j2 = 0; j2 < inp[j]; j2++) {
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
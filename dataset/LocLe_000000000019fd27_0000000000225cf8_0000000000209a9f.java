import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int numTests = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int m = 1; m <= numTests; ++m) {
      String str = in.next();
      int start = 0;
      int end = 0;
      String newStr = "";
      for (int k = 0 ; k < str.length(); k++) {
          if (k == 0) {
              start = 0;
              if (str.length() > 1) {
                end = str.charAt(1) - '0';
              }
          } else if (k == str.length() - 1) {
              end = 0;
              start = str.charAt(k - 1) - '0';
          } else {
              start = str.charAt(k - 1) - '0';
              end = str.charAt(k + 1) - '0';
          }
          int num = str.charAt(k) - '0';
          for (int i = 0; i < num - start; i++) {
              newStr += "(";
          }
          newStr += num;
          for (int j = 0; j < num - end; j++) {
              newStr += ")";
          }
      }
      System.out.println("Case #" + m + ": " + newStr);
    }
  }
}
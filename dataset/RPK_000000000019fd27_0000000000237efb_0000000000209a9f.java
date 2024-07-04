import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int i = 1; i <= t; ++i) {
      String s = in.next();
      int b = 0;
      StringBuilder sb = new StringBuilder();
      for (int j = 0; j < s.length(); ++j) {
        int c = s.charAt(j) - '0';
        if (b < c) {
            for (int k = 0; k < c - b; ++k) {
                sb.append('(');
            }
        } else {
            for (int k = 0; k < b - c; ++k) {
                sb.append(')');
            }
        }
        b = c;
        sb.append(s.charAt(j));
      }
      for (int k = 0; k < b; ++k) {
          sb.append(')');
      }
      System.out.println("Case #" + i + ": " + sb.toString());
    }
  }
}
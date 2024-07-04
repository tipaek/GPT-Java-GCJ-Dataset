
import java.util.Arrays;
import java.util.Scanner;

class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for (int t = 1; t <= T; t++) {
      String S = sc.next();
      StringBuilder sb = new StringBuilder();
      char[] chars = new char[S.length() + 2];
      Arrays.fill(chars, '0');
      for (int i = 0; i < S.length(); i++) {
        chars[i + 1] = S.charAt(i);
      }
      for (int i = 1; i <= S.length() + 1; i++) {
        char pre = chars[i-1];
        char cur = chars[i];
        if (cur - pre > 0) {
          for (int j = 1; j <= cur - pre; j++) {
            sb.append('(');
          }
        } else if (cur - pre < 0) {
          for (int j = 1; j <= pre - cur; j++) {
            sb.append(')');
          }
        }
        sb.append(cur);
      }
      sb.deleteCharAt(sb.length() - 1);
      System.out.println(String.format("#%d: %s", t, sb.toString()));
    }
  }
}

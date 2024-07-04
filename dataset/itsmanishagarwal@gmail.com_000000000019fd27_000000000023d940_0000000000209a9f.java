import java.util.Scanner;

/**
 * @Author Manish Agarwal
 * @Date : 2020-04-03 at 16:10
 * 4
 * 0000
 * 101
 * 111000
 * 1
 */
public class Solution {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n  = Integer.parseInt(s.nextLine());
    for (int i = 0; i < n ; i++) {
      String S = s.nextLine();
      int [] arr = new int[S.length()];
      for (int j = 0; j < S.length(); j++) {
          arr[j] = S.charAt(j) - 48;
      }

      StringBuilder o = new StringBuilder();
      int e = 0, b = 0;
      for (int j = 0; j < S.length(); j++) {
        int c = arr[j];
        if (c > e) {
          o.append(open(c - e));
        }
        if (c < e) {
          o.append(close(e - c));
        }
        o.append(c);
        b = b + c - e;
        e = c;
      }
      if (b > 0) {
        o.append(close(b));
      }
      System.out.println("Case #" + (i + 1) + ": " + o.toString());
    }
  }
  static String open(int n){
    StringBuilder o = new StringBuilder();
    for (int i = 0; i < n; i++) {
      o.append("(");
    }
    return o.toString();
  }

  static String close(int n){
    StringBuilder o = new StringBuilder();
    for (int i = 0; i < n; i++) {
      o.append(")");
    }
    return o.toString();
  }
}

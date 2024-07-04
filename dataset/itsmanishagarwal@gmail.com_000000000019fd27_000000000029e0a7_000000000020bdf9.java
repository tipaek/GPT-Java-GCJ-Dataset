import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author Manish Agarwal
 * @Date : 2020-04-03 at 16:10
 */
public class Solution {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n  = s.nextInt();
    for (int i = 0; i < n; i++) {
      int N  = s.nextInt();
      int [][] ar = new int[N][2];
      for (int j = 0; j < N; j++) {
        ar[j][0] = s.nextInt();
        ar[j][1] = s.nextInt();
      }
      int [] cr = new int[1440];
      int [] jr = new int[1440];

      boolean fnd = true;
      char[] ch = new char[N];
      String o = "";
      for (int j = 0; j < N; j++) {
        int st = ar[j][0];
        int en = ar[j][1];
        boolean cf = true, jf = true;
        for (int k = st; k < en; k ++) {
          if (cr[k] != 0) {
            cf = false;
            break;
          }
        }
        if (cf) {
          for (int k = st; k < en; k ++) {
            cr[k] = 1;
          }
          ch[j] = 'C';
        } else {
          for (int k = st; k < en; k ++) {
            if (jr[k] != 0) {
              jf = false;
              break;
            }
          }
          if (jf) {
            for (int k = st; k < en; k ++) {
              jr[k] = 1;
            }
            ch[j] = 'J';
          } else {
            o = "IMPOSSIBLE";
            fnd = false;
            break;
          }
        }
      }

      if (fnd) {
        o = new String(ch);
      }
      System.out.println("Case #" + (i + 1) + ": " + o);
    }
  }
}

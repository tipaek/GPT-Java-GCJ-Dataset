import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long tc = sc.nextInt();
    int tcn = 1;

    while (tc-- != 0) {
      int n = sc.nextInt();

      String[] arr = new String[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.next();
      }

      String im = "*";
      boolean imp = false;
      String ans = arr[0].substring(1);
      for (int i = 1; i < n; i++) {
          String val = arr[i].substring(1);
        if (ans.length() <= val.length()) {
          if (val.contains(ans)) {
            ans = val;
          } else {
            imp = true;
            break;
          }
        } else {
          if (!ans.contains(val)) {
            imp = true;
            break;
          }
        }
      }
      if (imp) {
        System.out.println("Case #" + tcn + ": " + im);
      } else {
        System.out.println("Case #" + tcn + ": " + ans);
      }

      tcn++;
    }
  }
}

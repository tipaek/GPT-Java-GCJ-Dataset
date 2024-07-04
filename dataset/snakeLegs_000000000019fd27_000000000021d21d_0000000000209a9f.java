import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long tc = sc.nextInt();
    int tcn = 1;

    while (tc-- != 0) {
      String s = sc.next();
      int ob = 0;

      String snew = "";
      for (int i = 0; i < s.length(); i++) {
        int val = Character.getNumericValue(s.charAt(i));
        if (ob < val) {
          while (ob < val) {
            snew = snew + "(";
            ob++;
          }
        }

        if (ob > val) {
          while (ob > val) {
            snew = snew + ")";
            ob--;
          }
        }

        if (ob == val) {
          snew = snew + val;
        }
      }

      while (ob > 0) {
        snew = snew + ")";
        ob--;
      }

      System.out.println("Case #" + tcn + ": " + snew);
      tcn++;
    }
  }
}

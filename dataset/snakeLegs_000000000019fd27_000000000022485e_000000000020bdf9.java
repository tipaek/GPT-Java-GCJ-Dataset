import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long tc = sc.nextInt();
    int tcn = 1;

    while (tc-- != 0) {
      int n = sc.nextInt();

      int inter[][] = new int[n][2];
      for (int i = 0; i < n; i++) {
        inter[i][0] = sc.nextInt();
        inter[i][1] = sc.nextInt();
      }

      int[] cschl = new int[1441];
      int[] jschl = new int[1441];
      String answer = "";

      for (int i = 0; i < n; i++) {
        int s = inter[i][0];
        int e = inter[i][1];

        if ((cschl[s] == 1 || cschl[e] == 1) && (jschl[s] == 1 || jschl[e] == 1)) {
          answer = "IMPOSSIBLE";
          break;
        }
        if (cschl[s] == 1 || cschl[e] == 1) {
          Arrays.fill(jschl, s, e, 1);
          jschl[1440] = jschl[1439];
          answer = answer + "J";
        } else {
          Arrays.fill(cschl, s, e, 1);
          cschl[1440] = cschl[1439];
          answer = answer + 'C';
        }
      }
      System.out.println("Case #" + tcn + ": " + answer);
      tcn++;
    }
  }
}

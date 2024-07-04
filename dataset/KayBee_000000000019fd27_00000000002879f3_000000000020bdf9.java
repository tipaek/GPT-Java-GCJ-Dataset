import java.util.*;

class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for (int i = 0; i < t; i++) {
      int n = sc.nextInt();
      int[][] clock = new int[n][2];
      for (int j = 0; j < n; j++) {
        clock[j][0] = sc.nextInt();
        clock[j][1] = sc.nextInt();
      }
      char[] op = new char[n];
      String imp = "IMPOSSIBLE";
      int je = 0, ce = 0, flag = 0, min, prevMin = -1;
      int k = 0;

      for (int l = 0; l < n; l++) {
        min = 1440;
        for (int j = 0; j < n; j++) {
          if (clock[j][0] < min && clock[j][0] > prevMin) {
            min = clock[j][0];
            k = j;
          }
        }
        prevMin = min;
        if (clock[k][0] >= je || clock[k][0] >= ce) {
          if (clock[k][0] >= ce) {
            op[k] = 'C';
            ce = clock[k][1];
          } else {
            op[k] = 'J';
            je = clock[k][1];
          }
        } else {
          flag = 1;
          break;
        }
      }
      if (flag == 1) {
        System.out.println("Case #" + (i + 1) + ": " + imp);
      } else
        System.out.println("Case #" + (i + 1) + ": " + String.valueOf(op));
    }
  }
}
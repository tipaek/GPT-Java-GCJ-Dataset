import java.util.Scanner;

/**
 * @Author Manish Agarwal
 * @Date : 2020-04-03 at 16:10
 * 
 */
public class Solution {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n  = s.nextInt();
    for (int i = 0; i < n; i++) {
      int N  = s.nextInt();
      StringBuilder o = new StringBuilder();
      int C = 0;
      int J = 0;
      int [][] ar = new int[N][2];
      for (int j = 0; j < N; j++) {
        ar[j][0] = s.nextInt();
        ar[j][1] = s.nextInt();
      }

//      for (int j = 0; j < N; j++) {
//        System.out.println(ar[j][0] + " " + ar[j][1]);
//      }
      for (int j = 0; j < N - 1; j++) {
        for (int k = j+1; k < N; k++) {
          if (ar[j][0] > ar[k][0]) {
            int [] t = ar[j];
            ar[j] = ar[k];
            ar[k] = t;
          }
        }
      }

//      for (int j = 0; j < N; j++) {
//        System.out.println(ar[j][0] + " " + ar[j][1]);
//      }

//      boolean fnd = true;
      for (int j = 0; j < N; j++) {
        int st = ar[j][0];
        int en = ar[j][1];
        if (st >= C) {
          C = en;
          o.append("C");
        } else {
          if (st >= J) {
            J = en;
            o.append("J");
          } else {
            o = new StringBuilder();
            o.append("IMPOSSIBLE");
          }
        }
      }

      System.out.println("Case #" + (i + 1) + ": " + o.toString());
    }
  }
}

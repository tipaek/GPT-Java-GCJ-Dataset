import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author Manish Agarwal
 * @Date : 2020-04-03 at 16:10
 * 3
 * 4
 * 1 2 3 4
 * 2 1 4 3
 * 3 4 1 2
 * 4 3 2 1
 * 4
 * 2 2 2 2
 * 2 3 2 3
 * 2 2 2 3
 * 2 2 2 2
 * 3
 * 2 1 3
 * 1 3 2
 * 1 2 3
 */
public class Solution {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n  = s.nextInt();
    for (int i = 0; i < n; i++) {
      int N  = s.nextInt();
      int C = 0;
      int J = 0;
      int [][] ar = new int[N][2];
      Map<Integer, Integer> map = new HashMap<>();
      for (int j = 0; j < N; j++) {
        map.put(j, j);
        ar[j][0] = s.nextInt();
        ar[j][1] = s.nextInt();
      }

//      for (int j = 0; j < N; j++) {
//        System.out.println(ar[j][0] + " " + ar[j][1]);
//      }
//      System.out.println(map);
      for (int j = 0; j < N - 1; j++) {
        for (int k = j+1; k < N; k++) {
          if (ar[j][0] > ar[k][0]) {
            int ti = map.get(j);
            map.put(j, map.get(k));
            map.put(k, ti);
            int [] t = ar[j];
            ar[j] = ar[k];
            ar[k] = t;
          }
          System.out.println(map);
        }
      }
//      System.out.println(map);
//      for (int j = 0; j < N; j++) {
//        System.out.println(ar[j][0] + " " + ar[j][1]);
//      }

      boolean fnd = true;
      char[] ch = new char[N];
      String o = "";
      for (int j = 0; j < N; j++) {
        int st = ar[j][0];
        int en = ar[j][1];
        if (st >= C) {
          C = en;
          ch[map.get(j)] = 'C';
        } else {
          if (st >= J) {
            J = en;
            ch[map.get(j)] = 'J';
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

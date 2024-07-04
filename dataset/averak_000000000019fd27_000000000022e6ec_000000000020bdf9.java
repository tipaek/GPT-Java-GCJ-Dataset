

import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int countTest = in.nextInt();
    for (int i = 1; i <= countTest; i++) {
      if (in.hasNext()) {
        int sizeI = in.nextInt();
        int[][] m = new int[sizeI][2];
        Map<String, Integer> map = new HashMap<>();
        boolean isImp = false;
        for (int j = 0; j < sizeI; j++) {
          for (int k = 0; k < 2; k++) {
            if (in.hasNext()) {
              m[j][k] = in.nextInt();
            }
          }
          if (map.get(m[j][0] + "-" + m[j][1]) == null) {
            map.put(m[j][0] + "-" + m[j][1], j);
          } else {
            if (map.get(m[j][0] + "-" + m[j][1] + "*") == null) {
              map.put(m[j][0] + "-" + m[j][1] + "*", j);
            } else {
              System.out.println("Case #" + i + ": IMPOSSIBLE");
              isImp = true;
              break;
            }
          }
        }
        if (!isImp) {
          calculate(m, i, map);
        }
      }
    }
  }

  public static void calculate(int[][] m, int num, Map<String, Integer> map) {
    Arrays.sort(m, new Comparator<int[]>() {
      public int compare(int[] a, int[] b) {
        return a[0] - b[0];
      }
    });
    char[] res = new char[m.length];
    res[map.get(m[0][0]+ "-" + m[0][1])] = 'C';
    map.remove(m[0][0]+ "-" + m[0][1]);
    int cEnd = m[0][1];
    int jEnd = 0;


    for (int i = 1; i < m.length; i++) {
      String key = m[i][0]+ "-" + m[i][1];
      if (map.get(key) == null) {
        key = m[i][0]+ "-" + m[i][1] + "*";
      }
      Integer j = map.get(key);
      if (j == null) {
        System.out.println("Case #" + num + ": IMPOSSIBLE");
        return;
      }
      if (m[i][0] >= cEnd) {
        res[map.get(key)] = 'C';
        cEnd = m[i][1];
      } else if (m[i][0] >= jEnd) {
        res[map.get(key)] = 'J';
        jEnd = m[i][1];
      } else {
        System.out.println("Case #" + num + ": IMPOSSIBLE");
        return;
      }
      map.remove(key);
    }
    System.out.println("Case #" + num + ": " + new String(res));
  }
}
    
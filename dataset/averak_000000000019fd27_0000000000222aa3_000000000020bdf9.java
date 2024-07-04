import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int countTest = in.nextInt();
    for (int i = 1; i <= countTest; i++) {
      int sizeI = in.nextInt();
      int[][] m = new int[sizeI][2];
      for (int j = 0; j < sizeI; j++) {
        for (int k = 0; k < 2; k++) {
          m[j][k] = in.nextInt();
        }
      }
      calculate(m, i);
    }
  }

  public static void calculate(int[][] m, int num) {
    int[][] tmp = new int[m.length][2];
    for (int i = 0; i < m.length; i++) {
      tmp[i][0] = m[i][0];
      tmp[i][1] = m[i][1];
    }
    Arrays.sort(m, new Comparator<int[]>() {
      public int compare(int[] a, int[] b) {
        return a[0] - b[0];
      }
    });
    StringBuilder s = new StringBuilder();
    Map<String, Character> map = new HashMap<>();
    map.put(m[0][0]+ "-" + m[0][1], 'C');
    int cEnd = m[0][1];
    int jEnd = 0;

    for (int i = 1; i < m.length; i++) {
      if (m[i][0] >= cEnd) {
        map.put(m[i][0]+ "-" + m[i][1], 'C');
        cEnd = m[i][1];
      } else if (m[i][0] >= jEnd) {
        map.put(m[i][0]+ "-" + m[i][1], 'J');
        jEnd = m[i][1];
      } else {
        System.out.println("Case #" + num + ": IMPOSSIBLE");
        return;
      }
    }
    for (int i = 0; i < tmp.length; i++) {
      s.append(map.get(tmp[i][0] + "-" + tmp[i][1]));
    }
    System.out.println("Case #" + num + ": " + s.toString());
  }
}
    
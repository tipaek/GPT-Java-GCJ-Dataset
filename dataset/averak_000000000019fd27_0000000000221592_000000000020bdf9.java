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
    Arrays.sort(m, new Comparator<int[]>() {
      public int compare(int[] a, int[] b) {
        return a[0] - b[0];
      }
    });
    StringBuilder s = new StringBuilder();
    s.append('C');
    int cEnd = m[0][1];
    int jEnd = 0;
    for (int i = 1; i < m.length; i++) {
      if (m[i][0] >= cEnd) {
        s.append('C');
        cEnd = m[i][1];
      } else if (m[i][0] >= jEnd) {
        s.append('J');
        jEnd = m[i][1];
      } else {
        System.out.println("Case #" + num + ": IMPOSSIBLE");
        return;
      }
    }
    System.out.println("Case #" + num + ": " + s.toString());
  }
}
    
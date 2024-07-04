import java.io.*;
import java.util.*;

class Solution {
  public static void main( String[] args ) {
    Scanner sc = new Scanner(System.in);

    int cases = sc.nextInt();

    for (int c = 0; c < cases; c++) {

      int acts = sc.nextInt();

      int[][] act = new int[acts][3];

      for (int i = 0; i < acts; i++) {
        act[i] = new int[]{sc.nextInt(), sc.nextInt(), i};
      }

      Arrays.sort(act, new java.util.Comparator<int[]>() {
        public int compare(int[] a, int[] b) {
            return a[0] - b[0];
        }
      });

      int C = 0;
      int J = 0;
      boolean impossible = false;
      char[] result = new char[acts];
      for (int i = 0; i < acts; i++) {
        
        if (C <= act[i][0]) {
          C = act[i][1];
          result[act[i][2]] = 'C';
        } else if (J <= act[i][0]) {
          J = act[i][1];
          result[act[i][2]] = 'J';
        } else {
          impossible = true;
        }

      }

      if (impossible) {
        System.out.println("Case #" + (c + 1) + ": IMPOSSIBLE");
      } else {
        System.out.print("Case #" + (c + 1) + ": ");
        for (char p : result) {
          System.out.print(p);
        }
        System.out.println();
      }

    }
  }
}
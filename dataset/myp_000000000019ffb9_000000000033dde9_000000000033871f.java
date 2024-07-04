import java.util.*;
import java.io.*;

public class Solution {

  static Scanner s = new Scanner(System.in);
  static int max = 1000_000;

  public static void main(String[] args) {
    int T = s.nextInt();
    for (int t = 1; t <= T; t++) {
      int C = s.nextInt(), D = s.nextInt();
      int[] count = new int[C];
      for (int i = 1; i < C; i++) {
        count[i] = -s.nextInt();
      }
      // Integer[] index = new Integer[C];
      // for (int i = 0; i < C; i++) {
      //   index[i] = i;
      // }
      // Arrays.sort(index, (a, b) -> count[a] - count[b]);
      // int[] latency = new int[C];
      // int time = 0;
      // for (int i = 0; i < C; i++) {
      //   if (i != 0 && count[index[i]] != count[index[i - 1]]) {
      //     time++;
      //   }
      //   latency[index[i]] = time;
      // }

      // System.out.println("count: " + Arrays.toString(count));
      // System.out.println("index: " + Arrays.toString(index));
      // System.out.println("latency: " + Arrays.toString(latency));

      System.out.print(String.format("Case #%d:", t));
      for (int i = 0; i < D; i++) {
        int u = s.nextInt() - 1, v = s.nextInt() - 1;
        int ans = 0;
        if (u != 0 && v != 0) {
          ans = max;
        } else {
          if (u != 0) {
            ans = count[u];
          } else {
            ans = count[v];
          }
        }
        System.out.print(" " + ans);
      }
      System.out.println();
    }
  }
}

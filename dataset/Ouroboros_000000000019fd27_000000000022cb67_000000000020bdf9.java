import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int cn = 1; cn <= t; ++cn) {
      int n = in.nextInt();
      int[][] sc = new int[n][3];
      for (int i = 0;i < n;i++) {
        sc[i][0] = in.nextInt();
        sc[i][1] = in.nextInt();
        sc[i][2] = i;
      }
      Arrays.sort(sc, new Comparator<int[]>() {
        public int compare(int[] o1, int[] o2) {
          if (o1[0] > o2[0]) {
            return 1;
          } else {
            return -1;
          }
        }
      });

      int cf = -1; //earliest time that c is free
      int jf = -1; //earliest time that j is free
      char[] sol = new char[n];
      boolean impos = false;
      for (int i = 0;i < n;i++) {
        if (cf <= sc[i][0]) {
          sol[sc[i][2]] = 'C';
          cf = sc[i][1];
        } else if (jf <= sc[i][0]) {
          sol[sc[i][2]] = 'J';
          jf = sc[i][1];
        } else {
          impos = true;
          break;
        }
      }
      String sol_st = new String(sol);
      if (impos) {
          sol_st = "IMPOSSIBLE";
      }
      System.out.println("Case #" + cn + ": " +sol_st);
    }
  }
}
  

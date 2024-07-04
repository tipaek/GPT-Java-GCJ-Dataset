import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int rr = in.nextInt();
    for (int welp = 1; welp <= rr; welp++) {
      int l = in.nextInt();
      boolean[] c = new boolean[24 * 60 + 1];
      boolean[] j = new boolean[24 * 60 + 1];
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < l; i++) {
        int start = in.nextInt();
        int end = in.nextInt();
        boolean isCamAvail = true;
        for (int hmm = start; hmm < end; hmm++) {
          if (c[hmm]) {
            isCamAvail = false;
            break;
          }
        }
        if (isCamAvail) {
          sb.append("C");
          for (int hmm = start; hmm < end; hmm++) {
            c[hmm] = true;
          }
        } else {
          boolean isJamAvail = true;
          for (int hmm = start; hmm < end; hmm++) {
            if (j[hmm]) {
              isJamAvail = false;
              break;
            }
          }
          if (isJamAvail) {
            sb.append("J");
            for (int hmm = start; hmm < end; hmm++) {
              j[hmm] = true;
            }
          } else {
            sb.append("Q");
          }
        }
      }
      if (sb.toString().contains("Q")) {
        sb = new StringBuilder("IMPOSSIBLE");
      }
      System.out.println("Case #" + welp + ": " + sb);
    }
  }
}
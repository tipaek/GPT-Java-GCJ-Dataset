import java.util.*;
import java.io.*;

class Solution {
  static int[] dx = { 1, -1, 0, 0 };
  static int[] dy = { 0, 0, -1, 1 };

  public static void main(String[] args) throws Exception {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);

    int TT = Integer.parseInt(in.readLine());
    int currTT = 0;
    StringBuilder output = new StringBuilder();

    while (currTT++ < TT) {
      output.append("Case #" + currTT + ": ");

      String[] input = in.readLine().split("\\s+");
      int X = Integer.parseInt(input[0]);
      int Y = Integer.parseInt(input[1]);
      char[] m = input[2].toCharArray();

      int ans = -1;
      for (int i = 0; i < m.length; i++) {
        if (Math.abs(X) + Math.abs(Y) <= i) {
          ans = i;
          break;
        }
        if (m[i] == 'N') {
          Y++;
        } else if (m[i] == 'S') {
          Y--;
        } else if (m[i] == 'E') {
          X++;
        } else if (m[i] == 'W') {
          X--;
        }
      }
      if (ans == -1 && Math.abs(X) + Math.abs(Y) <= m.length) {
        ans = m.length;
      }

      if (ans == -1) {
        output.append("IMPOSSIBLE");
      } else {
        output.append(ans);
      }

      output.append('\n');
    }

    out.print(output);

    in.close();
    out.close();
  }

}
import java.util.*;
import java.io.*;

class Solution {
  private static int x, y, min;
  private static StringBuilder ans;
  private static char[] dxM = {'S', 'N'}, dyM = {'W', 'E'};
  private static int[] dx = {-1, 1}, dy = {-1, 1};
  public static void main(String[] args) throws Exception {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);

    int TT = Integer.parseInt(in.readLine());
    int currTT = 0;
    StringBuilder output = new StringBuilder();

    while (currTT++ < TT) {
      output.append("Case #" + currTT + ": ");

      String[] input = in.readLine().split("\\s+");
      x = Integer.parseInt(input[0]);
      y = Integer.parseInt(input[1]);

      min = Integer.MAX_VALUE;

      solve(0, 0, 0, new StringBuilder());

      if (min == Integer.MAX_VALUE) {
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

  private static void solve(long i, long j, int s, StringBuilder a) {
    if (s >= min) {
      return;
    }
    if (i == y && j == x) {
      ans = new StringBuilder(a);
      min = s;
      return;
    }
    long p = 1 << s;
    if (Math.abs(i - p) <= Math.abs(y)) {
      a.append('S');
      solve(i - p, j, s + 1, a);
      a.deleteCharAt(a.length() - 1);
    }
    
    if (Math.abs(i + p) <= Math.abs(y)) {
      a.append('N');
      solve(i + p, j, s + 1, a);
      a.deleteCharAt(a.length() - 1);
    }
    
    if (Math.abs(j - p) <= Math.abs(x)) {
      a.append('W');
      solve(i, j - p, s + 1, a);
      a.deleteCharAt(a.length() - 1);
    }
    
    if (Math.abs(j + p) <= Math.abs(x)) {
      a.append('E');
      solve(i, j + p, s + 1, a);
      a.deleteCharAt(a.length() - 1);
    }
  }

}
import java.io.*;
import java.util.*;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    int TC = Integer.parseInt(in.readLine());

    StringTokenizer st;

    for (int i = 1; i <= TC; i++) {
      int N = Integer.parseInt(in.readLine());
      int[][] sessions = new int[N][2];
      for (int j = 0; j < N; j++) {
        st = new StringTokenizer(in.readLine());
        sessions[j][0] = Integer.parseInt(st.nextToken());
        sessions[j][1] = Integer.parseInt(st.nextToken());
      }

      String schedule = "";
      boolean impossible = false;
      for (int j = 0; j < N; j++) {
        int numCollisions = 0;
        String collidedWith = "";
        for (int k = 0; k < j; k++) {
          if (collision(sessions[j][0], sessions[j][1], sessions[k][0], sessions[k][1])) {
            numCollisions++;
            collidedWith = "" + schedule.charAt(k);
            if (numCollisions > 1) {
              impossible = true;
              break;
            }
          }
        }
        if (impossible) {
          break;
        }
        if (numCollisions == 0) {
          schedule += "C";
        }
        else if (numCollisions == 1) {
          if (collidedWith.equals("C")) {
            schedule += "J";
          }
          else {
            schedule += "C";
          }
        }
      }
      if (impossible) {
        schedule = "IMPOSSIBLE";
      }

      out.printf("Case #%d: %s\n", i, schedule);
    }
    out.close();
  }

  private static boolean collision (int a, int b, int c, int d) {
    // returns true if sessions collide, otherwise false
    return ((a < d && a >= c) || (c < b && c >= a));
  }
}

import java.io.*;
import java.util.*;

class Time implements Comparable<Time> {
  boolean isAStart;
  String character;
  Time end;
  int time;

  public Time (int t, boolean typeIsStart) {
    this.time = t;
    this.isAStart = typeIsStart;
  }

  public int compareTo(Time other) {
    if (time != other.time) {
      return time - other.time;
    }
    return isAStart ? 1 : -1;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(System.in);
    int TC = in.nextInt();

    for (int n = 1; n <= TC; n++) {
      int N = in.nextInt();
      in.nextLine();

      int[][] sessions = new int[N][2];
      Time[][] times = new Time[N][2];
      PriorityQueue<Time> pq = new PriorityQueue<>();
      for (int i = 0; i < N; i++) {
        String[] line = in.nextLine().split(" ");
        sessions[i][0] = Integer.parseInt(line[0]);
        sessions[i][1] = Integer.parseInt(line[1]);
        times[i][0] = new Time(sessions[i][0], true);
        times[i][1] = new Time(sessions[i][1], false);
        times[i][0].end = times[i][1];
        pq.add(times[i][0]);
        pq.add(times[i][1]);
      }

      int currentSessions = 0;
      boolean impossible = false;
      boolean usingC = false;
      while (!pq.isEmpty()) {
        Time t = pq.poll();

        if (t.isAStart) {
          if (usingC) {
            t.end.character = "J";
          }
          else {
            t.end.character = "C";
            usingC = true;
          }
          /*if (currentSessions == 0) {
            t.end.character = "C";
          }
          else {
            t.end.character = "J";
          }
          */
          currentSessions++;
        }
        if (!t.isAStart) {
          if (t.character.equals("C")) {
            usingC = false;
          }
          currentSessions--;
        }

        if (currentSessions > 2) {
          impossible = true;
          break;
        }
      }

      String schedule = "";
      for (int j = 0; j < N; j++) {
        schedule += times[j][1].character;
      }

      if (impossible) {
        schedule = "IMPOSSIBLE";
      }

      System.out.printf("Case #%d: %s\n", n, schedule);
    }

  }
}














/*
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
        ArrayList<ArrayList<Integer>> collisions = new ArrayList<>();
        outer: for (int k = 0; k < j; k++) {
          if (collision(sessions[j][0], sessions[j][1], sessions[k][0], sessions[k][1])) {
            int left = 0;
            int right = 0;
            if (sessions[j][0] >= sessions[k][0] && sessions[j][1] <= sessions[k][1]) {
              left = sessions[j][0];
              right = sessions[j][1];
            }
            else if (sessions[j][0] >= sessions[k][0] && sessions[k][1] <= sessions[j][1]) {
              left = sessions[j][0];
              right = sessions[k][1];
            }
            else if (sessions[k][0] >= sessions[j][0] && sessions[k][1] <= sessions[j][1]) {
              left = sessions[k][0];
              right = sessions[k][1];
            }
            else if (sessions[k][0] >= sessions[j][0] && sessions[j][1] <= sessions[k][1]) {
              left = sessions[k][0];
              right = sessions[j][1];
            }
            collisions.add(new ArrayList<>());
            collisions.get(collisions.size() - 1).add(left);
            collisions.get(collisions.size() - 1).add(right);
            for (int m = 0; m < collisions.size() - 1; m++) {
              if (collision(left, right, collisions.get(m).get(0), collisions.get(m).get(1))) {
                impossible = true;
                break outer;
              }
            }
            numCollisions++;
            if (collidedWith.length() == 0) {
              collidedWith = "" + schedule.charAt(k);
            }
            //if (numCollisions > 1) {
            //  impossible = true;
            //  break;
            //}
          }
        }
        if (impossible) {
          break;
        }
        if (numCollisions == 0) {
          schedule += "C";
        }
        else {
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
*/

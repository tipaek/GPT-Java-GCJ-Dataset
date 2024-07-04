import java.util.*;
import java.io.*;

public class Solution {
  public static class Pair implements Comparable<Pair> {
    int t, i, in;

    public Pair(int t, int i, int in) {
      this.t = t;
      this.i = i;
      this.in = in;
    }

    public int compareTo(Pair o) {
      if (t == o.t) {
        if (i == 1)
          return -1;
        return 1;
      }
      return Integer.compare(t, o.t);
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int rr = in.nextInt();
    for (int welp = 1; welp <= rr; welp++) {
      int n = in.nextInt();
      PriorityQueue<Pair> pq = new PriorityQueue<>();
      for (int i = 0; i < n; i++) {
        pq.add(new Pair(in.nextInt(), 0, i));
        pq.add(new Pair(in.nextInt(), 1, i));
      }
      boolean works = true;
      int curr = 0;
      char[] ans = new char[n];
      boolean c = false, j = false;
      while (!pq.isEmpty()) {
        // System.out.println(Arrays.toString(ans));
        Pair pa = pq.poll();
        if (pa.i == 0) {
          curr++;
          if (curr == 3) {
            works = false;
            break;
          } else if (!c) {
            c = true;
            ans[pa.in] = 'C';
          } else {
            j = true;
            ans[pa.in] = 'J';
          }
        } else {
          curr--;
          if (ans[pa.in] == 'C')
            c = false;
          else
            j = false;
        }
      }
      String answer = new String(ans);
      if (!works)
        answer = "IMPOSSIBLE";
      System.out.println("Case #" + welp + ": " + answer);
    }
  }
}
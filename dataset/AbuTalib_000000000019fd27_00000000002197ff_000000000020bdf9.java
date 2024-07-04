import java.util.*;
import java.io.*;

public class Solution {
  public static class Node implements Comparable<Node> {
    int t, in;
    boolean isStartTime;

    public Node(int t, boolean isStartTime, int in) {
      this.t = t;
      this.isStartTime = isStartTime;
      this.in = in;
    }

    public int compareTo(Node o) {
      if (t == o.t) {
        if (!isStartTime)
          return -1;
        return 1;
      }
      return t < o.t ? -1 : 1;
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int rr = in.nextInt();
    for (int welp = 1; welp <= rr; welp++) {
      int n = in.nextInt();
      PriorityQueue<Node> pq = new PriorityQueue<>();
      for (int i = 0; i < n; i++) {
        pq.add(new Node(in.nextInt(), true, i));
        pq.add(new Node(in.nextInt(), false, i));
      }
      boolean works = true;
      int curr = 0;
      char[] ans = new char[n];
      boolean c = false;
      while (!pq.isEmpty()) {
        // System.out.println(Arrays.toString(ans));
        Node pa = pq.poll();
        if (pa.isStartTime) {
          curr++;
          if (curr == 3) {
            works = false;
            break;
          } else if (!c) {
            c = true;
            ans[pa.in] = 'C';
          } else {
            ans[pa.in] = 'J';
          }
        } else {
          curr--;
          if (ans[pa.in] == 'C')
            c = false;
        }
      }
      String answer = new String(ans);
      if (!works)
        answer = "IMPOSSIBLE";
      System.out.println("Case #" + welp + ": " + answer);
    }
  }
}
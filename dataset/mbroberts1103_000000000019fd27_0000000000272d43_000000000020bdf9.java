import java.io.*;
import java.util.*;

public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int runs = Integer.parseInt(sc.nextLine().trim());
    for (int run = 1; run <= runs; run++) {
      int N = Integer.parseInt(sc.nextLine().trim());
      Map<Integer, Integer> C = new HashMap<Integer, Integer>();
      Map<Integer, Integer> J = new HashMap<Integer, Integer>();
      String sched = "";
      C.put(0, 1440);
      J.put(0, 1440);
      boolean skip = false;

      for (int i = 0; i < N; i++) {
        int start = sc.nextInt();
        int end = sc.nextInt();

        if (!skip) {
          if (schedule(start, end, C)) {
            sched += "C";
          } else if (schedule(start, end, J)) {
            sched += "J";
          } else {
            skip = true;
            sched = "IMPOSSIBLE";
          }
        }

        if (sc.hasNextLine()) {
          sc.nextLine();
        }
      }

      System.out.printf("Case #%d: %s\n", run, sched);
    }
  }

  public static boolean schedule(int start, int end, Map<Integer, Integer> sched) {
    for (int blockStart : sched.keySet()) {
      if (start >= blockStart && end <= sched.get(blockStart)) {
        int blockEnd = sched.get(blockStart);
        sched.put(blockStart, start);
        sched.put(end, blockEnd);

        return true;
      }
    }

    return false;
  }
}
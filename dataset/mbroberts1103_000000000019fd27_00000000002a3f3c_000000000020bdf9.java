import java.io.*;
import java.util.*;

public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int runs = Integer.parseInt(sc.nextLine().trim());
    for (int run = 1; run <= runs; run++) {
      int N = Integer.parseInt(sc.nextLine().trim());

      StringBuffer sched = new StringBuffer(N);
      for (int i = 0; i < N; i++) {
        sched.append("-");
      }

      Map<Integer, Integer> C = new HashMap<Integer, Integer>();
      Map<Integer, Integer> J = new HashMap<Integer, Integer>();
      C.put(0, 1440);
      J.put(0, 1440);

      boolean skip = false;

      Map<Integer, ArrayList<int[]>> sortedSched = new TreeMap<>();
      for (int i = 0; i < N; i++) {
        int start = sc.nextInt();
        int end = sc.nextInt();
        int size = end - start;

        if (!sortedSched.containsKey(size)) {
          sortedSched.put(size, new ArrayList<>());
        }
        sortedSched.get(size).add(new int[] { start, end, i });

        if (sc.hasNextLine()) {
          sc.nextLine();
        }
      }

      for (int key : sortedSched.keySet()) {
        for (int[] data : sortedSched.get(key)) {
          int start = data[0];
          int end = data[1];
          int ind = data[2];

          if (!skip) {
            if (schedule(start, end, C)) {
              sched.setCharAt(ind, 'C');
            } else if (schedule(start, end, J)) {
              sched.setCharAt(ind, 'J');
            } else {
              skip = true;
              sched = new StringBuffer("IMPOSSIBLE");
            }
          }
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
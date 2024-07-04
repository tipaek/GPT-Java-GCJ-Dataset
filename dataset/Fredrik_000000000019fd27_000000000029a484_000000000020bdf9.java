import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    int testCases = in.nextInt();
    for (int i = 1; i <= testCases; i++) {
      printSolution(i, getSequence(in));
    }
  }

  private static String getSequence (Scanner in) {
    int schedules = in.nextInt();
      in.nextLine();

      PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
        if (a[0] == b[0]) return a[1] - b[1];
        return a[0] - b[0];
      });

      for (int j = 0; j < schedules; j++) {
        String line = in.nextLine();
        String[] splits = line.split(" ");

        int start = Integer.parseInt(splits[0]);
        int end = Integer.parseInt(splits[1]);

        minHeap.offer(new int[] { start, end });
      }

      int[] cameronSchedule = null;
      int[] jamieSchedule = null;

      StringBuilder sb = new StringBuilder();


      while (!minHeap.isEmpty()) {
        int[] interval = minHeap.poll();

        if (cameronSchedule == null || cameronSchedule[1] <= interval[0]) {
          cameronSchedule = interval;
          sb.append("C");
        } else if (jamieSchedule == null || jamieSchedule[1] <= interval[0]) {
          jamieSchedule = interval;
          sb.append("J");
        } else {
          return "IMPOSSIBLE";
        }
      }
    return sb.toString();
  }

  private static void printSolution (int i, String line) {
    System.out.println("Case #" + i + ": " + line);
  }
}

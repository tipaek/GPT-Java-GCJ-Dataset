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

      List<int[]> cameronSchedule = new ArrayList<>();
      List<int[]> jamieSchedule = new ArrayList<>();

      Deque<int[]> intervals = new ArrayDeque<>();
      StringBuilder sb = new StringBuilder();

      for (int j = 0; j < schedules; j++) {
        String line = in.nextLine();
        String[] splits = line.split(" ");

        int start = Integer.parseInt(splits[0]);
        int end = Integer.parseInt(splits[1]);

        intervals.offer(new int[] { start, end });
      }

      while (!intervals.isEmpty()) {
        int[] interval = intervals.poll();

        if (isAvailable(cameronSchedule, interval)) {
          cameronSchedule.add(interval);
          sb.append("C");
        } else if (isAvailable(jamieSchedule, interval)) {
          jamieSchedule.add(interval);
          sb.append('J');
        } else {
          return "IMPOSSIBLE";
        }
      }
    return sb.toString();
  }

  private static boolean isAvailable (List<int[]> schedule, int[] interval) {
    for (int[] scheduledInterval: schedule) {
      if (scheduledInterval[0] < interval[1] && interval[0] < scheduledInterval[1]) {
        return false;
      }
    }
    return true;
  }

  private static void printSolution (int i, String line) {
    System.out.println("Case #" + i + ": " + line);
  }
}


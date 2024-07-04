import java.util.Arrays;
import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int testCasesCount = s.nextInt();

    String[] results = new String[testCasesCount];

    for (int i = 0; i < testCasesCount; i++) {
      results[i] = scheduleActivities(s);
    }

    for (int i = 1; i <= testCasesCount; i++) {
      System.out.println(String.format("Case #%s: %s ", i, results[i - 1]));
    }
  }

  public static String scheduleActivities(Scanner s) {
    int n = s.nextInt();
    Range[] activities = new Range[n];

    for (int i = 0; i < n; i++) {
      int start = s.nextInt();
      int end = s.nextInt();

      activities[i] = new Range(start, end, i);
    }

    // sorts activities by their start time to find intersections
    Arrays.sort(activities);

    char[] result = new char[n];

    Range lastJamieActivity = new Range(-1, -1, -1);
    Range lastCameronActivity = new Range(-1, -1, -1);

    for (Range activity : activities) {
      if (activity.intersects(lastJamieActivity)) {
        if (activity.intersects(lastCameronActivity)) {
          return "IMPOSSIBLE";
        } else {
          result[activity.index] = 'C';
          lastCameronActivity = activity;
        }
      } else {
        result[activity.index] = 'J';
        lastJamieActivity = activity;
      }
    }

    return new String(result);
  }

  public static class Range implements Comparable<Range> {
    private final int start;
    private final int end;

    // index of the range within input
    private final int index;

    public Range(int start, int end, int index) {
      this.start = start;
      this.end = end;
      this.index = index;
    }

    public boolean intersects(Range other) {
      // start of this range inside other range
      return (this.start >= other.start && this.start < other.end)
          // start of other range inside this range
          || (other.start >= this.start && other.start < this.end);
    }

    @Override
    public int compareTo(Range o) {
      // order by start of the action
      return this.start - o.start;
    }
  }
}
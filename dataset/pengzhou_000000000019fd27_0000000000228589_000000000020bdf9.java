import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      Schedule[] schedules = new Schedule[n];
      for (int k = 0; k < n; k++) {
        int startTime = in.nextInt();
        int endTime = in.nextInt();
        schedules[k] = new Schedule(startTime, endTime, k);
      }
      String result = calculateSchedule(schedules);
      System.out.println("Case #" + i + ": " + result);
    }
  }

  private static String calculateSchedule(Schedule[] schedules) {
    int N = schedules.length;
    String[] results = new String[N];
    Arrays.sort(schedules, new SortByStartTime());
    int jLastTime=0;
    int cLastTime=0;
    for (int i = 0; i<N; i++) {
      Schedule schedule = schedules[i];
      if (cLastTime <= schedule.startTime) {
        results[schedule.order] = "C";
        cLastTime = schedule.endTime;
      } else if (jLastTime <= schedule.startTime) {
        results[schedule.order] = "J";
        jLastTime = schedule.endTime;
      } else {
        return "IMPOSSIBLE";
      }
    }
    StringBuilder sb = new StringBuilder();
    for (String s : results) {
      sb.append(s);
    }
    return sb.toString();
  }

  static class Schedule {
    int startTime;
    int endTime;
    int order;

    public Schedule(int startTime, int endTime, int order) {
      this.startTime = startTime;
      this.endTime = endTime;
      this.order = order;
    }

    public String toString() {
      return "Schedule -startTime: " + this.startTime + " -endTime: " + this.endTime + " -order: " + this.order; 
    }
  }

  static class SortByStartTime implements Comparator<Schedule> {
    public int compare(Schedule a, Schedule b) {
      return a.startTime - b.startTime;
    }
  }
}
import java.io.BufferedInputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.Collections.sort;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedInputStream(System.in));
    PrintStream out = System.out;
    int T = in.nextInt();
    int N;
    List<Activity> activities;
    List<Activity> sortedActivities;
    Activity C, J;
    StringBuilder schedule;
    for (int t = 1; t <= T; t++) {
      N = in.nextInt();
      activities = new ArrayList<>();
      for (int i = 0; i < N; i++) {
        activities.add(new Activity(in.nextInt(), in.nextInt()));
      }
      sortedActivities = new ArrayList<>(activities);
      sort(sortedActivities);
      C = new Activity(-1, -1);
      J = new Activity(-1, -1);
      schedule = new StringBuilder();
      for (Activity activity : sortedActivities) {
        if (C.end <= activity.start) {
          activity.owner = "C";
          C = activity;
        } else if (J.end <= activity.start) {
          activity.owner = "J";
          J = activity;
        } else {
          schedule = new StringBuilder("IMPOSSIBLE");
          break;
        }
      }
      if (!schedule.toString().equals("IMPOSSIBLE")) {
        for (Activity activity : activities) {
          schedule.append(activity.owner);
        }
      }
      out.println("Case #" + t + ": " + schedule);
    }
  }

  private static class Activity implements Comparable<Activity> {
    int start, end;
    String owner;

    public Activity(int start, int end) {
      this.start = start;
      this.end = end;
    }

    @Override
    public int compareTo(Activity o) {
      if (start == o.start) {
        return end - o.end;
      }
      return start - o.start;
    }

    @Override
    public String toString() {
      return "Activity{" +
          "start=" + start +
          ", end=" + end +
          ", owner='" + owner + '\'' +
          '}';
    }
  }
}
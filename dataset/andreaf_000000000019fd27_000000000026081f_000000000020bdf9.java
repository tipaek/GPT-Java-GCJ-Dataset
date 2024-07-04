
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
      //try (Scanner sc = new Scanner(new File("src/main/resources/codejam/parents-example.in"))) {
      int numberOfTestCase = sc.nextInt();
      for (int i = 0; i < numberOfTestCase; i++) {
        int numberOfActivities = sc.nextInt();
        List<Activity> activities = new ArrayList<>();
        for (int activity = 0; activity < numberOfActivities; activity++) {
          int startTime = sc.nextInt();
          int endTime = sc.nextInt();
          activities.add(new Activity(startTime, endTime));
        }
        activities.sort(new SortActivityByStartTime());
        int cameronEndTurn = -1;
        int jamieEndTurn = -1;
        StringBuilder schedule = new StringBuilder();
        int activityIndex = 0;
        for (int minute = 0; minute <= 24 * 60; minute++) {
          if (activityIndex >= activities.size()) {
            break;
          }
          Activity activity = activities.get(activityIndex);
          if (activity.getStart() > minute) {
            continue;
          }
          if (cameronEndTurn != -1 && minute >= cameronEndTurn) {
            cameronEndTurn = -1;
          }
          if (jamieEndTurn != -1 && minute >= jamieEndTurn) {
            jamieEndTurn = -1;
          }
          if (cameronEndTurn == -1) {
            schedule.append("C");
            cameronEndTurn = activity.getEnd();
            activityIndex++;
            minute--;
          } else if (jamieEndTurn == -1) {
            schedule.append("J");
            jamieEndTurn = activity.getEnd();
            activityIndex++;
            minute--;
          } else {
            schedule = new StringBuilder("IMPOSSIBLE");
            break;
          }
        }
        System.out.println(String.format("Case #%d: %s", (i + 1), schedule.toString()));
      }

    }
  }

  private static class SortActivityByStartTime implements Comparator<Activity> {
    @Override
    public int compare(Activity a1, Activity a2) {
      return Integer.compare(a1.getStart(), a2.getStart());
    }
  }

  private static class Activity {
    private final int start;
    private final int end;

    public Activity(int start, int end) {
      this.start = start;
      this.end = end;
    }

    public int getStart() {
      return start;
    }

    public int getEnd() {
      return end;
    }

    @Override
    public String toString() {
      return "Activity{" +
          "start=" + start +
          ", end=" + end +
          '}';
    }
  }
}


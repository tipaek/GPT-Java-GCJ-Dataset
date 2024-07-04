
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
          activities.add(new Activity(activity, startTime, endTime));
        }
        activities.sort(new SortActivityByStartTime());
        int cameronEndTurn = -1;
        int jamieEndTurn = -1;
        int activityIndex = 0;
        boolean impossible = false;
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
            cameronEndTurn = activity.getEnd();
            activity.setOwner("C");
            activityIndex++;
            minute--;
          } else if (jamieEndTurn == -1) {
            jamieEndTurn = activity.getEnd();
            activity.setOwner("J");
            activityIndex++;
            minute--;
          } else {
            impossible = true;
            break;
          }
        }
        if (impossible) {
          System.out.println(String.format("Case #%d: %s", (i + 1), "IMPOSSIBLE"));
        } else {
          System.out.println(String.format("Case #%d: %s", (i + 1), getOwners(activities)));
        }
      }

    }
  }

  private static String getOwners(List<Activity> activities) {
    return activities
        .stream()
        .sorted(new SortActivityByIndex())
        .map(Activity::getOwner)
        .collect(Collectors.joining(""));
  }

  private static class SortActivityByStartTime implements Comparator<Activity> {
    @Override
    public int compare(Activity a1, Activity a2) {
      return Integer.compare(a1.getStart(), a2.getStart());
    }
  }

  private static class SortActivityByIndex implements Comparator<Activity> {
    @Override
    public int compare(Activity a1, Activity a2) {
      return Integer.compare(a1.getIndex(), a2.getIndex());
    }
  }

  private static class Activity {
    private final int index;
    private final int start;
    private final int end;
    private String owner;

    public Activity(int index, int start, int end) {
      this.index = index;
      this.start = start;
      this.end = end;
    }

    public int getIndex() {
      return index;
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

    public String getOwner() {
      return owner;
    }

    public void setOwner(String owner) {
      this.owner = owner;
    }
  }
}
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Solution {
  static class Activity {
    private Integer startTime;
    private Integer endTime;

    private Integer activityNumber;
    private char assignedTo;

    public Activity() {}

    public Activity(int startTime, int endTime) {
      this.startTime = startTime;
      this.endTime = endTime;
    }

    public Integer getStartTime() {
      return startTime;
    }

    public void setStartTime(int startTime) {
      this.startTime = startTime;
    }

    public Integer getEndTime() {
      return endTime;
    }

    public void setEndTime(int endTime) {
      this.endTime = endTime;
    }

    public Integer getActivityNumber() {
      return activityNumber;
    }

    public void setActivityNumber(Integer activityNumber) {
      this.activityNumber = activityNumber;
    }

    public char getAssignedTo() {
      return assignedTo;
    }

    public void setAssignedTo(char assignedTo) {
      this.assignedTo = assignedTo;
    }
  }

  public static void main(String[] arg) {
    Scanner scanner = new Scanner(System.in);
    try {
      int testCases = parseInt(scanner.nextLine());
      ArrayList<ArrayList<Activity>> testActivities = new ArrayList<>();
      for (int i = 0; i < testCases; i++) {
        int numberOfActivities = parseInt(scanner.nextLine());
        ArrayList<Activity> activities = new ArrayList<>();
        for (int j = 0; j < numberOfActivities; j++) {
          Activity activity = new Activity();

          String in = scanner.nextLine();
          String[] times = in.split("\\s+");

          activity.setStartTime(parseInt(times[0]));
          activity.setEndTime(parseInt(times[1]));
          activity.setActivityNumber(j);

          activities.add(activity);
        }
        testActivities.add(activities);
      }
      for (int i = 0; i < testCases; i++) {
        solve(testActivities.get(i), i + 1);
      }
    } catch (Exception e) {
      System.out.println(String.format("Error: %s", e.getMessage()));
    } finally {
      scanner.close();
    }
  }

  private static void solve(ArrayList<Activity> activities, int testCase) {
    Collections.sort(activities, Comparator.comparingInt(Activity::getStartTime));
    char jamie = 'J';
    char cameron = 'C';
    int assignedActivities = 0;

    // assign first activity to Cameron always
    Activity cameronLastActivity = activities.get(0);
    activities.get(0).setAssignedTo(cameron);
    assignedActivities++;
    Activity jamieLastActivity = null;

    for (int i = 1; i < activities.size(); i++) {
      Activity activity = activities.get(i);
      // if jamie's last activities end time <= this activities start time then assign to jamie
      // else if cameron's last activities end time <= this activities start time then assign to
      // cameron
      if (jamieLastActivity == null || jamieLastActivity.getEndTime() <= activity.getStartTime()) {
        jamieLastActivity = activity;
        activity.setAssignedTo(jamie);
        assignedActivities++;
      } else if (cameronLastActivity == null
          || cameronLastActivity.getEndTime() <= activity.getStartTime()) {
        cameronLastActivity = activity;
        activity.setAssignedTo(cameron);
        assignedActivities++;
      }
    }

    if (assignedActivities != activities.size()) {
      System.out.printf("Case #%d: IMPOSSIBLE\n", testCase);
    } else {
      Collections.sort(activities, Comparator.comparingInt(Activity::getActivityNumber));
      StringBuilder sb = new StringBuilder();
      activities.forEach(a -> sb.append(a.getAssignedTo()));
      System.out.printf("Case #%d: %s\n", testCase, sb.toString());
    }
  }
}

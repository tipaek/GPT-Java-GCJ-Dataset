import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

  public static void main(String[] args) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int testCases;
    testCases = sc.nextInt();

    for (int testCase = 1; testCase <= testCases; testCase++) {
      int activityCount = sc.nextInt();
      List<Activity> activities = new LinkedList<Activity>();
      for (int i = 0; i < activityCount; i++) {
        Activity activity = new Activity(i, sc.nextInt(), sc.nextInt());
        activities.add(activity);
      }
      Comparator<Activity> byTime = new Comparator<Activity>() {
        public int compare(Activity t1, Activity t2) {
          int result;
          if (t1.startTime < t2.startTime) {
            result = -1;
          } else if (t1.startTime > t2.startTime) {
            result = 1;
          } else {
            result = t1.endTime.compareTo(t2.endTime);
          }
          return result;
        }
      };
      Collections.sort(activities, byTime);
      if (assignActivities(activities)) {
        String[] activityTrack = new String[activityCount];
        for (Activity a : activities) {
          activityTrack[a.index] = a.owner;
        }
        System.out.println("Case #" + testCase + ": " + Arrays.stream(activityTrack)
            .collect(Collectors.joining()));
      } else {
        System.out.println("Case #" + testCase + ": IMPOSSIBLE");
      }
    }
  }

  private static boolean assignActivities(List<Activity> activities) {
    Integer lastEndForC, lastEndForJ;
    lastEndForC = activities.get(0).endTime;
    activities.get(0).assignToC();
    lastEndForJ = -1;

    for (int i = 1; i < activities.size(); i++) {
      Activity current = activities.get(i);
      if (lastEndForC <= current.startTime) {
        current.assignToC();
        lastEndForC = current.endTime;
      } else if (lastEndForJ <= current.startTime) {
        current.assignToJ();
        lastEndForJ = current.endTime;
      } else {
        return false;
      }
    }
    return true;
  }


  private static class Activity {

    private Integer index;
    private Integer startTime;
    private Integer endTime;
    private String owner;

    public Activity(int index, int startTime, int endTime) {
      this.index = index;
      this.startTime = startTime;
      this.endTime = endTime;
    }

    public void assignToC() {
      this.owner = "C";
    }

    public void assignToJ() {
      this.owner = "J";
    }
  }
}
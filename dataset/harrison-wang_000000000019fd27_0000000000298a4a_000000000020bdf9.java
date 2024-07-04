import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int numTestCases = Integer.parseInt(in.nextLine());
    for (int i = 1; i <= numTestCases; ++i) {
      int numActivities = Integer.parseInt(in.nextLine());
      PriorityQueue<Activity> activityQueue = new PriorityQueue<>(numActivities, new ActivityComparator());
      for (int j = 0; j < numActivities; j++) {
        String line = in.nextLine();
        String[] activity = line.split(" ");
        int begin = Integer.valueOf(activity[0]);
        int end = Integer.valueOf(activity[1]);
        Activity a = new Activity(begin, end, j);
        activityQueue.add(a);
      }

      int whenIsJamieNextAvailable = 0;
      int whenIsCameronNextAvailable = 0;
      boolean isImpossible = false;
      char[] output = new char[numActivities];
      for (int k = 0; k < numActivities; k++) {
        Activity activity = activityQueue.poll();
        if (activity.getBegin() >= whenIsCameronNextAvailable) {
          whenIsCameronNextAvailable = activity.getEnd();
          output[activity.getIndex()] = 'C';
        } else if (activity.getBegin() >= whenIsJamieNextAvailable) {
          whenIsJamieNextAvailable = activity.getEnd();
          output[activity.getIndex()] = 'J';
        } else {
          isImpossible = true;
          break;
        }
      }
      String outputString = isImpossible ? "IMPOSSIBLE" : new String(output);
      System.out.println(String.format("Case #%d:  %s", i, outputString));
    }
  }

  public static class ActivityComparator implements Comparator<Activity> {
    @Override
    public int compare(Activity a1, Activity a2) {
      if (a1.begin < a2.begin) {
        return -1;
      } else if (a1.begin == a2.begin && a1.end < a2.end) {
        return -1;
      } else if (a1.begin > a2.begin) {
        return 1;
      }
      return 0;
    }
  }

  public static class Activity {
    public int begin;
    public int end;
    public int index;

    public Activity(int begin, int end, int index) {
      this.begin = begin;
      this.end = end;
      this.index = index;
    }

    public int getBegin() {
      return this.begin;
    }
    public int getEnd() {
      return this.end;
    }
    public int getIndex() {
      return this.index;
    }

    public String toString() {
      return String.format("Activity{%d,%d,%d}", begin, end, index);
    }
  }
}
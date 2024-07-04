import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Input:
 * <p>
 * 4
 * 3
 * 360 480
 * 420 540
 * 600 660
 * 3
 * 0 1440
 * 1 3
 * 2 4
 * 5
 * 99 150
 * 1 100
 * 100 301
 * 2 5
 * 150 250
 * 2
 * 0 720
 * 720 1440
 * <p>
 * Output:
 * <p>
 * Case #1: CJC
 * Case #2: IMPOSSIBLE
 * Case #3: JCCJJ
 * Case #4: CC
 */
public class Solution {

  public static void main(String[] args) {
    try (Scanner in = new Scanner((System.in))) {
      int t = in.nextInt();
      in.nextLine();
      for (int i = 1; i <= t; i++) {
        int size = in.nextInt();
        List<Activity> activities = new ArrayList<>(size);
        for (int j = 0; j < size; j++) {
          activities.add(new Activity(j, in.nextInt(), in.nextInt()));
        }
        System.out.println(String.format("Case #%d: %s", i,
            parentingPartneringReturns(activities)));
      }
    }
  }

  private static String parentingPartneringReturns(List<Activity> activities) {
    final char CAMERON = 'C';
    int cameronTime = 0;
    final char JAMIE = 'J';
    int jamieTime = 0;
    boolean isItPossible = true;

    sortActivities(activities);
    char[] schedule = new char[activities.size()];

    for (Activity activity : activities) {
      if (activity.start >= cameronTime) {
        cameronTime = activity.end;
        schedule[activity.id] = CAMERON;
        continue;
      }
      if (activity.start >= jamieTime) {
        jamieTime = activity.end;
        schedule[activity.id] = JAMIE;
        continue;
      }

      isItPossible = false;
      break;
    }

    if (!isItPossible) {
      return "IMPOSSIBLE";
    }
    return String.valueOf(schedule);
  }

  private static void sortActivities(List<Activity> activities) {
    Collections.sort(activities);
  }

  static class Activity implements Comparable<Activity> {
    int id;
    int start;
    int end;

    public Activity(int id, int start, int end) {
      this.id = id;
      this.start = start;
      this.end = end;
    }

    @Override
    public int compareTo(Activity o) {
      int f = Integer.compare(this.start, o.start);
      if (f == 0) {
        return Integer.compare(this.end, o.end);
      }
      return f;
    }
  }
}

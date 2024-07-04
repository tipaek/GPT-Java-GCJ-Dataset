import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

  final static Scanner keyboard = new Scanner(System.in);


  public static void main(final String[] args) {
    final int numberOfTestCases = keyboard.nextInt();
    final String[] outputs = new String[numberOfTestCases];
    for (int i = 0; i < numberOfTestCases; i++) {
      final int size = keyboard.nextInt();
      final Activity[] activities = readActivities(size);
      outputs[i] = createResultOutput(i + 1, activities);
    }
    for (final String output : outputs) {
      System.out.println(output);
    }
  }

  private static Activity[] readActivities(int size) {
    Activity[] activities = new Activity[size];
    for (int i = 0; i < size; i++) {
      activities[i] = new Activity(i, keyboard.nextInt(), keyboard.nextInt());
    }
    return activities;
  }

  private static String createResultOutput(final int testCase, final Activity[] activities) {
    final int size = activities.length;
    sortActivities(activities);
    final Map<String, Activity> active = new HashMap<>();
    active.put("C", null);
    active.put("J", null);
    final String[] results = new String[size];
    for (int i = 0; i < size; i++) {
      final Activity activity = activities[i];
      if (active.get("C") == null) {
        active.put("C", activity);
        results[activity.getPosition()] = "C";
      } else if (active.get("C").getEnd() <= activity.getStart()) {
        active.put("C", activity);
        results[activity.getPosition()] = "C";
      } else if (active.get("J") == null) {
        active.put("J", activity);
        results[activity.getPosition()] = "J";
      } else if (active.get("J").getEnd() <= activity.getStart()) {
        active.put("J", activity);
        results[activity.getPosition()] = "J";
      } else {
        return "Case #" + testCase + ": IMPOSSIBLE";
      }
    }

    return "Case #" + testCase + ": " + String.join("", results);
  }

  private static void sortActivities(Activity[] activities) {
    Arrays.sort(activities, (activity1, activity2) -> {
      if (activity1.getStart() != activity2.getStart()) {
        return activity1.getStart() - activity2.getStart();
      }
      return activity1.getEnd() - activity2.getEnd();
    });
  }

  private static class Activity {

    private int position;
    private int start;
    private int end;

    public Activity(int position, int start, int end) {
      this.position = position;
      this.start = start;
      this.end = end;
    }

    public int getStart() {
      return start;
    }

    public int getEnd() {
      return end;
    }

    public int getPosition() {
      return position;
    }
  }
}

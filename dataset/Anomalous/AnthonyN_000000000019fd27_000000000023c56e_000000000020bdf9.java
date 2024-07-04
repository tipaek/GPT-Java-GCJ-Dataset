import java.util.*;

public class Solution {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int testCases = Integer.parseInt(scanner.nextLine());

    for (int t = 0; t < testCases; t++) {
      int activitiesCount = Integer.parseInt(scanner.nextLine());
      int[][] activities = new int[activitiesCount][2];

      for (int a = 0; a < activitiesCount; a++) {
        String[] times = scanner.nextLine().split(" ");
        activities[a][0] = Integer.parseInt(times[0]);
        activities[a][1] = Integer.parseInt(times[1]);
      }

      System.out.println("Case #" + (t + 1) + ": " + assignActivities(activities));
    }
  }

  private static String assignActivities(int[][] activities) {
    int[][] sortedActivities = sortActivities(activities);
    String[] assignments = new String[sortedActivities.length];
    String[] result = new String[sortedActivities.length];

    assignments[0] = "C";

    for (int i = 1; i < sortedActivities.length; i++) {
      if (getLastEndTime("C", sortedActivities, assignments) <= sortedActivities[i][0]) {
        assignments[i] = "C";
      } else if (getLastEndTime("J", sortedActivities, assignments) <= sortedActivities[i][0]) {
        assignments[i] = "J";
      } else {
        return "IMPOSSIBLE";
      }
    }

    for (int i = 0; i < assignments.length; i++) {
      result[findOriginalIndex(sortedActivities[i], activities)] = assignments[i];
    }

    return String.join("", result);
  }

  private static int[][] sortActivities(int[][] activities) {
    int[][] sortedActivities = Arrays.copyOf(activities, activities.length);

    Arrays.sort(sortedActivities, (a1, a2) -> Integer.compare(a1[0], a2[0]));

    return sortedActivities;
  }

  private static int findOriginalIndex(int[] activity, int[][] activities) {
    for (int i = 0; i < activities.length; i++) {
      if (Arrays.equals(activity, activities[i])) {
        return i;
      }
    }
    return -1;
  }

  private static int getLastEndTime(String person, int[][] activities, String[] assignments) {
    for (int i = assignments.length - 1; i >= 0; i--) {
      if (assignments[i] != null && assignments[i].equals(person)) {
        return activities[i][1];
      }
    }
    return -1;
  }
}
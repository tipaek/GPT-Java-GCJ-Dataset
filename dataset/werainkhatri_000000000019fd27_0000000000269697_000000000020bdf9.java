import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int tests = scanner.nextInt();
    for (int t = 0; t < tests; t++) {
      int n = scanner.nextInt();

      int[][] activities = new int[n][2];
      for (int i = 0; i < n; i++) {
        activities[i][0] = scanner.nextInt();
        activities[i][1] = scanner.nextInt();
      }

      String[] schedule = new String[n];
      boolean isImpossible = false;

      for (int i = 0; i < activities.length - 1; i++) {
        ArrayList<Integer> activitiesItOverlaps = new ArrayList<>();
        for (int j = i + 1; j < activities.length; j++) {
          if (overlaps(activities[i], activities[j]))
            activitiesItOverlaps.add(j);
        }

        if (activitiesItOverlaps.size() == 0) {
          if (schedule[i] == null)
            schedule[i] = "C";

        } else {
          boolean c = schedule[i] == null || schedule[i].equals("C");
          if (activitiesItOverlaps.size() == 1) {
            if (c) {
              schedule[i] = "C";
              schedule[activitiesItOverlaps.get(0)] = "J";
            } else {
              schedule[activitiesItOverlaps.get(0)] = "C";
            }

          } else {
            if (isImpossible(activitiesItOverlaps, activities)) {
              isImpossible = true;
              break;
            } else {
              if (c) {
                schedule[i] = "C";
                for (Integer activitiesItOverlap : activitiesItOverlaps) schedule[activitiesItOverlap] = "J";
              } else {
                for (Integer activitiesItOverlap : activitiesItOverlaps) schedule[activitiesItOverlap] = "C";
              }
            }
          }
        }
      }
      if (schedule[schedule.length - 1] == null) schedule[schedule.length - 1] = "C";

      if (isImpossible) System.out.println("Case #" + (t + 1) + ": " + "IMPOSSIBLE");
      else {
        StringBuilder sol = new StringBuilder();
        for (String s : schedule) sol.append(s);
        System.out.println("Case #" + (t + 1) + ": " + sol.toString());
      }
    }
  }

  static boolean overlaps(int[] one, int[] two) {
    return (one[0] >= two[0] && one[0] < two[1]) || (two[0] >= one[0] && two[0] < one[1]);
  }

  static boolean isImpossible(ArrayList<Integer> activitiesItOverlaps, int[][] activities) {
    for (int j = 0; j < activitiesItOverlaps.size() - 1; j++) {
      for (int k = j + 1; k < activitiesItOverlaps.size(); k++) {
        if (overlaps(activities[activitiesItOverlaps.get(j)], activities[activitiesItOverlaps.get(k)])) return true;
      }
    }
    return false;
  }
}
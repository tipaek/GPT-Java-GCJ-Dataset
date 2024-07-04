import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < testCases; i++) {
            int activitiesCount = Integer.parseInt(scanner.nextLine());
            int[][] activities = new int[activitiesCount][2];

            for (int j = 0; j < activitiesCount; j++) {
                String[] times = scanner.nextLine().split(" ");
                activities[j][0] = Integer.parseInt(times[0]);
                activities[j][1] = Integer.parseInt(times[1]);
            }

            System.out.println("Case #" + (i + 1) + ": " + assignActivities(activities));
        }
    }

    private static String assignActivities(int[][] activities) {
        int[][] sortedActivities = sortActivities(activities);
        String[] assigned = new String[sortedActivities.length];
        String[] result = new String[sortedActivities.length];

        assigned[0] = "C";

        for (int i = 1; i < sortedActivities.length; i++) {
            if (getLastEndTime("C", sortedActivities, assigned) <= sortedActivities[i][0]) {
                assigned[i] = "C";
            } else if (getLastEndTime("J", sortedActivities, assigned) <= sortedActivities[i][0]) {
                assigned[i] = "J";
            } else {
                return "IMPOSSIBLE";
            }
        }

        for (int i = 0; i < assigned.length; i++) {
            result[getOriginalIndex(sortedActivities[i], activities)] = assigned[i];
        }

        return String.join("", result);
    }

    private static int[][] sortActivities(int[][] activities) {
        int[][] sorted = Arrays.copyOf(activities, activities.length);
        Arrays.sort(sorted, Comparator.comparingInt(a -> a[0]));
        return sorted;
    }

    private static int getOriginalIndex(int[] activity, int[][] activities) {
        for (int i = 0; i < activities.length; i++) {
            if (Arrays.equals(activity, activities[i])) {
                return i;
            }
        }
        return -1;
    }

    private static int getLastEndTime(String person, int[][] activities, String[] assigned) {
        for (int i = assigned.length - 1; i >= 0; i--) {
            if (person.equals(assigned[i])) {
                return activities[i][1];
            }
        }
        return -1;
    }
}
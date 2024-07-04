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
        String[] assigned = new String[sortedActivities.length];
        String[] result = new String[sortedActivities.length];

        assigned[0] = "C";

        for (int i = 1; i < assigned.length; i++) {
            if (getLastEndTime("C", sortedActivities, assigned) <= sortedActivities[i][0]) {
                assigned[i] = "C";
            } else if (getLastEndTime("J", sortedActivities, assigned) <= sortedActivities[i][0]) {
                assigned[i] = "J";
            } else {
                return "IMPOSSIBLE";
            }
        }

        for (int i = 0; i < assigned.length; i++) {
            result[findOriginalIndex(sortedActivities[i], activities)] = assigned[i];
        }

        return String.join("", result);
    }

    private static int[][] sortActivities(int[][] activities) {
        int[][] sortedActivities = Arrays.copyOf(activities, activities.length);
        Arrays.sort(sortedActivities, (a1, a2) -> 
            a1[0] != a2[0] ? a1[0] - a2[0] : a1[1] - a2[1]
        );
        return sortedActivities;
    }

    private static int getLastEndTime(String person, int[][] activities, String[] assigned) {
        for (int i = assigned.length - 1; i >= 0; i--) {
            if (assigned[i] != null && assigned[i].equals(person)) {
                return activities[i][1];
            }
        }
        return -1;
    }

    private static int findOriginalIndex(int[] activity, int[][] activities) {
        for (int i = 0; i < activities.length; i++) {
            if (Arrays.equals(activities[i], activity)) {
                return i;
            }
        }
        return -1;
    }
}
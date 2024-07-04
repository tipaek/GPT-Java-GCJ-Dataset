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
        List<Integer> ambiguousIndices = new ArrayList<>();
        List<String> assignments = new ArrayList<>();
        String[] result = new String[sortedActivities.length];

        assignments.add("C");

        for (int i = 1; i < sortedActivities.length; i++) {
            boolean canAssignC = getLastEndTime("C", sortedActivities, assignments) <= sortedActivities[i][0];
            boolean canAssignJ = getLastEndTime("J", sortedActivities, assignments) <= sortedActivities[i][0];

            if (canAssignC && canAssignJ) {
                ambiguousIndices.add(i);
                assignments.add("C");
            } else if (canAssignC) {
                assignments.add("C");
            } else if (canAssignJ) {
                assignments.add("J");
            } else if (!ambiguousIndices.isEmpty()) {
                i = rollback(ambiguousIndices, assignments);
            } else {
                return "IMPOSSIBLE";
            }
        }

        for (int i = 0; i < result.length; i++) {
            result[findOriginalIndex(sortedActivities[i], activities)] = assignments.get(i);
        }

        return String.join("", result);
    }

    private static int rollback(List<Integer> indices, List<String> assignments) {
        int index = indices.remove(indices.size() - 1);

        while (assignments.size() > index + 1) {
            assignments.remove(assignments.size() - 1);
        }

        assignments.set(index, assignments.get(index).equals("C") ? "J" : "C");

        return index;
    }

    private static int[][] sortActivities(int[][] activities) {
        int[][] sorted = Arrays.copyOf(activities, activities.length);

        Arrays.sort(sorted, (a1, a2) -> {
            if (a1[0] != a2[0]) return Integer.compare(a1[0], a2[0]);
            return Integer.compare(a1[1], a2[1]);
        });

        return sorted;
    }

    private static int getLastEndTime(String person, int[][] activities, List<String> assignments) {
        for (int i = assignments.size() - 1; i >= 0; i--) {
            if (assignments.get(i).equals(person)) {
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
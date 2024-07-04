import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfTestCases = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfTestCases; i++) {
            int numOfActivities = Integer.parseInt(scanner.nextLine());
            int[][] activities = new int[numOfActivities][2];

            for (int j = 0; j < numOfActivities; j++) {
                String[] timeStrs = scanner.nextLine().split(" ");
                activities[j][0] = Integer.parseInt(timeStrs[0]);
                activities[j][1] = Integer.parseInt(timeStrs[1]);
            }

            System.out.println("Case #" + (i + 1) + ": " + assignActivities(activities));
        }
    }

    private static String assignActivities(int[][] activities) {
        int[][] sortedActivities = sortActivities(activities);
        List<Integer> ambiguousIndexes = new ArrayList<>();
        List<String> assignedActivities = new ArrayList<>();
        String[] result = new String[sortedActivities.length];

        assignedActivities.add("C");

        for (int i = 1; i < sortedActivities.length; i++) {
            boolean canAssignC = getLastEndTime("C", sortedActivities, assignedActivities) <= sortedActivities[i][0];
            boolean canAssignJ = getLastEndTime("J", sortedActivities, assignedActivities) <= sortedActivities[i][0];

            if (canAssignC && canAssignJ) {
                ambiguousIndexes.add(i);
                assignedActivities.add("C");
            } else if (canAssignC) {
                assignedActivities.add("C");
            } else if (canAssignJ) {
                assignedActivities.add("J");
            } else if (!ambiguousIndexes.isEmpty()) {
                i = revertAssignment(ambiguousIndexes, assignedActivities);
            } else {
                return "IMPOSSIBLE";
            }
        }

        for (int i = 0; i < result.length; i++) {
            result[findOriginalIndex(sortedActivities[i], activities)] = assignedActivities.get(i);
        }

        return String.join("", result);
    }

    private static int revertAssignment(List<Integer> indexes, List<String> assignments) {
        int index = indexes.remove(indexes.size() - 1);

        for (int i = assignments.size() - 1; i > index; i--) {
            assignments.remove(i);
        }

        assignments.set(index, assignments.get(index).equals("C") ? "J" : "C");

        return index;
    }

    private static int[][] sortActivities(int[][] activities) {
        int[][] sorted = Arrays.copyOf(activities, activities.length);

        Arrays.sort(sorted, (a1, a2) -> a1[0] != a2[0] ? Integer.compare(a1[0], a2[0]) : Integer.compare(a1[1], a2[1]));

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
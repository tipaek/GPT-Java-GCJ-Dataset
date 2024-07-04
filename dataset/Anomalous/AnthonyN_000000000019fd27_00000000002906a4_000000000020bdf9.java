import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfTestCases = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfTestCases; i++) {
            int numOfActivities = Integer.parseInt(scanner.nextLine());
            int[][] activities = new int[numOfActivities][2];

            for (int j = 0; j < numOfActivities; j++) {
                String[] times = scanner.nextLine().split(" ");
                activities[j][0] = Integer.parseInt(times[0]);
                activities[j][1] = Integer.parseInt(times[1]);
            }

            System.out.println("Case #" + (i + 1) + ": " + solve(activities));
        }
    }

    private static String solve(int[][] activities) {
        List<Activity> sortedActivities = sortActivities(activities);
        List<Integer> ambiguousIndexes = new ArrayList<>();
        String[] result = new String[sortedActivities.size()];

        sortedActivities.get(0).assignedTo = "C";

        for (int i = 1; i < sortedActivities.size(); i++) {
            int startTime = sortedActivities.get(i).startTime;
            boolean canAssignToC = getLastEndTime("C", sortedActivities) <= startTime;
            boolean canAssignToJ = getLastEndTime("J", sortedActivities) <= startTime;

            if (canAssignToC && canAssignToJ) {
                ambiguousIndexes.add(i);
                sortedActivities.get(i).assignedTo = "C";
            } else if (canAssignToC) {
                sortedActivities.get(i).assignedTo = "C";
            } else if (canAssignToJ) {
                sortedActivities.get(i).assignedTo = "J";
            } else if (!ambiguousIndexes.isEmpty()) {
                i = revertAssignments(ambiguousIndexes, sortedActivities);
            } else {
                return "IMPOSSIBLE";
            }
        }

        for (int i = 0; i < result.length; i++) {
            result[sortedActivities.get(i).originalIndex] = sortedActivities.get(i).assignedTo;
        }

        return String.join("", result);
    }

    private static int revertAssignments(List<Integer> indexes, List<Activity> activities) {
        int index = indexes.remove(indexes.size() - 1);

        for (int i = activities.size() - 1; i > index; i--) {
            activities.get(i).assignedTo = "";
        }

        String newAssignment = activities.get(index).assignedTo.equals("C") ? "J" : "C";
        activities.get(index).assignedTo = newAssignment;

        return index;
    }

    private static int getLastEndTime(String person, List<Activity> activities) {
        for (int i = activities.size() - 1; i >= 0; i--) {
            if (activities.get(i).assignedTo.equals(person)) {
                return activities.get(i).endTime;
            }
        }
        return -1;
    }

    private static List<Activity> sortActivities(int[][] activities) {
        List<Activity> sortedActivities = new ArrayList<>();

        for (int i = 0; i < activities.length; i++) {
            sortedActivities.add(new Activity(i, activities[i][0], activities[i][1]));
        }

        sortedActivities.sort(Comparator.comparingInt((Activity a) -> a.startTime)
                .thenComparingInt(a -> a.endTime));

        return sortedActivities;
    }

    private static class Activity {
        int originalIndex;
        int startTime;
        int endTime;
        String assignedTo;

        Activity(int originalIndex, int startTime, int endTime) {
            this.originalIndex = originalIndex;
            this.startTime = startTime;
            this.endTime = endTime;
            this.assignedTo = "";
        }
    }
}
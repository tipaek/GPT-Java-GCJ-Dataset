import javafx.util.Pair;
import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < testCases; i++) {
            int numOfActivities = Integer.parseInt(scanner.nextLine());
            List<Pair<Integer, Integer>> activities = readActivities(scanner, numOfActivities);
            List<Pair<Integer, Integer>> activitiesCopy = new ArrayList<>(activities);

            List<Pair<Integer, Integer>> firstPersonActivities = assignActivities(activitiesCopy);
            List<Pair<Integer, Integer>> remainingActivities = getRemainingActivities(activities, firstPersonActivities);

            if (hasOverlap(remainingActivities)) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                printSchedule(i + 1, activities, firstPersonActivities, remainingActivities);
            }
        }
    }

    private static List<Pair<Integer, Integer>> readActivities(Scanner scanner, int numOfActivities) {
        List<Pair<Integer, Integer>> activities = new ArrayList<>();
        for (int i = 0; i < numOfActivities; i++) {
            String[] times = scanner.nextLine().split(" ");
            int start = Integer.parseInt(times[0]);
            int end = Integer.parseInt(times[1]);
            activities.add(new Pair<>(start, end));
        }
        return activities;
    }

    private static List<Pair<Integer, Integer>> assignActivities(List<Pair<Integer, Integer>> activities) {
        List<Pair<Integer, Integer>> assignedActivities = new ArrayList<>();
        while (!activities.isEmpty()) {
            Pair<Integer, Integer> earliestActivity = getEarliestActivity(activities);
            activities.remove(earliestActivity);
            assignedActivities.add(earliestActivity);
            removeConflictingActivities(activities, earliestActivity);
        }
        return assignedActivities;
    }

    private static Pair<Integer, Integer> getEarliestActivity(List<Pair<Integer, Integer>> activities) {
        return activities.stream().min(Comparator.comparing(Pair::getValue)).orElseThrow();
    }

    private static void removeConflictingActivities(List<Pair<Integer, Integer>> activities, Pair<Integer, Integer> chosenActivity) {
        activities.removeIf(activity -> activity.getKey() < chosenActivity.getValue() && activity.getValue() > chosenActivity.getKey());
    }

    private static List<Pair<Integer, Integer>> getRemainingActivities(List<Pair<Integer, Integer>> activities, List<Pair<Integer, Integer>> firstPersonActivities) {
        List<Pair<Integer, Integer>> remainingActivities = new ArrayList<>(activities);
        remainingActivities.removeAll(firstPersonActivities);
        return remainingActivities;
    }

    private static boolean hasOverlap(List<Pair<Integer, Integer>> activities) {
        for (int i = 0; i < activities.size(); i++) {
            Pair<Integer, Integer> currentActivity = activities.get(i);
            for (int j = i + 1; j < activities.size(); j++) {
                Pair<Integer, Integer> otherActivity = activities.get(j);
                if (currentActivity.getKey() < otherActivity.getValue() && currentActivity.getValue() > otherActivity.getKey()) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void printSchedule(int caseNumber, List<Pair<Integer, Integer>> activities, List<Pair<Integer, Integer>> firstPersonActivities, List<Pair<Integer, Integer>> secondPersonActivities) {
        StringBuilder result = new StringBuilder("Case #" + caseNumber + ": ");
        for (Pair<Integer, Integer> activity : activities) {
            if (firstPersonActivities.contains(activity)) {
                result.append("J");
            } else {
                result.append("C");
            }
        }
        System.out.println(result.toString());
    }
}
import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        for (int i = 0; i < t; i++) {
            int numOfActivities = Integer.parseInt(in.nextLine());
            List<AbstractMap.SimpleEntry<Integer, Integer>> activities = getActivities(in, numOfActivities);
            List<AbstractMap.SimpleEntry<Integer, Integer>> activitiesCopy = new ArrayList<>(activities);
            List<AbstractMap.SimpleEntry<Integer, Integer>> firstPersonActivities = assignActivities(activitiesCopy);
            List<AbstractMap.SimpleEntry<Integer, Integer>> remainingActivities = getRemainingActivities(activities, firstPersonActivities);

            if (hasOverlap(remainingActivities)) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                printOutput(i + 1, activities, firstPersonActivities, remainingActivities);
            }
        }
    }

    private static void printOutput(int index, List<AbstractMap.SimpleEntry<Integer, Integer>> activities,
                                    List<AbstractMap.SimpleEntry<Integer, Integer>> firstPersonActivities,
                                    List<AbstractMap.SimpleEntry<Integer, Integer>> secondPersonActivities) {
        System.out.print("Case #" + index + ": ");
        StringBuilder result = new StringBuilder();
        for (AbstractMap.SimpleEntry<Integer, Integer> activity : activities) {
            if (firstPersonActivities.contains(activity)) {
                result.append("C");
            } else {
                result.append("J");
            }
        }
        System.out.println(result);
    }

    private static boolean hasOverlap(List<AbstractMap.SimpleEntry<Integer, Integer>> activities) {
        for (int i = 0; i < activities.size(); i++) {
            AbstractMap.SimpleEntry<Integer, Integer> activity1 = activities.get(i);
            for (int j = i + 1; j < activities.size(); j++) {
                AbstractMap.SimpleEntry<Integer, Integer> activity2 = activities.get(j);
                if (activity1.getKey() < activity2.getValue() && activity1.getValue() > activity2.getKey()) {
                    return true;
                }
            }
        }
        return false;
    }

    private static List<AbstractMap.SimpleEntry<Integer, Integer>> getRemainingActivities(
            List<AbstractMap.SimpleEntry<Integer, Integer>> activities,
            List<AbstractMap.SimpleEntry<Integer, Integer>> assignedActivities) {
        List<AbstractMap.SimpleEntry<Integer, Integer>> remainingActivities = new ArrayList<>();
        for (AbstractMap.SimpleEntry<Integer, Integer> activity : activities) {
            if (!assignedActivities.contains(activity)) {
                remainingActivities.add(activity);
            }
        }
        return remainingActivities;
    }

    private static List<AbstractMap.SimpleEntry<Integer, Integer>> assignActivities(
            List<AbstractMap.SimpleEntry<Integer, Integer>> activities) {
        List<AbstractMap.SimpleEntry<Integer, Integer>> assignedActivities = new ArrayList<>();
        while (!activities.isEmpty()) {
            AbstractMap.SimpleEntry<Integer, Integer> earliestActivity = getEarliestActivity(activities);
            activities.remove(earliestActivity);
            assignedActivities.add(earliestActivity);
            removeOverlappingActivities(activities, earliestActivity);
        }
        return assignedActivities;
    }

    private static void removeOverlappingActivities(
            List<AbstractMap.SimpleEntry<Integer, Integer>> activities,
            AbstractMap.SimpleEntry<Integer, Integer> chosenActivity) {
        activities.removeIf(activity -> activity.getKey() < chosenActivity.getValue() && activity.getValue() > chosenActivity.getKey());
    }

    private static AbstractMap.SimpleEntry<Integer, Integer> getEarliestActivity(
            List<AbstractMap.SimpleEntry<Integer, Integer>> activities) {
        return activities.stream().min(Comparator.comparingInt(AbstractMap.SimpleEntry::getValue)).orElseThrow();
    }

    private static List<AbstractMap.SimpleEntry<Integer, Integer>> getActivities(Scanner in, int numOfActivities) {
        List<AbstractMap.SimpleEntry<Integer, Integer>> activities = new ArrayList<>();
        for (int i = 0; i < numOfActivities; i++) {
            String[] line = in.nextLine().split(" ");
            activities.add(new AbstractMap.SimpleEntry<>(Integer.parseInt(line[0]), Integer.parseInt(line[1])));
        }
        return activities;
    }
}
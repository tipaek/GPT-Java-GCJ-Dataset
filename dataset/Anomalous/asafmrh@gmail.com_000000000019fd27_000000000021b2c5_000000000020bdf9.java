import java.util.*;
import java.io.*;

class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        for (int i = 0; i < t; i++) {
            int numOfActivities = Integer.parseInt(in.nextLine());
            List<AbstractMap.SimpleEntry<Integer, Integer>> activities = parseActivities(in, numOfActivities);
            List<AbstractMap.SimpleEntry<Integer, Integer>> activitiesCopy = new ArrayList<>(activities);
            List<AbstractMap.SimpleEntry<Integer, Integer>> firstPersonActivities = assignActivities(activitiesCopy);
            List<AbstractMap.SimpleEntry<Integer, Integer>> remainingActivities = filterActivities(activities, firstPersonActivities);
            if (hasOverlap(remainingActivities)) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                printResult(i + 1, activities, firstPersonActivities, remainingActivities);
            }
        }
    }

    private static void printResult(int caseNumber, List<AbstractMap.SimpleEntry<Integer, Integer>> activities, List<AbstractMap.SimpleEntry<Integer, Integer>> firstPersonActivities, List<AbstractMap.SimpleEntry<Integer, Integer>> secondPersonActivities) {
        StringBuilder result = new StringBuilder("Case #" + caseNumber + ": ");
        for (AbstractMap.SimpleEntry<Integer, Integer> activity : activities) {
            if (firstPersonActivities.contains(activity)) {
                result.append("J");
            } else {
                result.append("C");
            }
        }
        System.out.println(result);
    }

    private static boolean hasOverlap(List<AbstractMap.SimpleEntry<Integer, Integer>> activities) {
        for (int i = 0; i < activities.size(); i++) {
            AbstractMap.SimpleEntry<Integer, Integer> current = activities.get(i);
            for (int j = i + 1; j < activities.size(); j++) {
                AbstractMap.SimpleEntry<Integer, Integer> next = activities.get(j);
                if (current.getKey() < next.getValue() && current.getValue() > next.getKey()) {
                    return true;
                }
            }
        }
        return false;
    }

    private static List<AbstractMap.SimpleEntry<Integer, Integer>> filterActivities(List<AbstractMap.SimpleEntry<Integer, Integer>> activities, List<AbstractMap.SimpleEntry<Integer, Integer>> firstPersonActivities) {
        List<AbstractMap.SimpleEntry<Integer, Integer>> remainingActivities = new ArrayList<>();
        for (AbstractMap.SimpleEntry<Integer, Integer> activity : activities) {
            if (!firstPersonActivities.contains(activity)) {
                remainingActivities.add(activity);
            }
        }
        return remainingActivities;
    }

    private static List<AbstractMap.SimpleEntry<Integer, Integer>> assignActivities(List<AbstractMap.SimpleEntry<Integer, Integer>> activities) {
        List<AbstractMap.SimpleEntry<Integer, Integer>> assignedActivities = new ArrayList<>();
        while (!activities.isEmpty()) {
            AbstractMap.SimpleEntry<Integer, Integer> earliestActivity = getEarliestActivity(activities);
            activities.remove(earliestActivity);
            assignedActivities.add(earliestActivity);
            removeOverlappingActivities(activities, earliestActivity);
        }
        return assignedActivities;
    }

    private static void removeOverlappingActivities(List<AbstractMap.SimpleEntry<Integer, Integer>> activities, AbstractMap.SimpleEntry<Integer, Integer> chosenActivity) {
        activities.removeIf(activity -> activity.getKey() < chosenActivity.getValue() && activity.getValue() > chosenActivity.getKey());
    }

    private static AbstractMap.SimpleEntry<Integer, Integer> getEarliestActivity(List<AbstractMap.SimpleEntry<Integer, Integer>> activities) {
        AbstractMap.SimpleEntry<Integer, Integer> earliest = activities.get(0);
        for (AbstractMap.SimpleEntry<Integer, Integer> activity : activities) {
            if (activity.getValue() < earliest.getValue()) {
                earliest = activity;
            }
        }
        return earliest;
    }

    private static List<AbstractMap.SimpleEntry<Integer, Integer>> parseActivities(Scanner in, int numOfActivities) {
        List<AbstractMap.SimpleEntry<Integer, Integer>> activities = new ArrayList<>();
        for (int i = 0; i < numOfActivities; i++) {
            String[] times = in.nextLine().split(" ");
            activities.add(new AbstractMap.SimpleEntry<>(Integer.parseInt(times[0]), Integer.parseInt(times[1])));
        }
        return activities;
    }
}
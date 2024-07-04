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
            List<AbstractMap.SimpleEntry<Integer, Integer>> first = assignActivitiesToPerson(activitiesCopy);
            List<AbstractMap.SimpleEntry<Integer, Integer>> remainingActivities = getRemainingActivities(activities, new ArrayList<>(first));
            if (hasOverlap(remainingActivities)) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                printFormattedOutput(i + 1, activities, first, remainingActivities);
            }
        }
    }

    public static void printFormattedOutput(int index, List<AbstractMap.SimpleEntry<Integer, Integer>> activities, List<AbstractMap.SimpleEntry<Integer, Integer>> first, List<AbstractMap.SimpleEntry<Integer, Integer>> second) {
        StringBuilder result = new StringBuilder();
        for (AbstractMap.SimpleEntry<Integer, Integer> activity : activities) {
            if (first.contains(activity)) {
                result.append("C");
                first.remove(activity);
            } else {
                result.append("J");
            }
        }
        System.out.println("Case #" + index + ": " + result);
    }

    public static boolean hasOverlap(List<AbstractMap.SimpleEntry<Integer, Integer>> activities) {
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

    public static List<AbstractMap.SimpleEntry<Integer, Integer>> getRemainingActivities(List<AbstractMap.SimpleEntry<Integer, Integer>> activities, List<AbstractMap.SimpleEntry<Integer, Integer>> first) {
        List<AbstractMap.SimpleEntry<Integer, Integer>> remaining = new ArrayList<>();
        for (AbstractMap.SimpleEntry<Integer, Integer> activity : activities) {
            if (!first.contains(activity)) {
                remaining.add(activity);
            } else {
                first.remove(activity);
            }
        }
        return remaining;
    }

    public static List<AbstractMap.SimpleEntry<Integer, Integer>> assignActivitiesToPerson(List<AbstractMap.SimpleEntry<Integer, Integer>> activities) {
        List<AbstractMap.SimpleEntry<Integer, Integer>> assigned = new ArrayList<>();
        while (!activities.isEmpty()) {
            AbstractMap.SimpleEntry<Integer, Integer> earliest = getEarliestActivity(activities);
            activities.remove(earliest);
            assigned.add(earliest);
            removeConflictingActivities(activities, earliest);
        }
        return assigned;
    }

    public static void removeConflictingActivities(List<AbstractMap.SimpleEntry<Integer, Integer>> activities, AbstractMap.SimpleEntry<Integer, Integer> chosen) {
        activities.removeIf(activity -> activity.getKey() < chosen.getValue() && activity.getValue() > chosen.getKey());
    }

    public static AbstractMap.SimpleEntry<Integer, Integer> getEarliestActivity(List<AbstractMap.SimpleEntry<Integer, Integer>> activities) {
        return activities.stream().min(Comparator.comparingInt(AbstractMap.SimpleEntry::getValue)).orElse(activities.get(0));
    }

    public static List<AbstractMap.SimpleEntry<Integer, Integer>> getActivities(Scanner in, int numOfActivities) {
        List<AbstractMap.SimpleEntry<Integer, Integer>> activities = new ArrayList<>();
        for (int i = 0; i < numOfActivities; i++) {
            String[] line = in.nextLine().split(" ");
            activities.add(new AbstractMap.SimpleEntry<>(Integer.parseInt(line[0]), Integer.parseInt(line[1])));
        }
        return activities;
    }
}
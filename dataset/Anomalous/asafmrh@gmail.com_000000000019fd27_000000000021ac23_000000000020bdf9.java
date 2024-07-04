import java.util.*;
import java.io.*;

class Solution {

    public static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int t = 1; t <= testCases; t++) {
            int numOfActivities = Integer.parseInt(scanner.nextLine());
            List<Pair<Integer, Integer>> activities = getActivities(scanner, numOfActivities);
            List<Pair<Integer, Integer>> firstPersonActivities = getPersonActivities(new ArrayList<>(activities));
            List<Pair<Integer, Integer>> remainingActivities = getRemainingActivities(activities, firstPersonActivities);

            if (hasOverlap(remainingActivities)) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                printOutput(t, activities, firstPersonActivities, remainingActivities);
            }
        }
    }

    private static void printOutput(int index, List<Pair<Integer, Integer>> activities, List<Pair<Integer, Integer>> firstPerson, List<Pair<Integer, Integer>> secondPerson) {
        StringBuilder result = new StringBuilder("Case #" + index + ": ");
        for (Pair<Integer, Integer> activity : activities) {
            if (firstPerson.contains(activity)) {
                result.append("J");
            } else {
                result.append("C");
            }
        }
        System.out.println(result.toString());
    }

    private static boolean hasOverlap(List<Pair<Integer, Integer>> activities) {
        for (int i = 0; i < activities.size(); i++) {
            Pair<Integer, Integer> activity1 = activities.get(i);
            for (int j = i + 1; j < activities.size(); j++) {
                Pair<Integer, Integer> activity2 = activities.get(j);
                if (activity1.getKey() < activity2.getValue() && activity1.getValue() > activity2.getKey()) {
                    return true;
                }
            }
        }
        return false;
    }

    private static List<Pair<Integer, Integer>> getRemainingActivities(List<Pair<Integer, Integer>> activities, List<Pair<Integer, Integer>> firstPersonActivities) {
        List<Pair<Integer, Integer>> remainingActivities = new ArrayList<>();
        for (Pair<Integer, Integer> activity : activities) {
            if (!firstPersonActivities.contains(activity)) {
                remainingActivities.add(activity);
            }
        }
        return remainingActivities;
    }

    private static List<Pair<Integer, Integer>> getPersonActivities(List<Pair<Integer, Integer>> activities) {
        List<Pair<Integer, Integer>> personActivities = new ArrayList<>();
        while (!activities.isEmpty()) {
            Pair<Integer, Integer> earliestActivity = getEarliestActivity(activities);
            activities.remove(earliestActivity);
            personActivities.add(earliestActivity);
            removeOverlappingActivities(activities, earliestActivity);
        }
        return personActivities;
    }

    private static void removeOverlappingActivities(List<Pair<Integer, Integer>> activities, Pair<Integer, Integer> selectedActivity) {
        activities.removeIf(activity -> activity.getKey() < selectedActivity.getValue() && activity.getValue() > selectedActivity.getKey());
    }

    private static Pair<Integer, Integer> getEarliestActivity(List<Pair<Integer, Integer>> activities) {
        return activities.stream().min(Comparator.comparingInt(Pair::getValue)).orElseThrow(NoSuchElementException::new);
    }

    private static List<Pair<Integer, Integer>> getActivities(Scanner scanner, int numOfActivities) {
        List<Pair<Integer, Integer>> activities = new ArrayList<>();
        for (int i = 0; i < numOfActivities; i++) {
            String[] timeRange = scanner.nextLine().split(" ");
            int start = Integer.parseInt(timeRange[0]);
            int end = Integer.parseInt(timeRange[1]);
            activities.add(new Pair<>(start, end));
        }
        return activities;
    }
}
import java.util.*;
import java.io.*;

class Solution {

    public static class Pair<K, V> {
        private final K key;
        private final V value;

        private Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public static <K, V> Pair<K, V> of(K key, V value) {
            return new Pair<>(key, value);
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

        for (int i = 0; i < testCases; i++) {
            int numOfActivities = Integer.parseInt(scanner.nextLine());
            List<Pair<Integer, Integer>> activities = readActivities(scanner, numOfActivities);
            List<Pair<Integer, Integer>> activitiesCopy = new ArrayList<>(activities);

            List<Pair<Integer, Integer>> firstPersonActivities = allocateActivities(activitiesCopy);
            List<Pair<Integer, Integer>> remainingActivities = getRemainingActivities(activities, firstPersonActivities);

            if (hasOverlap(remainingActivities)) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                printOutput(i + 1, activities, firstPersonActivities, remainingActivities);
            }
        }
    }

    private static List<Pair<Integer, Integer>> readActivities(Scanner scanner, int numOfActivities) {
        List<Pair<Integer, Integer>> activities = new ArrayList<>();
        for (int i = 0; i < numOfActivities; i++) {
            String[] times = scanner.nextLine().split(" ");
            activities.add(Pair.of(Integer.parseInt(times[0]), Integer.parseInt(times[1])));
        }
        return activities;
    }

    private static List<Pair<Integer, Integer>> allocateActivities(List<Pair<Integer, Integer>> activities) {
        List<Pair<Integer, Integer>> personActivities = new ArrayList<>();
        while (!activities.isEmpty()) {
            Pair<Integer, Integer> earliest = getEarliestActivity(activities);
            activities.remove(earliest);
            personActivities.add(earliest);
            removeOverlappingActivities(activities, earliest);
        }
        return personActivities;
    }

    private static Pair<Integer, Integer> getEarliestActivity(List<Pair<Integer, Integer>> activities) {
        Pair<Integer, Integer> earliest = activities.get(0);
        for (Pair<Integer, Integer> activity : activities) {
            if (activity.getValue() < earliest.getValue()) {
                earliest = activity;
            }
        }
        return earliest;
    }

    private static void removeOverlappingActivities(List<Pair<Integer, Integer>> activities, Pair<Integer, Integer> chosen) {
        activities.removeIf(activity -> activity.getKey() < chosen.getValue() && activity.getValue() > chosen.getKey());
    }

    private static List<Pair<Integer, Integer>> getRemainingActivities(List<Pair<Integer, Integer>> activities, List<Pair<Integer, Integer>> firstPersonActivities) {
        List<Pair<Integer, Integer>> remainingActivities = new ArrayList<>(activities);
        remainingActivities.removeAll(firstPersonActivities);
        return remainingActivities;
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

    private static void printOutput(int caseNumber, List<Pair<Integer, Integer>> activities, List<Pair<Integer, Integer>> firstPersonActivities, List<Pair<Integer, Integer>> secondPersonActivities) {
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
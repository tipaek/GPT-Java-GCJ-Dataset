import java.util.*;
import java.io.*;

class Pair<K, V> {

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

public class Solution {

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
                printResult(i + 1, activities, firstPersonActivities, remainingActivities);
            }
        }
    }

    private static List<Pair<Integer, Integer>> readActivities(Scanner scanner, int numOfActivities) {
        List<Pair<Integer, Integer>> activities = new ArrayList<>();
        for (int i = 0; i < numOfActivities; i++) {
            String[] input = scanner.nextLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            activities.add(Pair.of(start, end));
        }
        return activities;
    }

    private static List<Pair<Integer, Integer>> assignActivities(List<Pair<Integer, Integer>> activities) {
        List<Pair<Integer, Integer>> assignedActivities = new ArrayList<>();
        while (!activities.isEmpty()) {
            Pair<Integer, Integer> earliest = findEarliestActivity(activities);
            activities.remove(earliest);
            assignedActivities.add(earliest);
            removeConflictingActivities(activities, earliest);
        }
        return assignedActivities;
    }

    private static Pair<Integer, Integer> findEarliestActivity(List<Pair<Integer, Integer>> activities) {
        return activities.stream()
                .min(Comparator.comparing(Pair::getValue))
                .orElseThrow(NoSuchElementException::new);
    }

    private static void removeConflictingActivities(List<Pair<Integer, Integer>> activities, Pair<Integer, Integer> reference) {
        activities.removeIf(activity -> activity.getKey() < reference.getValue() && activity.getValue() > reference.getKey());
    }

    private static List<Pair<Integer, Integer>> getRemainingActivities(List<Pair<Integer, Integer>> activities, List<Pair<Integer, Integer>> assignedActivities) {
        List<Pair<Integer, Integer>> remainingActivities = new ArrayList<>(activities);
        remainingActivities.removeAll(assignedActivities);
        return remainingActivities;
    }

    private static boolean hasOverlap(List<Pair<Integer, Integer>> activities) {
        for (int i = 0; i < activities.size(); i++) {
            Pair<Integer, Integer> current = activities.get(i);
            for (int j = i + 1; j < activities.size(); j++) {
                Pair<Integer, Integer> next = activities.get(j);
                if (current.getKey() < next.getValue() && current.getValue() > next.getKey()) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void printResult(int caseNumber, List<Pair<Integer, Integer>> activities, List<Pair<Integer, Integer>> firstPersonActivities, List<Pair<Integer, Integer>> secondPersonActivities) {
        StringBuilder result = new StringBuilder("Case #" + caseNumber + ": ");
        for (Pair<Integer, Integer> activity : activities) {
            if (firstPersonActivities.contains(activity)) {
                result.append("J");
            } else {
                result.append("C");
            }
        }
        System.out.println(result);
    }
}
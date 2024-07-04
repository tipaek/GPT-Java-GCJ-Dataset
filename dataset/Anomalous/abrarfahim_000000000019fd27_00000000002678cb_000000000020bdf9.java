import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int activityCount = scanner.nextInt();
            ArrayList<Pair<Integer, Integer>> activities = new ArrayList<>();

            for (int j = 0; j < activityCount; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new Pair<>(start, end));
            }

            StringBuilder schedule = new StringBuilder();
            ArrayList<Pair<Integer, Integer>> jActivities = new ArrayList<>();
            ArrayList<Pair<Integer, Integer>> cActivities = new ArrayList<>();

            jActivities.add(activities.remove(0));
            schedule.append("J");

            boolean isImpossible = false;

            for (Pair<Integer, Integer> activity : activities) {
                boolean jOverlap = hasOverlap(jActivities, activity);
                boolean cOverlap = hasOverlap(cActivities, activity);

                if (!jOverlap) {
                    jActivities.add(activity);
                    schedule.append("J");
                } else if (!cOverlap) {
                    cActivities.add(activity);
                    schedule.append("C");
                } else {
                    isImpossible = true;
                    break;
                }
            }

            String result = isImpossible ? "IMPOSSIBLE" : schedule.toString();
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    private static boolean hasOverlap(ArrayList<Pair<Integer, Integer>> activities, Pair<Integer, Integer> newActivity) {
        for (Pair<Integer, Integer> activity : activities) {
            if ((activity.getKey() < newActivity.getValue() && activity.getValue() > newActivity.getKey()) ||
                (activity.getKey() <= newActivity.getKey() && activity.getValue() >= newActivity.getValue())) {
                return true;
            }
        }
        return false;
    }
}

class Pair<U, V> {
    private final U key;
    private final V value;

    public Pair(U key, V value) {
        this.key = key;
        this.value = value;
    }

    public U getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
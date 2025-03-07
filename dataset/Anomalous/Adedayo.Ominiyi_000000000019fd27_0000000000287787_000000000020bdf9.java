import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.HashSet;

public class Solution {

    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int numberOfTestCases = Integer.parseInt(scanner.nextLine());

            for (int testCase = 0; testCase < numberOfTestCases; testCase++) {
                int activityCount = Integer.parseInt(scanner.nextLine());
                Set<ActivityDuration> activitiesSet = new LinkedHashSet<>();

                for (int activity = 0; activity < activityCount; activity++) {
                    String[] lineParts = scanner.nextLine().split(" ");
                    activitiesSet.add(new ActivityDuration(Integer.parseInt(lineParts[0]), Integer.parseInt(lineParts[1])));
                }

                ActivityDuration[] sortedActivities = activitiesSet.toArray(new ActivityDuration[0]);
                char[] parentAssigned = new char[sortedActivities.length];
                parentAssigned[0] = 'J';

                if (assignParents(sortedActivities, parentAssigned)) {
                    System.out.println(String.format("Case #%d: %s", testCase + 1, new String(parentAssigned)));
                } else {
                    System.out.println(String.format("Case #%d: IMPOSSIBLE", testCase + 1));
                }
            }
        }
    }

    private static boolean assignParents(ActivityDuration[] sortedActivities, char[] parentAssigned) {
        for (int i = 1; i < sortedActivities.length; i++) {
            Set<Character> overlappingParents = new HashSet<>();

            for (int j = 0; j < i; j++) {
                if (!doesNotOverlap(sortedActivities[j], sortedActivities[i])) {
                    overlappingParents.add(parentAssigned[j]);
                }
            }

            if (overlappingParents.size() >= 2) {
                return false;
            }

            if (overlappingParents.isEmpty()) {
                parentAssigned[i] = 'J';
            } else if (overlappingParents.contains('J')) {
                parentAssigned[i] = 'C';
            } else {
                parentAssigned[i] = 'J';
            }
        }
        return true;
    }

    private static boolean doesNotOverlap(ActivityDuration a, ActivityDuration b) {
        return a.endTime <= b.startTime || b.endTime <= a.startTime;
    }

    static class ActivityDuration implements Comparable<ActivityDuration> {
        int startTime;
        int endTime;

        ActivityDuration(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(ActivityDuration other) {
            int startCompare = Integer.compare(this.startTime, other.startTime);
            return startCompare != 0 ? startCompare : Integer.compare(this.endTime, other.endTime);
        }

        @Override
        public String toString() {
            return String.format("Start time: %d; End time: %d", startTime, endTime);
        }
    }
}
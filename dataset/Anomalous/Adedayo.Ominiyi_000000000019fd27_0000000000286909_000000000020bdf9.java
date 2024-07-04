import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;

public class Solution {

    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int numberOfTestCases = Integer.parseInt(scanner.nextLine());

            for (int testCase = 0; testCase < numberOfTestCases; testCase++) {
                int activityCount = Integer.parseInt(scanner.nextLine());
                TreeSet<ActivityDuration> activitiesSet = new TreeSet<>();

                for (int activity = 0; activity < activityCount; activity++) {
                    String[] lineParts = scanner.nextLine().split(" ");
                    activitiesSet.add(new ActivityDuration(Integer.parseInt(lineParts[0]), Integer.parseInt(lineParts[1])));
                }

                ActivityDuration[] sortedActivities = activitiesSet.toArray(new ActivityDuration[0]);
                char[] parentAssigned = new char[sortedActivities.length];
                parentAssigned[0] = 'J';

                boolean isPossible = true;
                for (int i = 1; i < sortedActivities.length && isPossible; i++) {
                    Set<Character> overlappingParent = new HashSet<>();

                    for (int j = 0; j < i; j++) {
                        if (!doesNotOverlap(sortedActivities[j], sortedActivities[i])) {
                            overlappingParent.add(parentAssigned[j]);
                        }
                    }

                    if (overlappingParent.size() >= 2) {
                        System.out.println(String.format("Case #%d: IMPOSSIBLE", testCase + 1));
                        isPossible = false;
                    } else {
                        parentAssigned[i] = overlappingParent.isEmpty() ? 'J' : (overlappingParent.contains('J') ? 'C' : 'J');
                    }
                }

                if (isPossible) {
                    System.out.println(String.format("Case #%d: %s", testCase + 1, new String(parentAssigned)));
                }
            }
        }
    }

    private static boolean doesNotOverlap(ActivityDuration previousActivity, ActivityDuration currentActivity) {
        return previousActivity.startTime >= currentActivity.endTime || currentActivity.startTime >= previousActivity.endTime;
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
            int compareStartTime = Integer.compare(this.startTime, other.startTime);
            return compareStartTime == 0 ? Integer.compare(this.endTime, other.endTime) : compareStartTime;
        }

        @Override
        public String toString() {
            return String.format("Start time: %d; End Time: %d", startTime, endTime);
        }
    }
}
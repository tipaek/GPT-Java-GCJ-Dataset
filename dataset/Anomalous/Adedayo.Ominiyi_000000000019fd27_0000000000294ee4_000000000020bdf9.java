import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;

public class Solution {

    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int numberOfTestCases = Integer.parseInt(scanner.nextLine());

            for (int testCase = 0; testCase < numberOfTestCases; testCase++) {
                TreeSet<ActivityDuration> activitiesSet = new TreeSet<>();
                int activityCount = Integer.parseInt(scanner.nextLine());

                for (int activityIndex = 0; activityIndex < activityCount; activityIndex++) {
                    String[] lineParts = scanner.nextLine().split(" ");
                    activitiesSet.add(new ActivityDuration(
                            Integer.parseInt(lineParts[0]),
                            Integer.parseInt(lineParts[1]),
                            activityIndex));
                }

                ActivityDuration[] sortedActivities = activitiesSet.toArray(new ActivityDuration[0]);
                char[] finalParentAssigned = new char[sortedActivities.length];
                Schedule[] parentAssigned = new Schedule[sortedActivities.length];

                char defaultParent = 'J';
                parentAssigned[0] = new Schedule(defaultParent, sortedActivities[0].originalActivityIndex);
                finalParentAssigned[sortedActivities[0].originalActivityIndex] = defaultParent;

                boolean isPossible = true;
                for (int i = 1; i < sortedActivities.length && isPossible; i++) {
                    Set<Character> overlappingParent = new HashSet<>();
                    ActivityDuration currentActivity = sortedActivities[i];

                    for (int j = 0; j < i; j++) {
                        if (!doesNotOverlap(sortedActivities[j], currentActivity)) {
                            overlappingParent.add(parentAssigned[j].parentChar);
                        }
                    }

                    if (overlappingParent.isEmpty()) {
                        parentAssigned[i] = new Schedule(defaultParent, currentActivity.originalActivityIndex);
                        finalParentAssigned[currentActivity.originalActivityIndex] = defaultParent;
                    } else if (overlappingParent.size() == 1) {
                        char assignedParent = overlappingParent.contains('C') ? 'J' : 'C';
                        parentAssigned[i] = new Schedule(assignedParent, currentActivity.originalActivityIndex);
                        finalParentAssigned[currentActivity.originalActivityIndex] = assignedParent;
                    } else {
                        System.out.println(String.format("Case #%d: IMPOSSIBLE", testCase + 1));
                        isPossible = false;
                    }
                }

                if (isPossible) {
                    System.out.println(String.format("Case #%d: %s", testCase + 1, new String(finalParentAssigned)));
                }
            }
        }
    }

    private static boolean doesNotOverlap(ActivityDuration previousActivity, ActivityDuration currentActivity) {
        return currentActivity.endTime <= previousActivity.startTime || currentActivity.startTime >= previousActivity.endTime;
    }

    static final class Schedule {
        final char parentChar;
        final int originalActivityIndex;

        Schedule(char parentChar, int originalActivityIndex) {
            this.parentChar = parentChar;
            this.originalActivityIndex = originalActivityIndex;
        }
    }

    static final class ActivityDuration implements Comparable<ActivityDuration> {
        final int startTime;
        final int endTime;
        final int originalActivityIndex;

        ActivityDuration(int startTime, int endTime, int originalActivityIndex) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.originalActivityIndex = originalActivityIndex;
        }

        @Override
        public int compareTo(ActivityDuration other) {
            int startComparison = Integer.compare(this.startTime, other.startTime);
            if (startComparison != 0) {
                return startComparison;
            }
            int endComparison = Integer.compare(this.endTime, other.endTime);
            if (endComparison != 0) {
                return endComparison;
            }
            return Integer.compare(this.originalActivityIndex, other.originalActivityIndex);
        }
    }
}
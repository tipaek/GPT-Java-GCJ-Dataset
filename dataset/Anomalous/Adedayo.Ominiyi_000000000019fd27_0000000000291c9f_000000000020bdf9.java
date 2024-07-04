import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
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
                Schedule[] parentAssigned = new Schedule[sortedActivities.length];
                parentAssigned[0] = new Schedule('C', sortedActivities[0].originalActivityIndex);

                boolean isImpossible = false;
                for (int i = 1; i < sortedActivities.length; i++) {
                    Set<Character> overlappingParent = new HashSet<>();
                    ActivityDuration currentActivity = sortedActivities[i];

                    for (int j = 0; j < i; j++) {
                        ActivityDuration previousActivity = sortedActivities[j];
                        if (!doesNotOverlap(previousActivity, currentActivity)) {
                            overlappingParent.add(parentAssigned[j].parentChar);
                        }
                    }

                    if (overlappingParent.isEmpty()) {
                        parentAssigned[i] = new Schedule('C', currentActivity.originalActivityIndex);
                    } else if (overlappingParent.size() == 1) {
                        char assignedParent = overlappingParent.contains('C') ? 'J' : 'C';
                        parentAssigned[i] = new Schedule(assignedParent, currentActivity.originalActivityIndex);
                    } else {
                        System.out.println(String.format("Case #%d: IMPOSSIBLE", testCase + 1));
                        isImpossible = true;
                        break;
                    }
                }

                if (!isImpossible) {
                    Arrays.sort(parentAssigned, (o1, o2) -> Integer.compare(o1.originalActivityIndex, o2.originalActivityIndex));
                    StringBuilder result = new StringBuilder();
                    for (Schedule schedule : parentAssigned) {
                        result.append(schedule.parentChar);
                    }
                    System.out.println(String.format("Case #%d: %s", testCase + 1, result.toString()));
                }
            }
        }
    }

    private static boolean doesNotOverlap(ActivityDuration previousActivity, ActivityDuration currentActivity) {
        return previousActivity.startTime >= currentActivity.endTime || currentActivity.startTime >= previousActivity.endTime;
    }

    static final class Schedule {
        final char parentChar;
        final int originalActivityIndex;

        Schedule(char parentChar, int originalActivityIndex) {
            this.parentChar = parentChar;
            this.originalActivityIndex = originalActivityIndex;
        }

        @Override
        public String toString() {
            return String.format("parentChar: %s; Original Activity Index: %d", parentChar, originalActivityIndex);
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
            int compareStartTime = Integer.compare(this.startTime, other.startTime);
            return compareStartTime != 0 ? compareStartTime : Integer.compare(this.endTime, other.endTime);
        }

        @Override
        public String toString() {
            return String.format("Start time: %d; End Time: %d; Original Activity Index: %d",
                    startTime, endTime, originalActivityIndex);
        }
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Solution {

    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int numberOfTestCases = Integer.parseInt(scanner.nextLine());

            for (int testCase = 0; testCase < numberOfTestCases; testCase++) {
                int activityCount = Integer.parseInt(scanner.nextLine());
                TreeSet<ActivityDuration> activitiesSet = new TreeSet<>();

                for (int activity = 0; activity < activityCount; activity++) {
                    String[] lineParts = scanner.nextLine().split(" ");
                    activitiesSet.add(new ActivityDuration(
                            Integer.parseInt(lineParts[0]),
                            Integer.parseInt(lineParts[1]),
                            activity));
                }

                ActivityDuration[] sortedActivities = activitiesSet.toArray(new ActivityDuration[0]);
                Schedule[] parentAssigned = new Schedule[sortedActivities.length];
                parentAssigned[0] = new Schedule('C', sortedActivities[0].originalActivityIndex);

                if (!assignParents(sortedActivities, parentAssigned)) {
                    System.out.println(String.format("Case #%d: IMPOSSIBLE", testCase + 1));
                } else {
                    Arrays.sort(parentAssigned, Comparator.comparingInt(o -> o.originalActivityIndex));
                    StringBuilder builder = new StringBuilder();
                    for (Schedule schedule : parentAssigned) {
                        builder.append(schedule.parentChar);
                    }
                    System.out.println(String.format("Case #%d: %s", testCase + 1, builder.toString()));
                }
            }
        }
    }

    private static boolean assignParents(ActivityDuration[] sortedActivities, Schedule[] parentAssigned) {
        for (int i = 1; i < sortedActivities.length; i++) {
            Set<Character> overlappingParent = new HashSet<>();
            ActivityDuration currentActivity = sortedActivities[i];

            for (int j = 0; j < i; j++) {
                if (!doesNotOverlap(sortedActivities[j], currentActivity)) {
                    overlappingParent.add(parentAssigned[j].parentChar);
                }
            }

            if (overlappingParent.size() >= 2) {
                return false;
            }

            if (overlappingParent.isEmpty()) {
                parentAssigned[i] = new Schedule('C', currentActivity.originalActivityIndex);
            } else {
                parentAssigned[i] = overlappingParent.contains('C')
                        ? new Schedule('J', currentActivity.originalActivityIndex)
                        : new Schedule('C', currentActivity.originalActivityIndex);
            }
        }
        return true;
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
            return String.format("Start time: %d; End Time: %d; Original Activity Index: %d", startTime, endTime, originalActivityIndex);
        }
    }
}
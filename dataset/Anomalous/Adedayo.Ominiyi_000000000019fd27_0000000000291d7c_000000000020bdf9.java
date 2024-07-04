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
                int activityCount = Integer.parseInt(scanner.nextLine());
                TreeSet<ActivityDuration> activitiesSet = new TreeSet<>();

                for (int activityIndex = 0; activityIndex < activityCount; activityIndex++) {
                    String[] lineParts = scanner.nextLine().split(" ");
                    activitiesSet.add(new ActivityDuration(
                            Integer.parseInt(lineParts[0]),
                            Integer.parseInt(lineParts[1]),
                            activityIndex));
                }

                if (!assignSchedules(testCase, activitiesSet)) {
                    System.out.println(String.format("Case #%d: IMPOSSIBLE", testCase + 1));
                }
            }
        }
    }

    private static boolean assignSchedules(int testCase, TreeSet<ActivityDuration> activitiesSet) {
        ActivityDuration[] sortedActivities = activitiesSet.toArray(new ActivityDuration[0]);
        Schedule[] parentAssigned = new Schedule[sortedActivities.length];
        parentAssigned[0] = new Schedule('C', sortedActivities[0].originalActivityIndex);

        for (int i = 1; i < sortedActivities.length; i++) {
            Set<Character> overlappingParents = new HashSet<>();
            for (int j = 0; j < i; j++) {
                if (!doesNotOverlap(sortedActivities[j], sortedActivities[i])) {
                    overlappingParents.add(parentAssigned[j].parentChar);
                }
            }

            if (overlappingParents.isEmpty()) {
                parentAssigned[i] = new Schedule('C', sortedActivities[i].originalActivityIndex);
            } else if (overlappingParents.size() == 1) {
                parentAssigned[i] = new Schedule(overlappingParents.contains('C') ? 'J' : 'C', sortedActivities[i].originalActivityIndex);
            } else {
                return false;
            }
        }

        Arrays.sort(parentAssigned, (o1, o2) -> Integer.compare(o1.originalActivityIndex, o2.originalActivityIndex));
        StringBuilder builder = new StringBuilder();
        for (Schedule schedule : parentAssigned) {
            builder.append(schedule.parentChar);
        }
        System.out.println(String.format("Case #%d: %s", testCase + 1, builder.toString()));
        return true;
    }

    private static boolean doesNotOverlap(ActivityDuration previousActivity, ActivityDuration currentActivity) {
        return previousActivity.startTime >= currentActivity.endTime || currentActivity.startTime >= previousActivity.endTime;
    }

    static class Schedule {
        final char parentChar;
        final int originalActivityIndex;

        Schedule(char parentChar, int originalActivityIndex) {
            this.parentChar = parentChar;
            this.originalActivityIndex = originalActivityIndex;
        }
    }

    static class ActivityDuration implements Comparable<ActivityDuration> {
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
    }
}
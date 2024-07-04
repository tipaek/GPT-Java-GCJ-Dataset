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

            for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
                int activityCount = Integer.parseInt(scanner.nextLine());
                TreeSet<ActivityDuration> activitiesSet = new TreeSet<>();

                for (int i = 0; i < activityCount; i++) {
                    String[] lineParts = scanner.nextLine().split(" ");
                    activitiesSet.add(new ActivityDuration(
                            Integer.parseInt(lineParts[0]),
                            Integer.parseInt(lineParts[1]),
                            i));
                }

                ActivityDuration[] sortedActivities = activitiesSet.toArray(new ActivityDuration[0]);
                Schedule[] parentAssigned = new Schedule[sortedActivities.length];
                boolean isImpossible = assignParents(sortedActivities, parentAssigned);

                if (isImpossible) {
                    System.out.printf("Case #%d: IMPOSSIBLE%n", testCase);
                } else {
                    Arrays.sort(parentAssigned, Comparator.comparingInt(s -> s.originalActivityIndex));
                    StringBuilder result = new StringBuilder();
                    for (Schedule schedule : parentAssigned) {
                        result.append(schedule.parentChar);
                    }
                    System.out.printf("Case #%d: %s%n", testCase, result.toString());
                }
            }
        }
    }

    private static boolean assignParents(ActivityDuration[] sortedActivities, Schedule[] parentAssigned) {
        boolean isImpossible = false;
        char defaultParent = 'C';
        parentAssigned[0] = new Schedule(defaultParent, sortedActivities[0].originalActivityIndex);

        for (int i = 1; i < sortedActivities.length; i++) {
            Set<Character> overlappingParents = new HashSet<>();
            ActivityDuration currentActivity = sortedActivities[i];

            for (int j = 0; j < i; j++) {
                ActivityDuration previousActivity = sortedActivities[j];
                if (!doesNotOverlap(previousActivity, currentActivity)) {
                    overlappingParents.add(parentAssigned[j].parentChar);
                }
            }

            if (overlappingParents.size() >= 2) {
                parentAssigned[i] = new Schedule(' ', currentActivity.originalActivityIndex);
                isImpossible = true;
            } else if (overlappingParents.isEmpty()) {
                parentAssigned[i] = new Schedule(defaultParent, currentActivity.originalActivityIndex);
            } else {
                char assignedParent = overlappingParents.contains('C') ? 'J' : 'C';
                parentAssigned[i] = new Schedule(assignedParent, currentActivity.originalActivityIndex);
            }
        }

        return isImpossible;
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

        @Override
        public String toString() {
            return String.format("parentChar: %s; Original Activity Index: %d", parentChar, originalActivityIndex);
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

        @Override
        public String toString() {
            return String.format("Start time: %d; End Time: %d; Original Activity Index: %d", startTime, endTime, originalActivityIndex);
        }
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
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

                for (int i = 0; i < activityCount; i++) {
                    String[] lineParts = scanner.nextLine().split(" ");
                    activitiesSet.add(new ActivityDuration(
                            Integer.parseInt(lineParts[0]),
                            Integer.parseInt(lineParts[1]),
                            i));
                }

                ActivityDuration[] sortedActivities = activitiesSet.toArray(new ActivityDuration[0]);
                char[] finalParentAssigned = new char[sortedActivities.length];
                Schedule[] parentAssigned = new Schedule[sortedActivities.length];
                char defaultParent = 'J';
                parentAssigned[0] = new Schedule(defaultParent, sortedActivities[0].originalActivityIndex);
                finalParentAssigned[sortedActivities[0].originalActivityIndex] = defaultParent;

                for (int i = 1; i < sortedActivities.length; i++) {
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
                        char newParent = overlappingParent.contains('C') ? 'J' : 'C';
                        parentAssigned[i] = new Schedule(newParent, currentActivity.originalActivityIndex);
                        finalParentAssigned[currentActivity.originalActivityIndex] = newParent;
                    } else {
                        System.out.println(String.format("Case #%d: IMPOSSIBLE", testCase + 1));
                        continue;
                    }
                }

                System.out.println(String.format("Case #%d: %s", testCase + 1, new String(finalParentAssigned)));
            }
        }
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
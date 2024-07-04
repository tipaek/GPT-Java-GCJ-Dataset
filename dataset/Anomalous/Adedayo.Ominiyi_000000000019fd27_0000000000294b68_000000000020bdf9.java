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
            
            testCaseLoop: for (int testCase = 0; testCase < numberOfTestCases; testCase++) {
                int activityCount = Integer.parseInt(scanner.nextLine());
                TreeSet<ActivityDuration> activities = new TreeSet<>();

                for (int i = 0; i < activityCount; i++) {
                    String[] parts = scanner.nextLine().split(" ");
                    activities.add(new ActivityDuration(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), i));
                }

                ActivityDuration[] sortedActivities = activities.toArray(new ActivityDuration[0]);
                char[] assignments = new char[sortedActivities.length];
                Schedule[] schedules = new Schedule[sortedActivities.length];
                char defaultParent = 'J';

                schedules[0] = new Schedule(defaultParent, sortedActivities[0].originalIndex);
                assignments[sortedActivities[0].originalIndex] = defaultParent;

                for (int i = 1; i < sortedActivities.length; i++) {
                    Set<Character> overlappingParents = new HashSet<>();
                    ActivityDuration current = sortedActivities[i];

                    for (int j = 0; j < i; j++) {
                        if (!doesNotOverlap(sortedActivities[j], current)) {
                            overlappingParents.add(schedules[j].parent);
                        }
                    }

                    if (overlappingParents.isEmpty()) {
                        schedules[i] = new Schedule(defaultParent, current.originalIndex);
                        assignments[current.originalIndex] = defaultParent;
                    } else if (overlappingParents.size() == 1) {
                        char assignedParent = overlappingParents.contains('C') ? 'J' : 'C';
                        schedules[i] = new Schedule(assignedParent, current.originalIndex);
                        assignments[current.originalIndex] = assignedParent;
                    } else {
                        System.out.printf("Case #%d: IMPOSSIBLE%n", testCase + 1);
                        continue testCaseLoop;
                    }
                }

                System.out.printf("Case #%d: %s%n", testCase + 1, new String(assignments));
            }
        }
    }

    private static boolean doesNotOverlap(ActivityDuration a, ActivityDuration b) {
        return b.endTime <= a.startTime || b.startTime >= a.endTime;
    }

    static class Schedule {
        final char parent;
        final int originalIndex;

        Schedule(char parent, int originalIndex) {
            this.parent = parent;
            this.originalIndex = originalIndex;
        }
    }

    static class ActivityDuration implements Comparable<ActivityDuration> {
        final int startTime;
        final int endTime;
        final int originalIndex;

        ActivityDuration(int startTime, int endTime, int originalIndex) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.originalIndex = originalIndex;
        }

        @Override
        public int compareTo(ActivityDuration other) {
            int startComparison = Integer.compare(this.startTime, other.startTime);
            return startComparison != 0 ? startComparison : Integer.compare(this.endTime, other.endTime);
        }
    }
}
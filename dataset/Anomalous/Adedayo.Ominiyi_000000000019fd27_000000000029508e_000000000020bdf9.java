import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int numberOfTestCases = Integer.parseInt(scanner.nextLine());

            for (int testCase = 0; testCase < numberOfTestCases; testCase++) {
                int activityCount = Integer.parseInt(scanner.nextLine());
                ActivityDuration[] activities = new ActivityDuration[activityCount];

                for (int i = 0; i < activityCount; i++) {
                    String[] parts = scanner.nextLine().split(" ");
                    activities[i] = new ActivityDuration(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), i);
                }

                Arrays.sort(activities);
                char[] assignedParents = new char[activityCount];
                Arrays.fill(assignedParents, ' ');

                if (assignParents(activities, assignedParents)) {
                    System.out.println("Case #" + (testCase + 1) + ": " + new String(assignedParents));
                } else {
                    System.out.println("Case #" + (testCase + 1) + ": IMPOSSIBLE");
                }
            }
        }
    }

    private static boolean assignParents(ActivityDuration[] activities, char[] assignedParents) {
        char[] parents = {'C', 'J'};
        int[] endTimes = {-1, -1}; // end times for C and J

        for (ActivityDuration activity : activities) {
            boolean assigned = false;
            for (int i = 0; i < parents.length; i++) {
                if (endTimes[i] <= activity.startTime) {
                    assignedParents[activity.originalActivityIndex] = parents[i];
                    endTimes[i] = activity.endTime;
                    assigned = true;
                    break;
                }
            }
            if (!assigned) {
                return false;
            }
        }
        return true;
    }

    static class ActivityDuration implements Comparable<ActivityDuration> {
        int startTime;
        int endTime;
        int originalActivityIndex;

        ActivityDuration(int startTime, int endTime, int originalActivityIndex) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.originalActivityIndex = originalActivityIndex;
        }

        @Override
        public int compareTo(ActivityDuration other) {
            if (this.startTime != other.startTime) {
                return Integer.compare(this.startTime, other.startTime);
            } else if (this.endTime != other.endTime) {
                return Integer.compare(this.endTime, other.endTime);
            } else {
                return Integer.compare(this.originalActivityIndex, other.originalActivityIndex);
            }
        }
    }
}
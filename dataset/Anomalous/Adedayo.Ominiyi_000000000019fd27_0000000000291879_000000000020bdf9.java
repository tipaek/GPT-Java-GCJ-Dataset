import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int numberOfTestCases = Integer.parseInt(scanner.nextLine());

            for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
                int activityCount = Integer.parseInt(scanner.nextLine());
                ActivityDuration[] activities = new ActivityDuration[activityCount];

                for (int i = 0; i < activityCount; i++) {
                    String[] parts = scanner.nextLine().split(" ");
                    activities[i] = new ActivityDuration(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), i);
                }

                Arrays.sort(activities);

                char[] result = new char[activityCount];
                int endC = 0, endJ = 0;
                boolean isImpossible = false;

                for (ActivityDuration activity : activities) {
                    if (activity.startTime >= endC) {
                        result[activity.originalActivityIndex] = 'C';
                        endC = activity.endTime;
                    } else if (activity.startTime >= endJ) {
                        result[activity.originalActivityIndex] = 'J';
                        endJ = activity.endTime;
                    } else {
                        isImpossible = true;
                        break;
                    }
                }

                if (isImpossible) {
                    System.out.println("Case #" + testCase + ": IMPOSSIBLE");
                } else {
                    System.out.println("Case #" + testCase + ": " + new String(result));
                }
            }
        }
    }

    static class ActivityDuration implements Comparable<ActivityDuration> {
        int startTime, endTime, originalActivityIndex;

        ActivityDuration(int startTime, int endTime, int originalActivityIndex) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.originalActivityIndex = originalActivityIndex;
        }

        @Override
        public int compareTo(ActivityDuration other) {
            if (this.startTime != other.startTime) {
                return Integer.compare(this.startTime, other.startTime);
            }
            return Integer.compare(this.endTime, other.endTime);
        }
    }
}
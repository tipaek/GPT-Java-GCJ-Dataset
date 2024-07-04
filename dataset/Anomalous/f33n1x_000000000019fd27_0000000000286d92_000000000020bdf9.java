import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        scanner.nextLine();
        StringBuilder result = new StringBuilder();

        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            int activityCount = scanner.nextInt();
            scanner.nextLine();
            List<Activity> activities = new ArrayList<>(activityCount);

            for (int j = 0; j < activityCount; j++) {
                String[] times = scanner.nextLine().split(" ");
                int start = Integer.parseInt(times[0]);
                int end = Integer.parseInt(times[1]);
                activities.add(new Activity(start, end));
            }

            String allocation = allocateActivities(activities);
            result.append("Case #").append(testCase).append(": ").append(allocation);
            if (testCase < testCaseCount) {
                result.append("\n");
            }
        }

        System.out.println(result);
    }

    static class Activity implements Comparable<Activity> {
        int start;
        int end;

        Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Activity other) {
            return Integer.compare(this.start, other.start);
        }
    }

    static String allocateActivities(List<Activity> activities) {
        Collections.sort(activities);
        int cEnd = -1, jEnd = -1;
        StringBuilder allocation = new StringBuilder();

        for (Activity activity : activities) {
            if (cEnd <= activity.start) {
                allocation.append("C");
                cEnd = activity.end;
            } else if (jEnd <= activity.start) {
                allocation.append("J");
                jEnd = activity.end;
            } else {
                return "IMPOSSIBLE";
            }
        }

        return allocation.toString();
    }
}
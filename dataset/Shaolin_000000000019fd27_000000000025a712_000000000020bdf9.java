//package codejam.y2020.qualification;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    static String impossible = "IMPOSSIBLE";

    static class Activity {
        int start;
        int end;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();
        int T = scanner.nextInt();
        for (int i = 1; i <= T; i++) {
            int totalActivities = scanner.nextInt();
            Activity[] activities = new Activity[totalActivities];
            for (int j = 0; j < totalActivities; j++) {
                activities[j] = new Activity(scanner.nextInt(), scanner.nextInt());
            }
            String assignment = solution.getAssignment(totalActivities, activities);
            System.out.println("Case #" + i + ": " + assignment);
        }
    }

    private String getAssignment(int totalActivities, Activity[] activities) {
        Arrays.sort(activities, Comparator.comparingInt(a -> a.start));
        String assignment = "C";
        int cameronLastTime = activities[0].end;
        int jamieLastTime = -1;

        for (int i = 1; i < totalActivities; i++) {
            if (cameronLastTime > jamieLastTime) {
                if (activities[i].start >= jamieLastTime) {
                    assignment += 'J';
                    jamieLastTime = activities[i].end;
                } else {
                    return impossible;
                }
            } else {
                if (activities[i].start >= cameronLastTime) {
                    assignment += 'C';
                    cameronLastTime = activities[i].end;
                } else {
                    return impossible;
                }
            }
        }
        return assignment;
    }
}

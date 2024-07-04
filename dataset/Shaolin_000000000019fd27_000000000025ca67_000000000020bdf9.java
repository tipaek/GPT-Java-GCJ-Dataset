//package codejam.y2020.qualification;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    static String impossible = "IMPOSSIBLE";

    enum Assignee {
        CAMERON,
        JAMIE
    }
    static class Activity {
        int start;
        int end;
        int index;
        Assignee assignee;

        public Activity(int index, int start, int end) {
            this.index = index;
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
                activities[j] = new Activity(j, scanner.nextInt(), scanner.nextInt());
            }
            String assignment = solution.getAssignment(totalActivities, activities);
            System.out.println("Case #" + i + ": " + assignment);
        }
    }

    private String getAssignment(int totalActivities, Activity[] activities) {
        Arrays.sort(activities, Comparator.comparingInt(a -> a.start));

        int cameronLastTime = activities[0].end;
        activities[0].assignee = Assignee.CAMERON;
        int jamieLastTime = -1;

        for (int i = 1; i < totalActivities; i++) {
            if (cameronLastTime > jamieLastTime) {
                if (activities[i].start >= jamieLastTime) {
                    activities[i].assignee = Assignee.JAMIE;
                    jamieLastTime = activities[i].end;
                } else {
                    return impossible;
                }
            } else {
                if (activities[i].start >= cameronLastTime) {
                    activities[i].assignee = Assignee.CAMERON;
                    cameronLastTime = activities[i].end;
                } else {
                    return impossible;
                }
            }
        }
        Arrays.sort(activities, Comparator.comparingInt(a -> a.index));
        StringBuilder assignment = new StringBuilder();
        for (int i = 0; i < totalActivities; i++) {
            if (activities[i].assignee == Assignee.CAMERON) {
                assignment.append('C');
            } else {
                assignment.append('J');
            }
         }
        return assignment.toString();
    }
}

import java.util.ArrayList;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        ArrayList<String> results = new ArrayList<>();

        for (int i = 0; i < testCases; i++) {
            int activityCount = scanner.nextInt();
            int[][] activities = new int[activityCount][2];

            for (int j = 0; j < activityCount; j++) {
                activities[j][0] = scanner.nextInt();
                activities[j][1] = scanner.nextInt();
            }

            results.add(new ActivityScheduler().scheduleActivities(activities, activityCount));
        }

        for (int i = 0; i < results.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + results.get(i));
        }
    }
}

class ActivityScheduler {
    public String scheduleActivities(int[][] activities, int n) {
        StringBuilder output = new StringBuilder();
        int cEndTime = 0, jEndTime = 0;
        ArrayList<Character> assignments = new ArrayList<>();

        for (int[] activity : activities) {
            if (cEndTime <= activity[0]) {
                assignments.add('C');
                cEndTime = activity[1];
            } else if (jEndTime <= activity[0]) {
                assignments.add('J');
                jEndTime = activity[1];
            } else {
                return "IMPOSSIBLE";
            }
        }

        int earliestStartIndex = 0;
        int earliestStartTime = activities[0][0];
        for (int i = 1; i < n; i++) {
            if (activities[i][0] < earliestStartTime) {
                earliestStartIndex = i;
                earliestStartTime = activities[i][0];
            }
        }

        if (assignments.get(earliestStartIndex) != 'C') {
            for (int i = 0; i < assignments.size(); i++) {
                assignments.set(i, assignments.get(i) == 'C' ? 'J' : 'C');
            }
        }

        for (char assignment : assignments) {
            output.append(assignment);
        }

        return output.toString();
    }
}
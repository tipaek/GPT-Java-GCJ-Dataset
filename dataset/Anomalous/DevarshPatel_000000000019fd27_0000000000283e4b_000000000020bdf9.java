import java.util.ArrayList;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        ArrayList<String> results = new ArrayList<>();

        for (int t = 0; t < testCases; t++) {
            int numActivities = scanner.nextInt();
            int[][] activities = new int[numActivities][2];

            for (int i = 0; i < numActivities; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
            }

            results.add(new ActivityScheduler().scheduleActivities(activities));
        }

        for (int i = 0; i < results.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + results.get(i));
        }
    }
}

class ActivityScheduler {
    public String scheduleActivities(int[][] activities) {
        int n = activities.length;
        int[] endTimeC = {0, 0};
        int[] endTimeJ = {0, 0};
        ArrayList<String> assignments = new ArrayList<>();

        for (int[] activity : activities) {
            if (activity[0] > 1440 || activity[1] > 1440) {
                return "IMPOSSIBLE";
            }

            if (endTimeC[1] <= activity[0] || endTimeC[0] >= activity[1]) {
                assignments.add("C");
                endTimeC[0] = activity[0];
                endTimeC[1] = activity[1];
            } else if (endTimeJ[1] <= activity[0] || endTimeJ[0] >= activity[1]) {
                assignments.add("J");
                endTimeJ[0] = activity[0];
                endTimeJ[1] = activity[1];
            } else {
                return "IMPOSSIBLE";
            }
        }

        int earliestStart = Integer.MAX_VALUE;
        int earliestIndex = -1;

        for (int i = 0; i < n; i++) {
            if (activities[i][0] < earliestStart) {
                earliestStart = activities[i][0];
                earliestIndex = i;
            }
        }

        if (!assignments.get(earliestIndex).equals("C")) {
            for (int i = 0; i < assignments.size(); i++) {
                assignments.set(i, assignments.get(i).equals("C") ? "J" : "C");
            }
        }

        return String.join("", assignments);
    }
}
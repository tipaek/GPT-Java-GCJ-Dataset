import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static class Activity {
        int start;
        int end;
        int index;
        String assigned;

        // Constructor
        Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
            this.assigned = "";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int activityCount = scanner.nextInt();
            Activity[] activities = new Activity[activityCount];

            for (int i = 0; i < activityCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities[i] = new Activity(start, end, i);
            }

            Arrays.sort(activities, (a1, a2) -> Integer.compare(a1.start, a2.start));

            int cEndTime = 0;
            int jEndTime = 0;
            boolean impossible = false;

            for (Activity activity : activities) {
                if (activity.start >= cEndTime) {
                    activity.assigned = "C";
                    cEndTime = activity.end;
                } else if (activity.start >= jEndTime) {
                    activity.assigned = "J";
                    jEndTime = activity.end;
                } else {
                    impossible = true;
                    break;
                }
            }

            StringBuilder result = new StringBuilder();
            if (impossible) {
                result.append("IMPOSSIBLE");
            } else {
                Arrays.sort(activities, (a1, a2) -> Integer.compare(a1.index, a2.index));
                for (Activity activity : activities) {
                    result.append(activity.assigned);
                }
            }

            System.out.println("Case #" + t + ": " + result.toString());
        }
    }
}
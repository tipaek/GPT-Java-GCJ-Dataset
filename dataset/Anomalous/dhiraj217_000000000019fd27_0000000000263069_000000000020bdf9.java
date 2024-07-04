import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int numActivities = scanner.nextInt();
            int[][] activities = new int[numActivities][2];
            for (int i = 0; i < numActivities; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
            }

            Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));

            StringBuilder schedule = new StringBuilder();
            int cEndTime = 0;
            int jEndTime = 0;
            boolean impossible = false;

            for (int i = 0; i < numActivities; i++) {
                if (cEndTime <= activities[i][0]) {
                    schedule.append('C');
                    cEndTime = activities[i][1];
                } else if (jEndTime <= activities[i][0]) {
                    schedule.append('J');
                    jEndTime = activities[i][1];
                } else {
                    impossible = true;
                    System.out.println("Case #" + t + ": IMPOSSIBLE");
                    break;
                }
            }

            if (!impossible) {
                System.out.println("Case #" + t + ": " + schedule);
            }
        }

        scanner.close();
    }
}
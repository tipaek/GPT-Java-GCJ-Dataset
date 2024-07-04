import java.util.Scanner;

public class Solution {

    static void parenting(int[][] activities) {
        if (activities == null || activities.length == 0) {
            return;
        }

        int numActivities = activities.length;
        int cStart = -1, cEnd = -1, jStart = -1, jEnd = -1;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < numActivities; i++) {
            int activityStart = activities[i][0];
            int activityEnd = activities[i][1];

            if (cStart >= activityEnd || cEnd <= activityStart) { // Cameron can take it
                if (cStart == -1) {
                    cStart = activityStart;
                } else {
                    cStart = Math.min(cStart, activityStart);
                }
                cEnd = Math.max(cEnd, activityEnd);
                result.append("C");
            } else if (jStart >= activityEnd || jEnd <= activityStart) { // Jamie can take it
                if (jStart == -1) {
                    jStart = activityStart;
                } else {
                    jStart = Math.min(jStart, activityStart);
                }
                jEnd = Math.max(jEnd, activityEnd);
                result.append("J");
            } else {
                System.out.println("IMPOSSIBLE");
                return;
            }
        }

        System.out.println(result.toString());
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int tIndex = 0; tIndex < t; tIndex++) {
            int n = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            int[][] activities = new int[n][2];

            for (int i = 0; i < n; i++) {
                String[] activityTimes = scanner.nextLine().split(" ");
                activities[i][0] = Integer.parseInt(activityTimes[0]);
                activities[i][1] = Integer.parseInt(activityTimes[1]);
            }

            System.out.print("Case #" + (tIndex + 1) + ": ");
            parenting(activities);
        }

        scanner.close();
    }
}
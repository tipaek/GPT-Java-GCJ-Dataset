import java.util.Scanner;

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

            StringBuilder schedule = new StringBuilder();
            int cEnd = 0, jEnd = 0;
            boolean possible = true;

            for (int i = 0; i < numActivities; i++) {
                if (activities[i][0] >= cEnd) {
                    cEnd = activities[i][1];
                    schedule.append("C");
                } else if (activities[i][0] >= jEnd) {
                    jEnd = activities[i][1];
                    schedule.append("J");
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + t + ": " + schedule.toString());
            }
        }

        scanner.close();
    }
}
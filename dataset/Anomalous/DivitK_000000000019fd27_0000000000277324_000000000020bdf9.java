import java.util.Scanner;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();

        for (int i = 0; i < testCaseCount; i++) {
            int activityCount = scanner.nextInt();
            int[][] activities = new int[activityCount][2];

            for (int j = 0; j < activityCount; j++) {
                activities[j][0] = scanner.nextInt();
                activities[j][1] = scanner.nextInt();
            }

            StringBuilder schedule = new StringBuilder("C");
            boolean impossible = false;
            int conflictCount = 0;

            for (int j = 1; j < activityCount; j++) {
                if (activities[j][0] >= activities[j - 1][0] && activities[j][0] <= activities[j - 1][1]) {
                    schedule.append('J');
                    conflictCount++;
                } else if (activities[j][1] >= activities[j - 1][0] && activities[j][1] <= activities[j - 1][1]) {
                    schedule.append('J');
                } else {
                    schedule.append('C');
                }
            }

            if (conflictCount == 2) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (i + 1) + ": " + schedule);
            }
        }
        scanner.close();
    }
}
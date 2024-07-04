import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int activityCount = scanner.nextInt();
            int[][] activities = new int[activityCount][2];
            StringBuilder schedule = new StringBuilder();
            boolean impossible = false;

            for (int i = 0; i < activityCount; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
            }

            for (int i = 0; i < activityCount; i++) {
                int overlaps = 0;
                int lastOverlapIndex = -1;

                for (int j = 0; j < i; j++) {
                    if ((activities[i][0] >= activities[j][0] && activities[i][0] < activities[j][1]) ||
                        (activities[i][1] > activities[j][0] && activities[i][1] <= activities[j][1])) {
                        overlaps++;
                        lastOverlapIndex = j;
                    }
                }

                if (overlaps == 0) {
                    if (i == 0 || schedule.charAt(lastOverlapIndex) == 'C') {
                        schedule.append('C');
                    } else {
                        schedule.append('J');
                    }
                } else if (overlaps == 1) {
                    if (schedule.charAt(lastOverlapIndex) == 'C') {
                        schedule.append('J');
                    } else {
                        schedule.append('C');
                    }
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNumber + ": " + schedule.toString());
            }
        }

        scanner.close();
    }
}
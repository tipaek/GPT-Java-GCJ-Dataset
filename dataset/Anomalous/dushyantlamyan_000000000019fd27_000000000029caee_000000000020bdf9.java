import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt(); 

        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            int numberOfActivities = scanner.nextInt();
            int[][] activities = new int[numberOfActivities][2];
            StringBuilder schedule = new StringBuilder();

            for (int i = 0; i < numberOfActivities; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
            }

            String result = "";
            int overlapCount = 0;
            int lastOverlapIndex = 0;

            for (int i = 0; i < numberOfActivities; i++) {
                for (int j = 0; j < i; j++) {
                    if ((activities[i][0] > activities[j][0] && activities[i][0] < activities[j][1]) ||
                        (activities[i][1] > activities[j][0] && activities[i][1] < activities[j][1])) {
                        overlapCount++;
                        lastOverlapIndex = j;
                    }
                }

                if (overlapCount == 0) {
                    if (i == 0 || schedule.charAt(lastOverlapIndex) == 'C') {
                        schedule.append('C');
                    } else {
                        schedule.append('J');
                    }
                } else if (overlapCount == 1) {
                    if (schedule.charAt(lastOverlapIndex) == 'C') {
                        schedule.append('J');
                    } else {
                        schedule.append('C');
                    }
                } else {
                    result = "IMPOSSIBLE";
                }

                overlapCount = 0;
            }

            System.out.println("Case #" + caseNumber + ": " + (result.equals("IMPOSSIBLE") ? result : schedule.toString()));
        }
    }
}
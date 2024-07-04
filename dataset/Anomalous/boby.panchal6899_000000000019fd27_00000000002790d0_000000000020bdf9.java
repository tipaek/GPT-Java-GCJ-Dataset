import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= testCaseCount; caseIndex++) {
            int activityCount = scanner.nextInt();
            List<int[]> activities = new ArrayList<>();

            for (int i = 0; i < activityCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new int[]{start, end});
            }

            int cEnd = 0, jEnd = 0;
            StringBuilder schedule = new StringBuilder();
            boolean isPossible = true;

            for (int[] activity : activities) {
                char cChar = (activity[0] % 2 == 0) ? 'C' : 'J';
                char jChar = (cChar == 'C') ? 'J' : 'C';

                if (cEnd <= activity[0]) {
                    cEnd = activity[1];
                    jEnd = Math.max(0, jEnd - (cEnd - activity[0]));
                    schedule.append(cChar);
                } else if (jEnd <= activity[0]) {
                    jEnd = activity[1];
                    cEnd = Math.max(0, cEnd - (jEnd - activity[0]));
                    schedule.append(jChar);
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (!isPossible) {
                schedule = new StringBuilder("IMPOSSIBLE");
            }

            System.out.println("Case #" + caseIndex + ": " + schedule);
        }
    }
}
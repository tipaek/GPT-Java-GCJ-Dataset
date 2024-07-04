import java.util.Scanner;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();

        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            int numberOfIntervals = scanner.nextInt();
            int[][] intervals = new int[numberOfIntervals][2];

            for (int intervalIndex = 0; intervalIndex < numberOfIntervals; intervalIndex++) {
                intervals[intervalIndex][0] = scanner.nextInt();
                intervals[intervalIndex][1] = scanner.nextInt();
            }

            StringBuilder schedule = new StringBuilder("C");
            int conflictCount = 0;

            for (int i = 1; i < numberOfIntervals; i++) {
                if (intervals[i][0] >= intervals[i - 1][0] && intervals[i][0] <= intervals[i - 1][1]) {
                    schedule.append('J');
                    conflictCount++;
                } else if (intervals[i][1] >= intervals[i - 1][0] && intervals[i][1] <= intervals[i - 1][1]) {
                    schedule.append('J');
                } else {
                    schedule.append('C');
                }
            }

            if (conflictCount == 2) {
                System.out.println("Case #" + (caseIndex + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (caseIndex + 1) + ": " + schedule.toString());
            }
        }
    }
}
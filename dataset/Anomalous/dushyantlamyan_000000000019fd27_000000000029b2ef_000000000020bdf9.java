import java.io.*;
import java.util.*;

public class Solution3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt(); 

        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            int intervalCount = scanner.nextInt();
            int[][] intervals = new int[intervalCount][2];
            int[][] sortedIntervals = new int[intervalCount][2];
            StringBuilder schedule = new StringBuilder();

            for (int i = 0; i < intervalCount; i++) {
                for (int j = 0; j < 2; j++) {
                    intervals[i][j] = scanner.nextInt();
                    sortedIntervals[i][j] = intervals[i][j];
                }
            }

            String result = "";
            int overlapCount = 0;
            int conflictingInterval = 0;

            for (int i = 0; i < intervalCount; i++) {
                for (int j = 0; j <= i; j++) {
                    if (i == j) {
                        if (i == 0) {
                            overlapCount = 0;
                            break;
                        }
                        break;
                    }
                    if ((intervals[i][0] > sortedIntervals[j][0] && intervals[i][0] < sortedIntervals[j][1]) ||
                        (intervals[i][1] > sortedIntervals[j][0] && intervals[i][1] < sortedIntervals[j][1])) {
                        overlapCount++;
                        conflictingInterval = j;
                    }
                }

                if (i == 0 || overlapCount == 0) {
                    if (i == 0) {
                        schedule.append('C');
                    } else if (schedule.charAt(conflictingInterval) == 'C') {
                        schedule.append('C');
                    } else {
                        schedule.append('J');
                    }
                } else if (overlapCount == 1) {
                    if (schedule.charAt(conflictingInterval) == 'C') {
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
import java.util.*;
import java.io.*;

public class Solution {

    public static void sortByStartTime(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
    }

    public static void sortByOriginalIndex(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[3]));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][4];

            for (int i = 0; i < n; i++) {
                intervals[i][3] = i; // Store the original index
                intervals[i][0] = scanner.nextInt(); // Start time
                intervals[i][1] = scanner.nextInt(); // End time
            }

            for (int i = 0; i < n; i++) {
                intervals[i][2] = 0; // Initialize assignment to 'C'
            }

            sortByStartTime(intervals);

            boolean impossible = false;
            int cameronEndTime = intervals[0][1];
            int jamieEndTime = 0;
            StringBuilder schedule = new StringBuilder();

            for (int i = 0; i < n - 2; i++) {
                if (intervals[i][1] > intervals[i + 1][0] && intervals[i][1] > intervals[i + 2][0] && intervals[i + 1][1] > intervals[i + 2][0]) {
                    impossible = true;
                    System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                    break;
                }
            }

            if (!impossible) {
                for (int i = 1; i < n; i++) {
                    if (intervals[i][0] < cameronEndTime) {
                        intervals[i][2] = 1; // Assign to 'J'
                        jamieEndTime = intervals[i][1];
                    } else if (intervals[i][0] < jamieEndTime) {
                        intervals[i][2] = 0; // Assign to 'C'
                        cameronEndTime = intervals[i][1];
                    }
                }

                sortByOriginalIndex(intervals);

                for (int i = 0; i < n; i++) {
                    schedule.append(intervals[i][2] == 0 ? 'C' : 'J');
                }

                System.out.println("Case #" + caseNumber + ": " + schedule.toString());
            }
        }
    }
}
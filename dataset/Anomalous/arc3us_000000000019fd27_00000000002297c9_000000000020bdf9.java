import java.util.*;
import java.io.*;

public class Solution {

    public static void sortTime(int[][] arr) {
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];

            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }

            StringBuilder schedule = new StringBuilder("C".repeat(n));
            sortTime(intervals);

            boolean impossible = false;
            int cameronEnd = intervals[0][1];
            int jamieEnd = 0;

            for (int i = 0; i < n - 1; i++) {
                if (intervals[i][1] > intervals[i + 1][0]) {
                    if (jamieEnd <= intervals[i + 1][0]) {
                        schedule.setCharAt(i + 1, 'J');
                        jamieEnd = intervals[i + 1][1];
                    } else if (cameronEnd <= intervals[i + 1][0]) {
                        schedule.setCharAt(i + 1, 'C');
                        cameronEnd = intervals[i + 1][1];
                    } else {
                        impossible = true;
                        break;
                    }
                } else {
                    cameronEnd = intervals[i + 1][1];
                }

                if (i >= 1 && intervals[i + 1][0] < intervals[i - 1][1]) {
                    if (jamieEnd <= intervals[i + 1][0]) {
                        schedule.setCharAt(i + 1, 'J');
                        jamieEnd = intervals[i + 1][1];
                    } else if (cameronEnd <= intervals[i + 1][0]) {
                        schedule.setCharAt(i + 1, 'C');
                        cameronEnd = intervals[i + 1][1];
                    }
                }

                if (intervals[i][1] > intervals[i + 1][0] && intervals[i][1] > intervals[i + 2][0] && intervals[i + 1][1] > intervals[i + 2][0]) {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNumber + ": " + schedule);
            }
            caseNumber++;
        }
    }
}
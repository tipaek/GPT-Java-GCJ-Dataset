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

            for (int i = 0; i < n - 2; i++) {
                if (intervals[i][1] > intervals[i + 1][0] &&
                    intervals[i][1] > intervals[i + 2][0] &&
                    intervals[i + 1][1] > intervals[i + 2][0]) {
                    impossible = true;
                    System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                    break;
                }
            }

            if (!impossible) {
                for (int i = 1; i < n; i++) {
                    if (intervals[i][0] < cameronEnd) {
                        schedule.setCharAt(i, 'J');
                        jamieEnd = intervals[i][1];
                    } else {
                        schedule.setCharAt(i, 'C');
                        cameronEnd = intervals[i][1];
                    }
                }

                System.out.println("Case #" + caseNumber + ": " + schedule.toString());
            }

            caseNumber++;
        }
    }
}
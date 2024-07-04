import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][3];

            for (int j = 0; j < n; j++) {
                intervals[j][0] = scanner.nextInt();
                intervals[j][1] = scanner.nextInt();
                intervals[j][2] = j;
            }

            processIntervals(intervals, n, i + 1);
        }
    }

    private static void sortByStartTime(int[][] array) {
        Arrays.sort(array, (a, b) -> Integer.compare(a[0], b[0]));
    }

    private static void processIntervals(int[][] intervals, int n, int testCaseNumber) {
        int cEnd = 0, jEnd = 0;
        sortByStartTime(intervals);
        
        char[] result = new char[n];
        result[intervals[0][2]] = 'C';
        cEnd = intervals[0][1];

        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= cEnd) {
                result[intervals[i][2]] = 'C';
                cEnd = intervals[i][1];
            } else if (intervals[i][0] >= jEnd) {
                result[intervals[i][2]] = 'J';
                jEnd = intervals[i][1];
            } else {
                System.out.println("Case #" + testCaseNumber + ": IMPOSSIBLE");
                return;
            }
        }

        System.out.print("Case #" + testCaseNumber + ": ");
        for (char ch : result) {
            System.out.print(ch);
        }
        System.out.println();
    }
}
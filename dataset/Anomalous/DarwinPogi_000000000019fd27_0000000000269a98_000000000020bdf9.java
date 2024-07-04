import java.util.*;
import java.io.*;

public class Solution {
    
    public static int[][] buildIntervals(int N, Scanner scanner) {
        int[][] intervals = new int[N][2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                intervals[i][j] = scanner.nextInt();
            }
        }
        return intervals;
    }

    public static void processIntervals(int testCaseNumber, int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        int cEnd = -1;
        int jEnd = -1;
        StringBuilder schedule = new StringBuilder();

        for (int[] interval : intervals) {
            if (interval[0] >= cEnd) {
                cEnd = interval[1];
                schedule.append("C");
            } else if (interval[0] >= jEnd) {
                jEnd = interval[1];
                schedule.append("J");
            } else {
                System.out.println("Case #" + testCaseNumber + ": IMPOSSIBLE");
                return;
            }
        }

        System.out.println("Case #" + testCaseNumber + ": " + schedule.toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = scanner.nextInt();

        for (int testCaseNumber = 1; testCaseNumber <= testCaseCount; testCaseNumber++) {
            int N = scanner.nextInt();
            int[][] intervals = buildIntervals(N, scanner);
            processIntervals(testCaseNumber, intervals);
        }
    }
}
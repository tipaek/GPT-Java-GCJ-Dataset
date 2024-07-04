import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    private static String findSchedule(int n, int[][] intervals) {
        char[] assignments = new char[n];
        Arrays.sort(intervals, (first, second) -> first[1] == second[1] ? second[2] - first[2] : first[1] - second[1]);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (intervals[i][1] < intervals[j][2]) {
                    if (assignments[intervals[i][0]] == 0) {
                        assignments[intervals[i][0]] = assignments[intervals[j][0]] == 'C' ? 'J' : 'C';
                    } else if (assignments[intervals[i][0]] == assignments[intervals[j][0]]) {
                        return "IMPOSSIBLE";
                    }
                }
            }
            if (assignments[intervals[i][0]] == 0) {
                assignments[intervals[i][0]] = 'C';
            }
        }
        return new String(assignments);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][3];

            for (int i = 0; i < n; i++) {
                intervals[i][0] = i;
                intervals[i][1] = scanner.nextInt();
                intervals[i][2] = scanner.nextInt();
            }

            System.out.println("Case #" + t + ": " + findSchedule(n, intervals));
        }
        scanner.close();
    }
}
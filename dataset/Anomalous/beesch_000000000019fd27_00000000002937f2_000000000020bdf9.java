import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();

            for (int testCase = 1; testCase <= testCases; testCase++) {
                int n = scanner.nextInt();
                scanner.nextLine();

                int[][] intervals = new int[n][2];
                for (int i = 0; i < n; i++) {
                    intervals[i][0] = scanner.nextInt();
                    intervals[i][1] = scanner.nextInt();
                    if (i < n - 1) scanner.nextLine();
                }

                String result = assignTasks(intervals);
                System.out.println("Case #" + testCase + ": " + result);
            }
        }
    }

    private static String assignTasks(int[][] intervals) {
        int[] endTime = new int[2]; // endTime[0] for Cameron, endTime[1] for Jamie
        char[] assignment = new char[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (start >= endTime[0]) {
                endTime[0] = end;
                assignment[i] = 'C';
            } else if (start >= endTime[1]) {
                endTime[1] = end;
                assignment[i] = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }

        return new String(assignment);
    }
}
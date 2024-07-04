import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int numSegments = scanner.nextInt();
            int[][] segments = new int[numSegments][2];
            for (int i = 0; i < numSegments; i++) {
                segments[i][0] = scanner.nextInt();
                segments[i][1] = scanner.nextInt();
            }

            String result = findSchedule(numSegments, segments);
            System.out.println("Case #" + testCase + ": " + result);
        }
    }

    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    private static String findSchedule(int numSegments, int[][] segments) {
        Arrays.sort(segments, (segment1, segment2) -> Integer.compare(segment1[0], segment2[0]));
        StringBuilder schedule = new StringBuilder();
        int cameronEndTime = 0;
        int jamieEndTime = 0;

        for (int[] segment : segments) {
            int start = segment[0];
            int end = segment[1];

            if (start >= cameronEndTime) {
                schedule.append('C');
                cameronEndTime = end;
            } else if (start >= jamieEndTime) {
                schedule.append('J');
                jamieEndTime = end;
            } else {
                return IMPOSSIBLE;
            }
        }

        return schedule.toString();
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] segments = new int[n][2];
            
            for (int i = 0; i < n; i++) {
                segments[i][0] = scanner.nextInt();
                segments[i][1] = scanner.nextInt();
            }
            
            String result = scheduleSegments(n, segments);
            System.out.println("Case #" + testCase + ": " + result);
        }
    }

    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    private static String scheduleSegments(int n, int[][] segments) {
        Arrays.sort(segments, (a, b) -> Integer.compare(a[0], b[0]));
        StringBuilder schedule = new StringBuilder();
        int cEnd = 0;
        int jEnd = 0;

        for (int[] segment : segments) {
            int start = segment[0];
            int end = segment[1];

            if (start >= cEnd) {
                schedule.append('C');
                cEnd = end;
            } else if (start >= jEnd) {
                schedule.append('J');
                jEnd = end;
            } else {
                return IMPOSSIBLE;
            }
        }

        return schedule.toString();
    }
}
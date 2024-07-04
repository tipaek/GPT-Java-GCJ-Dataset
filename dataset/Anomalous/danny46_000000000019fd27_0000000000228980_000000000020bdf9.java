import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int N = scanner.nextInt();
            int[][] segments = new int[N][2];
            
            for (int i = 0; i < N; i++) {
                segments[i][0] = scanner.nextInt();
                segments[i][1] = scanner.nextInt();
            }
            
            String result = findSchedule(N, segments);
            System.out.println("Case #" + testCase + ": " + result);
        }
    }

    private static String findSchedule(int N, int[][] segments) {
        Arrays.sort(segments, (a, b) -> Integer.compare(a[0], b[0]));
        StringBuilder schedule = new StringBuilder();
        int cameronEnd = 0;
        int jamieEnd = 0;

        for (int[] segment : segments) {
            int start = segment[0];
            int end = segment[1];

            if (start >= cameronEnd) {
                schedule.append('C');
                cameronEnd = end;
            } else if (start >= jamieEnd) {
                schedule.append('J');
                jamieEnd = end;
            } else {
                return IMPOSSIBLE;
            }
        }

        return schedule.toString();
    }
}
import java.util.Scanner;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        try (Scanner inputScanner = new Scanner(System.in)) {
            int T = inputScanner.nextInt();
            for (int i = 0; i < T; i++) {
                int N = inputScanner.nextInt();
                int[][] intervals = new int[N][4];
                for (int j = 0; j < N; j++) {
                    intervals[j][0] = inputScanner.nextInt();
                    intervals[j][1] = inputScanner.nextInt();
                    intervals[j][2] = j;
                }
                processSchedule(intervals, i);
            }
        }
    }

    private static void processSchedule(int[][] intervals, int caseNumber) {
        StringBuilder result = new StringBuilder();
        result.append("Case #").append(caseNumber + 1).append(": ");

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int endC = 0, endJ = 0;
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            if (start >= endC) {
                endC = end;
                interval[3] = 0; // Assigned to C
            } else if (start >= endJ) {
                endJ = end;
                interval[3] = 1; // Assigned to J
            } else {
                System.out.printf("Case #%d: IMPOSSIBLE%n", caseNumber + 1);
                return;
            }
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[2], b[2]));
        for (int[] interval : intervals) {
            result.append(interval[3] == 0 ? "C" : "J");
        }

        System.out.println(result.toString());
    }
}
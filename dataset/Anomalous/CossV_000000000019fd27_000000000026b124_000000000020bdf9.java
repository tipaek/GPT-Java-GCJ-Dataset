import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = Integer.parseInt(scanner.nextLine());
            List<int[]> intervals = new ArrayList<>();
            List<int[]> cIntervals = new ArrayList<>();
            List<int[]> jIntervals = new ArrayList<>();
            StringBuilder output = new StringBuilder();

            for (int i = 0; i < n; i++) {
                String[] parts = scanner.nextLine().split(" ");
                int start = Integer.parseInt(parts[0]);
                int end = Integer.parseInt(parts[1]);
                intervals.add(new int[]{start, end});
            }

            for (int[] interval : intervals) {
                if (!hasOverlap(cIntervals, interval)) {
                    cIntervals.add(interval);
                    output.append("C");
                } else if (!hasOverlap(jIntervals, interval)) {
                    jIntervals.add(interval);
                    output.append("J");
                } else {
                    output = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + testCase + ": " + output);
        }
    }

    private static boolean hasOverlap(List<int[]> intervals, int[] newInterval) {
        for (int[] interval : intervals) {
            if (!isNonOverlapping(interval[0], interval[1], newInterval[0], newInterval[1])) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNonOverlapping(int start1, int end1, int start2, int end2) {
        return end1 <= start2 || end2 <= start1;
    }
}
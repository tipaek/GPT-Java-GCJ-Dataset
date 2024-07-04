import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int testCase = 1; testCase <= testCases; ++testCase) {
            ArrayList<long[]> cameron = new ArrayList<>();
            ArrayList<long[]> jamie = new ArrayList<>();
            int numIntervals = Integer.parseInt(scanner.nextLine());
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < numIntervals; i++) {
                long[] interval = parseInterval(scanner.nextLine());
                if (interval.length != 2) {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }

                if (!hasOverlap(jamie, interval)) {
                    jamie.add(interval);
                    result.append("J");
                } else if (!hasOverlap(cameron, interval)) {
                    cameron.add(interval);
                    result.append("C");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + testCase + ": " + result);
        }
    }

    private static long[] parseInterval(String input) {
        String[] parts = input.split(" ");
        long[] interval = new long[2];
        interval[0] = Long.parseLong(parts[0]);
        interval[1] = Long.parseLong(parts[1]);
        return interval;
    }

    private static boolean hasOverlap(ArrayList<long[]> intervals, long[] newInterval) {
        for (long[] interval : intervals) {
            if (isOverlap(interval, newInterval)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isOverlap(long[] interval1, long[] interval2) {
        return (interval1[0] < interval2[1] && interval1[1] > interval2[0]);
    }
}
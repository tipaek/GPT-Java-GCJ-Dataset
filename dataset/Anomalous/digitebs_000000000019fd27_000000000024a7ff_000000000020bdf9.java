import java.util.*;
import java.io.*;

public class Solution {

    static String schedule(List<int[]> intervals) {
        int[] j = null;
        int[] c = null;

        List<int[]> sortedIntervals = new ArrayList<>(intervals);
        sortedIntervals.sort((a, b) -> {
            int startComparison = Integer.compare(a[0], b[0]);
            return startComparison != 0 ? startComparison : Integer.compare(a[1], b[1]);
        });

        Map<int[], String> assignments = new HashMap<>();
        StringBuilder result = new StringBuilder();

        for (int[] interval : sortedIntervals) {
            if (j == null || j[1] <= interval[0]) {
                j = interval;
                assignments.put(interval, "C");
            } else if (c == null || c[1] <= interval[0]) {
                c = interval;
                assignments.put(interval, "J");
            } else {
                return "IMPOSSIBLE";
            }
        }

        for (int[] interval : intervals) {
            result.append(assignments.get(interval));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; ++i) {
            int n = scanner.nextInt();
            List<int[]> intervals = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals.add(new int[]{start, end});
            }

            String result = schedule(intervals);
            System.out.println("Case #" + i + ": " + result);
        }
    }
}
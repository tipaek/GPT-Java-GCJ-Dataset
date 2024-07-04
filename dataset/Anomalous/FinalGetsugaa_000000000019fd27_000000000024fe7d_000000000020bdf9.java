import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    static class IntervalComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] interval1, int[] interval2) {
            return Integer.compare(interval1[0], interval2[0]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseIndex = 0; caseIndex < testCases; caseIndex++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];

            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }

            int[][] sortedIntervals = intervals.clone();
            Arrays.sort(sortedIntervals, new IntervalComparator());

            HashMap<String, String> assignments = new HashMap<>();
            int cEnd = 0;
            int jEnd = 0;
            boolean isImpossible = false;

            for (int[] interval : sortedIntervals) {
                if (cEnd <= interval[0]) {
                    cEnd = interval[1];
                    assignments.put(interval[0] + "-" + interval[1], "C");
                } else if (jEnd <= interval[0]) {
                    jEnd = interval[1];
                    assignments.put(interval[0] + "-" + interval[1], "J");
                } else {
                    isImpossible = true;
                    break;
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + (caseIndex + 1) + ": IMPOSSIBLE");
                continue;
            }

            StringBuilder result = new StringBuilder();
            HashMap<String, Integer> processed = new HashMap<>();

            for (int[] interval : intervals) {
                String key = interval[0] + "-" + interval[1];
                if (processed.containsKey(key)) {
                    result.append("C");
                } else {
                    result.append(assignments.get(key));
                }
                processed.put(key, 1);
            }

            System.out.println("Case #" + (caseIndex + 1) + ": " + result.toString());
        }

        scanner.close();
    }
}
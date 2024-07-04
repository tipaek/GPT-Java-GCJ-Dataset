import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= t; ++i) {
            int n = Integer.parseInt(scanner.nextLine());
            int[][] intervals = new int[n][2];
            Map<Integer, Character> result = new LinkedHashMap<>();
            boolean[] scheduledByC = new boolean[1441];
            boolean[] scheduledByJ = new boolean[1441];
            boolean possible = true;

            for (int j = 0; j < n; j++) {
                String[] input = scanner.nextLine().split(" ");
                intervals[j][0] = Integer.parseInt(input[0]);
                intervals[j][1] = Integer.parseInt(input[1]);
            }

            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

            for (int[] interval : intervals) {
                int start = interval[0];
                int end = interval[1];

                if (canSchedule(scheduledByC, start, end)) {
                    schedule(scheduledByC, start, end);
                    result.put(start, 'C');
                } else if (canSchedule(scheduledByJ, start, end)) {
                    schedule(scheduledByJ, start, end);
                    result.put(start, 'J');
                } else {
                    possible = false;
                    break;
                }
            }

            StringBuilder output = new StringBuilder();
            if (possible) {
                for (Map.Entry<Integer, Character> entry : result.entrySet()) {
                    output.append(entry.getValue());
                }
            } else {
                output.append("IMPOSSIBLE");
            }

            System.out.println("Case #" + i + ": " + output);
        }
    }

    private static boolean canSchedule(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i]) {
                return false;
            }
        }
        return true;
    }

    private static void schedule(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule[i] = true;
        }
    }
}
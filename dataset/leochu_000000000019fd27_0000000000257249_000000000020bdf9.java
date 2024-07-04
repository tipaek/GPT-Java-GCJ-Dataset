import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int size = in.nextInt();
            int[][] input = new int[size][2];
            for (int j = 0; j < size; j++) {
                input[j][0] = in.nextInt();
                input[j][1] = in.nextInt();
            }
            ParentingPartneringReturn solution = new ParentingPartneringReturn(input);
            System.out.println("Case #" + i + ": " + solution.getParentingSchedule());
        }
    }

    private static class ParentingPartneringReturn {
        private int[][] intervals;
        private int[] keys;

        ParentingPartneringReturn(int[][] interval) {
            this.intervals = new int[interval.length][3];
            this.keys = new int[interval.length];
            for (int i = 0; i < interval.length; i++) {
                this.intervals[i][0] = interval[i][0];
                this.intervals[i][1] = interval[i][1];
                this.intervals[i][2] = interval[i][0] + interval[i][1] + i + 1441;
                this.keys[i] = interval[i][0] + interval[i][1] + i + 1441;
            }
            Arrays.sort(this.intervals, (o1, o2) -> {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            });
        }

        String getParentingSchedule() {
            Map<Integer, Character> table = new HashMap<>();
            int[] available = new int[]{-1, -1};
            for (int[] interval : intervals) {
                int start = interval[0];
                int end = interval[1];
                int key = interval[2];
                if (start >= available[0]) {
                    table.put(key, 'C');
                    available[0] = end;
                } else if (start >= available[1]) {
                    table.put(key, 'J');
                    available[1] = end;
                } else {
                    return "IMPOSSIBLE";
                }
            }
            StringBuilder schedule = new StringBuilder();
            for (int key : keys) {
                schedule.append(table.get(key));
            }
            return schedule.toString();
        }
    }
}
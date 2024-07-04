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
        private static final char parentOne = 'C';
        private static final char parentTwo = 'J';
        private int[][] interval;
        private int[] keys;

        ParentingPartneringReturn(int[][] interval) {
            this.interval = new int[interval.length][3];
            this.keys = new int[interval.length];
            for (int i = 0; i < interval.length; i++) {
                this.interval[i][0] = interval[i][0];
                this.interval[i][1] = interval[i][1];
                this.interval[i][2] = interval[i][0] + interval[i][1] + i;
                this.keys[i] = interval[i][0] + interval[i][1] + i;
            }
            Arrays.sort(this.interval, (o1, o2) -> {
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
            for (int[] ints : interval) {
                int start = ints[0];
                int end = ints[1];
                int key = ints[2];

                if (start >= available[0]) {
                    table.put(key, parentOne);
                    available[0] = end;
                } else if (start >= available[1]) {
                    table.put(key, parentTwo);
                    available[1] = end;
                } else {
                    return "IMPOSSIBLE";
                }
            }
            StringBuilder schedule = new StringBuilder();
            for (int number : keys) {
                schedule.append(table.get(number));
            }
            return schedule.toString();
        }
    }
}
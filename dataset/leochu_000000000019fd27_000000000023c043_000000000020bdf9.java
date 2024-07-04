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
        private TreeMap<Integer, Integer> scheduleOne;
        private TreeMap<Integer, Integer> scheduleTwo;
        private int[] order;
        private boolean invalid = true;

        ParentingPartneringReturn(int[][] interval) {
            this.interval = new int[interval.length][2];
            this.order = new int[interval.length];
            for (int i = 0; i < interval.length; i++) {
                if (interval[i][0] >= interval[i][1] || interval[i][0] < 0 || interval[i][1] < 0) {
                    throw new IllegalStateException();
                }
                this.interval[i][0] = interval[i][0];
                this.interval[i][1] = interval[i][1];
                this.order[i] = interval[i][0];
            }
            Arrays.sort(this.interval, (o1, o2) -> {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            });
            scheduleOne = new TreeMap<>();
            scheduleTwo = new TreeMap<>();
        }

        String getParentingSchedule() {
            Map<Integer, Character> table = new HashMap<>();

            for (int[] ints : interval) {
                int start = ints[0];
                int end = ints[1];

                if (insertNewSchedule(scheduleOne, start, end)) {
                    table.put(start, parentOne);
                } else if (insertNewSchedule(scheduleTwo, start, end)) {
                    table.put(start, parentTwo);
                } else {
                    return "IMPOSSIBLE";
                }
            }
            StringBuilder schedule = new StringBuilder();
            for (int number: order) {
                schedule.append(table.get(number));
            }
            return schedule.toString();
        }

        private boolean insertNewSchedule(TreeMap<Integer, Integer> schedule, int start, int end) {
            Integer prev = schedule.floorKey(start),
                    next = schedule.ceilingKey(start);
            if ((prev == null || schedule.get(prev) <= start) && (next == null || end <= next)) {
                schedule.put(start, end);
                return true;
            }
            return false;
        }
    }
}
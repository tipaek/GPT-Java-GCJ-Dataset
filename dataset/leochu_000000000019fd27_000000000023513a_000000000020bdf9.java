import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int size = in.nextInt();
            int[] input = new int[size * 2];
            for (int j = 0; j < size * 2; j++) {
                input[j] = in.nextInt();
            }
            ParentingPartneringReturn solution = new ParentingPartneringReturn(input);
            System.out.println("Case #" + i + ": " + solution.getParentingSchedule());
        }
    }

    private static class ParentingPartneringReturn {

        private static final char parentOne = 'C';
        private static final char parentTwo = 'J';
        private int[] time;
        private TreeMap<Integer, Integer> scheduleOne;
        private TreeMap<Integer, Integer> scheduleTwo;

        ParentingPartneringReturn(int[] time) {
            this.time = new int[time.length];
            System.arraycopy(time, 0, this.time, 0, time.length);
            scheduleOne = new TreeMap<>();
            scheduleTwo = new TreeMap<>();
        }

        String getParentingSchedule() {
            StringBuilder schedule = new StringBuilder();

            for (int i = 0; i < time.length; i += 2) {
                int start = time[i];
                int end = time[i+1];

                if (insertNewSchedule(scheduleOne, start, end)) {
                    schedule.append(parentOne);
                } else if (insertNewSchedule(scheduleTwo, start, end)) {
                    schedule.append(parentTwo);
                } else {
                    return "IMPOSSIBLE";
                }
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
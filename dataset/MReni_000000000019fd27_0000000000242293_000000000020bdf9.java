
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
      Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
      int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
      for (int i = 1; i <= t; ++i) {
        int lineCount = in.nextInt();
        int[][] schedules = new int[lineCount][2];
        for (int x = 0; x < lineCount; x++) {
            schedules[x] = new int[]{in.nextInt(), in.nextInt()};
        }

        String output = getSchedule(schedules, 0, new ArrayList<>(), new ArrayList<>());
        if (output == null) output = "IMPOSSIBLE";
        System.out.println("Case #" + i + ": " + output);
      }
    }

    private static String getSchedule(int[][] schedules, int idx, List<int[]> c, List<int[]> j) {
        // todo check end
        if (idx == schedules.length) return "";
        int[] task = schedules[idx];
        if (!hasConflict(c, task)) {
            c.add(task);
            String followSchedule = getSchedule(schedules, idx+1, c, j);
            if (followSchedule != null) {
                return "C" + followSchedule;
            }
            c.remove(task);
        }
        if (!hasConflict(j, task)) {
            j.add(task);
            String followSchedule = getSchedule(schedules, idx+1, c, j);
            if (followSchedule != null) {
                return "J" + followSchedule;
            }
            j.remove(task);
        }

        return null;
    }

    private static boolean hasConflict(List<int[]> existingSchedule, int[] task) {
        // check if existing schedule can accomodate new schedule
        for (int[] schedule : existingSchedule) {
            int begin = schedule[0], end = schedule[1];
            int taskBegin = task[0], taskEnd = task[1];
            if ((taskBegin >= begin && taskEnd <= end) ||
                (taskBegin <= begin && taskEnd > begin) ||
                (taskBegin < end && taskEnd >= end)
            ) {
                return true;
            }
        }
        return false;
    }

}

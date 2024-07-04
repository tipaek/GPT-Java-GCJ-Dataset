import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String first = in.nextLine(); // Scanner has functions to read ints, longs, strings, chars, etc.
        int t = Integer.parseInt(first);
        for (int i = 1; i <= t; i++) {
            String tasksLine = in.nextLine();
            int tasks = Integer.parseInt(tasksLine);
            StringBuffer sb = new StringBuffer();
            String result = null;
            Set<int[]> cameron = new HashSet<>();
            Set<int[]> jamie = new HashSet<>();
            for (int j = 0; j < tasks; j++) {
                String taskLine = in.nextLine();
                String[] taskTime = taskLine.split(" ");
                int start = Integer.parseInt(taskTime[0]);
                int end;
                if (taskTime.length == 1) {
                    end = start;
                } else {
                    end = Integer.parseInt(taskTime[1]);
                }

                if (canPick(cameron, start, end)) {
                    int[] pickedTask = new int[2];
                    pickedTask[0] = start;
                    pickedTask[1] = end;
                    cameron.add(pickedTask);
                    sb.append('C');
                } else if (canPick(jamie, start, end)) {
                    int[] pickedTask = new int[]{start, end};
                    jamie.add(pickedTask);
                    sb.append('J');
                } else {
                    result = "IMPOSSIBLE";
                    break;
                }
            }
            if (result == null) {
                result = sb.toString();
            }
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static boolean canPick(Set<int[]> c, int start, int end) {
        for (int[] task : c) {
            if (start > task[0] && start < task[1]) return false;
            if (end > task[0] && end < task[1]) return false;
        }
        return true;
    }
}

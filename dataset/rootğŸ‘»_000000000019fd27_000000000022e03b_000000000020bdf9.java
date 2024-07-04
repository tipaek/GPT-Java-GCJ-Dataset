import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

    private static class Schedule {
        public int start;
        public int end;
        public int order;
        public char assignee;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = in.nextInt();
        for (int test = 1; test <= tests; ++test) {
            int activities = in.nextInt();
            Schedule[] schedules = new Schedule[activities];
            for (int i = 0; i < activities; ++i) {
                schedules[i] = new Schedule();
                schedules[i].start = in.nextInt();
                schedules[i].end = in.nextInt();
                schedules[i].order = i;
            }
            Arrays.sort(schedules, Comparator.comparingInt(o -> o.start));
            Integer jEndTime = null;
            Integer cEndTime = null;
            boolean impossible = false;
            for (int i = 0; i < schedules.length; i++) {
                Schedule schedule = schedules[i];
                if (jEndTime != null && schedule.start >= jEndTime) {
                    jEndTime = null;
                }
                if (cEndTime != null && schedule.start >= cEndTime) {
                    cEndTime = null;
                }
                if (jEndTime == null) {
                    schedule.assignee = 'C';
                    jEndTime = schedule.end;
                } else if (cEndTime == null) {
                    schedule.assignee = 'J';
                    cEndTime = schedule.end;
                } else {
                    impossible = true;
                    break;
                }
            }
            if (impossible) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", test);
                continue;
            }
            StringBuilder sb = new StringBuilder(schedules.length);
            sb.setLength(schedules.length);
            for (Schedule s : schedules) {
                sb.insert(s.order, s.assignee);
            }
            System.out.printf("Case #%d: %s\n", test, sb.toString());
        }
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    static final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    static final PrintWriter out = new PrintWriter(System.out);

    public static void main(final String[] args) throws IOException {
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            out.print("Case #" + i + ": ");
            processTestCase();
        }
        out.flush();
        out.close();
        in.close();
    }

    private static void processTestCase() throws IOException {
        int n = in.nextInt();
        Schedule[] schedules = new Schedule[n];
        
        for (int i = 0; i < n; i++) {
            schedules[i] = new Schedule(in.nextInt(), in.nextInt(), i);
        }

        Arrays.sort(schedules, (s1, s2) -> s1.start != s2.start ? s1.start - s2.start : s1.end - s2.end);

        Schedule cameron = null, jamie = null;
        for (Schedule schedule : schedules) {
            if (cameron == null || schedule.start >= cameron.end) {
                schedule.assignedTo = 'C';
                cameron = schedule;
            } else if (jamie == null || schedule.start >= jamie.end) {
                schedule.assignedTo = 'J';
                jamie = schedule;
            } else {
                out.println("IMPOSSIBLE");
                return;
            }
        }

        char[] result = new char[n];
        for (Schedule schedule : schedules) {
            result[schedule.index] = schedule.assignedTo;
        }
        out.println(new String(result));
    }

    static class Schedule {
        int start, end, index;
        char assignedTo;

        Schedule(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}
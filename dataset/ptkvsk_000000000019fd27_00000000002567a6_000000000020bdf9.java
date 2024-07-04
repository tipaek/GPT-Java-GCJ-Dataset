import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            List<Activity> a = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                a.add(new Activity(in.nextInt(), in.nextInt()));
            }

            System.out.println("Case #" + i + ": " + getSchedule(a));
        }
    }

    private static String getSchedule(List<Activity> original) {
        List<Activity> a = new ArrayList<>(original);
        a.sort(Comparator.comparingInt(o -> o.start));
        int cEnd = 0, jEnd = 0;

        for (int i = 0; i < a.size(); i++) {
            Activity act = a.get(i);
            if (act.start >= cEnd) {
                act.parent = 'C';
                cEnd = act.end;
            } else if (act.start >= jEnd) {
                act.parent = 'J';
                jEnd = act.end;
            } else {
                return "IMPOSSIBLE";
            }
        }

        StringBuilder schedule = new StringBuilder();
        for (Activity act: original) {
            schedule.append(act.parent);
        }

        return schedule.toString();
    }

    private static class Activity {
        private int start;
        private int end;
        private Character parent;

        private Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
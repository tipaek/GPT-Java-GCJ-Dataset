import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static class Range {
        private int start;
        private int end;
        public Range(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean disjoint(Range input) {
            return input.end <= start || end <= input.start;
        }
    }
    public static class Schedule {
        List<Range> schedules = new ArrayList<>();

        public boolean add(Range input) {
            for (Range schedule: schedules) {
                if (!schedule.disjoint(input)) {
                    return false;
                }
            }
            schedules.add(input);
            return true;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            Schedule C = new Schedule();
            Schedule J = new Schedule();

            int n = in.nextInt();
            String result = "";
            for (int s = 0; s < n; s++) {
                int start = in.nextInt();
                int end = in.nextInt();

                if (!result.equals("IMPOSSIBLE")) {
                    if (C.add(new Range(start, end))) {
                        result += "C";
                    } else if (J.add(new Range(start, end))) {
                        result += "J";
                    } else {
                        result = "IMPOSSIBLE";
                    }
                }
            }
            System.out.println("Case #" + i + ": " + result);
        }
    }
}

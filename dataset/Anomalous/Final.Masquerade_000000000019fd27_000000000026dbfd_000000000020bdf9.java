import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int testCount = Integer.parseInt(reader.readLine());
            Solver solver = new Solver();
            for (int i = 1; i <= testCount; i++) {
                solver.solve(i, reader);
            }
        }
    }

    static class Solver {

        public void solve(int caseNumber, BufferedReader reader) throws IOException {
            StringBuilder result = new StringBuilder();
            ArrayList<Interval> cameronSchedule = new ArrayList<>();
            ArrayList<Interval> jamieSchedule = new ArrayList<>();
            int activityCount = Integer.parseInt(reader.readLine());
            boolean cameronBusy = false;
            boolean impossible = false;

            for (int i = 0; i < activityCount; i++) {
                Interval interval = new Interval(reader.readLine().split(" "));

                for (Interval scheduledInterval : cameronSchedule) {
                    if (scheduledInterval.overlaps(interval)) {
                        cameronBusy = true;
                        break;
                    }
                }

                if (cameronBusy) {
                    for (Interval scheduledInterval : jamieSchedule) {
                        if (scheduledInterval.overlaps(interval)) {
                            System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                            impossible = true;
                            break;
                        }
                    }
                    if (!impossible) {
                        jamieSchedule.add(interval);
                        result.append("J");
                    }
                } else {
                    cameronSchedule.add(interval);
                    result.append("C");
                }

                cameronBusy = false;
            }

            if (!impossible) {
                System.out.println("Case #" + caseNumber + ": " + result);
            }
        }
    }
}

class Interval {
    int start;
    int end;

    public Interval(String[] times) {
        this.start = Integer.parseInt(times[0]);
        this.end = Integer.parseInt(times[1]);
    }

    boolean overlaps(Interval other) {
        return !(this.end <= other.start || this.start >= other.end);
    }
}
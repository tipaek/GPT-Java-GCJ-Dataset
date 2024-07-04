import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTests = Integer.parseInt(reader.readLine());
        TestSolver solver = new TestSolver();
        for (int testIndex = 1; testIndex <= numberOfTests; testIndex++) {
            solver.solve(testIndex, reader);
        }
    }

    static class TestSolver {

        public void solve(int testIndex, BufferedReader reader) throws IOException {
            StringBuilder result = new StringBuilder();
            List<TimeInterval> cameronSchedule = new ArrayList<>();
            List<TimeInterval> jamieSchedule = new ArrayList<>();
            int numberOfActivities = Integer.parseInt(reader.readLine());
            boolean isCameronBusy = false;
            boolean isImpossible = false;

            for (int i = 0; i < numberOfActivities; i++) {
                if (isImpossible) break;
                TimeInterval activity = new TimeInterval(reader.readLine().split(" "));

                for (TimeInterval interval : cameronSchedule) {
                    if (interval.overlapsWith(activity)) {
                        isCameronBusy = true;
                        break;
                    }
                }

                if (isCameronBusy) {
                    for (TimeInterval interval : jamieSchedule) {
                        if (interval.overlapsWith(activity)) {
                            System.out.println("Case #" + testIndex + ": IMPOSSIBLE");
                            isImpossible = true;
                            break;
                        }
                    }
                    if (!isImpossible) {
                        jamieSchedule.add(activity);
                        result.append("J");
                    }
                } else {
                    cameronSchedule.add(activity);
                    result.append("C");
                }

                isCameronBusy = false;
            }

            if (!isImpossible) {
                System.out.println("Case #" + testIndex + ": " + result);
            }
        }
    }
}

class TimeInterval {
    int start;
    int end;

    public TimeInterval(String[] timeRange) {
        this.start = Integer.parseInt(timeRange[0]);
        this.end = Integer.parseInt(timeRange[1]);
    }

    public boolean overlapsWith(TimeInterval other) {
        return !(this.end <= other.start || this.start >= other.end);
    }
}
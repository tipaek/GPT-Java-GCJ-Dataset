import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTests = Integer.parseInt(reader.readLine());
        TaskSolver solver = new TaskSolver();
        for (int i = 1; i <= numberOfTests; i++) {
            solver.solve(i, reader);
        }
    }

    static class TaskSolver {

        public void solve(int testCaseNumber, BufferedReader reader) throws IOException {
            StringBuilder result = new StringBuilder();
            ArrayList<Interval> cameronIntervals = new ArrayList<>();
            ArrayList<Interval> jamieIntervals = new ArrayList<>();
            int numberOfIntervals = Integer.parseInt(reader.readLine());
            boolean isCameronBusy = false;
            boolean isImpossible = false;

            for (int i = 0; i < numberOfIntervals; i++) {
                Interval interval = new Interval(reader.readLine().split(" "));
                if (!isImpossible) {
                    for (Interval existingInterval : cameronIntervals) {
                        if (existingInterval.isOverlapping(interval)) {
                            isCameronBusy = true;
                            break;
                        }
                    }

                    if (isCameronBusy) {
                        for (Interval existingInterval : jamieIntervals) {
                            if (existingInterval.isOverlapping(interval)) {
                                System.out.println("Case #" + testCaseNumber + ": IMPOSSIBLE");
                                isImpossible = true;
                                break;
                            }
                        }
                        if (!isImpossible) {
                            jamieIntervals.add(interval);
                            result.append("J");
                        }
                    } else {
                        cameronIntervals.add(interval);
                        result.append("C");
                    }
                    isCameronBusy = false;
                }
            }

            if (!isImpossible) {
                System.out.println("Case #" + testCaseNumber + ": " + result);
            }
        }
    }
}

class Interval {
    int start;
    int end;

    public Interval(String[] timeRange) {
        start = Integer.parseInt(timeRange[0]);
        end = Integer.parseInt(timeRange[1]);
    }

    boolean isOverlapping(Interval other) {
        return !(end <= other.start || start >= other.end);
    }
}
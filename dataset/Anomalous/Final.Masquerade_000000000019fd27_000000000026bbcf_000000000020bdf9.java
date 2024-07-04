import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTests = Integer.parseInt(reader.readLine());
        TaskSolver solver = new TaskSolver();
        
        for (int testIndex = 1; testIndex <= numberOfTests; testIndex++) {
            solver.solve(testIndex, reader);
        }
    }

    static class TaskSolver {

        public void solve(int testNumber, BufferedReader reader) throws IOException {
            StringBuilder result = new StringBuilder();
            ArrayList<Interval> cIntervals = new ArrayList<>();
            ArrayList<Interval> jIntervals = new ArrayList<>();
            int numberOfIntervals = Integer.parseInt(reader.readLine());
            boolean isCBusy = false;
            boolean isImpossible = false;

            for (int i = 0; i < numberOfIntervals; i++) {
                Interval interval = new Interval(reader.readLine().split(" "));

                for (Interval cInterval : cIntervals) {
                    if (cInterval.overlaps(interval)) {
                        isCBusy = true;
                        break;
                    }
                }

                if (isCBusy) {
                    for (Interval jInterval : jIntervals) {
                        if (jInterval.overlaps(interval)) {
                            System.out.println("Case #" + testNumber + ": " + "IMPOSSIBLE");
                            isImpossible = true;
                            break;
                        }
                    }
                    if (isImpossible) break;

                    jIntervals.add(interval);
                    result.append("J");
                } else {
                    cIntervals.add(interval);
                    result.append("C");
                }

                isCBusy = false;
            }

            if (!isImpossible) {
                System.out.println("Case #" + testNumber + ": " + result);
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

    boolean overlaps(Interval other) {
        return !(end <= other.start || start >= other.end);
    }
}
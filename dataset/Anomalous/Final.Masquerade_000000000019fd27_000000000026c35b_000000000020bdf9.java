import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTests = Integer.parseInt(reader.readLine());
        ProblemSolver solver = new ProblemSolver();
        for (int test = 1; test <= numberOfTests; test++) {
            solver.solve(test, reader);
        }
    }

    static class ProblemSolver {

        public void solve(int testNumber, BufferedReader reader) throws IOException {
            StringBuilder result = new StringBuilder();
            ArrayList<Interval> cameronIntervals = new ArrayList<>();
            ArrayList<Interval> jamieIntervals = new ArrayList<>();
            int numberOfIntervals = Integer.parseInt(reader.readLine());
            boolean cameronBusy = false;
            boolean isImpossible = false;

            for (int i = 0; i < numberOfIntervals; i++) {
                Interval currentInterval = new Interval(reader.readLine().split(" "));

                for (Interval interval : cameronIntervals) {
                    if (interval.isOverlapping(currentInterval)) {
                        cameronBusy = true;
                        break;
                    }
                }

                if (cameronBusy) {
                    for (Interval interval : jamieIntervals) {
                        if (interval.isOverlapping(currentInterval)) {
                            System.out.println("Case #" + testNumber + ": IMPOSSIBLE");
                            isImpossible = true;
                            break;
                        }
                    }
                    if (isImpossible) break;
                    jamieIntervals.add(currentInterval);
                    result.append("J");
                } else {
                    cameronIntervals.add(currentInterval);
                    result.append("C");
                }

                cameronBusy = false;
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

    public Interval(String[] times) {
        this.start = Integer.parseInt(times[0]);
        this.end = Integer.parseInt(times[1]);
    }

    boolean isOverlapping(Interval other) {
        return !(this.end <= other.start || this.start >= other.end);
    }
}